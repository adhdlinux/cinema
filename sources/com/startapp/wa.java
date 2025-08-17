package com.startapp;

import android.os.Handler;

public class wa implements va {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f36827a;

    public wa(Handler handler) {
        this.f36827a = handler;
    }

    public void a(Runnable runnable, long j2) {
        this.f36827a.postDelayed(runnable, j2);
    }

    public void execute(Runnable runnable) {
        this.f36827a.post(runnable);
    }

    public void a(Runnable runnable) {
        this.f36827a.removeCallbacks(runnable);
    }
}
