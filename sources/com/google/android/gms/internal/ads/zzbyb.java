package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzbyb {
    private final Map zza = new HashMap();
    /* access modifiers changed from: private */
    public final List zzb = new ArrayList();
    private final Context zzc;
    private final zzbwy zzd;

    zzbyb(Context context, zzbwy zzbwy) {
        this.zzc = context;
        this.zzd = zzbwy;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            this.zzd.zze();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc(String str) {
        SharedPreferences sharedPreferences;
        if (!this.zza.containsKey(str)) {
            if ("__default__".equals(str)) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.zzc);
            } else {
                sharedPreferences = this.zzc.getSharedPreferences(str, 0);
            }
            zzbya zzbya = new zzbya(this, str);
            this.zza.put(str, zzbya);
            sharedPreferences.registerOnSharedPreferenceChangeListener(zzbya);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd(zzbxz zzbxz) {
        this.zzb.add(zzbxz);
    }
}
