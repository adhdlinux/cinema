package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzgnv implements Comparator {
    zzgnv() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgoe zzgoe = (zzgoe) obj;
        zzgoe zzgoe2 = (zzgoe) obj2;
        zzgny zzs = zzgoe.iterator();
        zzgny zzs2 = zzgoe2.iterator();
        while (zzs.hasNext() && zzs2.hasNext()) {
            int compareTo = Integer.valueOf(zzs.zza() & 255).compareTo(Integer.valueOf(zzs2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzgoe.zzd()).compareTo(Integer.valueOf(zzgoe2.zzd()));
    }
}
