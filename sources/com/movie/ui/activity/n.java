package com.movie.ui.activity;

import android.widget.Spinner;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class n implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MainActivity f32252b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Spinner f32253c;

    public /* synthetic */ n(MainActivity mainActivity, Spinner spinner) {
        this.f32252b = mainActivity;
        this.f32253c = spinner;
    }

    public final void accept(Object obj) {
        this.f32252b.Y(this.f32253c, (List) obj);
    }
}
