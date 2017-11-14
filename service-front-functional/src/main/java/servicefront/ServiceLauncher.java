package servicefront;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by avd on 2017-11-14.
 */
public class ServiceLauncher {

    public Process launch(ServiceData serviceData) throws IOException {


        StringTokenizer st = new StringTokenizer(serviceData.getCommandLine());
        String[] cmdarray = new String[st.countTokens()];
        for (int i = 0; st.hasMoreTokens(); i++)
            cmdarray[i] = st.nextToken();


        ProcessBuilder processBuilder = new ProcessBuilder(cmdarray);
        for (String envstring : serviceData.getEnvironment()) {
            // Before 1.5, we blindly passed invalid envstrings
            // to the child process.
            // We would like to throw an exception, but do not,
            // for compatibility with old broken code.

            // Silently discard any trailing junk.
            if (envstring.indexOf((int) '\u0000') != -1)
                envstring = envstring.replaceFirst("\u0000.*", "");

            int eqlsign =
                    envstring.indexOf('=', 1);
            // Silently ignore envstrings lacking the required `='.
            if (eqlsign != -1)
                processBuilder.environment().put(envstring.substring(0,eqlsign),
                        envstring.substring(eqlsign+1));
        }

        processBuilder.directory(new File(serviceData.getWorkingDirectory()));
        if(serviceData.getStdErrFile()!=null) {
            File file = new File(serviceData.getStdErrFile());
            System.out.println("INFO: Redirecting stderr to" +file.getAbsolutePath());
            processBuilder.redirectError(file);
        }
        if(serviceData.getStdOutFile()!=null) {
            File file = new File(serviceData.getStdOutFile());
            System.out.println("INFO: Redirecting stdout to" +file.getAbsolutePath());
            processBuilder.redirectOutput(file);
        }
        return processBuilder.start();
   }
}
