package com.unity3d.scar.adapter.common.signals;

import java.util.HashMap;
import java.util.Map;

public class SignalsResult {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f37065a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private String f37066b = null;

    public void a(String str, String str2) {
        this.f37065a.put(str, str2);
    }

    public String b() {
        return this.f37066b;
    }

    public Map<String, String> c() {
        return this.f37065a;
    }

    public void d(String str) {
        this.f37066b = str;
    }
}
