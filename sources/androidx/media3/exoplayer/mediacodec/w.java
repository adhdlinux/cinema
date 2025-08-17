package androidx.media3.exoplayer.mediacodec;

import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.Comparator;

public final /* synthetic */ class w implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecUtil.ScoreProvider f6761b;

    public /* synthetic */ w(MediaCodecUtil.ScoreProvider scoreProvider) {
        this.f6761b = scoreProvider;
    }

    public final int compare(Object obj, Object obj2) {
        return MediaCodecUtil.O(this.f6761b, obj, obj2);
    }
}
