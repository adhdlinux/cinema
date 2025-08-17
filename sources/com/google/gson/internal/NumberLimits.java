package com.google.gson.internal;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberLimits {
    private NumberLimits() {
    }

    private static void a(String str) {
        if (str.length() > 10000) {
            throw new NumberFormatException("Number string too large: " + str.substring(0, 30) + "...");
        }
    }

    public static BigDecimal b(String str) throws NumberFormatException {
        a(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs((long) bigDecimal.scale()) < NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
            return bigDecimal;
        }
        throw new NumberFormatException("Number has unsupported scale: " + str);
    }

    public static BigInteger c(String str) throws NumberFormatException {
        a(str);
        return new BigInteger(str);
    }
}
