package com.startapp;

import android.net.LinkProperties;
import android.net.NetworkCapabilities;

public class s2 {
    public static String a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            try {
                return a(networkCapabilities.toString(), "Capabilities:").replaceAll("&", ",").toLowerCase();
            } catch (Throwable th) {
                l2.a(th);
            }
        }
        return "";
    }

    public static int b(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            try {
                return Integer.parseInt(a(networkCapabilities.toString(), "Specifier:").replaceAll("<", "").replaceAll(">", ""));
            } catch (Throwable th) {
                l2.a(th);
            }
        }
        return -1;
    }

    public static String a(LinkProperties linkProperties) {
        if (linkProperties == null) {
            return "";
        }
        try {
            String a2 = a(linkProperties.toString().replaceAll("\\[ ", "\\[").replaceAll(" \\]", "\\]"), "PcscfAddresses:");
            if (a2.isEmpty()) {
                return "";
            }
            String replace = a2.replace("[", "").replace("]", "");
            return replace.lastIndexOf(",") == replace.length() + -1 ? replace.substring(0, replace.length() - 1) : replace;
        } catch (Throwable th) {
            l2.a(th);
            return "";
        }
    }

    private static String a(String str, String str2) throws Exception {
        String substring = str.substring(str.indexOf(str2));
        String replaceAll = substring.replaceAll(str2 + " ", "");
        return replaceAll.substring(0, replaceAll.contains(" ") ? replaceAll.indexOf(" ") : replaceAll.length() - 1);
    }
}
