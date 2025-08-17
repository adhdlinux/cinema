package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzfrj extends zzfqw {
    final /* synthetic */ zzfrl zza;
    private final Object zzb;
    private int zzc;

    zzfrj(zzfrl zzfrl, int i2) {
        this.zza = zzfrl;
        Object[] objArr = zzfrl.zzb;
        objArr.getClass();
        this.zzb = objArr[i2];
        this.zzc = i2;
    }

    private final void zza() {
        int i2 = this.zzc;
        if (i2 != -1 && i2 < this.zza.size()) {
            Object obj = this.zzb;
            zzfrl zzfrl = this.zza;
            int i3 = this.zzc;
            Object[] objArr = zzfrl.zzb;
            objArr.getClass();
            if (zzfpc.zza(obj, objArr[i3])) {
                return;
            }
        }
        this.zzc = this.zza.zzq(this.zzb);
    }

    public final Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.get(this.zzb);
        }
        zza();
        int i2 = this.zzc;
        if (i2 == -1) {
            return null;
        }
        Object[] objArr = this.zza.zzc;
        objArr.getClass();
        return objArr[i2];
    }

    public final Object setValue(Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.put(this.zzb, obj);
        }
        zza();
        int i2 = this.zzc;
        if (i2 == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        Object[] objArr = this.zza.zzc;
        objArr.getClass();
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }
}
