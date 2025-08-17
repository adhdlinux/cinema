package com.facebook.ads.internal.adapters.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class f implements Serializable {
    private static final long serialVersionUID = -2102939945352398575L;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f19715a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19716b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f19717c;

    /* renamed from: d  reason: collision with root package name */
    private String f19718d;

    f(byte[] bArr, String str, List<String> list) {
        this.f19715a = bArr;
        this.f19716b = str;
        this.f19717c = list;
    }

    public String a() {
        return this.f19718d;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.f19718d = str;
    }

    public byte[] b() {
        return this.f19715a;
    }

    public String c() {
        return this.f19716b;
    }

    public List<String> d() {
        return Collections.unmodifiableList(this.f19717c);
    }
}
