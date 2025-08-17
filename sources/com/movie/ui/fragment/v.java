package com.movie.ui.fragment;

import com.movie.data.model.MovieInfo;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

public final /* synthetic */ class v implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieFragment f33598b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f33599c;

    public /* synthetic */ v(MovieFragment movieFragment, MovieInfo movieInfo) {
        this.f33598b = movieFragment;
        this.f33599c = movieInfo;
    }

    public final void accept(Object obj) {
        this.f33598b.M0(this.f33599c, (ArrayList) obj);
    }
}
