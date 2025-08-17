package com.movie.ui.activity.sources;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f32970b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f32971c;

    public /* synthetic */ h(SourceActivity sourceActivity, MovieInfo movieInfo) {
        this.f32970b = sourceActivity;
        this.f32971c = movieInfo;
    }

    public final void accept(Object obj) {
        this.f32970b.X0(this.f32971c, (MediaSource) obj);
    }
}
