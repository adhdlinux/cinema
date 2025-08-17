package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzpn {
    /* access modifiers changed from: private */
    public zzoe zza = zzoe.zza;
    private boolean zzb;
    /* access modifiers changed from: private */
    public final zzpm zzc = zzpm.zza;
    /* access modifiers changed from: private */
    public zzpp zzd;
    /* access modifiers changed from: private */
    public zzph zze;

    @Deprecated
    public final zzpn zzc(zzoe zzoe) {
        this.zza = zzoe;
        return this;
    }

    public final zzpn zzd(zzdr[] zzdrArr) {
        this.zzd = new zzpp(zzdrArr);
        return this;
    }

    public final zzpz zze() {
        zzdy.zzf(!this.zzb);
        this.zzb = true;
        if (this.zzd == null) {
            this.zzd = new zzpp(new zzdr[0]);
        }
        if (this.zze == null) {
            this.zze = new zzph((Context) null);
        }
        return new zzpz(this, (zzpy) null);
    }
}
