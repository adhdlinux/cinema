package com.unity3d.scar.adapter.common;

public class DispatchGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f37017a = 0;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f37018b;

    private void d() {
        Runnable runnable;
        if (this.f37017a <= 0 && (runnable = this.f37018b) != null) {
            runnable.run();
        }
    }

    public synchronized void a() {
        this.f37017a++;
    }

    public synchronized void b() {
        this.f37017a--;
        d();
    }

    public void c(Runnable runnable) {
        this.f37018b = runnable;
        d();
    }
}
