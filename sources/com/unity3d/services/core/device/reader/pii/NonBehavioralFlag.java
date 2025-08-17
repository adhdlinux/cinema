package com.unity3d.services.core.device.reader.pii;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public enum NonBehavioralFlag {
    UNKNOWN,
    TRUE,
    FALSE;
    
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NonBehavioralFlag fromString(String str) {
            NonBehavioralFlag nonBehavioralFlag;
            Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            try {
                Result.Companion companion = Result.f40263c;
                String upperCase = str.toUpperCase(Locale.ROOT);
                Intrinsics.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                nonBehavioralFlag = Result.b(NonBehavioralFlag.valueOf(upperCase));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f40263c;
                nonBehavioralFlag = Result.b(ResultKt.a(th));
            }
            NonBehavioralFlag nonBehavioralFlag2 = NonBehavioralFlag.UNKNOWN;
            if (Result.g(nonBehavioralFlag)) {
                nonBehavioralFlag = nonBehavioralFlag2;
            }
            return (NonBehavioralFlag) nonBehavioralFlag;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }
}
