package com.chartboost.sdk.impl;

import com.vungle.ads.internal.Constants;

public enum f9 {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL("normal"),
    EXPANDED("expanded"),
    FULLSCREEN(Constants.TEMPLATE_TYPE_FULLSCREEN);
    

    /* renamed from: b  reason: collision with root package name */
    public final String f17702b;

    /* access modifiers changed from: public */
    f9(String str) {
        this.f17702b = str;
    }

    public String toString() {
        return this.f17702b;
    }
}
