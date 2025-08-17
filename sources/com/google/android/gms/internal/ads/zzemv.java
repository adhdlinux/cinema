package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzemv implements zzeqy {
    private final zzewl zza;

    zzemv(zzewl zzewl) {
        this.zza = zzewl;
    }

    public final int zza() {
        return 15;
    }

    public final zzfwm zzb() {
        zzewl zzewl = this.zza;
        zzemu zzemu = null;
        if (!(zzewl == null || zzewl.zza() == null || zzewl.zza().isEmpty())) {
            zzemu = new zzemu(this);
        }
        return zzfwc.zzh(zzemu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
