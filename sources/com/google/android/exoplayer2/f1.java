package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.collect.ImmutableList;

public final /* synthetic */ class f1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaPeriodQueue f25176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImmutableList.Builder f25177c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f25178d;

    public /* synthetic */ f1(MediaPeriodQueue mediaPeriodQueue, ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f25176b = mediaPeriodQueue;
        this.f25177c = builder;
        this.f25178d = mediaPeriodId;
    }

    public final void run() {
        this.f25176b.w(this.f25177c, this.f25178d);
    }
}
