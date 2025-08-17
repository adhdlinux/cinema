package com.applovin.impl.sdk;

import android.os.Process;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final AppLovinExceptionHandler f14969a = new AppLovinExceptionHandler();

    /* renamed from: b  reason: collision with root package name */
    private final Set<m> f14970b = new HashSet(2);

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f14971c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f14972d;

    public static AppLovinExceptionHandler shared() {
        return f14969a;
    }

    public void addSdk(m mVar) {
        this.f14970b.add(mVar);
    }

    public void enable() {
        if (this.f14971c.compareAndSet(false, true)) {
            this.f14972d = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        for (m next : this.f14970b) {
            if (v.a()) {
                next.A().b("AppLovinExceptionHandler", "Detected unhandled exception");
            }
            ((EventServiceImpl) next.w()).trackEventSynchronously("paused");
            ((EventServiceImpl) next.w()).trackEventSynchronously("crashed");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f14972d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
