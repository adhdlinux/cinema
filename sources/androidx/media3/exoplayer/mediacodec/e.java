package androidx.media3.exoplayer.mediacodec;

import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter;
import com.google.common.base.Supplier;

public final /* synthetic */ class e implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f6758b;

    public /* synthetic */ e(int i2) {
        this.f6758b = i2;
    }

    public final Object get() {
        return AsynchronousMediaCodecAdapter.Factory.g(this.f6758b);
    }
}
