package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public abstract class u1 {
    public static boolean a(AtomicReference atomicReference, JSONObject jSONObject) {
        try {
            atomicReference.set(new pa(jSONObject));
            return true;
        } catch (Exception e2) {
            w7.b("CBConfig", "updateConfig: " + e2.toString());
            return false;
        }
    }

    public static boolean a(Context context) {
        int i2;
        int i3;
        if (context != null) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    i3 = context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE");
                    i2 = context.checkSelfPermission("android.permission.INTERNET");
                } else {
                    i3 = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
                    i2 = context.checkCallingOrSelfPermission("android.permission.INTERNET");
                }
                boolean z2 = i2 != 0;
                boolean z3 = i3 != 0;
                if (z2) {
                    throw new RuntimeException("Please add the permission : android.permission.INTERNET in your android manifest.xml");
                } else if (!z3) {
                    return true;
                } else {
                    throw new RuntimeException("Please add the permission : android.permission.ACCESS_NETWORK_STATE in your android manifest.xml");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } else {
            throw new RuntimeException("Invalid activity context passed during intitalization");
        }
    }
}
