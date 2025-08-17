package com.extension;

import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class CinemaWorker$startProvider$5 extends Lambda implements Function1<MediaSource, Boolean> {

    /* renamed from: f  reason: collision with root package name */
    public static final CinemaWorker$startProvider$5 f19379f = new CinemaWorker$startProvider$5();

    CinemaWorker$startProvider$5() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(MediaSource mediaSource) {
        Intrinsics.f(mediaSource, "mediaSource");
        if (!Utils.f37610c) {
            return Boolean.TRUE;
        }
        String quality = mediaSource.getQuality();
        Intrinsics.e(quality, "getQuality(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.e(locale, "getDefault(...)");
        String lowerCase = quality.toLowerCase(locale);
        Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return Boolean.valueOf(!StringsKt__StringsKt.L(lowerCase, "cam", false, 2, (Object) null));
    }
}
