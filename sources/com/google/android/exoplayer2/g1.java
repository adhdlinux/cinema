package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;

public final /* synthetic */ class g1 implements MediaSource.MediaSourceCaller {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList f25180a;

    public /* synthetic */ g1(MediaSourceList mediaSourceList) {
        this.f25180a = mediaSourceList;
    }

    public final void a(MediaSource mediaSource, Timeline timeline) {
        this.f25180a.t(mediaSource, timeline);
    }
}
