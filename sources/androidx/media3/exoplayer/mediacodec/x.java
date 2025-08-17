package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;

public final /* synthetic */ class x implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SynchronousMediaCodecAdapter f6762a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.OnFrameRenderedListener f6763b;

    public /* synthetic */ x(SynchronousMediaCodecAdapter synchronousMediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener) {
        this.f6762a = synchronousMediaCodecAdapter;
        this.f6763b = onFrameRenderedListener;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j3) {
        this.f6762a.q(this.f6763b, mediaCodec, j2, j3);
    }
}
