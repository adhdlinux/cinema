package androidx.media3.exoplayer.mediacodec;

import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.List;

public interface MediaCodecSelector {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaCodecSelector f6742a = new o();

    List<MediaCodecInfo> a(String str, boolean z2, boolean z3) throws MediaCodecUtil.DecoderQueryException;
}
