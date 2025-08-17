package com.movie.ui.activity.sources;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

public final /* synthetic */ class t implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f33026b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSource f33027c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f33028d;

    public /* synthetic */ t(SourceActivity sourceActivity, MediaSource mediaSource, MovieInfo movieInfo) {
        this.f33026b = sourceActivity;
        this.f33027c = mediaSource;
        this.f33028d = movieInfo;
    }

    public final void accept(Object obj) {
        this.f33026b.L0(this.f33027c, this.f33028d, (ArrayList) obj);
    }
}
