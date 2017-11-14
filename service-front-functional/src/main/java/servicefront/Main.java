package servicefront;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by avd on 2017-11-14.
 */
public class Main {
    private static final Yaml YAML = new Yaml();
    private static final ServiceLauncher serviceLauncher = new ServiceLauncher();
    private static final List<String> errors = new ArrayList<>();
    private static final Map<String, Process> nameToService = new HashMap<>();

    public static void main(String[] args) throws IOException {
        PrintStream printStream = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(printStream);
        System.setErr(printStream);

        System.err.println("Launching");

        InputStream is = new FileInputStream("service-front-config.yaml");
        Configuration configuration = YAML.loadAs(is, Configuration.class);
        configuration.getServices().forEach((name,data)->{
            try {
                System.out.println("INFO: Launching service "+data);
                Process launchedProcess = serviceLauncher.launch(data);
                nameToService.put(name, launchedProcess);
            } catch (IOException e) {
                errors.add(name);
            }
        });
    }

}
