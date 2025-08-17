package com.google.android.gms.internal.cast;

import java.util.Comparator;

final class zzre implements Comparator {
    zzre() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzrm zzrm = (zzrm) obj;
        zzrm zzrm2 = (zzrm) obj2;
        zzrd zzrd = new zzrd(zzrm);
        zzrd zzrd2 = new zzrd(zzrm2);
        while (zzrd.hasNext() && zzrd2.hasNext()) {
            int compareTo = Integer.valueOf(zzrd.zza() & 255).compareTo(Integer.valueOf(zzrd2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzrm.zzd()).compareTo(Integer.valueOf(zzrm2.zzd()));
    }
}
