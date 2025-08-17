package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;

public final class zzdmm extends zzcrd {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdew zze;
    private final zzdcc zzf;
    private final zzcvt zzg;
    private final zzcxa zzh;
    private final zzcrx zzi;
    private final zzbvk zzj;
    private final zzfjm zzk;
    private final zzfab zzl;
    private boolean zzm = false;

    zzdmm(zzcrc zzcrc, Context context, zzcez zzcez, zzdew zzdew, zzdcc zzdcc, zzcvt zzcvt, zzcxa zzcxa, zzcrx zzcrx, zzezn zzezn, zzfjm zzfjm, zzfab zzfab) {
        super(zzcrc);
        String str;
        int i2;
        this.zzc = context;
        this.zze = zzdew;
        this.zzd = new WeakReference(zzcez);
        this.zzf = zzdcc;
        this.zzg = zzcvt;
        this.zzh = zzcxa;
        this.zzi = zzcrx;
        this.zzk = zzfjm;
        zzbvg zzbvg = zzezn.zzm;
        if (zzbvg != null) {
            str = zzbvg.zza;
        } else {
            str = "";
        }
        if (zzbvg != null) {
            i2 = zzbvg.zzb;
        } else {
            i2 = 1;
        }
        this.zzj = new zzbwe(str, i2);
        this.zzl = zzfab;
    }

    public final void finalize() throws Throwable {
        try {
            zzcez zzcez = (zzcez) this.zzd.get();
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzgy)).booleanValue()) {
                if (!this.zzm && zzcez != null) {
                    zzcae.zze.execute(new zzdml(zzcez));
                }
            } else if (zzcez != null) {
                zzcez.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzbvk zzc() {
        return this.zzj;
    }

    public final zzfab zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcez zzcez = (zzcez) this.zzd.get();
        if (zzcez == null || zzcez.zzaB()) {
            return false;
        }
        return true;
    }

    public final boolean zzh(boolean z2, Activity activity) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzaB)).booleanValue()) {
            zzt.zzp();
            if (zzs.zzC(this.zzc)) {
                zzbzr.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzaC)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzm) {
            zzbzr.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzfbi.zzd(10, (String) null, (zze) null));
            return false;
        }
        this.zzm = true;
        this.zzf.zzb();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            this.zze.zza(z2, context, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdev e2) {
            this.zzg.zzc(e2);
            return false;
        }
    }
}
