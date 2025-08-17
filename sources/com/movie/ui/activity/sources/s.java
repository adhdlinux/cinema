package com.movie.ui.activity.sources;

import com.original.tase.helper.StreamAction;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Action;

public final /* synthetic */ class s implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f32989b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSource f32990c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StreamAction.ActionID f32991d;

    public /* synthetic */ s(SourceActivity sourceActivity, MediaSource mediaSource, StreamAction.ActionID actionID) {
        this.f32989b = sourceActivity;
        this.f32990c = mediaSource;
        this.f32991d = actionID;
    }

    public final void run() {
        this.f32989b.C0(this.f32990c, this.f32991d);
    }
}
