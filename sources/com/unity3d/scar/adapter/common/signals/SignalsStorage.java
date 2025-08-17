package com.unity3d.scar.adapter.common.signals;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SignalsStorage<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, T> f37067a = new ConcurrentHashMap();

    public T a(String str) {
        return this.f37067a.get(str);
    }

    public void b(String str, T t2) {
        this.f37067a.put(str, t2);
    }
}
