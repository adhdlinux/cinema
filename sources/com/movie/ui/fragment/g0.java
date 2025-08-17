package com.movie.ui.fragment;

import com.movie.data.model.MovieInfo;
import com.movie.ui.fragment.MovieFragment;
import com.utils.subtitle.SubtitleInfo;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieFragment.AnonymousClass12 f33345b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f33346c;

    public /* synthetic */ g0(MovieFragment.AnonymousClass12 r12, MovieInfo movieInfo) {
        this.f33345b = r12;
        this.f33346c = movieInfo;
    }

    public final void accept(Object obj) {
        this.f33345b.d(this.f33346c, (SubtitleInfo) obj);
    }
}
