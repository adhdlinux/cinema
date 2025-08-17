package com.facebook.ads.internal.protocol;

import android.text.TextUtils;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final AdErrorType f20543a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20544b;

    public a(int i2, String str) {
        this(AdErrorType.adErrorTypeFromCode(i2), str);
    }

    public a(AdErrorType adErrorType, String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.f20543a = adErrorType;
        this.f20544b = str;
    }

    public static a a(AdErrorType adErrorType, String str) {
        return new a(adErrorType, str);
    }

    public static a a(b bVar) {
        return new a(bVar.a(), bVar.b());
    }

    public AdErrorType a() {
        return this.f20543a;
    }

    public String b() {
        return this.f20544b;
    }
}
