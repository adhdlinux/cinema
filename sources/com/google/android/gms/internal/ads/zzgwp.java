package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class zzgwp implements zzgwe {
    private static final zzgwe zza = zzgwf.zza(Collections.emptySet());
    private final List zzb;
    private final List zzc;

    /* synthetic */ zzgwp(List list, List list2, zzgwn zzgwn) {
        this.zzb = list;
        this.zzc = list2;
    }

    public static zzgwo zza(int i2, int i3) {
        return new zzgwo(i2, i3, (zzgwn) null);
    }

    /* renamed from: zzc */
    public final Set zzb() {
        int size = this.zzb.size();
        ArrayList arrayList = new ArrayList(this.zzc.size());
        int size2 = this.zzc.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Collection collection = (Collection) ((zzgwr) this.zzc.get(i2)).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet zza2 = zzgwb.zza(size);
        int size3 = this.zzb.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Object zzb2 = ((zzgwr) this.zzb.get(i3)).zzb();
            zzb2.getClass();
            zza2.add(zzb2);
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            for (Object next : (Collection) arrayList.get(i4)) {
                next.getClass();
                zza2.add(next);
            }
        }
        return Collections.unmodifiableSet(zza2);
    }
}
