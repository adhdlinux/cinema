package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzgdx extends zzfyf {
    private final zzgfb zza;

    public zzgdx(zzgfb zzgfb) {
        this.zza = zzgfb;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgdx)) {
            return false;
        }
        zzgfb zzgfb = ((zzgdx) obj).zza;
        if (!this.zza.zzb().zzf().equals(zzgfb.zzb().zzf()) || !this.zza.zzb().zzh().equals(zzgfb.zzb().zzh()) || !this.zza.zzb().zzg().equals(zzgfb.zzb().zzg())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        zzgfb zzgfb = this.zza;
        return Arrays.hashCode(new Object[]{zzgfb.zzb(), zzgfb.zzd()});
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = this.zza.zzb().zzh();
        zzglq zzf = this.zza.zzb().zzf();
        zzglq zzglq = zzglq.UNKNOWN_PREFIX;
        int ordinal = zzf.ordinal();
        if (ordinal == 1) {
            str = "TINK";
        } else if (ordinal == 2) {
            str = "LEGACY";
        } else if (ordinal == 3) {
            str = "RAW";
        } else if (ordinal != 4) {
            str = "UNKNOWN";
        } else {
            str = "CRUNCHY";
        }
        objArr[1] = str;
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }

    public final zzgfb zza() {
        return this.zza;
    }
}
