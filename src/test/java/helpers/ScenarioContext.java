package helpers;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, Object> contextMap;

    public ScenarioContext() {
        contextMap = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        contextMap.put(key, value);
    }

    public Object getContext(String key) {
        return contextMap.get(key);
    }
}
