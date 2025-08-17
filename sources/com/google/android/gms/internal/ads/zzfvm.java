package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

abstract class zzfvm extends zzfvb {
    private List zza;

    zzfvm(zzfrx zzfrx, boolean z2) {
        super(zzfrx, true, true);
        List list;
        if (zzfrx.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = zzfsq.zza(zzfrx.size());
        }
        for (int i2 = 0; i2 < zzfrx.size(); i2++) {
            list.add((Object) null);
        }
        this.zza = list;
    }

    /* access modifiers changed from: package-private */
    public abstract Object zzH(List list);

    /* access modifiers changed from: package-private */
    public final void zzg(int i2, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i2, new zzfvl(obj));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzv() {
        List list = this.zza;
        if (list != null) {
            zzd(zzH(list));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzz(int i2) {
        super.zzz(i2);
        this.zza = null;
    }
}
