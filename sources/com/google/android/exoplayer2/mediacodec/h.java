package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;

public final /* synthetic */ class h implements MediaCodecUtil.ScoreProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Format f25347a;

    public /* synthetic */ h(Format format) {
        this.f25347a = format;
    }

    public final int a(Object obj) {
        return MediaCodecUtil.L(this.f25347a, (MediaCodecInfo) obj);
    }
}
