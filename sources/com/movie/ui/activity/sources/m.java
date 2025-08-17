package com.movie.ui.activity.sources;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f32981b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f32982c;

    public /* synthetic */ m(SourceActivity sourceActivity, MovieInfo movieInfo) {
        this.f32981b = sourceActivity;
        this.f32982c = movieInfo;
    }

    public final void accept(Object obj) {
        this.f32981b.V0(this.f32982c, (MediaSource) obj);
    }
}
