package com.movie.ui.activity.sources;

import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f32909b;

    public /* synthetic */ b0(SourceActivity sourceActivity) {
        this.f32909b = sourceActivity;
    }

    public final void accept(Object obj) {
        this.f32909b.E0((MediaSource) obj);
    }
}
