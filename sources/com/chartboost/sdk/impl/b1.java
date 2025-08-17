package com.chartboost.sdk.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class b1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f17254a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17255b;

    /* renamed from: c  reason: collision with root package name */
    public String f17256c;

    /* renamed from: d  reason: collision with root package name */
    public w f17257d;

    /* renamed from: e  reason: collision with root package name */
    public v f17258e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17259f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17260g;

    public b1(int i2, String str, String str2, w wVar, v vVar, boolean z2, boolean z3) {
        Intrinsics.f(str, "location");
        this.f17254a = i2;
        this.f17255b = str;
        this.f17256c = str2;
        this.f17257d = wVar;
        this.f17258e = vVar;
        this.f17259f = z2;
        this.f17260g = z3;
    }

    public final void a(String str) {
        this.f17256c = str;
    }

    public final w b() {
        return this.f17257d;
    }

    public final String c() {
        return this.f17256c;
    }

    public final String d() {
        return this.f17255b;
    }

    public final boolean e() {
        return this.f17260g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        return this.f17254a == b1Var.f17254a && Intrinsics.a(this.f17255b, b1Var.f17255b) && Intrinsics.a(this.f17256c, b1Var.f17256c) && Intrinsics.a(this.f17257d, b1Var.f17257d) && Intrinsics.a(this.f17258e, b1Var.f17258e) && this.f17259f == b1Var.f17259f && this.f17260g == b1Var.f17260g;
    }

    public int hashCode() {
        int hashCode = ((this.f17254a * 31) + this.f17255b.hashCode()) * 31;
        String str = this.f17256c;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        w wVar = this.f17257d;
        int hashCode3 = (hashCode2 + (wVar == null ? 0 : wVar.hashCode())) * 31;
        v vVar = this.f17258e;
        if (vVar != null) {
            i2 = vVar.hashCode();
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z2 = this.f17259f;
        boolean z3 = true;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        boolean z4 = this.f17260g;
        if (!z4) {
            z3 = z4;
        }
        return i4 + (z3 ? 1 : 0);
    }

    public String toString() {
        return "AppRequest(id=" + this.f17254a + ", location=" + this.f17255b + ", bidResponse=" + this.f17256c + ", bannerData=" + this.f17257d + ", adUnit=" + this.f17258e + ", isTrackedCache=" + this.f17259f + ", isTrackedShow=" + this.f17260g + ')';
    }

    public final void a(w wVar) {
        this.f17257d = wVar;
    }

    public final void b(boolean z2) {
        this.f17260g = z2;
    }

    public final v a() {
        return this.f17258e;
    }

    public final void a(v vVar) {
        this.f17258e = vVar;
    }

    public final void a(boolean z2) {
        this.f17259f = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b1(int i2, String str, String str2, w wVar, v vVar, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, str, str2, (i3 & 8) != 0 ? null : wVar, (i3 & 16) != 0 ? null : vVar, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? false : z3);
    }
}
