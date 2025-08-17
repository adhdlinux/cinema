package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.Comparator;

public final /* synthetic */ class i implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecUtil.ScoreProvider f25348b;

    public /* synthetic */ i(MediaCodecUtil.ScoreProvider scoreProvider) {
        this.f25348b = scoreProvider;
    }

    public final int compare(Object obj, Object obj2) {
        return MediaCodecUtil.M(this.f25348b, obj, obj2);
    }
}
