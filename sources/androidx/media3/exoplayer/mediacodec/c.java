package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;

public final /* synthetic */ class c implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AsynchronousMediaCodecAdapter f6755a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.OnFrameRenderedListener f6756b;

    public /* synthetic */ c(AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener) {
        this.f6755a = asynchronousMediaCodecAdapter;
        this.f6756b = onFrameRenderedListener;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j3) {
        this.f6755a.x(this.f6756b, mediaCodec, j2, j3);
    }
}
