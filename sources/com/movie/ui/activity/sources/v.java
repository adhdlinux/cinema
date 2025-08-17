package com.movie.ui.activity.sources;

import com.movie.data.model.MovieInfo;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

public final /* synthetic */ class v implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f33032b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f33033c;

    public /* synthetic */ v(SourceActivity sourceActivity, MovieInfo movieInfo) {
        this.f33032b = sourceActivity;
        this.f33033c = movieInfo;
    }

    public final void accept(Object obj) {
        this.f33032b.M0(this.f33033c, (ArrayList) obj);
    }
}
