package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class i implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f25187b;

    public /* synthetic */ i(Context context) {
        this.f25187b = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.i(this.f25187b);
    }
}
