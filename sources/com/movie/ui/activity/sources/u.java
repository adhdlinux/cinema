package com.movie.ui.activity.sources;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class u implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f33029b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSource f33030c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f33031d;

    public /* synthetic */ u(SourceActivity sourceActivity, MediaSource mediaSource, MovieInfo movieInfo) {
        this.f33029b = sourceActivity;
        this.f33030c = mediaSource;
        this.f33031d = movieInfo;
    }

    public final void accept(Object obj) {
        this.f33029b.K0(this.f33030c, this.f33031d, (Throwable) obj);
    }
}
