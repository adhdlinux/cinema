package com.facebook.ads.internal.p.a;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    protected String f20469a = "";

    /* renamed from: b  reason: collision with root package name */
    protected j f20470b;

    /* renamed from: c  reason: collision with root package name */
    protected String f20471c;

    /* renamed from: d  reason: collision with root package name */
    protected byte[] f20472d;

    public l(String str, p pVar) {
        if (str != null) {
            this.f20469a = str;
        }
        if (pVar != null) {
            this.f20469a += "?" + pVar.a();
        }
    }

    public String a() {
        return this.f20469a;
    }

    public j b() {
        return this.f20470b;
    }

    public String c() {
        return this.f20471c;
    }

    public byte[] d() {
        return this.f20472d;
    }
}
