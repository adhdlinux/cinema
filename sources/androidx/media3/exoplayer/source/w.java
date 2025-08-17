package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.ProgressiveMediaExtractor;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.extractor.ExtractorsFactory;

public final /* synthetic */ class w implements ProgressiveMediaExtractor.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtractorsFactory f7315a;

    public /* synthetic */ w(ExtractorsFactory extractorsFactory) {
        this.f7315a = extractorsFactory;
    }

    public final ProgressiveMediaExtractor a(PlayerId playerId) {
        return ProgressiveMediaSource.Factory.i(this.f7315a, playerId);
    }
}
