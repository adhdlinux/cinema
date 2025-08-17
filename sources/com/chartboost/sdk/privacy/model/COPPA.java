package com.chartboost.sdk.privacy.model;

import com.chartboost.sdk.impl.a5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class COPPA extends GenericDataUseConsent {
    public static final String COPPA_STANDARD = "coppa";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public COPPA(boolean z2) {
        super((a5) null, 1, (DefaultConstructorMarker) null);
        b(COPPA_STANDARD);
        a((Object) Boolean.valueOf(z2));
    }

    public Boolean getConsent() {
        Object a2 = a();
        Intrinsics.d(a2, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) a2;
    }
}
