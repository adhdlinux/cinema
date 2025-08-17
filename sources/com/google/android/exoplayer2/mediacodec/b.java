package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter;
import com.google.common.base.Supplier;

public final /* synthetic */ class b implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f25344b;

    public /* synthetic */ b(int i2) {
        this.f25344b = i2;
    }

    public final Object get() {
        return AsynchronousMediaCodecAdapter.Factory.e(this.f25344b);
    }
}
