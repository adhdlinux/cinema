package com.chartboost.sdk.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class k9 {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f18038a;

    /* renamed from: b  reason: collision with root package name */
    public final List f18039b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f18040c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f18041d;

    /* renamed from: e  reason: collision with root package name */
    public final JSONObject f18042e;

    /* renamed from: f  reason: collision with root package name */
    public final String f18043f;

    /* renamed from: g  reason: collision with root package name */
    public final String f18044g;

    public k9(Integer num, List list, Integer num2, Integer num3, JSONObject jSONObject, String str, String str2) {
        this.f18038a = num;
        this.f18039b = list;
        this.f18040c = num2;
        this.f18041d = num3;
        this.f18042e = jSONObject;
        this.f18043f = str;
        this.f18044g = str2;
    }

    public final Integer a() {
        return this.f18038a;
    }

    public final Integer b() {
        return this.f18041d;
    }

    public final Integer c() {
        return this.f18040c;
    }

    public final String d() {
        return this.f18043f;
    }

    public final JSONObject e() {
        return this.f18042e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k9)) {
            return false;
        }
        k9 k9Var = (k9) obj;
        return Intrinsics.a(this.f18038a, k9Var.f18038a) && Intrinsics.a(this.f18039b, k9Var.f18039b) && Intrinsics.a(this.f18040c, k9Var.f18040c) && Intrinsics.a(this.f18041d, k9Var.f18041d) && Intrinsics.a(this.f18042e, k9Var.f18042e) && Intrinsics.a(this.f18043f, k9Var.f18043f) && Intrinsics.a(this.f18044g, k9Var.f18044g);
    }

    public final String f() {
        return this.f18044g;
    }

    public final List g() {
        return this.f18039b;
    }

    public int hashCode() {
        Integer num = this.f18038a;
        int i2 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List list = this.f18039b;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.f18040c;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f18041d;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        JSONObject jSONObject = this.f18042e;
        int hashCode5 = (hashCode4 + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        String str = this.f18043f;
        int hashCode6 = (hashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f18044g;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode6 + i2;
    }

    public String toString() {
        return "PrivacyBodyFields(openRtbConsent=" + this.f18038a + ", whitelistedPrivacyStandardsList=" + this.f18039b + ", openRtbGdpr=" + this.f18040c + ", openRtbCoppa=" + this.f18041d + ", privacyListAsJson=" + this.f18042e + ", piDataUseConsent=" + this.f18043f + ", tcfString=" + this.f18044g + ')';
    }
}
