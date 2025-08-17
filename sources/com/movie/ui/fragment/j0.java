package com.movie.ui.fragment;

import androidx.appcompat.app.AlertDialog;
import com.movie.ui.fragment.MovieFragment;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class j0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieFragment.AnonymousClass3 f33368b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f33369c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AlertDialog.Builder f33370d;

    public /* synthetic */ j0(MovieFragment.AnonymousClass3 r12, int i2, AlertDialog.Builder builder) {
        this.f33368b = r12;
        this.f33369c = i2;
        this.f33370d = builder;
    }

    public final void accept(Object obj) {
        this.f33368b.c(this.f33369c, this.f33370d, (MediaSource) obj);
    }
}
