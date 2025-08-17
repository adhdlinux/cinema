package com.chartboost.sdk.privacy.model;

import com.chartboost.sdk.impl.a5;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class CCPA extends GenericDataUseConsent {
    public static final String CCPA_STANDARD = "us_privacy";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public enum CCPA_CONSENT {
        OPT_OUT_SALE("1YY-"),
        OPT_IN_SALE("1YN-");
        
        public static final Companion Companion = null;

        /* renamed from: b  reason: collision with root package name */
        public final String f19186b;

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final CCPA_CONSENT fromValue(String str) {
                Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                CCPA_CONSENT ccpa_consent = CCPA_CONSENT.OPT_OUT_SALE;
                if (Intrinsics.a(ccpa_consent.getValue(), str)) {
                    return ccpa_consent;
                }
                CCPA_CONSENT ccpa_consent2 = CCPA_CONSENT.OPT_IN_SALE;
                if (Intrinsics.a(ccpa_consent2.getValue(), str)) {
                    return ccpa_consent2;
                }
                return null;
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: public */
        CCPA_CONSENT(String str) {
            this.f19186b = str;
        }

        public static final CCPA_CONSENT fromValue(String str) {
            return Companion.fromValue(str);
        }

        public final String getValue() {
            return this.f19186b;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CCPA(CCPA_CONSENT ccpa_consent) {
        super((a5) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.f(ccpa_consent, "consent");
        if (c(ccpa_consent.getValue())) {
            b(CCPA_STANDARD);
            a((Object) ccpa_consent.getValue());
            return;
        }
        a("Invalid CCPA consent values. Use provided values or Custom class. Value: " + ccpa_consent);
    }

    public final boolean c(String str) {
        return Intrinsics.a(CCPA_CONSENT.OPT_OUT_SALE.getValue(), str) || Intrinsics.a(CCPA_CONSENT.OPT_IN_SALE.getValue(), str);
    }

    public String getConsent() {
        Object a2 = a();
        Intrinsics.d(a2, "null cannot be cast to non-null type kotlin.String");
        return (String) a2;
    }
}
