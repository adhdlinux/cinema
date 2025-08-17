package com.chartboost.sdk.impl;

import kotlin.jvm.internal.Intrinsics;

public final class dc {

    /* renamed from: a  reason: collision with root package name */
    public final String f17465a;

    public dc(String str) {
        Intrinsics.f(str, "actionName");
        this.f17465a = str;
    }

    public final String a() {
        return this.f17465a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof dc) && Intrinsics.a(this.f17465a, ((dc) obj).f17465a);
    }

    public int hashCode() {
        return this.f17465a.hashCode();
    }

    public String toString() {
        return "UrlActionResult(actionName=" + this.f17465a + ')';
    }
}
