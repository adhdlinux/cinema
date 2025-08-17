package com.startapp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class m4 {

    /* renamed from: a  reason: collision with root package name */
    public static m4 f34897a = new m4();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, l4> f34898b = new ConcurrentHashMap();

    public l4 a(String str) {
        if (this.f34898b.containsKey(str)) {
            return this.f34898b.get(str);
        }
        l4 l4Var = new l4();
        this.f34898b.put(str, l4Var);
        return l4Var;
    }
}
