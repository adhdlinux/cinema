package androidx.media3.exoplayer.source;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.source.MediaSource;

public final /* synthetic */ class b implements MediaSource.MediaSourceCaller {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CompositeMediaSource f7185a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f7186b;

    public /* synthetic */ b(CompositeMediaSource compositeMediaSource, Object obj) {
        this.f7185a = compositeMediaSource;
        this.f7186b = obj;
    }

    public final void a(MediaSource mediaSource, Timeline timeline) {
        this.f7185a.I(this.f7186b, mediaSource, timeline);
    }
}
