package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.SeekMap;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressiveMediaPeriod f26711b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SeekMap f26712c;

    public /* synthetic */ r(ProgressiveMediaPeriod progressiveMediaPeriod, SeekMap seekMap) {
        this.f26711b = progressiveMediaPeriod;
        this.f26712c = seekMap;
    }

    public final void run() {
        this.f26711b.T(this.f26712c);
    }
}
