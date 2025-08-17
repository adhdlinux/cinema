package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.common.base.Supplier;

public final /* synthetic */ class m implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f25209b;

    public /* synthetic */ m(Context context) {
        this.f25209b = context;
    }

    public final Object get() {
        return DefaultBandwidthMeter.n(this.f25209b);
    }
}
