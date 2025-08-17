package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import kotlin.jvm.internal.Intrinsics;

public final class c7 {

    /* renamed from: a  reason: collision with root package name */
    public final e2 f17329a;

    /* renamed from: b  reason: collision with root package name */
    public final CBError.CBImpressionError f17330b;

    public c7(e2 e2Var, CBError.CBImpressionError cBImpressionError) {
        this.f17329a = e2Var;
        this.f17330b = cBImpressionError;
    }

    public final CBError.CBImpressionError a() {
        return this.f17330b;
    }

    public final e2 b() {
        return this.f17329a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c7)) {
            return false;
        }
        c7 c7Var = (c7) obj;
        return Intrinsics.a(this.f17329a, c7Var.f17329a) && this.f17330b == c7Var.f17330b;
    }

    public int hashCode() {
        e2 e2Var = this.f17329a;
        int i2 = 0;
        int hashCode = (e2Var == null ? 0 : e2Var.hashCode()) * 31;
        CBError.CBImpressionError cBImpressionError = this.f17330b;
        if (cBImpressionError != null) {
            i2 = cBImpressionError.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "ImpressionHolder(impression=" + this.f17329a + ", error=" + this.f17330b + ')';
    }
}
