package com.startapp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class c3 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34284a = "c3";

    public static String a(String str) {
        String str2;
        try {
            str2 = InetAddress.getByName(str).getCanonicalHostName();
        } catch (UnknownHostException e2) {
            l2.b(e2);
            str2 = null;
        }
        if (str2 != null && !str2.equals(str) && str2.contains("cloudfront")) {
            String[] split = str2.split("\\.");
            if (split.length > 0) {
                return b(split[1]);
            }
        }
        return "";
    }

    public static String b(String str) {
        if (str == null || str.length() <= 2) {
            return "";
        }
        return str.substring(0, 3);
    }
}
