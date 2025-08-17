package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

public final /* synthetic */ class zzczz implements zzdap {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzczz(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final void zza(Object obj) {
        ((AppEventListener) obj).onAppEvent(this.zza, this.zzb);
    }
}
