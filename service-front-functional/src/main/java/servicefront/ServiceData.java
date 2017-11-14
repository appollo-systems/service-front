package servicefront;

import java.util.Arrays;

/**
 * Created by avd on 2017-11-14.
 */
public class ServiceData {
    private String workingDirectory;
    private String[] environment;
    private String commandLine;
    private String stdErrFile;
    private String stdOutFile;

    public String getStdErrFile() {
        return stdErrFile;
    }

    public void setStdErrFile(String stdErrFile) {
        this.stdErrFile = stdErrFile;
    }

    public String getStdOutFile() {
        return stdOutFile;
    }

    public void setStdOutFile(String stdOutFile) {
        this.stdOutFile = stdOutFile;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    public String[] getEnvironment() {
        return environment;
    }

    public void setEnvironment(String[] environment) {
        this.environment = environment;
    }

    public String getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(String commandLine) {
        this.commandLine = commandLine;
    }

    public ServiceData() {
    }

    public ServiceData(String workingDirectory, String[] environment, String commandLine) {
        this.workingDirectory = workingDirectory;
        this.environment = environment;
        this.commandLine = commandLine;
    }

    @Override
    public String toString() {
        return "ServiceData{" +
                "workingDirectory='" + workingDirectory + '\'' +
                ", environment=" + Arrays.toString(environment) +
                ", commandLine='" + commandLine + '\'' +
                '}';
    }
}
