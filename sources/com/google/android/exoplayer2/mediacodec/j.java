package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;

public final /* synthetic */ class j implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SynchronousMediaCodecAdapter f25349a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.OnFrameRenderedListener f25350b;

    public /* synthetic */ j(SynchronousMediaCodecAdapter synchronousMediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener) {
        this.f25349a = synchronousMediaCodecAdapter;
        this.f25350b = onFrameRenderedListener;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j3) {
        this.f25349a.p(this.f25350b, mediaCodec, j2, j3);
    }
}
