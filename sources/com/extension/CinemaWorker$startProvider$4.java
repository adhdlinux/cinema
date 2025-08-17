package com.extension;

import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class CinemaWorker$startProvider$4 extends Lambda implements Function1<MediaSource, Boolean> {

    /* renamed from: f  reason: collision with root package name */
    public static final CinemaWorker$startProvider$4 f19378f = new CinemaWorker$startProvider$4();

    CinemaWorker$startProvider$4() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(MediaSource mediaSource) {
        Intrinsics.f(mediaSource, "mediaSource");
        boolean z2 = false;
        if (Utils.f37609b) {
            if (mediaSource.isHD() && (mediaSource.getFileSize() > 0 || mediaSource.isHLS())) {
                z2 = true;
            }
            return Boolean.valueOf(z2);
        }
        if (mediaSource.getFileSize() > 0 || mediaSource.isHLS()) {
            z2 = true;
        }
        return Boolean.valueOf(z2);
    }
}
