package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzfri extends AbstractSet {
    final /* synthetic */ zzfrl zza;

    zzfri(zzfrl zzfrl) {
        this.zza = zzfrl;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzfrl zzfrl = this.zza;
        Map zzj = zzfrl.zzj();
        if (zzj != null) {
            return zzj.keySet().iterator();
        }
        return new zzfrc(zzfrl);
    }

    public final boolean remove(Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.keySet().remove(obj);
        }
        if (this.zza.zzs(obj) == zzfrl.zzd) {
            return false;
        }
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
