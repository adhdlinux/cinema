package com.startapp;

public class o2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f35545a;

    public o2(Runnable runnable) {
        this.f35545a = runnable;
    }

    public void run() {
        try {
            this.f35545a.run();
        } catch (Throwable th) {
            l2.c(th);
        }
    }
}
