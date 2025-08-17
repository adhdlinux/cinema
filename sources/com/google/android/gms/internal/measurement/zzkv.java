package com.google.android.gms.internal.measurement;

final class zzkv extends zzkx {
    private zzkv() {
        super((zzkw) null);
    }

    /* synthetic */ zzkv(zzku zzku) {
        super((zzkw) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j2) {
        ((zzkj) zzmv.zzf(obj, j2)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, Object obj2, long j2) {
        zzkj zzkj = (zzkj) zzmv.zzf(obj, j2);
        zzkj zzkj2 = (zzkj) zzmv.zzf(obj2, j2);
        int size = zzkj.size();
        int size2 = zzkj2.size();
        if (size > 0 && size2 > 0) {
            if (!zzkj.zzc()) {
                zzkj = zzkj.zzd(size2 + size);
            }
            zzkj.addAll(zzkj2);
        }
        if (size > 0) {
            zzkj2 = zzkj;
        }
        zzmv.zzs(obj, j2, zzkj2);
    }
}
