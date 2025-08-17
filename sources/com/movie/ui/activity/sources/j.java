package com.movie.ui.activity.sources;

import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f32976b;

    public /* synthetic */ j(SourceActivity sourceActivity) {
        this.f32976b = sourceActivity;
    }

    public final void accept(Object obj) {
        this.f32976b.c1((MediaSource) obj);
    }
}
