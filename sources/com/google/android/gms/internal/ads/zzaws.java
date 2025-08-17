package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

final class zzaws extends PushbackInputStream {
    final /* synthetic */ zzawt zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaws(zzawt zzawt, InputStream inputStream, int i2) {
        super(inputStream, 1);
        this.zza = zzawt;
    }

    public final synchronized void close() throws IOException {
        zzawv.zze(this.zza.zzc);
        super.close();
    }
}
