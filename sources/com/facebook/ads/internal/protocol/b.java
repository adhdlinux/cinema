package com.facebook.ads.internal.protocol;

public class b extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final AdErrorType f20545a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20546b;

    public b(AdErrorType adErrorType, String str) {
        this(adErrorType, str, (Throwable) null);
    }

    public b(AdErrorType adErrorType, String str, Throwable th) {
        super(str, th);
        this.f20545a = adErrorType;
        this.f20546b = str;
    }

    public AdErrorType a() {
        return this.f20545a;
    }

    public String b() {
        return this.f20546b;
    }
}
