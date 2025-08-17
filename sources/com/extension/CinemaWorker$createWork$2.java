package com.extension;

import androidx.work.ListenableWorker;
import com.original.tase.model.media.MediaSource;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class CinemaWorker$createWork$2 extends Lambda implements Function1<List<MediaSource>, ListenableWorker.Result> {

    /* renamed from: f  reason: collision with root package name */
    public static final CinemaWorker$createWork$2 f19373f = new CinemaWorker$createWork$2();

    CinemaWorker$createWork$2() {
        super(1);
    }

    /* renamed from: a */
    public final ListenableWorker.Result invoke(List<MediaSource> list) {
        Intrinsics.f(list, "it");
        return ListenableWorker.Result.c();
    }
}
