package com.adcolony.sdk;

class f {

    /* renamed from: a  reason: collision with root package name */
    private boolean f13119a;

    f() {
    }

    public synchronized void a(long j2) {
        if (!this.f13119a) {
            try {
                wait(j2);
            } catch (InterruptedException unused) {
            }
        }
    }

    public synchronized void b(boolean z2) {
        this.f13119a = z2;
        if (z2) {
            notifyAll();
        }
    }

    public boolean c() {
        return this.f13119a;
    }
}
