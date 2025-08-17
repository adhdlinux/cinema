package com.google.android.gms.internal.ads;

public final class zzalq {
    public final Object zza;
    public final zzakt zzb;
    public final zzalt zzc;
    public boolean zzd;

    private zzalq(zzalt zzalt) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzalt;
    }

    private zzalq(Object obj, zzakt zzakt) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzakt;
        this.zzc = null;
    }

    public static zzalq zza(zzalt zzalt) {
        return new zzalq(zzalt);
    }

    public static zzalq zzb(Object obj, zzakt zzakt) {
        return new zzalq(obj, zzakt);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
