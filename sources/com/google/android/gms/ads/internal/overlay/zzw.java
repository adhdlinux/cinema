package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzfmz;
import com.google.android.gms.internal.ads.zzfna;
import com.google.android.gms.internal.ads.zzfnb;
import com.google.android.gms.internal.ads.zzfnc;
import com.google.android.gms.internal.ads.zzfnl;
import com.google.android.gms.internal.ads.zzfnn;
import com.google.android.gms.internal.ads.zzfno;
import com.google.android.gms.internal.ads.zzfnp;
import com.google.android.gms.internal.ads.zzfnq;
import com.google.android.gms.internal.ads.zzfok;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.HashMap;
import java.util.Map;

public final class zzw {
    private String zza = null;
    private String zzb = null;
    private zzcez zzc = null;
    private zzfnb zzd = null;
    private boolean zze = false;
    private zzfno zzf;

    private final zzfnq zzl() {
        zzfnp zzc2 = zzfnq.zzc();
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjQ)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        return zzc2.zzc();
    }

    private final void zzm() {
        if (this.zzf == null) {
            this.zzf = new zzv(this);
        }
    }

    public final synchronized void zza(zzcez zzcez, Context context) {
        this.zzc = zzcez;
        if (!zzk(context)) {
            zzf("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("action", "fetch_completed");
        zze("on_play_store_bind", hashMap);
    }

    public final void zzb() {
        zzfnb zzfnb;
        if (!this.zze || (zzfnb = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfnb.zza(zzl(), this.zzf);
        zzd("onLMDOverlayCollapse");
    }

    public final void zzc() {
        zzfnb zzfnb;
        if (!this.zze || (zzfnb = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfmz zzc2 = zzfna.zzc();
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjQ)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        zzfnb.zzb(zzc2.zzc(), this.zzf);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zze(str, new HashMap());
    }

    /* access modifiers changed from: package-private */
    public final void zze(String str, Map map) {
        zzcae.zze.execute(new zzu(this, str, map));
    }

    /* access modifiers changed from: package-private */
    public final void zzf(String str, String str2) {
        zze.zza(str);
        if (this.zzc != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("message", str);
            hashMap.put("action", str2);
            zze("onError", hashMap);
        }
    }

    public final void zzg() {
        zzfnb zzfnb;
        if (!this.zze || (zzfnb = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfnb.zzc(zzl(), this.zzf);
        zzd("onLMDOverlayExpand");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str, Map map) {
        zzcez zzcez = this.zzc;
        if (zzcez != null) {
            zzcez.zzd(str, map);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(zzfnn zzfnn) {
        if (!TextUtils.isEmpty(zzfnn.zzb())) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjQ)).booleanValue()) {
                this.zza = zzfnn.zzb();
            }
        }
        switch (zzfnn.zza()) {
            case 8152:
                zzd("onLMDOverlayOpened");
                return;
            case 8153:
                zzd("onLMDOverlayClicked");
                return;
            case 8155:
                zzd("onLMDOverlayClose");
                return;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                return;
            case 8160:
            case 8161:
            case 8162:
                HashMap hashMap = new HashMap();
                hashMap.put(MRAIDPresenter.ERROR, String.valueOf(zzfnn.zza()));
                zze("onLMDOverlayFailedToOpen", hashMap);
                return;
            default:
                return;
        }
    }

    public final void zzj(zzcez zzcez, zzfnl zzfnl) {
        if (zzcez == null) {
            zzf("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzcez;
        if (this.zze || zzk(zzcez.getContext())) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjQ)).booleanValue()) {
                this.zzb = zzfnl.zzg();
            }
            zzm();
            zzfnb zzfnb = this.zzd;
            if (zzfnb != null) {
                zzfnb.zzd(zzfnl, this.zzf);
                return;
            }
            return;
        }
        zzf("LMDOverlay not bound", "on_play_store_bind");
    }

    public final synchronized boolean zzk(Context context) {
        if (!zzfok.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzfnc.zza(context);
        } catch (NullPointerException e2) {
            zze.zza("Error connecting LMD Overlay service");
            zzt.zzo().zzu(e2, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzm();
        this.zze = true;
        return true;
    }
}
