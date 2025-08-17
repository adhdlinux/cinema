package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzdlx {
    /* access modifiers changed from: private */
    public final zzdlk zza = new zzdlk();
    private final zza zzb;
    private final zzcfl zzc;
    private final Context zzd;
    private final zzdqa zze;
    private final zzfev zzf;
    private final Executor zzg;
    private final zzaqs zzh;
    private final zzbzx zzi;
    private final zzbix zzj;
    private final zzeba zzk;
    private final zzfgr zzl;
    private final zzebl zzm;
    private zzfwm zzn;

    zzdlx(zzdlu zzdlu) {
        this.zzd = zzdlu.zzc;
        this.zzg = zzdlu.zzg;
        this.zzh = zzdlu.zzh;
        this.zzi = zzdlu.zzi;
        this.zzb = zzdlu.zza;
        this.zzc = zzdlu.zzb;
        this.zzj = new zzbix();
        this.zzk = zzdlu.zzf;
        this.zzl = zzdlu.zzj;
        this.zze = zzdlu.zzd;
        this.zzf = zzdlu.zze;
        this.zzm = zzdlu.zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcez zza(zzcez zzcez) {
        zzcez zzcez2 = zzcez;
        zzcez2.zzad("/result", this.zzj);
        zzcgm zzN = zzcez.zzN();
        zzdlk zzdlk = this.zza;
        zzb zzb2 = r2;
        zzb zzb3 = new zzb(this.zzd, (zzbws) null, (zzbtk) null);
        zzN.zzM((com.google.android.gms.ads.internal.client.zza) null, zzdlk, zzdlk, zzdlk, zzdlk, false, (zzbil) null, zzb2, (zzbqx) null, (zzbws) null, this.zzk, this.zzl, this.zze, this.zzf, (zzbjb) null, (zzdcu) null, (zzbja) null, (zzbiu) null);
        return zzcez2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(String str, JSONObject jSONObject, zzcez zzcez) throws Exception {
        return this.zzj.zzb(zzcez, str, jSONObject);
    }

    public final synchronized zzfwm zzd(String str, JSONObject jSONObject) {
        zzfwm zzfwm = this.zzn;
        if (zzfwm == null) {
            return zzfwc.zzh((Object) null);
        }
        return zzfwc.zzm(zzfwm, new zzdll(this, str, jSONObject), this.zzg);
    }

    public final synchronized void zze(zzezn zzezn, zzezq zzezq) {
        zzfwm zzfwm = this.zzn;
        if (zzfwm != null) {
            zzfwc.zzq(zzfwm, new zzdlr(this, zzezn, zzezq), this.zzg);
        }
    }

    public final synchronized void zzf() {
        zzfwm zzfwm = this.zzn;
        if (zzfwm != null) {
            zzfwc.zzq(zzfwm, new zzdln(this), this.zzg);
            this.zzn = null;
        }
    }

    public final synchronized void zzg(String str, Map map) {
        zzfwm zzfwm = this.zzn;
        if (zzfwm != null) {
            zzfwc.zzq(zzfwm, new zzdlq(this, "sendMessageToNativeJs", map), this.zzg);
        }
    }

    public final synchronized void zzh() {
        Context context = this.zzd;
        zzbzx zzbzx = this.zzi;
        zzbbe zzbbe = zzbbm.zzdu;
        zzfwm zzl2 = zzfwc.zzl(zzfwc.zzk(new zzcfi(context, this.zzh, zzbzx, this.zzb, this.zzm, (String) zzba.zzc().zzb(zzbbe)), zzcae.zze), new zzdlm(this), this.zzg);
        this.zzn = zzl2;
        zzcah.zza(zzl2, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzi(String str, zzbij zzbij) {
        zzfwm zzfwm = this.zzn;
        if (zzfwm != null) {
            zzfwc.zzq(zzfwm, new zzdlo(this, str, zzbij), this.zzg);
        }
    }

    public final void zzj(WeakReference weakReference, String str, zzbij zzbij) {
        zzi(str, new zzdlw(this, weakReference, str, zzbij, (zzdlv) null));
    }

    public final synchronized void zzk(String str, zzbij zzbij) {
        zzfwm zzfwm = this.zzn;
        if (zzfwm != null) {
            zzfwc.zzq(zzfwm, new zzdlp(this, str, zzbij), this.zzg);
        }
    }
}
