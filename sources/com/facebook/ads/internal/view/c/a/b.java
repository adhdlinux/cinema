package com.facebook.ads.internal.view.c.a;

import com.facebook.ads.internal.adapters.a.h;
import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f20970a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20971b;

    /* renamed from: c  reason: collision with root package name */
    private final h f20972c;

    b(int i2, int i3, h hVar) {
        this.f20970a = i2;
        this.f20971b = i3;
        this.f20972c = hVar;
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("cardind", this.f20970a + "");
        hashMap.put("cardcnt", this.f20971b + "");
        return hashMap;
    }

    public int b() {
        return this.f20970a;
    }

    public h c() {
        return this.f20972c;
    }
}
