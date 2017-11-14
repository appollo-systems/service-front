package systems.appollo.servicefront;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by avd on 2017-11-14.
 */
public class Configuration {
    Map<String, ServiceData> services = new HashMap<>();

    public Map<String, ServiceData> getServices() {
        return services;
    }

    public void setServices(Map<String, ServiceData> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Services{" +
                "services=" + services +
                '}';
    }
}
