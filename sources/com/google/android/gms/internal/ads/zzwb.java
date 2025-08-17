package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final /* synthetic */ class zzwb implements Comparator {
    public static final /* synthetic */ zzwb zza = new zzwb();

    private /* synthetic */ zzwb() {
    }

    public final int compare(Object obj, Object obj2) {
        List list = (List) obj;
        List list2 = (List) obj2;
        zzfrr zzj = zzfrr.zzj();
        zzwv zzwv = zzwv.zza;
        zzfrr zzb = zzj.zzc((zzwx) Collections.max(list, zzwv), (zzwx) Collections.max(list2, zzwv), zzwv).zzb(list.size(), list2.size());
        zzww zzww = zzww.zza;
        return zzb.zzc((zzwx) Collections.max(list, zzww), (zzwx) Collections.max(list2, zzww), zzww).zza();
    }
}
