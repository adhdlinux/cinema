package com.google.android.gms.internal.ads;

public final class zzgwc implements zzgwe {
    private zzgwr zza;

    public static void zza(zzgwr zzgwr, zzgwr zzgwr2) {
        zzgwc zzgwc = (zzgwc) zzgwr;
        if (zzgwc.zza == null) {
            zzgwc.zza = zzgwr2;
            return;
        }
        throw new IllegalStateException();
    }

    public final Object zzb() {
        zzgwr zzgwr = this.zza;
        if (zzgwr != null) {
            return zzgwr.zzb();
        }
        throw new IllegalStateException();
    }
}
