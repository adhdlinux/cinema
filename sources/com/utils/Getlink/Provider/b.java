package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37512b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f37513c;

    public /* synthetic */ b(String str, MovieInfo movieInfo) {
        this.f37512b = str;
        this.f37513c = movieInfo;
    }

    public final void accept(Object obj) {
        RemoteJS.N(this.f37512b, this.f37513c, (String) obj);
    }
}
