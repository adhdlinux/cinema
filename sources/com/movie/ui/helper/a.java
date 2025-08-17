package com.movie.ui.helper;

import android.app.Activity;
import com.utils.Utils;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f33635b;

    public /* synthetic */ a(Activity activity) {
        this.f33635b = activity;
    }

    public final void accept(Object obj) {
        Utils.i0(this.f33635b, (String) obj);
    }
}
