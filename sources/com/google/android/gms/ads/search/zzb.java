package com.google.android.gms.ads.search;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzdw;
import com.google.android.gms.ads.mediation.NetworkExtras;

public final class zzb {
    /* access modifiers changed from: private */
    public final zzdw zza = new zzdw();
    /* access modifiers changed from: private */
    public String zzb;

    public final zzb zzb(Class cls, Bundle bundle) {
        this.zza.zzq(cls, bundle);
        return this;
    }

    public final zzb zzc(NetworkExtras networkExtras) {
        this.zza.zzu(networkExtras);
        return this;
    }

    public final zzb zzd(Class cls, Bundle bundle) {
        this.zza.zzt(cls, bundle);
        return this;
    }

    public final zzb zze(String str) {
        this.zzb = str;
        return this;
    }
}
