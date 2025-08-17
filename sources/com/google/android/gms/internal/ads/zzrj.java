package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzrj extends zzhp {
    private long zzf;
    private int zzg;
    private int zzh = 32;

    public zzrj() {
        super(2, 0);
    }

    public final void zzb() {
        super.zzb();
        this.zzg = 0;
    }

    public final int zzm() {
        return this.zzg;
    }

    public final long zzn() {
        return this.zzf;
    }

    public final void zzo(int i2) {
        this.zzh = i2;
    }

    public final boolean zzp(zzhp zzhp) {
        ByteBuffer byteBuffer;
        zzdy.zzd(!zzhp.zzd(1073741824));
        zzdy.zzd(!zzhp.zzd(268435456));
        zzdy.zzd(!zzhp.zzd(4));
        if (zzq()) {
            if (this.zzg >= this.zzh || zzhp.zzd(Integer.MIN_VALUE) != zzd(Integer.MIN_VALUE)) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzhp.zzb;
            if (!(byteBuffer2 == null || (byteBuffer = this.zzb) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000)) {
                return false;
            }
        }
        int i2 = this.zzg;
        this.zzg = i2 + 1;
        if (i2 == 0) {
            this.zzd = zzhp.zzd;
            if (zzhp.zzd(1)) {
                zzc(1);
            }
        }
        if (zzhp.zzd(Integer.MIN_VALUE)) {
            zzc(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer3 = zzhp.zzb;
        if (byteBuffer3 != null) {
            zzj(byteBuffer3.remaining());
            this.zzb.put(byteBuffer3);
        }
        this.zzf = zzhp.zzd;
        return true;
    }

    public final boolean zzq() {
        return this.zzg > 0;
    }
}
