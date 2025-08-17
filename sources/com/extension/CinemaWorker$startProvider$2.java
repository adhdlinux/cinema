package com.extension;

import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.SourceObservableUtils;
import io.reactivex.ObservableSource;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class CinemaWorker$startProvider$2 extends Lambda implements Function1<MediaSource, ObservableSource<? extends MediaSource>> {

    /* renamed from: f  reason: collision with root package name */
    public static final CinemaWorker$startProvider$2 f19377f = new CinemaWorker$startProvider$2();

    CinemaWorker$startProvider$2() {
        super(1);
    }

    /* renamed from: a */
    public final ObservableSource<? extends MediaSource> invoke(MediaSource mediaSource) {
        return SourceObservableUtils.d(mediaSource);
    }
}
