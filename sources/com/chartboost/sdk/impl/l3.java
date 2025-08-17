package com.chartboost.sdk.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;

public enum l3 {
    CLICK_PREFERENCE_EMBEDDED(0),
    CLICK_PREFERENCE_NATIVE(1);
    

    /* renamed from: c  reason: collision with root package name */
    public static final a f18098c = null;

    /* renamed from: b  reason: collision with root package name */
    public final int f18102b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final l3 a(int i2) {
            if (i2 == 0) {
                return l3.CLICK_PREFERENCE_EMBEDDED;
            }
            if (i2 != 1) {
                return l3.CLICK_PREFERENCE_EMBEDDED;
            }
            return l3.CLICK_PREFERENCE_NATIVE;
        }

        public a() {
        }
    }

    static {
        f18098c = new a((DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: public */
    l3(int i2) {
        this.f18102b = i2;
    }

    public final int b() {
        return this.f18102b;
    }
}
