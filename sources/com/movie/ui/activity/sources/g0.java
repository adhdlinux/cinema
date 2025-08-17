package com.movie.ui.activity.sources;

import androidx.appcompat.app.AlertDialog;
import com.movie.ui.activity.sources.SourceActivity;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity.AnonymousClass2 f32967b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f32968c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AlertDialog.Builder f32969d;

    public /* synthetic */ g0(SourceActivity.AnonymousClass2 r12, int i2, AlertDialog.Builder builder) {
        this.f32967b = r12;
        this.f32968c = i2;
        this.f32969d = builder;
    }

    public final void accept(Object obj) {
        this.f32967b.c(this.f32968c, this.f32969d, (MediaSource) obj);
    }
}
