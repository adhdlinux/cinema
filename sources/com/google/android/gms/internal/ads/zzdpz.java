package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzdpz {
    final /* synthetic */ zzdqa zza;
    private final Map zzb = new ConcurrentHashMap();

    zzdpz(zzdqa zzdqa) {
        this.zza = zzdqa;
    }

    public final zzdpz zzb(String str, String str2) {
        this.zzb.put(str, str2);
        return this;
    }

    public final zzdpz zzc(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdpz zzd(zzezn zzezn) {
        this.zzb.put("aai", zzezn.zzx);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgN)).booleanValue()) {
            zzc("rid", zzezn.zzao);
        }
        return this;
    }

    public final zzdpz zze(zzezq zzezq) {
        this.zzb.put("gqi", zzezq.zzb);
        return this;
    }

    public final String zzf() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzg() {
        this.zza.zzb.execute(new zzdpy(this));
    }

    public final void zzh() {
        this.zza.zzb.execute(new zzdpx(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zza.zza.zze(this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj() {
        this.zza.zza.zzd(this.zzb);
    }
}
