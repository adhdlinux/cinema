package com.chartboost.sdk.privacy.model;

import com.chartboost.sdk.impl.a5;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class GDPR extends GenericDataUseConsent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String GDPR_STANDARD = "gdpr";

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public enum GDPR_CONSENT {
        NON_BEHAVIORAL("0"),
        BEHAVIORAL("1");
        
        public static final Companion Companion = null;

        /* renamed from: b  reason: collision with root package name */
        public final String f19189b;

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final GDPR_CONSENT fromValue(String str) {
                Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                GDPR_CONSENT gdpr_consent = GDPR_CONSENT.NON_BEHAVIORAL;
                if (Intrinsics.a(gdpr_consent.getValue(), str)) {
                    return gdpr_consent;
                }
                GDPR_CONSENT gdpr_consent2 = GDPR_CONSENT.BEHAVIORAL;
                if (Intrinsics.a(gdpr_consent2.getValue(), str)) {
                    return gdpr_consent2;
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
        GDPR_CONSENT(String str) {
            this.f19189b = str;
        }

        public static final GDPR_CONSENT fromValue(String str) {
            return Companion.fromValue(str);
        }

        public final String getValue() {
            return this.f19189b;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GDPR(GDPR_CONSENT gdpr_consent) {
        super((a5) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.f(gdpr_consent, "consent");
        if (c(gdpr_consent.getValue())) {
            b(GDPR_STANDARD);
            a((Object) gdpr_consent.getValue());
            return;
        }
        a("Invalid GDPR consent values. Use provided values or Custom class. Value: " + gdpr_consent);
    }

    private final boolean c(String str) {
        return Intrinsics.a(GDPR_CONSENT.NON_BEHAVIORAL.getValue(), str) || Intrinsics.a(GDPR_CONSENT.BEHAVIORAL.getValue(), str);
    }

    public String getConsent() {
        Object a2 = a();
        Intrinsics.d(a2, "null cannot be cast to non-null type kotlin.String");
        return (String) a2;
    }
}
