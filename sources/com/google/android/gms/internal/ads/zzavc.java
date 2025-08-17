package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzavc implements Comparator {
    zzavc(zzave zzave) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzavi zzavi = (zzavi) obj;
        zzavi zzavi2 = (zzavi) obj2;
        int i2 = zzavi.zzc - zzavi2.zzc;
        if (i2 != 0) {
            return i2;
        }
        return (zzavi.zza > zzavi2.zza ? 1 : (zzavi.zza == zzavi2.zza ? 0 : -1));
    }
}
