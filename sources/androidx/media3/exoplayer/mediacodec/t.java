package androidx.media3.exoplayer.mediacodec;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;

public final /* synthetic */ class t implements MediaCodecUtil.ScoreProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Format f6760a;

    public /* synthetic */ t(Format format) {
        this.f6760a = format;
    }

    public final int a(Object obj) {
        return MediaCodecUtil.N(this.f6760a, (MediaCodecInfo) obj);
    }
}
