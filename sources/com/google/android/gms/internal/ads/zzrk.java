package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzrk {
    private long zza;
    private long zzb;
    private boolean zzc;

    zzrk() {
    }

    private final long zzd(long j2) {
        return this.zza + Math.max(0, ((this.zzb - 529) * 1000000) / j2);
    }

    public final long zza(zzam zzam) {
        return zzd((long) zzam.zzA);
    }

    public final long zzb(zzam zzam, zzhp zzhp) {
        if (this.zzb == 0) {
            this.zza = zzhp.zzd;
        }
        if (this.zzc) {
            return zzhp.zzd;
        }
        ByteBuffer byteBuffer = zzhp.zzb;
        byteBuffer.getClass();
        byte b2 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            b2 = (b2 << 8) | (byteBuffer.get(i2) & 255);
        }
        int zzc2 = zzabq.zzc(b2);
        if (zzc2 == -1) {
            this.zzc = true;
            this.zzb = 0;
            this.zza = zzhp.zzd;
            zzer.zzf("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return zzhp.zzd;
        }
        long zzd = zzd((long) zzam.zzA);
        this.zzb += (long) zzc2;
        return zzd;
    }

    public final void zzc() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = false;
    }
}
