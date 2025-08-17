package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzghn {
    public static final zzghn zza = new zzghl().zza();
    private final Map zzb;

    /* synthetic */ zzghn(Map map, zzghm zzghm) {
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghn)) {
            return false;
        }
        return this.zzb.equals(((zzghn) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map zza() {
        return this.zzb;
    }
}
