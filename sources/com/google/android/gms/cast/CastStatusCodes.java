package com.google.android.gms.cast;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Locale;

public final class CastStatusCodes extends CommonStatusCodes {
    public static final int APPLICATION_NOT_FOUND = 2004;
    public static final int APPLICATION_NOT_RUNNING = 2005;
    public static final int AUTHENTICATION_FAILED = 2000;
    public static final int CANCELED = 2002;
    public static final int DEVICE_CONNECTION_SUSPENDED = 2016;
    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_CAST_PLATFORM_INCOMPATIBLE = 2110;
    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_CAST_PLATFORM_NOT_CONNECTED = 2113;
    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_DEVICE_ID_FLAGS_NOT_SET = 2115;
    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_HOST_NOT_ALLOWED = 2112;
    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_NO_CAST_CONFIGURATION = 2114;
    public static final int ERROR_SERVICE_CREATION_FAILED = 2200;
    public static final int ERROR_SERVICE_DISCONNECTED = 2201;
    public static final int ERROR_STOPPING_SERVICE_FAILED = 2202;
    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_URL_INSEURE = 2111;
    public static final int FAILED = 2100;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 14;
    public static final int INVALID_REQUEST = 2001;
    public static final int MEDIA_ERROR = 2104;
    public static final int MESSAGE_SEND_BUFFER_TOO_FULL = 2007;
    public static final int MESSAGE_TOO_LARGE = 2006;
    public static final int NETWORK_ERROR = 7;
    public static final int NOT_ALLOWED = 2003;
    public static final int REPLACED = 2103;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 15;
    public static final int UNKNOWN_ERROR = 13;

    private CastStatusCodes() {
    }

    public static String getStatusCodeString(int i2) {
        if (i2 < -999 || i2 > 999) {
            if (i2 < 2000 || i2 > 2049) {
                if (i2 >= 2050 && i2 <= 2059) {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Cast controller status code", Integer.valueOf(i2)});
                } else if (i2 >= 2100 && i2 <= 2109) {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Media control channel status code", Integer.valueOf(i2)});
                } else if (i2 >= 2150 && i2 <= 2169) {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Cast session status code", Integer.valueOf(i2)});
                } else if (i2 >= 2200 && i2 <= 2219) {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Cast remote display status code", Integer.valueOf(i2)});
                } else if (i2 >= 2250 && i2 <= 2289) {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Cast socket status code", Integer.valueOf(i2)});
                } else if (i2 >= 2300 && i2 <= 2309) {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Cast service status code", Integer.valueOf(i2)});
                } else if (i2 >= 2310 && i2 <= 2319) {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Endpoint switch status code", Integer.valueOf(i2)});
                } else if (i2 >= 2350 && i2 <= 2359) {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Cast multizone device status code", Integer.valueOf(i2)});
                } else if (i2 >= 2400 && i2 <= 2419) {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Cast relay casting status code", Integer.valueOf(i2)});
                } else if (i2 >= 2450 && i2 <= 2469) {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Cast nearby casting status code", Integer.valueOf(i2)});
                } else if (i2 >= 2470 && i2 <= 2479) {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Cast application status code", Integer.valueOf(i2)});
                } else if (i2 < 2490 || i2 > 2499) {
                    return String.format(Locale.ROOT, "Unknown cast status code %d", new Object[]{Integer.valueOf(i2)});
                } else {
                    return String.format(Locale.ROOT, "%s %d", new Object[]{"Cast media loading status code", Integer.valueOf(i2)});
                }
            } else if (i2 == 2015) {
                return "TCP_PROBER_FAIL_TO_VERIFY_DEVICE";
            } else {
                switch (i2) {
                    case 2000:
                        return "AUTHENTICATION_FAILED";
                    case 2001:
                        return "INVALID_REQUEST";
                    case 2002:
                        return "CANCELED";
                    case 2003:
                        return "NOT_ALLOWED";
                    case 2004:
                        return "APPLICATION_NOT_FOUND";
                    case 2005:
                        return "APPLICATION_NOT_RUNNING";
                    case 2006:
                        return "MESSAGE_TOO_LARGE";
                    case 2007:
                        return "MESSAGE_SEND_BUFFER_TOO_FULL";
                    default:
                        return String.format(Locale.ROOT, "%s %d", new Object[]{"Common cast status code", Integer.valueOf(i2)});
                }
            }
        } else if (i2 == 0) {
            return "SUCCESS";
        } else {
            if (i2 == 7) {
                return "NETWORK_ERROR";
            }
            if (i2 == 14) {
                return "INTERRUPTED";
            }
            if (i2 != 15) {
                return CommonStatusCodes.getStatusCodeString(i2);
            }
            return "TIMEOUT";
        }
    }
}
