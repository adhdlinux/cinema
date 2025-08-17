package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;

public final class zzghu {
    private final zzghn zza;
    private final List zzb;
    private final Integer zzc;

    /* synthetic */ zzghu(zzghn zzghn, List list, Integer num, zzght zzght) {
        this.zza = zzghn;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghu)) {
            return false;
        }
        zzghu zzghu = (zzghu) obj;
        if (this.zza.equals(zzghu.zza) && this.zzb.equals(zzghu.zzb)) {
            Integer num = this.zzc;
            Integer num2 = zzghu.zzc;
            if (num == num2) {
                return true;
            }
            if (num == null || !num.equals(num2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.zza, this.zzb, this.zzc});
    }
}
