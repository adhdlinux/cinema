package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzdkt {
    private final zzfai zza;
    private final Executor zzb;
    private final zzdni zzc;
    private final zzdmd zzd;
    private final Context zze;
    private final zzdqa zzf;
    private final zzfev zzg;
    private final zzfgr zzh;
    private final zzeba zzi;

    public zzdkt(zzfai zzfai, Executor executor, zzdni zzdni, Context context, zzdqa zzdqa, zzfev zzfev, zzfgr zzfgr, zzeba zzeba, zzdmd zzdmd) {
        this.zza = zzfai;
        this.zzb = executor;
        this.zzc = zzdni;
        this.zze = context;
        this.zzf = zzdqa;
        this.zzg = zzfev;
        this.zzh = zzfgr;
        this.zzi = zzeba;
        this.zzd = zzdmd;
    }

    private final void zzh(zzcez zzcez) {
        zzi(zzcez);
        zzcez.zzad("/video", zzbii.zzl);
        zzcez.zzad("/videoMeta", zzbii.zzm);
        zzcez.zzad("/precache", new zzcdm());
        zzcez.zzad("/delayPageLoaded", zzbii.zzp);
        zzcez.zzad("/instrument", zzbii.zzn);
        zzcez.zzad("/log", zzbii.zzg);
        zzcez.zzad("/click", new zzbhk((zzdcu) null));
        if (this.zza.zzb != null) {
            zzcez.zzN().zzD(true);
            zzcez.zzad("/open", new zzbit((zzb) null, (zzbqq) null, (zzeba) null, (zzdqa) null, (zzfev) null));
        } else {
            zzcez.zzN().zzD(false);
        }
        if (zzt.zzn().zzu(zzcez.getContext())) {
            zzcez.zzad("/logScionEvent", new zzbio(zzcez.getContext()));
        }
    }

    private static final void zzi(zzcez zzcez) {
        zzcez.zzad("/videoClicked", zzbii.zzh);
        zzcez.zzN().zzF(true);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdw)).booleanValue()) {
            zzcez.zzad("/getNativeAdViewSignals", zzbii.zzs);
        }
        zzcez.zzad("/getNativeClickMeta", zzbii.zzt);
    }

    public final zzfwm zza(JSONObject jSONObject) {
        return zzfwc.zzm(zzfwc.zzm(zzfwc.zzh((Object) null), new zzdkj(this), this.zzb), new zzdkk(this, jSONObject), this.zzb);
    }

    public final zzfwm zzb(String str, String str2, zzezn zzezn, zzezq zzezq, zzq zzq) {
        return zzfwc.zzm(zzfwc.zzh((Object) null), new zzdkm(this, zzq, zzezn, zzezq, str, str2), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(JSONObject jSONObject, zzcez zzcez) throws Exception {
        zzcai zza2 = zzcai.zza(zzcez);
        if (this.zza.zzb != null) {
            zzcez.zzag(zzcgo.zzd());
        } else {
            zzcez.zzag(zzcgo.zze());
        }
        zzcez.zzN().zzA(new zzdki(this, zzcez, zza2));
        zzcez.zzl("google.afma.nativeAds.renderVideo", jSONObject);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzd(zzq zzq, zzezn zzezn, zzezq zzezq, String str, String str2, Object obj) throws Exception {
        zzcez zza2 = this.zzc.zza(zzq, zzezn, zzezq);
        zzcai zza3 = zzcai.zza(zza2);
        if (this.zza.zzb != null) {
            zzh(zza2);
            zza2.zzag(zzcgo.zzd());
        } else {
            zzdma zzb2 = this.zzd.zzb();
            zzdma zzdma = zzb2;
            zzcgm zzN = zza2.zzN();
            zzb zzb3 = r3;
            zzb zzb4 = new zzb(this.zze, (zzbws) null, (zzbtk) null);
            zzN.zzM(zzb2, zzdma, zzb2, zzb2, zzb2, false, (zzbil) null, zzb3, (zzbqx) null, (zzbws) null, this.zzi, this.zzh, this.zzf, this.zzg, (zzbjb) null, zzb2, (zzbja) null, (zzbiu) null);
            zzi(zza2);
        }
        zza2.zzN().zzA(new zzdkn(this, zza2, zza3));
        zza2.zzab(str, str2, (String) null);
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zze(Object obj) throws Exception {
        zzcez zza2 = this.zzc.zza(zzq.zzc(), (zzezn) null, (zzezq) null);
        zzcai zza3 = zzcai.zza(zza2);
        zzh(zza2);
        zza2.zzN().zzG(new zzdkl(zza3));
        zza2.loadUrl((String) zzba.zzc().zzb(zzbbm.zzdv));
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzcez zzcez, zzcai zzcai, boolean z2) {
        if (!(this.zza.zza == null || zzcez.zzq() == null)) {
            zzcez.zzq().zzs(this.zza.zza);
        }
        zzcai.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzcez zzcez, zzcai zzcai, boolean z2) {
        if (z2) {
            if (!(this.zza.zza == null || zzcez.zzq() == null)) {
                zzcez.zzq().zzs(this.zza.zza);
            }
            zzcai.zzb();
            return;
        }
        zzcai.zze(new zzefu(1, "Html video Web View failed to load."));
    }
}
