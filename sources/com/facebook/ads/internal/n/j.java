package com.facebook.ads.internal.n;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import org.json.JSONObject;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final double f20379a;

    /* renamed from: b  reason: collision with root package name */
    private final double f20380b;

    public j(double d2, double d3) {
        this.f20379a = d2;
        this.f20380b = d3;
    }

    public static j a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0.0d);
        double optDouble2 = jSONObject.optDouble("scale", 0.0d);
        if (optDouble == 0.0d || optDouble2 == 0.0d) {
            return null;
        }
        return new j(optDouble, optDouble2);
    }

    public double a() {
        return this.f20379a;
    }

    public double b() {
        return this.f20380b;
    }
}
