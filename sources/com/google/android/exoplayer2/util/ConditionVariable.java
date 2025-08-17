package com.google.android.exoplayer2.util;

public class ConditionVariable {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f28658a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f28659b;

    public ConditionVariable() {
        this(Clock.f28651a);
    }

    public synchronized void a() throws InterruptedException {
        while (!this.f28659b) {
            wait();
        }
    }

    public synchronized boolean b(long j2) throws InterruptedException {
        if (j2 <= 0) {
            return this.f28659b;
        }
        long elapsedRealtime = this.f28658a.elapsedRealtime();
        long j3 = j2 + elapsedRealtime;
        if (j3 < elapsedRealtime) {
            a();
        } else {
            while (!this.f28659b && elapsedRealtime < j3) {
                wait(j3 - elapsedRealtime);
                elapsedRealtime = this.f28658a.elapsedRealtime();
            }
        }
        return this.f28659b;
    }

    public synchronized void c() {
        boolean z2 = false;
        while (!this.f28659b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean d() {
        boolean z2;
        z2 = this.f28659b;
        this.f28659b = false;
        return z2;
    }

    public synchronized boolean e() {
        return this.f28659b;
    }

    public synchronized boolean f() {
        if (this.f28659b) {
            return false;
        }
        this.f28659b = true;
        notifyAll();
        return true;
    }

    public ConditionVariable(Clock clock) {
        this.f28658a = clock;
    }
}
