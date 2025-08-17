package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class j implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f25191b;

    public /* synthetic */ j(Context context) {
        this.f25191b = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.j(this.f25191b);
    }
}
