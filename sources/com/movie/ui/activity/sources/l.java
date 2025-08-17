package com.movie.ui.activity.sources;

import com.original.tase.helper.StreamAction;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f32978b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSource f32979c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StreamAction.ActionID f32980d;

    public /* synthetic */ l(SourceActivity sourceActivity, MediaSource mediaSource, StreamAction.ActionID actionID) {
        this.f32978b = sourceActivity;
        this.f32979c = mediaSource;
        this.f32980d = actionID;
    }

    public final void accept(Object obj) {
        this.f32978b.G0(this.f32979c, this.f32980d, (MediaSource) obj);
    }
}
