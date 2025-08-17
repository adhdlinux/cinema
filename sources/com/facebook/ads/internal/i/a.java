package com.facebook.ads.internal.i;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.f.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20205a = "com.facebook.ads.internal.i.a";

    /* renamed from: b  reason: collision with root package name */
    private static a f20206b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f20207c = false;

    /* renamed from: d  reason: collision with root package name */
    private Context f20208d;

    private a(Context context) {
        this.f20208d = context;
    }

    public static a a(Context context) {
        if (f20206b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f20206b == null) {
                    f20206b = new a(applicationContext);
                }
            }
        }
        return f20206b;
    }

    public synchronized void a() {
        if (!f20207c) {
            if (com.facebook.ads.internal.l.a.h(this.f20208d)) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(new c(Thread.getDefaultUncaughtExceptionHandler(), this.f20208d, new c(this.f20208d, false).b()));
                } catch (SecurityException e2) {
                    Log.e(f20205a, "No permissions to set the default uncaught exception handler", e2);
                }
            }
            f20207c = true;
        }
    }
}
