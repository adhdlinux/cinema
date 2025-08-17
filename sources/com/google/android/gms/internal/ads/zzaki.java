package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class zzaki implements zzakj {
    private final ByteBuffer zza;

    public zzaki(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.slice();
    }

    public final long zza() {
        return (long) this.zza.capacity();
    }

    public final void zzb(MessageDigest[] messageDigestArr, long j2, int i2) throws IOException {
        ByteBuffer slice;
        synchronized (this.zza) {
            int i3 = (int) j2;
            this.zza.position(i3);
            this.zza.limit(i3 + i2);
            slice = this.zza.slice();
        }
        for (MessageDigest update : messageDigestArr) {
            slice.position(0);
            update.update(slice);
        }
    }
}
