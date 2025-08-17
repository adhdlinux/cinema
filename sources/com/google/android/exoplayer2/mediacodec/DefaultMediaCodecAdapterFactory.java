package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class DefaultMediaCodecAdapterFactory implements MediaCodecAdapter.Factory {

    /* renamed from: a  reason: collision with root package name */
    private int f25258a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f25259b;

    public MediaCodecAdapter a(MediaCodecAdapter.Configuration configuration) throws IOException {
        int i2;
        int i3 = Util.f28808a;
        if (i3 < 23 || ((i2 = this.f25258a) != 1 && (i2 != 0 || i3 < 31))) {
            return new SynchronousMediaCodecAdapter.Factory().a(configuration);
        }
        int k2 = MimeTypes.k(configuration.f25267c.f23071m);
        Log.f("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + Util.n0(k2));
        return new AsynchronousMediaCodecAdapter.Factory(k2, this.f25259b).a(configuration);
    }
}
