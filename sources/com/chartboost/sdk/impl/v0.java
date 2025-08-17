package com.chartboost.sdk.impl;

import android.content.Context;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.privacy.model.COPPA;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import kotlin.jvm.internal.Intrinsics;

public abstract class v0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f18814a;

    public v0(Context context) {
        Intrinsics.f(context, "context");
        this.f18814a = context;
    }

    public final boolean a() {
        Object obj;
        try {
            DataUseConsent dataUseConsent = Chartboost.getDataUseConsent(this.f18814a, COPPA.COPPA_STANDARD);
            Boolean bool = null;
            if (dataUseConsent != null) {
                obj = dataUseConsent.getConsent();
            } else {
                obj = null;
            }
            if (obj instanceof Boolean) {
                bool = (Boolean) obj;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
