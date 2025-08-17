package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

final class zzfrk extends AbstractCollection {
    final /* synthetic */ zzfrl zza;

    zzfrk(zzfrl zzfrl) {
        this.zza = zzfrl;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzfrl zzfrl = this.zza;
        Map zzj = zzfrl.zzj();
        if (zzj != null) {
            return zzj.values().iterator();
        }
        return new zzfre(zzfrl);
    }

    public final int size() {
        return this.zza.size();
    }
}
