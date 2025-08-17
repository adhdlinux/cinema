package androidx.media3.exoplayer.video;

import android.view.Surface;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;

public class MediaCodecVideoDecoderException extends MediaCodecDecoderException {

    /* renamed from: e  reason: collision with root package name */
    public final int f7654e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f7655f;

    public MediaCodecVideoDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo, Surface surface) {
        super(th, mediaCodecInfo);
        boolean z2;
        this.f7654e = System.identityHashCode(surface);
        if (surface == null || surface.isValid()) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f7655f = z2;
    }
}
