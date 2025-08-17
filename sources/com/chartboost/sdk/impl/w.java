package com.chartboost.sdk.impl;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f18880a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18881b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18882c;

    public w(ViewGroup viewGroup, int i2, int i3) {
        Intrinsics.f(viewGroup, "bannerView");
        this.f18880a = viewGroup;
        this.f18881b = i2;
        this.f18882c = i3;
    }

    public final int a() {
        return this.f18882c;
    }

    public final ViewGroup b() {
        return this.f18880a;
    }

    public final int c() {
        return this.f18881b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return Intrinsics.a(this.f18880a, wVar.f18880a) && this.f18881b == wVar.f18881b && this.f18882c == wVar.f18882c;
    }

    public int hashCode() {
        return (((this.f18880a.hashCode() * 31) + this.f18881b) * 31) + this.f18882c;
    }

    public String toString() {
        return "AdUnitBannerData(bannerView=" + this.f18880a + ", bannerWidth=" + this.f18881b + ", bannerHeight=" + this.f18882c + ')';
    }
}
