package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzfrf extends AbstractSet {
    final /* synthetic */ zzfrl zza;

    zzfrf(zzfrl zzfrl) {
        this.zza = zzfrl;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzd = this.zza.zzq(entry.getKey());
            if (zzd != -1) {
                Object[] objArr = this.zza.zzc;
                objArr.getClass();
                if (zzfpc.zza(objArr[zzd], entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Iterator iterator() {
        zzfrl zzfrl = this.zza;
        Map zzj = zzfrl.zzj();
        if (zzj != null) {
            return zzj.entrySet().iterator();
        }
        return new zzfrd(zzfrl);
    }

    public final boolean remove(Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzfrl zzfrl = this.zza;
        if (zzfrl.zzo()) {
            return false;
        }
        int zzc = zzfrl.zzp();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object zzh = zzfrl.zzh(this.zza);
        zzfrl zzfrl2 = this.zza;
        int[] iArr = zzfrl2.zza;
        iArr.getClass();
        Object[] objArr = zzfrl2.zzb;
        objArr.getClass();
        Object[] objArr2 = zzfrl2.zzc;
        objArr2.getClass();
        int zzb = zzfrm.zzb(key, value, zzc, zzh, iArr, objArr, objArr2);
        if (zzb == -1) {
            return false;
        }
        this.zza.zzn(zzb, zzc);
        zzfrl zzfrl3 = this.zza;
        zzfrl3.zzg = zzfrl3.zzg - 1;
        this.zza.zzl();
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
