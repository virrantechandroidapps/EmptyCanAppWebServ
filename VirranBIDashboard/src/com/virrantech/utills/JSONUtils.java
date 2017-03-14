
package com.virrantech.utills;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;


import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.codehaus.jackson.JsonParseException;

/**
 * The Class JSONUtils.
 */
public final class JSONUtils {

    /**
     * Instantiates a new jSON utils.
     */
    public JSONUtils() {
    }

    /**
     * Gets the jSON object.
     *
     * @param object the object
     * @return the jSON object
     */
    public JsonObject getJSONObject(Object object) {
        JsonObject jObj = null;
        JsonArray jsArr = new JsonArray();
        jsArr.add(getJSONElement(object));
        jObj = new JsonObject();
        jObj.add("rows", jsArr);
        return jObj;
    }

    /**
     * Gets the jSON object.
     *
     * @param object the object
     * @return the jSON object
     */
    public JsonElement getJSONElement(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new GsonExclusionStrategy(null));
        Gson gson = gsonBuilder.serializeNulls().create();
        String json = gson.toJson(object);
        JsonElement jelement = new JsonParser().parse(json);
        return jelement;
    }

    /**
     * Gets the jSON object for list.
     *
     * @param lineList the line list
     * @param type the type
     * @return the jSON object for list
     */
    @SuppressWarnings({"rawtypes"})
    public JsonObject getJSONObjectForList(List lineList, Type type) {
        JsonObject jObj = null;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new GsonExclusionStrategy(null));
        Gson gson = gsonBuilder.serializeNulls().create();
        String json = gson.toJson(lineList, type);
        JsonElement jelement = new JsonParser().parse(json);
        JsonArray jsArr = new JsonArray();
        jsArr.add(jelement);
        jObj = new JsonObject();
        jObj.addProperty("HDR", "LIST OBJECTS");
        jObj.add("rows", jelement);
        return jObj;
    }

    /**
     * Gets the jSON string from hashtable.
     *
     * @param dataList the data list
     * @return the jSON string from hashtable
     * @throws JSONException the jSON exception
     */
    public String getJSONStringFromHashtableList(List<Hashtable<String, String>> dataList) throws JSONException {
        JSONObject jsObj = null;
        JsonArray jsArr = new JsonArray();
        JsonElement jEle = null;
        if (dataList.size() == 0)
            return null;
        for (Hashtable<String, String> data : dataList) {
            jsObj = new JSONObject();
            Enumeration<String> e = data.keys();
            String key = "";
            while (e.hasMoreElements()) {
                key = e.nextElement();
                jsObj.put(key, data.get(key));
            }
            jEle = new JsonParser().parse(jsObj.toString());
            jsArr.add(jEle);
        }
        return jsArr.toString();
    }

    /**
     * Gets the jSON string from hash map list.
     *
     * @param dataList the data list
     * @return the jSON string from hash map list
     * @throws JSONException the jSON exception
     */
    public String getJSONStringFromMapList(List<Map<String, Object>> dataList) throws JSONException {
        JSONObject jsObj = null;
        JsonArray jsArr = new JsonArray();
        JsonElement jEle = null;
        if (dataList.size() == 0)
            return null;
        for (Map<String, Object> data : dataList) {
            jsObj = new JSONObject();
            Iterator<String> e = data.keySet().iterator();
            String key = "";
            while (e.hasNext()) {
                key = e.next();
                jsObj.put(key, data.get(key));
            }
            jEle = new JsonParser().parse(jsObj.toString());
            jsArr.add(jEle);
        }
        return jsArr.toString();
    }

    /**
     * Gets the jSON string from hashtable.
     *
     * @param data the data
     * @return the jSON string from hashtable
     * @throws JSONException the jSON exception
     */
    public String getJSONStringFromHashtable(Hashtable<String, String> data) throws JSONException {
        JSONObject jsObj = new JSONObject();
        Enumeration<String> e = data.keys();
        String key = "";
        while (e.hasMoreElements()) {
            key = e.nextElement();
            jsObj.put(key, data.get(key));
        }
        return jsObj.toString();
    }

    /**
     * Gets the jSON string for list.
     *
     * @param lineList the line list
     * @param type the type
     * @return the jSON string for list
     */
    @SuppressWarnings("rawtypes")
    public String getJSONStringForList(List lineList, Type type) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new GsonExclusionStrategy(null));
        Gson gson = gsonBuilder.serializeNulls().create();
        String json = gson.toJson(lineList, type);
        return json;
    }

    /**
     * Gets the jSON element with check box.
     *
     * @param object the object
     * @param checkBoxPropertyList the check box property list
     * @param index the index
     * @return the jSON element with check box
     */
    public JsonElement getJSONElementWithCheckBox(Object object, Map<String, String> checkBoxPropertyList, int index) {
        JsonElement jelement = getJSONElement(object);
        String propertyValue = null;
        Iterator<String> iterator = null;
        String checkBoxPropertyName = "";
        String checkBoxEnableProperty = "";
        String checkBoxEnablePropertyValue = "";
        String checkBoxContent = "";

        if (checkBoxPropertyList != null && checkBoxPropertyList.size() > 0) {
            iterator = checkBoxPropertyList.keySet().iterator();
            while (iterator.hasNext()) {
                checkBoxPropertyName = iterator.next();
                checkBoxEnableProperty = checkBoxPropertyList.get(checkBoxPropertyName);
                try {
                    checkBoxEnablePropertyValue = "";
                    propertyValue = "";
                    propertyValue = (String) PropertyUtils.getProperty(object, checkBoxPropertyName);
                    if (checkBoxEnableProperty != null && !checkBoxEnableProperty.equals(""))
                        checkBoxEnablePropertyValue =
                        (String) PropertyUtils.getProperty(object, checkBoxEnableProperty);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                checkBoxContent = "<input ";
                if (propertyValue != null && propertyValue.equals("Y"))
                    checkBoxContent += " checked ";
                if (checkBoxEnablePropertyValue != null && checkBoxEnablePropertyValue.equals("N"))
                    checkBoxContent += " disabled ";
                checkBoxContent +=
                    " type=\"checkbox\" id=" + checkBoxPropertyName + index + " name=" + checkBoxPropertyName
                    + " onclick=\"check(this," + index + ")\"/> ";
                jelement.getAsJsonObject().getAsJsonObject().addProperty(checkBoxPropertyName, checkBoxContent);

            }
        }
        return jelement;
        

}

    @SuppressWarnings("unchecked")
    public Object getObjectFromJson(String json, Object object) throws JsonParseException, JsonMappingException,
        IOException {
        return new ObjectMapper().readValue(json, (Class<Object>) object);
    }    

}
