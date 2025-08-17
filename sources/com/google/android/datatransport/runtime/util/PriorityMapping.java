package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

public final class PriorityMapping {

    /* renamed from: a  reason: collision with root package name */
    private static SparseArray<Priority> f22778a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<Priority, Integer> f22779b;

    static {
        HashMap<Priority, Integer> hashMap = new HashMap<>();
        f22779b = hashMap;
        hashMap.put(Priority.DEFAULT, 0);
        f22779b.put(Priority.VERY_LOW, 1);
        f22779b.put(Priority.HIGHEST, 2);
        for (Priority next : f22779b.keySet()) {
            f22778a.append(f22779b.get(next).intValue(), next);
        }
    }

    public static int a(Priority priority) {
        Integer num = f22779b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    public static Priority b(int i2) {
        Priority priority = f22778a.get(i2);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i2);
    }
}
