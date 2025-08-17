package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class k implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f25196b;

    public /* synthetic */ k(Context context) {
        this.f25196b = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.k(this.f25196b);
    }
}
