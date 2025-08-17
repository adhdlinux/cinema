package androidx.media3.exoplayer.mediacodec;

import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter;
import com.google.common.base.Supplier;

public final /* synthetic */ class d implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f6757b;

    public /* synthetic */ d(int i2) {
        this.f6757b = i2;
    }

    public final Object get() {
        return AsynchronousMediaCodecAdapter.Factory.f(this.f6757b);
    }
}
