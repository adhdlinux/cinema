package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter;
import java.io.IOException;

public final class DefaultMediaCodecAdapterFactory implements MediaCodecAdapter.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6675a;

    /* renamed from: b  reason: collision with root package name */
    private int f6676b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6677c;

    @Deprecated
    public DefaultMediaCodecAdapterFactory() {
        this.f6676b = 0;
        this.f6677c = true;
        this.f6675a = null;
    }

    private boolean b() {
        int i2 = Util.f4714a;
        if (i2 >= 31) {
            return true;
        }
        Context context = this.f6675a;
        if (context == null || i2 < 28 || !context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen")) {
            return false;
        }
        return true;
    }

    public MediaCodecAdapter a(MediaCodecAdapter.Configuration configuration) throws IOException {
        int i2;
        if (Util.f4714a < 23 || ((i2 = this.f6676b) != 1 && (i2 != 0 || !b()))) {
            return new SynchronousMediaCodecAdapter.Factory().a(configuration);
        }
        int k2 = MimeTypes.k(configuration.f6680c.f4015n);
        Log.f("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + Util.s0(k2));
        AsynchronousMediaCodecAdapter.Factory factory = new AsynchronousMediaCodecAdapter.Factory(k2);
        factory.e(this.f6677c);
        return factory.a(configuration);
    }

    public DefaultMediaCodecAdapterFactory(Context context) {
        this.f6675a = context;
        this.f6676b = 0;
        this.f6677c = true;
    }
}
