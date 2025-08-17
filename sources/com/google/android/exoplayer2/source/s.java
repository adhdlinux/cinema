package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;

public final /* synthetic */ class s implements ProgressiveMediaExtractor.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtractorsFactory f27083a;

    public /* synthetic */ s(ExtractorsFactory extractorsFactory) {
        this.f27083a = extractorsFactory;
    }

    public final ProgressiveMediaExtractor a(PlayerId playerId) {
        return ProgressiveMediaSource.Factory.f(this.f27083a, playerId);
    }
}
