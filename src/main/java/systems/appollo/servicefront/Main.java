package systems.appollo.servicefront;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        InputStream is = new FileInputStream("service-front.yaml");
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
