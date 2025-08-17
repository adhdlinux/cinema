package com.google.android.exoplayer2;

import java.util.HashSet;

public final class ExoPlayerLibraryInfo {

    /* renamed from: a  reason: collision with root package name */
    private static final HashSet<String> f23039a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private static String f23040b = "goog.exo.core";

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f23041c = 0;

    private ExoPlayerLibraryInfo() {
    }

    public static synchronized void a(String str) {
        synchronized (ExoPlayerLibraryInfo.class) {
            if (f23039a.add(str)) {
                f23040b += ", " + str;
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (ExoPlayerLibraryInfo.class) {
            str = f23040b;
        }
        return str;
    }
}
