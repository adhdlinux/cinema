package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;

public class o2 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f18284a;

    /* renamed from: b  reason: collision with root package name */
    public final CBError f18285b;

    public o2(Object obj, CBError cBError) {
        this.f18284a = obj;
        this.f18285b = cBError;
    }

    public static o2 a(Object obj) {
        return new o2(obj, (CBError) null);
    }

    public static o2 a(CBError cBError) {
        return new o2((Object) null, cBError);
    }
}
