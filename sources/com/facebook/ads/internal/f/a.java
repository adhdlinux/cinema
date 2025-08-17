package com.facebook.ads.internal.f;

import com.facebook.ads.internal.q.a.n;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashMap;
import java.util.Map;

public class a extends d {
    public a(String str, String str2) {
        super(n.b(), n.c(), a(str, str2));
    }

    private static Map<String, String> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("key", str);
        hashMap.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, str2);
        return hashMap;
    }

    public String a() {
        return "client_response";
    }
}
