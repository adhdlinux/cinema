package com.original.tase.utils;

import java.util.HashMap;

public class SourceUtils {
    public static HashMap<String, String> a(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.putAll(hashMap);
        if (hashMap2.containsKey("X-TTV-Custom")) {
            String str = hashMap2.get("X-TTV-Custom");
            if (str != null && !str.isEmpty() && str.contains("rangeFromZero")) {
                hashMap2.put("Range", "bytes=0-");
            }
            hashMap2.remove("X-TTV-Custom");
        }
        return hashMap2;
    }

    public static HashMap<String, String> b(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.putAll(hashMap);
        if (!hashMap2.containsKey("X-TTV-Custom")) {
            return hashMap2;
        }
        hashMap2.remove("X-TTV-Custom");
        return hashMap2;
    }
}
