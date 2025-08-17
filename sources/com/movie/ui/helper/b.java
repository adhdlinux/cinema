package com.movie.ui.helper;

import android.app.Activity;
import com.utils.Utils;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f33636b;

    public /* synthetic */ b(Activity activity) {
        this.f33636b = activity;
    }

    public final void accept(Object obj) {
        Utils.i0(this.f33636b, "Save to favorites fail");
    }
}
