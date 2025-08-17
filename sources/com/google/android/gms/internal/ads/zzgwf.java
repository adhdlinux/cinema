package com.google.android.gms.internal.ads;

public final class zzgwf implements zzgwe, zzgvy {
    private static final zzgwf zza = new zzgwf((Object) null);
    private final Object zzb;

    private zzgwf(Object obj) {
        this.zzb = obj;
    }

    public static zzgwe zza(Object obj) {
        zzgwm.zza(obj, "instance cannot be null");
        return new zzgwf(obj);
    }

    public static zzgwe zzc(Object obj) {
        return obj == null ? zza : new zzgwf(obj);
    }

    public final Object zzb() {
        return this.zzb;
    }
}
