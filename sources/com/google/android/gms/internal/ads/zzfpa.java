package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzfpa {
    private final String zza;
    private final zzfoy zzb;
    private zzfoy zzc;

    /* synthetic */ zzfpa(String str, zzfoz zzfoz) {
        zzfoy zzfoy = new zzfoy((zzfox) null);
        this.zzb = zzfoy;
        this.zzc = zzfoy;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzfoy zzfoy = this.zzb.zzb;
        String str = "";
        while (zzfoy != null) {
            Object obj = zzfoy.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzfoy = zzfoy.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzfpa zza(Object obj) {
        zzfoy zzfoy = new zzfoy((zzfox) null);
        this.zzc.zzb = zzfoy;
        this.zzc = zzfoy;
        zzfoy.zza = obj;
        return this;
    }
}
