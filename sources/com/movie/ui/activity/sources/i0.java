package com.movie.ui.activity.sources;

import com.movie.data.model.MovieInfo;
import com.movie.ui.activity.sources.SourceActivity;
import com.utils.subtitle.SubtitleInfo;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity.AnonymousClass7 f32974b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f32975c;

    public /* synthetic */ i0(SourceActivity.AnonymousClass7 r12, MovieInfo movieInfo) {
        this.f32974b = r12;
        this.f32975c = movieInfo;
    }

    public final void accept(Object obj) {
        this.f32974b.d(this.f32975c, (SubtitleInfo) obj);
    }
}
