package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;

public final /* synthetic */ class a implements MediaSource.MediaSourceCaller {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CompositeMediaSource f26016a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f26017b;

    public /* synthetic */ a(CompositeMediaSource compositeMediaSource, Object obj) {
        this.f26016a = compositeMediaSource;
        this.f26017b = obj;
    }

    public final void a(MediaSource mediaSource, Timeline timeline) {
        this.f26016a.J(this.f26017b, mediaSource, timeline);
    }
}
