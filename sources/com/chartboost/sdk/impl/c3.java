package com.chartboost.sdk.impl;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;

public class c3 {
    public b3 a(Context context) {
        String str;
        String str2;
        if (c(context)) {
            w7.a("CarrierBuilder", "Permission READ_PHONE_STATE not granted");
            return null;
        }
        TelephonyManager b2 = b(context);
        if (!a(b2)) {
            return null;
        }
        String simOperator = b2.getSimOperator();
        if (!TextUtils.isEmpty(simOperator)) {
            str2 = simOperator.substring(0, 3);
            str = simOperator.substring(3);
        } else {
            str2 = null;
            str = null;
        }
        return new b3(simOperator, str2, str, b2.getNetworkOperatorName(), b2.getNetworkCountryIso(), b2.getPhoneType());
    }

    public final TelephonyManager b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return (TelephonyManager) context.getSystemService("phone");
        } catch (Exception e2) {
            w7.b("CarrierBuilder", "Unable to retrieve TELEPHONY_SERVICE " + e2.toString());
            return null;
        }
    }

    public final boolean c(Context context) {
        if (context == null || ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != -1) {
            return false;
        }
        return true;
    }

    public final boolean a(TelephonyManager telephonyManager) {
        return (telephonyManager == null || telephonyManager.getPhoneType() == 0 || telephonyManager.getSimState() != 5) ? false : true;
    }
}
