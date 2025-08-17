package com.extension;

import com.original.tase.model.media.MediaSource;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class CinemaWorker$startProvider$6 extends Lambda implements Function1<MediaSource, Boolean> {

    /* renamed from: f  reason: collision with root package name */
    public static final CinemaWorker$startProvider$6 f19380f = new CinemaWorker$startProvider$6();

    CinemaWorker$startProvider$6() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(MediaSource mediaSource) {
        Intrinsics.f(mediaSource, "mediaSource");
        String streamLink = mediaSource.getStreamLink();
        Intrinsics.e(streamLink, "getStreamLink(...)");
        return Boolean.valueOf(!StringsKt__StringsKt.L(streamLink, "video-downloads", false, 2, (Object) null));
    }
}
