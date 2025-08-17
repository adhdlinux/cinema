package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzeoi implements zzeqx {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final boolean zzd;

    public zzeoi(String str, boolean z2, boolean z3, boolean z4) {
        this.zza = str;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = z4;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!this.zza.isEmpty()) {
            bundle.putString("inspector_extras", this.zza);
        }
        bundle.putInt("test_mode", this.zzb ? 1 : 0);
        bundle.putInt("linked_device", this.zzc ? 1 : 0);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zziK)).booleanValue()) {
            return;
        }
        if (this.zzb || this.zzc) {
            bundle.putInt("risd", this.zzd ^ true ? 1 : 0);
        }
    }
}
