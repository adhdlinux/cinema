package com.vungle.ads.internal;

import android.view.ViewTreeObserver;

public final /* synthetic */ class a implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImpressionTracker f37841b;

    public /* synthetic */ a(ImpressionTracker impressionTracker) {
        this.f37841b = impressionTracker;
    }

    public final boolean onPreDraw() {
        return ImpressionTracker.m150_init_$lambda0(this.f37841b);
    }
}
