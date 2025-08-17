package com.movie.ui.fragment;

import com.original.tase.helper.StreamAction;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Action;

public final /* synthetic */ class u implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieFragment f33595b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSource f33596c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StreamAction.ActionID f33597d;

    public /* synthetic */ u(MovieFragment movieFragment, MediaSource mediaSource, StreamAction.ActionID actionID) {
        this.f33595b = movieFragment;
        this.f33596c = mediaSource;
        this.f33597d = actionID;
    }

    public final void run() {
        this.f33595b.B0(this.f33596c, this.f33597d);
    }
}
