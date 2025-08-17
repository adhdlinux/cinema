package com.chartboost.sdk.impl;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.jvm.internal.Intrinsics;

public final class pc {

    /* renamed from: a  reason: collision with root package name */
    public final String f18386a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18387b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18388c;

    public pc(String str, String str2, String str3) {
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(str2, "vendor");
        Intrinsics.f(str3, "params");
        this.f18386a = str;
        this.f18387b = str2;
        this.f18388c = str3;
    }

    public final String a() {
        return this.f18388c;
    }

    public final String b() {
        return this.f18386a;
    }

    public final String c() {
        return this.f18387b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pc)) {
            return false;
        }
        pc pcVar = (pc) obj;
        return Intrinsics.a(this.f18386a, pcVar.f18386a) && Intrinsics.a(this.f18387b, pcVar.f18387b) && Intrinsics.a(this.f18388c, pcVar.f18388c);
    }

    public int hashCode() {
        return (((this.f18386a.hashCode() * 31) + this.f18387b.hashCode()) * 31) + this.f18388c.hashCode();
    }

    public String toString() {
        return "VerificationModel(url=" + this.f18386a + ", vendor=" + this.f18387b + ", params=" + this.f18388c + ')';
    }
}
