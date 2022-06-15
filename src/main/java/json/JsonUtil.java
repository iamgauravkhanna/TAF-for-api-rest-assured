package json;

import logger.TestLogger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class JsonUtil {

    public static boolean parseObject(JSONObject json, String key) {
        TestLogger.INFO("Key : " + key + " has value : " + json.get(key));
        return json.has(key);
    }

    public static void getKey(String body, String key) {
        JSONObject json = new JSONObject(body);
        getKey(json, key);
    }

    public static void getKey(JSONObject json, String key) {
        boolean exists = json.has(key);

        Iterator<?> keys;

        String nextKeys;

        if (!exists) {
            keys = json.keys();
            while (keys.hasNext()) {
                nextKeys = (String) keys.next();
                try {
                    if (json.get(nextKeys) instanceof JSONObject) {
                        if (exists == false) {
                            getKey(json.getJSONObject(nextKeys), key);
                        }
                    } else if (json.get(nextKeys) instanceof JSONArray) {
                        JSONArray jsonarray = json.getJSONArray(nextKeys);
                        for (int i = 0; i < jsonarray.length(); i++) {
                            String jsonArrayString = jsonarray.get(i).toString();
                            JSONObject innerJSON = new JSONObject(jsonArrayString);
                            if (exists == false) {
                                getKey(innerJSON, key);
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        } else {
            parseObject(json, key);
        }
    }
}