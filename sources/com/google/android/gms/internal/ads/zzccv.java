package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

final class zzccv implements zzgvq {
    private final ByteBuffer zza;

    zzccv(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.duplicate();
    }

    public final void close() throws IOException {
    }

    public final int zza(ByteBuffer byteBuffer) throws IOException {
        if (this.zza.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.zza.remaining());
        byte[] bArr = new byte[min];
        this.zza.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    public final long zzb() throws IOException {
        return (long) this.zza.position();
    }

    public final long zzc() throws IOException {
        return (long) this.zza.limit();
    }

    public final ByteBuffer zzd(long j2, long j3) throws IOException {
        int position = this.zza.position();
        this.zza.position((int) j2);
        ByteBuffer slice = this.zza.slice();
        slice.limit((int) j3);
        this.zza.position(position);
        return slice;
    }

    public final void zze(long j2) throws IOException {
        this.zza.position((int) j2);
    }
}
