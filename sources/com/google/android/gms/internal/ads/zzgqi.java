package com.google.android.gms.internal.ads;

import java.util.List;

final class zzgqi extends zzgqk {
    private zzgqi() {
        super((zzgqj) null);
    }

    /* synthetic */ zzgqi(zzgqh zzgqh) {
        super((zzgqj) null);
    }

    /* access modifiers changed from: package-private */
    public final List zza(Object obj, long j2) {
        int i2;
        zzgpv zzgpv = (zzgpv) zzgsq.zzh(obj, j2);
        if (zzgpv.zzc()) {
            return zzgpv;
        }
        int size = zzgpv.size();
        if (size == 0) {
            i2 = 10;
        } else {
            i2 = size + size;
        }
        zzgpv zzd = zzgpv.zzd(i2);
        zzgsq.zzv(obj, j2, zzd);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j2) {
        ((zzgpv) zzgsq.zzh(obj, j2)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj, Object obj2, long j2) {
        zzgpv zzgpv = (zzgpv) zzgsq.zzh(obj, j2);
        zzgpv zzgpv2 = (zzgpv) zzgsq.zzh(obj2, j2);
        int size = zzgpv.size();
        int size2 = zzgpv2.size();
        if (size > 0 && size2 > 0) {
            if (!zzgpv.zzc()) {
                zzgpv = zzgpv.zzd(size2 + size);
            }
            zzgpv.addAll(zzgpv2);
        }
        if (size > 0) {
            zzgpv2 = zzgpv;
        }
        zzgsq.zzv(obj, j2, zzgpv2);
    }
}
