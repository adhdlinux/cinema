package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class zzhp extends zzhj {
    public final zzhm zza = new zzhm();
    public ByteBuffer zzb;
    public boolean zzc;
    public long zzd;
    public ByteBuffer zze;
    private final int zzf;

    static {
        zzbq.zzb("media3.decoder");
    }

    public zzhp(int i2, int i3) {
        this.zzf = i2;
    }

    private final ByteBuffer zzm(int i2) {
        int i3;
        int i4 = this.zzf;
        if (i4 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i4 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer == null) {
            i3 = 0;
        } else {
            i3 = byteBuffer.capacity();
        }
        throw new zzho(i3, i2);
    }

    public void zzb() {
        super.zzb();
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.zze;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.zzc = false;
    }

    @EnsuresNonNull({"data"})
    public final void zzj(int i2) {
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer == null) {
            this.zzb = zzm(i2);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i3 = i2 + position;
        if (capacity >= i3) {
            this.zzb = byteBuffer;
            return;
        }
        ByteBuffer zzm = zzm(i3);
        zzm.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            zzm.put(byteBuffer);
        }
        this.zzb = zzm;
    }

    public final void zzk() {
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.zze;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean zzl() {
        return zzd(1073741824);
    }
}
