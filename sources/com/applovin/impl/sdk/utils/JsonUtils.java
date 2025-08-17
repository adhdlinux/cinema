package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {
    public static final String EMPTY_JSON = "{}";

    private static Object a(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof JSONObject ? toStringObjectMap((JSONObject) obj) : obj instanceof JSONArray ? toList((JSONArray) obj) : obj;
    }

    private static <T> List<T> a(JSONArray jSONArray, List<T> list) throws JSONException {
        if (jSONArray == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(a(jSONArray.get(i2)));
        }
        return arrayList;
    }

    public static boolean containsCaseInsensitiveString(String str, JSONArray jSONArray) {
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                Object obj = jSONArray.get(i2);
                if ((obj instanceof String) && ((String) obj).equalsIgnoreCase(str)) {
                    return true;
                }
                i2++;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    public static JSONArray deepCopy(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                Object obj = jSONArray.get(i2);
                if (obj instanceof JSONObject) {
                    obj = deepCopy((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    obj = deepCopy((JSONArray) obj);
                }
                jSONArray2.put(i2, obj);
            } catch (JSONException unused) {
                if (v.a()) {
                    v.h("JsonUtils", "Failed to copy over item at index " + i2 + " to JSONArray deep copy");
                }
            }
        }
        return jSONArray2;
    }

    public static JSONObject deepCopy(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    obj = deepCopy((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    obj = deepCopy((JSONArray) obj);
                }
                jSONObject2.put(next, obj);
            } catch (JSONException unused) {
                if (v.a()) {
                    v.h("JsonUtils", "Failed to copy over item for key '" + next + "' to JSONObject deep copy");
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject deserialize(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            if (v.a()) {
                v.i("JsonUtils", "Failed to deserialize into JSON: " + str);
            }
            return null;
        }
    }

    public static Boolean getBoolean(JSONObject jSONObject, String str, Boolean bool) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return bool;
        }
        try {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        } catch (JSONException unused) {
            boolean z2 = true;
            if (getInt(jSONObject, str, (bool == null || !bool.booleanValue()) ? 0 : 1) <= 0) {
                z2 = false;
            }
            return Boolean.valueOf(z2);
        }
    }

    public static double getDouble(JSONObject jSONObject, String str, double d2) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return d2;
        }
        try {
            return jSONObject.getDouble(str);
        } catch (JSONException e2) {
            if (!v.a()) {
                return d2;
            }
            v.c("JsonUtils", "Failed to retrieve double property for key = " + str, e2);
            return d2;
        }
    }

    public static float getFloat(JSONObject jSONObject, String str, float f2) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return f2;
        }
        try {
            double d2 = jSONObject.getDouble(str);
            return (-3.4028234663852886E38d >= d2 || d2 >= 3.4028234663852886E38d) ? f2 : (float) d2;
        } catch (JSONException e2) {
            if (!v.a()) {
                return f2;
            }
            v.c("JsonUtils", "Failed to retrieve float property for key = " + str, e2);
            return f2;
        }
    }

    public static Float getFloat(JSONObject jSONObject, String str, Float f2) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return f2;
        }
        try {
            double d2 = jSONObject.getDouble(str);
            return (-3.4028234663852886E38d >= d2 || d2 >= 3.4028234663852886E38d) ? f2 : Float.valueOf((float) d2);
        } catch (JSONException e2) {
            if (!v.a()) {
                return f2;
            }
            v.c("JsonUtils", "Failed to retrieve float property for key = " + str, e2);
            return f2;
        }
    }

    public static int getInt(JSONObject jSONObject, String str, int i2) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return i2;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException e2) {
            if (!v.a()) {
                return i2;
            }
            v.c("JsonUtils", "Failed to retrieve int property for key = " + str, e2);
            return i2;
        }
    }

    public static List<Integer> getIntegerList(JSONObject jSONObject, String str, List<Integer> list) {
        JSONArray jSONArray = getJSONArray(jSONObject, str, (JSONArray) null);
        return jSONArray != null ? toIntegerList(jSONArray) : list;
    }

    public static JSONArray getJSONArray(Object obj) {
        if (obj == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(obj);
        return jSONArray;
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return jSONArray;
        }
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException e2) {
            if (!v.a()) {
                return jSONArray;
            }
            v.c("JsonUtils", "Failed to retrieve JSON array for key = " + str, e2);
            return jSONArray;
        }
    }

    public static JSONObject getJSONObject(JSONArray jSONArray, int i2, JSONObject jSONObject) {
        if (jSONArray == null || i2 >= jSONArray.length()) {
            return jSONObject;
        }
        try {
            return jSONArray.getJSONObject(i2);
        } catch (JSONException e2) {
            if (!v.a()) {
                return jSONObject;
            }
            v.c("JsonUtils", "Failed to retrieve JSON object from array for index = " + i2, e2);
            return jSONObject;
        }
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return jSONObject2;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e2) {
            if (!v.a()) {
                return jSONObject2;
            }
            v.c("JsonUtils", "Failed to retrieve JSON property for key = " + str, e2);
            return jSONObject2;
        }
    }

    public static List getList(JSONObject jSONObject, String str, List list) {
        try {
            JSONArray jSONArray = getJSONArray(jSONObject, str, (JSONArray) null);
            return jSONArray != null ? toList(jSONArray) : list;
        } catch (JSONException unused) {
            return list;
        }
    }

    public static long getLong(JSONObject jSONObject, String str, long j2) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return j2;
        }
        try {
            return jSONObject.getLong(str);
        } catch (JSONException e2) {
            if (!v.a()) {
                return j2;
            }
            v.c("JsonUtils", "Failed to retrieve long property for key = " + str, e2);
            return j2;
        }
    }

    public static Object getObject(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return obj;
        }
        try {
            Object obj2 = jSONObject.get(str);
            return obj2 != null ? obj2 : obj;
        } catch (JSONException e2) {
            if (!v.a()) {
                return obj;
            }
            v.c("JsonUtils", "Failed to retrieve Object for key = " + str, e2);
            return obj;
        }
    }

    public static Object getObjectAtIndex(JSONArray jSONArray, int i2, Object obj) {
        if (jSONArray == null || jSONArray.length() <= i2) {
            return obj;
        }
        try {
            return jSONArray.get(i2);
        } catch (JSONException e2) {
            if (!v.a()) {
                return obj;
            }
            v.c("JsonUtils", "Failed to retrieve object at index " + i2 + " for JSON array", e2);
            return obj;
        }
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return str2;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception e2) {
            if (!v.a()) {
                return str2;
            }
            v.c("JsonUtils", "Failed to retrieve string property for key = " + str, e2);
            return str2;
        }
    }

    public static JSONObject jsonObjectFromJsonString(String str, JSONObject jSONObject) {
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            if (v.a()) {
                v.c("JsonUtils", "Failed to convert JSON string '" + str + "' to JSONObject", e2);
            }
            return jSONObject;
        }
    }

    public static String maybeConvertToIndentedString(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return new JSONObject(str).toString(i2);
        } catch (JSONException unused) {
            return str;
        }
    }

    public static String maybeConvertToIndentedString(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.toString(4);
        } catch (JSONException unused) {
            return jSONObject.toString();
        }
    }

    public static <T> List<T> optList(JSONArray jSONArray, List<T> list) {
        try {
            return a(jSONArray, list);
        } catch (JSONException unused) {
            return list;
        }
    }

    public static void putAll(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object object = getObject(jSONObject2, next, (Object) null);
                if (object != null) {
                    putObject(jSONObject, next, object);
                }
            }
        }
    }

    public static void putBoolean(JSONObject jSONObject, String str, boolean z2) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, z2);
            } catch (JSONException e2) {
                if (v.a()) {
                    v.c("JsonUtils", "Failed to put boolean property for key = " + str, e2);
                }
            }
        }
    }

    public static void putDouble(JSONObject jSONObject, String str, double d2) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, d2);
            } catch (JSONException e2) {
                if (v.a()) {
                    v.c("JsonUtils", "Failed to put double property for key = " + str, e2);
                }
            }
        }
    }

    public static void putInt(JSONObject jSONObject, String str, int i2) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, i2);
            } catch (JSONException e2) {
                if (v.a()) {
                    v.c("JsonUtils", "Failed to put int property for key = " + str, e2);
                }
            }
        }
    }

    public static void putJSONObject(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, jSONObject2);
            } catch (JSONException e2) {
                if (v.a()) {
                    v.c("JsonUtils", "Failed to put JSON property for key = " + str, e2);
                }
            }
        }
    }

    public static void putJsonArray(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, jSONArray);
            } catch (JSONException e2) {
                if (v.a()) {
                    v.c("JsonUtils", "Failed to put JSONArray property for key = " + str, e2);
                }
            }
        }
    }

    public static void putLong(JSONObject jSONObject, String str, long j2) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, j2);
            } catch (JSONException e2) {
                if (v.a()) {
                    v.c("JsonUtils", "Failed to put long property for key = " + str, e2);
                }
            }
        }
    }

    public static void putObject(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e2) {
                if (v.a()) {
                    v.c("JsonUtils", "Failed to put Object property for key = " + str, e2);
                }
            }
        }
    }

    public static void putString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException e2) {
                if (v.a()) {
                    v.c("JsonUtils", "Failed to put String property for key = " + str, e2);
                }
            }
        }
    }

    public static void removeObjectsForKeys(JSONObject jSONObject, String[] strArr) {
        for (String remove : strArr) {
            jSONObject.remove(remove);
        }
    }

    public static JSONObject shallowCopy(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject2.put(next, jSONObject.get(next));
            } catch (JSONException unused) {
                if (v.a()) {
                    v.h("JsonUtils", "Failed to copy over item for key '" + next + "' to JSONObject copy");
                }
            }
        }
        return jSONObject2;
    }

    public static Bundle toBundle(Object obj) {
        JSONObject jSONObject;
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        } else {
            if (obj instanceof String) {
                try {
                    jSONObject = new JSONObject((String) obj);
                } catch (JSONException unused) {
                }
            }
            jSONObject = null;
        }
        return toBundle(jSONObject);
    }

    public static Bundle toBundle(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (jSONObject.isNull(next)) {
                bundle.putString(next, (String) null);
            } else {
                Object opt = jSONObject.opt(next);
                if (opt instanceof JSONObject) {
                    bundle.putBundle(next, toBundle((JSONObject) opt));
                } else if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (jSONArray.length() == 0) {
                        bundle.putStringArrayList(next, new ArrayList(0));
                    } else if (getObjectAtIndex(jSONArray, 0, (Object) null) instanceof String) {
                        ArrayList arrayList = new ArrayList(jSONArray.length());
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add((String) getObjectAtIndex(jSONArray, i2, (Object) null));
                        }
                        bundle.putStringArrayList(next, arrayList);
                    } else {
                        bundle.putParcelableArrayList(next, toBundle(jSONArray));
                    }
                } else if (opt instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) opt).booleanValue());
                } else if (opt instanceof String) {
                    bundle.putString(next, (String) opt);
                } else if (opt instanceof Integer) {
                    bundle.putInt(next, ((Integer) opt).intValue());
                } else if (opt instanceof Long) {
                    bundle.putLong(next, ((Long) opt).longValue());
                } else if (opt instanceof Double) {
                    bundle.putDouble(next, ((Double) opt).doubleValue());
                }
            }
        }
        return bundle;
    }

    public static ArrayList<Bundle> toBundle(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(toBundle(jSONArray.optJSONObject(i2)));
        }
        return arrayList;
    }

    public static List<Integer> toIntegerList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                arrayList.add((Integer) jSONArray.get(i2));
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static <T> List<T> toList(JSONArray jSONArray) throws JSONException {
        return a(jSONArray, new ArrayList());
    }

    public static Map<String, String> toStringMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, a(jSONObject.get(next)).toString());
        }
        return hashMap;
    }

    public static Map<String, Object> toStringObjectMap(String str, Map<String, Object> map) {
        try {
            return toStringObjectMap(new JSONObject(str));
        } catch (JSONException e2) {
            if (v.a()) {
                v.c("JsonUtils", "Failed to convert json string '" + str + "' to map", e2);
            }
            return map;
        }
    }

    public static Map<String, Object> toStringObjectMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, a(jSONObject.get(next)));
        }
        return hashMap;
    }

    public static boolean valueExists(JSONArray jSONArray, Object obj) {
        if (!(jSONArray == null || obj == null)) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (obj.equals(getObjectAtIndex(jSONArray, i2, (Object) null))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean valueExists(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }
}
