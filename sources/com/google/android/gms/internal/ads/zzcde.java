package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzcde implements Iterable {
    private final List zza = new ArrayList();

    public final Iterator iterator() {
        return this.zza.iterator();
    }

    /* access modifiers changed from: package-private */
    public final zzcdd zza(zzcca zzcca) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            zzcdd zzcdd = (zzcdd) it2.next();
            if (zzcdd.zza == zzcca) {
                return zzcdd;
            }
        }
        return null;
    }

    public final void zzb(zzcdd zzcdd) {
        this.zza.add(zzcdd);
    }

    public final void zzc(zzcdd zzcdd) {
        this.zza.remove(zzcdd);
    }

    public final boolean zzd(zzcca zzcca) {
        ArrayList<zzcdd> arrayList = new ArrayList<>();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            zzcdd zzcdd = (zzcdd) it2.next();
            if (zzcdd.zza == zzcca) {
                arrayList.add(zzcdd);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (zzcdd zzcdd2 : arrayList) {
            zzcdd2.zzb.zzf();
        }
        return true;
    }
}
