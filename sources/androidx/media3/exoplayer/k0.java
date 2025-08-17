package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.source.MediaSource;

public final /* synthetic */ class k0 implements MediaSource.MediaSourceCaller {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList f6626a;

    public /* synthetic */ k0(MediaSourceList mediaSourceList) {
        this.f6626a = mediaSourceList;
    }

    public final void a(MediaSource mediaSource, Timeline timeline) {
        this.f6626a.u(mediaSource, timeline);
    }
}
