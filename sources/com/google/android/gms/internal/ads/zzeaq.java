package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbr;

final class zzeaq extends zzebm {
    private Activity zza;
    private zzl zzb;
    private zzbr zzc;
    private String zzd;
    private String zze;

    zzeaq() {
    }

    public final zzebm zza(Activity activity) {
        if (activity != null) {
            this.zza = activity;
            return this;
        }
        throw new NullPointerException("Null activity");
    }

    public final zzebm zzb(zzl zzl) {
        this.zzb = zzl;
        return this;
    }

    public final zzebm zzc(String str) {
        this.zzd = str;
        return this;
    }

    public final zzebm zzd(String str) {
        this.zze = str;
        return this;
    }

    public final zzebm zze(zzbr zzbr) {
        this.zzc = zzbr;
        return this;
    }

    public final zzebn zzf() {
        Activity activity = this.zza;
        if (activity != null) {
            return new zzeas(activity, this.zzb, this.zzc, this.zzd, this.zze, (zzear) null);
        }
        throw new IllegalStateException("Missing required properties: activity");
    }
}
