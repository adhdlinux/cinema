package com.startapp;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h0 {
    public static <T> T a(String str, Class<T> cls) {
        try {
            return g0.a(cls, new JSONObject(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject b(Object obj) {
        if (obj == null) {
            return null;
        }
        Class cls = obj.getClass();
        ArrayList arrayList = new ArrayList();
        while (cls != null && !Object.class.equals(cls)) {
            arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
            cls = cls.getSuperclass();
        }
        JSONObject jSONObject = new JSONObject();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Field field = (Field) it2.next();
            int modifiers = field.getModifiers();
            if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                try {
                    field.setAccessible(true);
                    if (field.get(obj) != null) {
                        String a2 = p.a(field);
                        if (p.b(field)) {
                            jSONObject.put(a2, b(field.get(obj)));
                        } else {
                            if (List.class.isAssignableFrom(field.getType())) {
                                JSONArray jSONArray = new JSONArray();
                                for (Object a3 : (List) field.get(obj)) {
                                    jSONArray.put(a(a3));
                                }
                                jSONObject.put(a2, jSONArray);
                            } else {
                                if (Set.class.isAssignableFrom(field.getType())) {
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (Object a4 : (Set) field.get(obj)) {
                                        jSONArray2.put(a(a4));
                                    }
                                    jSONObject.put(a2, jSONArray2);
                                } else {
                                    if (Map.class.isAssignableFrom(field.getType())) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        for (Map.Entry entry : ((Map) field.get(obj)).entrySet()) {
                                            jSONObject2.put(entry.getKey().toString(), a(entry.getValue()));
                                        }
                                        jSONObject.put(a2, jSONObject2);
                                    } else {
                                        jSONObject.put(a2, field.get(obj));
                                    }
                                }
                            }
                        }
                    }
                } catch (IllegalAccessException | IllegalArgumentException | JSONException unused) {
                }
            }
        }
        return jSONObject;
    }

    public static Object a(Object obj) {
        Class<?> cls = obj.getClass();
        if (cls.equals(Boolean.class) || cls.equals(Integer.class) || cls.equals(Character.class) || cls.equals(Byte.class) || cls.equals(Short.class) || cls.equals(Double.class) || cls.equals(Long.class) || cls.equals(Float.class) || cls.equals(String.class)) {
            return obj;
        }
        return b(obj);
    }
}
