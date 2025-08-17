package com.google.android.gms.internal.ads;

import android.os.Bundle;

final class zzbys {
    final /* synthetic */ zzbyt zza;
    private long zzb = -1;
    private long zzc = -1;

    public zzbys(zzbyt zzbyt) {
        this.zza = zzbyt;
    }

    public final long zza() {
        return this.zzc;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzb);
        bundle.putLong("tclose", this.zzc);
        return bundle;
    }

    public final void zzc() {
        this.zzc = this.zza.zza.elapsedRealtime();
    }

    public final void zzd() {
        this.zzb = this.zza.zza.elapsedRealtime();
    }
}
