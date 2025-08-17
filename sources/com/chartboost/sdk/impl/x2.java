package com.chartboost.sdk.impl;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.jvm.internal.Intrinsics;

public final class x2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f18927a;

    /* renamed from: b  reason: collision with root package name */
    public final Boolean f18928b;

    public x2(String str, Boolean bool) {
        Intrinsics.f(str, ImagesContract.URL);
        this.f18927a = str;
        this.f18928b = bool;
    }

    public final Boolean a() {
        return this.f18928b;
    }

    public final String b() {
        return this.f18927a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x2)) {
            return false;
        }
        x2 x2Var = (x2) obj;
        return Intrinsics.a(this.f18927a, x2Var.f18927a) && Intrinsics.a(this.f18928b, x2Var.f18928b);
    }

    public int hashCode() {
        int hashCode = this.f18927a.hashCode() * 31;
        Boolean bool = this.f18928b;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "CBUrl(url=" + this.f18927a + ", shouldDismiss=" + this.f18928b + ')';
    }
}
