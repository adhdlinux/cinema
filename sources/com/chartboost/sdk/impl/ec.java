package com.chartboost.sdk.impl;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.jvm.internal.Intrinsics;

public final class ec {

    /* renamed from: a  reason: collision with root package name */
    public final String f17649a;

    /* renamed from: b  reason: collision with root package name */
    public final l3 f17650b;

    public ec(String str, l3 l3Var) {
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(l3Var, "clickPreference");
        this.f17649a = str;
        this.f17650b = l3Var;
    }

    public final ec a(String str, l3 l3Var) {
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(l3Var, "clickPreference");
        return new ec(str, l3Var);
    }

    public final String b() {
        return this.f17649a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ec)) {
            return false;
        }
        ec ecVar = (ec) obj;
        return Intrinsics.a(this.f17649a, ecVar.f17649a) && this.f17650b == ecVar.f17650b;
    }

    public int hashCode() {
        return (this.f17649a.hashCode() * 31) + this.f17650b.hashCode();
    }

    public String toString() {
        return "UrlArgs(url=" + this.f17649a + ", clickPreference=" + this.f17650b + ')';
    }

    public static /* synthetic */ ec a(ec ecVar, String str, l3 l3Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = ecVar.f17649a;
        }
        if ((i2 & 2) != 0) {
            l3Var = ecVar.f17650b;
        }
        return ecVar.a(str, l3Var);
    }

    public final l3 a() {
        return this.f17650b;
    }
}
