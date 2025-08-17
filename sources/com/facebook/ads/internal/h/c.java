package com.facebook.ads.internal.h;

import java.util.ArrayList;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f20180a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f20181b = 0;

    /* renamed from: c  reason: collision with root package name */
    private d f20182c;

    /* renamed from: d  reason: collision with root package name */
    private String f20183d;

    public c(d dVar, String str) {
        this.f20182c = dVar;
        this.f20183d = str;
    }

    public d a() {
        return this.f20182c;
    }

    public void a(a aVar) {
        this.f20180a.add(aVar);
    }

    public String b() {
        return this.f20183d;
    }

    public int c() {
        return this.f20180a.size();
    }

    public a d() {
        if (this.f20181b >= this.f20180a.size()) {
            return null;
        }
        int i2 = this.f20181b + 1;
        this.f20181b = i2;
        return this.f20180a.get(i2 - 1);
    }

    public boolean e() {
        return this.f20182c == null || System.currentTimeMillis() > this.f20182c.a() + ((long) this.f20182c.l());
    }
}
