package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzz;

public class zzdlk implements zza, zzbhc, zzo, zzbhe, zzz {
    private zza zza;
    private zzbhc zzb;
    private zzo zzc;
    private zzbhe zzd;
    private zzz zze;

    public final synchronized void onAdClicked() {
        zza zza2 = this.zza;
        if (zza2 != null) {
            zza2.onAdClicked();
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        zzbhc zzbhc = this.zzb;
        if (zzbhc != null) {
            zzbhc.zza(str, bundle);
        }
    }

    public final synchronized void zzb() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzb();
        }
    }

    public final synchronized void zzbF() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbF();
        }
    }

    public final synchronized void zzbo() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbo();
        }
    }

    public final synchronized void zzby() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzby();
        }
    }

    public final synchronized void zzbz(String str, String str2) {
        zzbhe zzbhe = this.zzd;
        if (zzbhe != null) {
            zzbhe.zzbz(str, str2);
        }
    }

    public final synchronized void zze() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zze();
        }
    }

    public final synchronized void zzf(int i2) {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzf(i2);
        }
    }

    public final synchronized void zzg() {
        zzz zzz = this.zze;
        if (zzz != null) {
            zzz.zzg();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzh(zza zza2, zzbhc zzbhc, zzo zzo, zzbhe zzbhe, zzz zzz) {
        this.zza = zza2;
        this.zzb = zzbhc;
        this.zzc = zzo;
        this.zzd = zzbhe;
        this.zze = zzz;
    }
}
