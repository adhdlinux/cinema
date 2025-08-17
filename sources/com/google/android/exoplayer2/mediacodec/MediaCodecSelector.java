package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

public interface MediaCodecSelector {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaCodecSelector f25330a = new e();

    List<MediaCodecInfo> a(String str, boolean z2, boolean z3) throws MediaCodecUtil.DecoderQueryException;
}
