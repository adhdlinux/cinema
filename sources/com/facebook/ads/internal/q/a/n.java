package com.facebook.ads.internal.q.a;

import java.util.UUID;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20652a = "n";

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f20653b = false;

    /* renamed from: c  reason: collision with root package name */
    private static double f20654c;

    /* renamed from: d  reason: collision with root package name */
    private static String f20655d;

    public static void a() {
        if (!f20653b) {
            synchronized (f20652a) {
                if (!f20653b) {
                    f20653b = true;
                    f20654c = ((double) System.currentTimeMillis()) / 1000.0d;
                    f20655d = UUID.randomUUID().toString();
                }
            }
        }
    }

    public static double b() {
        return f20654c;
    }

    public static String c() {
        return f20655d;
    }
}
