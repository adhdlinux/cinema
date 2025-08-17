package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.CastUtils;
import java.util.Collection;
import java.util.Locale;

final class zzw {
    private final String zza;
    private final String zzb;
    private final Collection zzc;

    /* synthetic */ zzw(String str, String str2, Collection collection, boolean z2, boolean z3, zzv zzv) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = collection;
    }

    static /* bridge */ /* synthetic */ String zza(zzw zzw) {
        StringBuilder sb = new StringBuilder(zzw.zza);
        String str = zzw.zzb;
        if (str != null) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            if (upperCase.matches("[A-F0-9]+")) {
                sb.append("/");
                sb.append(upperCase);
            } else {
                throw new IllegalArgumentException("Invalid application ID: ".concat(String.valueOf(zzw.zzb)));
            }
        }
        Collection collection = zzw.zzc;
        if (collection != null) {
            if (!collection.isEmpty()) {
                if (zzw.zzb == null) {
                    sb.append("/");
                }
                sb.append("/");
                boolean z2 = true;
                for (String str2 : zzw.zzc) {
                    CastUtils.throwIfInvalidNamespace(str2);
                    if (!z2) {
                        sb.append(",");
                    }
                    sb.append(CastUtils.zzc(str2));
                    z2 = false;
                }
            } else {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
        }
        if (zzw.zzb == null && zzw.zzc == null) {
            sb.append("/");
        }
        if (zzw.zzc == null) {
            sb.append("/");
        }
        sb.append("//ALLOW_IPV6");
        return sb.toString();
    }
}
