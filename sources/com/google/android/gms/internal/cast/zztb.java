package com.google.android.gms.internal.cast;

final class zztb extends zztd {
    private zztb() {
        super((zztc) null);
    }

    /* synthetic */ zztb(zzta zzta) {
        super((zztc) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j2) {
        ((zzsp) zzvb.zzf(obj, j2)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, Object obj2, long j2) {
        zzsp zzsp = (zzsp) zzvb.zzf(obj, j2);
        zzsp zzsp2 = (zzsp) zzvb.zzf(obj2, j2);
        int size = zzsp.size();
        int size2 = zzsp2.size();
        if (size > 0 && size2 > 0) {
            if (!zzsp.zzc()) {
                zzsp = zzsp.zzg(size2 + size);
            }
            zzsp.addAll(zzsp2);
        }
        if (size > 0) {
            zzsp2 = zzsp;
        }
        zzvb.zzs(obj, j2, zzsp2);
    }
}
