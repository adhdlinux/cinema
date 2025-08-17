package com.chartboost.sdk.privacy.model;

import com.chartboost.sdk.impl.a5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class LGPD extends GenericDataUseConsent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LGPD_STANDARD = "lgpd";

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LGPD(boolean z2) {
        super((a5) null, 1, (DefaultConstructorMarker) null);
        b(LGPD_STANDARD);
        a((Object) Boolean.valueOf(z2));
    }

    public Boolean getConsent() {
        Object a2 = a();
        Intrinsics.d(a2, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) a2;
    }
}
