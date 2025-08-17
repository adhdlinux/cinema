package com.chartboost.sdk.internal.Networking;

import android.util.Log;
import com.chartboost.sdk.impl.w7;
import java.net.URL;

public class NetworkHelper {
    private static String debugEndpoint = null;
    private static boolean isforceSDKToAcceptAllSSLCertsEnabled = false;

    public static String a(String str, String str2) {
        String str3 = debugEndpoint;
        if (str3 != null && !str3.isEmpty()) {
            Log.w("Chartboost", "normalizedUrl: " + str + " to: " + debugEndpoint);
            str = debugEndpoint;
        }
        Object[] objArr = new Object[3];
        objArr[0] = str;
        String str4 = "/";
        if (str2 != null && str2.startsWith(str4)) {
            str4 = "";
        }
        objArr[1] = str4;
        if (str2 == null) {
            str2 = "";
        }
        objArr[2] = str2;
        return String.format("%s%s%s", objArr);
    }

    public static String b(String str) {
        URL c2 = c(str);
        if (c2 == null) {
            return "";
        }
        try {
            return c2.getPath();
        } catch (Exception e2) {
            w7.a("NetworkHelper", "getPathFromUrl: " + str + " : " + e2.toString());
            return "";
        }
    }

    public static URL c(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            return new URL(str);
        } catch (Exception e2) {
            w7.a("NetworkHelper", "stringToURL: " + str + " : " + e2.toString());
            return null;
        }
    }

    private static void setDebugUrl(String str) {
        debugEndpoint = str;
    }

    public static String a(String str) {
        URL c2 = c(str);
        if (c2 == null) {
            return "";
        }
        try {
            return c2.getProtocol() + "://" + c2.getHost();
        } catch (Exception e2) {
            w7.a("NetworkHelper", "getEndpointFromUrl: " + str + " : " + e2.toString());
            return "";
        }
    }

    public static boolean a() {
        return isforceSDKToAcceptAllSSLCertsEnabled;
    }
}
