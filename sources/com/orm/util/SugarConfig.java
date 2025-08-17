package com.orm.util;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SugarConfig {

    /* renamed from: a  reason: collision with root package name */
    static Map<Class<?>, List<Field>> f34064a = new HashMap();

    public static List<Field> a(Class<?> cls) {
        if (f34064a.containsKey(cls)) {
            return Collections.synchronizedList(f34064a.get(cls));
        }
        return null;
    }

    public static void b(Class<?> cls, List<Field> list) {
        f34064a.put(cls, list);
    }
}
