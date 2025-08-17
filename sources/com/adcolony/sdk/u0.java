package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.e0;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class u0 {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f13434a = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ScheduledFuture<?> f13435b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ScheduledFuture<?> f13436c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final t0 f13437d;

    class a implements Runnable {
        a() {
        }

        public void run() {
            ScheduledFuture unused = u0.this.f13435b = null;
            u0.this.i();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (u0.this.f13437d.q()) {
                a.f().F0().x();
                ScheduledFuture unused = u0.this.f13436c = null;
            }
        }
    }

    u0(t0 t0Var) {
        this.f13437d = t0Var;
    }

    private void b() {
        ScheduledFuture<?> scheduledFuture = this.f13435b;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f13435b.cancel(false);
            this.f13435b = null;
        }
    }

    private void h() {
        if (this.f13435b == null) {
            try {
                this.f13435b = this.f13434a.schedule(new a(), this.f13437d.a(), TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e2) {
                new e0.a().c("RejectedExecutionException when scheduling session stop ").c(e2.toString()).d(e0.f13114i);
            }
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        new e0.a().c("AdColony session ending, releasing Context.").d(e0.f13109d);
        a.f().V(true);
        a.c((Context) null);
        this.f13437d.n(true);
        this.f13437d.p(true);
        this.f13437d.t();
        if (a.f().F0().u()) {
            ScheduledFuture<?> scheduledFuture = this.f13436c;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.f13436c.cancel(false);
            }
            try {
                this.f13436c = this.f13434a.schedule(new b(), 10, TimeUnit.SECONDS);
            } catch (RejectedExecutionException e2) {
                new e0.a().c("RejectedExecutionException when scheduling message pumping stop ").c(e2.toString()).d(e0.f13114i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        h();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        b();
    }
}
