package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

final class zzbya implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzbyb zza;
    private final String zzb;

    public zzbya(zzbyb zzbyb, String str) {
        this.zza = zzbyb;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzbxz zzbxz : this.zza.zzb) {
                zzbxz.zza.zzb(zzbxz.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
