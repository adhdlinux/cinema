package com.google.android.exoplayer2.video;

import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;

public class MediaCodecVideoDecoderException extends MediaCodecDecoderException {

    /* renamed from: d  reason: collision with root package name */
    public final int f28875d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f28876e;

    public MediaCodecVideoDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo, Surface surface) {
        super(th, mediaCodecInfo);
        boolean z2;
        this.f28875d = System.identityHashCode(surface);
        if (surface == null || surface.isValid()) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f28876e = z2;
    }
}
