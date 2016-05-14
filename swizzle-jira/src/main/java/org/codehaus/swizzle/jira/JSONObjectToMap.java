package org.codehaus.swizzle.jira;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by mirko on 14.05.16.
 */
class JSONObjectToMap {
    private JSONObject jsonObject;

    public JSONObjectToMap(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Map<String, Object> invoke() {
        final HashMap<String, Object> map = new HashMap<>();
        final Set<String> keySet = jsonObject.keySet();
        for (String s : keySet) {
            map.put(s, jsonObject.get(s));
        }
        return map;
    }
}
