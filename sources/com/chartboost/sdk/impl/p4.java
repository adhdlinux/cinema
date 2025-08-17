package com.chartboost.sdk.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;

public enum p4 {
    NONE(0),
    STOPPED_QUEUE(1),
    MAX_COUNT_TIME_WINDOW(2),
    FORCED_OUT(3);
    

    /* renamed from: c  reason: collision with root package name */
    public static final a f18330c = null;

    /* renamed from: b  reason: collision with root package name */
    public final int f18336b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    static {
        f18330c = new a((DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: public */
    p4(int i2) {
        this.f18336b = i2;
    }

    public final int b() {
        return this.f18336b;
    }
}
