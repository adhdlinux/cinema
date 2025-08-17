package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.m;

public class z extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f15451a;

    public z(m mVar, Runnable runnable) {
        this(mVar, false, runnable);
    }

    public z(m mVar, boolean z2, Runnable runnable) {
        super("TaskRunnable", mVar, z2);
        this.f15451a = runnable;
    }

    public void run() {
        this.f15451a.run();
    }
}
