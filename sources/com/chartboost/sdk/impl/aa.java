package com.chartboost.sdk.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;

public enum aa {
    MRAID("mraid"),
    HTML("html"),
    VAST("vast"),
    UNKNOWN("unknown");
    

    /* renamed from: c  reason: collision with root package name */
    public static final a f17218c = null;

    /* renamed from: b  reason: collision with root package name */
    public final String f17224b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final aa a(String str) {
            aa aaVar;
            aa[] values = aa.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    aaVar = null;
                    break;
                }
                aaVar = values[i2];
                if (StringsKt__StringsJVMKt.t(aaVar.b(), str, true)) {
                    break;
                }
                i2++;
            }
            return aaVar == null ? aa.UNKNOWN : aaVar;
        }

        public a() {
        }
    }

    static {
        f17218c = new a((DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: public */
    aa(String str) {
        this.f17224b = str;
    }

    public final String b() {
        return this.f17224b;
    }
}
