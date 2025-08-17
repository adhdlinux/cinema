package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzdh {
    public static final zzdh zza = new zzdh(zzfsc.zzl());
    public static final zzn zzb = zzde.zza;
    private static final String zzc = Integer.toString(0, 36);
    private final zzfsc zzd;

    public zzdh(List list) {
        this.zzd = zzfsc.zzj(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzdh.class != obj.getClass()) {
            return false;
        }
        return this.zzd.equals(((zzdh) obj).zzd);
    }

    public final int hashCode() {
        return this.zzd.hashCode();
    }

    public final zzfsc zza() {
        return this.zzd;
    }

    public final boolean zzb(int i2) {
        for (int i3 = 0; i3 < this.zzd.size(); i3++) {
            zzdg zzdg = (zzdg) this.zzd.get(i3);
            if (zzdg.zzc() && zzdg.zza() == i2) {
                return true;
            }
        }
        return false;
    }
}
