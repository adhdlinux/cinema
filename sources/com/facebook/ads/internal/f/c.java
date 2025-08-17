package com.facebook.ads.internal.f;

import android.content.Context;
import android.os.Process;
import com.facebook.ads.BuildConfig;
import com.facebook.ads.internal.q.a.n;
import com.facebook.ads.internal.q.a.q;
import java.lang.Thread;
import java.util.Map;

public class c implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f20150a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f20151b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f20152c;

    public c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Context context, Map<String, String> map) {
        this.f20150a = uncaughtExceptionHandler;
        if (context != null) {
            this.f20151b = context.getApplicationContext();
            this.f20152c = map;
            return;
        }
        throw new IllegalArgumentException("Missing Context");
    }

    private void a(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f20150a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
        try {
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a2 = q.a(th);
            if (a2 != null && a2.contains(BuildConfig.APPLICATION_ID)) {
                Map<String, String> a3 = new b(a2, this.f20152c).a();
                a3.put("subtype", "crash");
                a3.put("subtype_code", "0");
                e.a(new d(n.b(), n.c(), a3), this.f20151b);
            }
        } catch (Exception unused) {
        }
        a(thread, th);
    }
}
