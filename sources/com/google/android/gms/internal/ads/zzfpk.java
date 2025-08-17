package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.List;

final class zzfpk implements Serializable, zzfpi {
    private final List zza;

    /* synthetic */ zzfpk(List list, zzfpj zzfpj) {
        this.zza = list;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzfpk) {
            return this.zza.equals(((zzfpk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 306654252;
    }

    public final String toString() {
        List list = this.zza;
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append("and(");
        boolean z2 = true;
        for (Object next : list) {
            if (!z2) {
                sb.append(',');
            }
            sb.append(next);
            z2 = false;
        }
        sb.append(')');
        return sb.toString();
    }

    public final boolean zza(Object obj) {
        for (int i2 = 0; i2 < this.zza.size(); i2++) {
            if (!((zzfpi) this.zza.get(i2)).zza(obj)) {
                return false;
            }
        }
        return true;
    }
}
