package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

final class zzakk implements zzakj {
    private final FileChannel zza;
    private final long zzb;
    private final long zzc;

    public zzakk(FileChannel fileChannel, long j2, long j3) {
        this.zza = fileChannel;
        this.zzb = j2;
        this.zzc = j3;
    }

    public final long zza() {
        return this.zzc;
    }

    public final void zzb(MessageDigest[] messageDigestArr, long j2, int i2) throws IOException {
        MappedByteBuffer map = this.zza.map(FileChannel.MapMode.READ_ONLY, this.zzb + j2, (long) i2);
        map.load();
        for (MessageDigest update : messageDigestArr) {
            map.position(0);
            update.update(map);
        }
    }
}
