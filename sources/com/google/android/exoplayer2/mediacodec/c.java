package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter;
import com.google.common.base.Supplier;

public final /* synthetic */ class c implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f25345b;

    public /* synthetic */ c(int i2) {
        this.f25345b = i2;
    }

    public final Object get() {
        return AsynchronousMediaCodecAdapter.Factory.f(this.f25345b);
    }
}
