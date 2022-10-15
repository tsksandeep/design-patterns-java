// CREATIONAL PATTERN

// Only a single instance of a class

import java.util.HashMap;
import java.util.Map;

class ConfigManager {
    // constructor private
    private ConfigManager() {
    };

    private static ConfigManager instance = new ConfigManager();

    public static ConfigManager getInstance() {
        return instance;
    }

    private Map<String, Object> settings = new HashMap<String, Object>();

    public void set(String key, Object object) {
        settings.put(key, object);
    }

    public Object get(String key) {
        return settings.get(key);
    }
}

public class _2_singleton {

    public static void main(String[] args) {
        var configManager = ConfigManager.getInstance();
        configManager.set("Name", "Sandeep");
        configManager.get("name");
    }
}