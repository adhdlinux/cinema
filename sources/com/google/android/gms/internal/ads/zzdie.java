package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class zzdie implements View.OnClickListener {
    String zza;
    Long zzb;
    WeakReference zzc;
    private final zzdlx zzd;
    private final Clock zze;
    private zzbgl zzf;
    private zzbij zzg;

    public zzdie(zzdlx zzdlx, Clock clock) {
        this.zzd = zzdlx;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference weakReference = this.zzc;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzc = null;
        }
    }

    public final void onClick(View view) {
        WeakReference weakReference = this.zzc;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zza == null || this.zzb == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zza);
                hashMap.put("time_interval", String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzd.zzg("sendMessageToNativeJs", hashMap);
            }
            zzd();
        }
    }

    public final zzbgl zza() {
        return this.zzf;
    }

    public final void zzb() {
        if (this.zzf != null && this.zzb != null) {
            zzd();
            try {
                this.zzf.zze();
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void zzc(zzbgl zzbgl) {
        this.zzf = zzbgl;
        zzbij zzbij = this.zzg;
        if (zzbij != null) {
            this.zzd.zzk("/unconfirmedClick", zzbij);
        }
        zzdid zzdid = new zzdid(this, zzbgl);
        this.zzg = zzdid;
        this.zzd.zzi("/unconfirmedClick", zzdid);
    }
}
