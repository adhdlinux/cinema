package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public abstract class zzgvn extends zzgvl {
    private int zza;

    protected zzgvn(String str) {
        super("mvhd");
    }

    public final int zzh() {
        if (!this.zzc) {
            zzg();
        }
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final long zzi(ByteBuffer byteBuffer) {
        this.zza = zzamv.zzc(byteBuffer.get());
        zzamv.zzd(byteBuffer);
        byteBuffer.get();
        return 4;
    }
}
