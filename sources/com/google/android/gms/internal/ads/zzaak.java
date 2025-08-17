package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzaak implements zzabv {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zzaak(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length > 0) {
            int i2 = length - 1;
            this.zzf = jArr2[i2] + jArr3[i2];
            return;
        }
        this.zzf = 0;
    }

    public final String toString() {
        int i2 = this.zza;
        String arrays = Arrays.toString(this.zzb);
        String arrays2 = Arrays.toString(this.zzc);
        String arrays3 = Arrays.toString(this.zze);
        String arrays4 = Arrays.toString(this.zzd);
        return "ChunkIndex(length=" + i2 + ", sizes=" + arrays + ", offsets=" + arrays2 + ", timeUs=" + arrays3 + ", durationsUs=" + arrays4 + ")";
    }

    public final long zze() {
        return this.zzf;
    }

    public final zzabt zzg(long j2) {
        int zzc2 = zzfj.zzc(this.zze, j2, true, true);
        zzabw zzabw = new zzabw(this.zze[zzc2], this.zzc[zzc2]);
        if (zzabw.zzb >= j2 || zzc2 == this.zza - 1) {
            return new zzabt(zzabw, zzabw);
        }
        int i2 = zzc2 + 1;
        return new zzabt(zzabw, new zzabw(this.zze[i2], this.zzc[i2]));
    }

    public final boolean zzh() {
        return true;
    }
}
