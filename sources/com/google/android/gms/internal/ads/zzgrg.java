package com.google.android.gms.internal.ads;

final class zzgrg implements zzgqt {
    private final zzgqw zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzgrg(zzgqw zzgqw, String str, Object[] objArr) {
        this.zza = zzgqw;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        char c2 = charAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c2 |= (charAt2 & 8191) << i3;
                i3 += 13;
                i2 = i4;
            } else {
                this.zzd = c2 | (charAt2 << i3);
                return;
            }
        }
    }

    public final zzgqw zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    public final int zzc() {
        return (this.zzd & 1) != 0 ? 1 : 2;
    }

    /* access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }
}
