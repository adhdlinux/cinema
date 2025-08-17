package com.extension;

import com.original.tase.model.media.MediaSource;
import com.utils.Getlink.Resolver.BaseResolver;
import io.reactivex.ObservableSource;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

final class CinemaWorker$startProvider$1 extends Lambda implements Function1<MediaSource, ObservableSource<? extends MediaSource>> {

    /* renamed from: f  reason: collision with root package name */
    public static final CinemaWorker$startProvider$1 f19376f = new CinemaWorker$startProvider$1();

    CinemaWorker$startProvider$1() {
        super(1);
    }

    /* renamed from: a */
    public final ObservableSource<? extends MediaSource> invoke(MediaSource mediaSource) {
        Intrinsics.f(mediaSource, "mediaSource");
        Timber.Forest forest = Timber.f42178a;
        forest.h("baseProvider=" + mediaSource.toStringAllObjs(), new Object[0]);
        return BaseResolver.m(mediaSource).subscribeOn(Schedulers.c());
    }
}
