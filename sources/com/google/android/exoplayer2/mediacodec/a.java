package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;

public final /* synthetic */ class a implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AsynchronousMediaCodecAdapter f25342a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.OnFrameRenderedListener f25343b;

    public /* synthetic */ a(AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener) {
        this.f25342a = asynchronousMediaCodecAdapter;
        this.f25343b = onFrameRenderedListener;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j3) {
        this.f25342a.w(this.f25343b, mediaCodec, j2, j3);
    }
}
