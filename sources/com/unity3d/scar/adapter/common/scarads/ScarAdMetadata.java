package com.unity3d.scar.adapter.common.scarads;

public class ScarAdMetadata {

    /* renamed from: a  reason: collision with root package name */
    private String f37054a;

    /* renamed from: b  reason: collision with root package name */
    private String f37055b;

    /* renamed from: c  reason: collision with root package name */
    private String f37056c;

    /* renamed from: d  reason: collision with root package name */
    private String f37057d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f37058e;

    public ScarAdMetadata(String str, String str2) {
        this(str, str2, (String) null, (String) null, (Integer) null);
    }

    public String a() {
        return this.f37057d;
    }

    public String b() {
        return this.f37056c;
    }

    public String c() {
        return this.f37054a;
    }

    public String d() {
        return this.f37055b;
    }

    public Integer e() {
        return this.f37058e;
    }

    public ScarAdMetadata(String str, String str2, String str3, String str4, Integer num) {
        this.f37054a = str;
        this.f37055b = str2;
        this.f37056c = str3;
        this.f37057d = str4;
        this.f37058e = num;
    }
}
