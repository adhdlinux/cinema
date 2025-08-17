package com.google.android.gms.internal.auth;

final class zzfi extends zzfk {
    private zzfi() {
        super((zzfj) null);
    }

    /* synthetic */ zzfi(zzfh zzfh) {
        super((zzfj) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j2) {
        ((zzey) zzhi.zzf(obj, j2)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, Object obj2, long j2) {
        zzey zzey = (zzey) zzhi.zzf(obj, j2);
        zzey zzey2 = (zzey) zzhi.zzf(obj2, j2);
        int size = zzey.size();
        int size2 = zzey2.size();
        if (size > 0 && size2 > 0) {
            if (!zzey.zzc()) {
                zzey = zzey.zzd(size2 + size);
            }
            zzey.addAll(zzey2);
        }
        if (size > 0) {
            zzey2 = zzey;
        }
        zzhi.zzp(obj, j2, zzey2);
    }
}
