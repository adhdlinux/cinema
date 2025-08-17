package com.movie.ui.fragment;

import com.original.tase.helper.StreamAction;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieFragment f33373b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSource f33374c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StreamAction.ActionID f33375d;

    public /* synthetic */ l(MovieFragment movieFragment, MediaSource mediaSource, StreamAction.ActionID actionID) {
        this.f33373b = movieFragment;
        this.f33374c = mediaSource;
        this.f33375d = actionID;
    }

    public final void accept(Object obj) {
        this.f33373b.E0(this.f33374c, this.f33375d, (MediaSource) obj);
    }
}
