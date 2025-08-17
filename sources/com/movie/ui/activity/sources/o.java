package com.movie.ui.activity.sources;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class o implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f32984b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f32985c;

    public /* synthetic */ o(SourceActivity sourceActivity, MovieInfo movieInfo) {
        this.f32984b = sourceActivity;
        this.f32985c = movieInfo;
    }

    public final void accept(Object obj) {
        this.f32984b.Z0(this.f32985c, (MediaSource) obj);
    }
}
