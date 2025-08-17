package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.applovin.impl.sdk.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CollectionUtils {
    public static List<String> explode(String str) {
        return explode(str, ",\\s*");
    }

    public static List<String> explode(String str, String str2) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : Arrays.asList(str.split(str2));
    }

    public static boolean getBoolean(Map<String, Object> map, String str) {
        return getBoolean(map, str, false);
    }

    public static boolean getBoolean(Map<String, Object> map, String str, boolean z2) {
        if (map != null && map.containsKey(str)) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                return Boolean.parseBoolean((String) obj);
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (obj instanceof Number) {
                return ((Number) obj).intValue() >= 1;
            }
        }
        return z2;
    }

    public static String implode(Collection<String> collection, int i2) {
        return implode(collection, ",", i2);
    }

    public static String implode(Collection<String> collection, String str, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("No glue specified");
        } else if (collection == null || collection.size() < 1) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            for (String next : collection) {
                if (i3 >= i2) {
                    break;
                }
                i3++;
                sb.append(next);
                sb.append(str);
            }
            if (sb.length() > str.length()) {
                sb.setLength(sb.length() - str.length());
            }
            return sb.toString();
        }
    }

    public static <K, V> Map<K, V> map(K k2, V v2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(k2, v2);
        return hashMap;
    }

    public static List<String> removeTrimmedEmptyStrings(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String trim : list) {
            String trim2 = trim.trim();
            if (!TextUtils.isEmpty(trim2)) {
                arrayList.add(trim2);
            }
        }
        return arrayList;
    }

    public static <T> List<T> synchronizedList() {
        return synchronizedList(-1);
    }

    public static <T> List<T> synchronizedList(int i2) {
        return i2 >= 0 ? Collections.synchronizedList(new ArrayList(i2)) : Collections.synchronizedList(new ArrayList());
    }

    public static Bundle toBundle(Map<String, ?> map) {
        if (map == null || map.size() == 0) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof Map) {
                bundle.putBundle(next, toBundle((Map) obj));
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof String) {
                bundle.putString(next, (String) obj);
            } else if (obj instanceof Integer) {
                bundle.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(next, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(next, (Parcelable) obj);
            }
        }
        return bundle;
    }

    public static JSONArray toJSONArray(List<String> list) {
        if (list == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static JSONObject toJson(Map<String, ?> map) throws JSONException {
        if (map == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            jSONObject.put((String) next.getKey(), next.getValue());
        }
        return jSONObject;
    }

    public static String toJsonString(Map<String, Object> map, String str) {
        try {
            return toJson(map).toString();
        } catch (JSONException e2) {
            if (v.a()) {
                v.c("CollectionUtils", "Failed to convert map '" + map + "' to JSON string.", e2);
            }
            return str;
        }
    }
}
