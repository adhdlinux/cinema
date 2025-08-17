package com.startapp;

import com.startapp.networkTest.data.TimeInfo;

public class y2 {
    public static String a(TimeInfo timeInfo, String str) {
        byte[] bArr;
        if (timeInfo == null || str == null || str.length() == 0) {
            return null;
        }
        try {
            bArr = e1.a((str + timeInfo.TimestampMillis).getBytes("UTF-8"));
        } catch (Throwable th) {
            l2.a(th);
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return v2.a(bArr);
    }
}
