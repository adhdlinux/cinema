package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import org.json.JSONObject;

public final class zzdyh extends zzbtp {
    private final Context zza;
    private final zzfwn zzb;
    private final zzdyz zzc;
    private final zzcmg zzd;
    private final ArrayDeque zze;
    private final zzfgb zzf;
    private final zzbuq zzg;
    private final zzdyw zzh;

    public zzdyh(Context context, zzfwn zzfwn, zzbuq zzbuq, zzcmg zzcmg, zzdyz zzdyz, ArrayDeque arrayDeque, zzdyw zzdyw, zzfgb zzfgb) {
        zzbbm.zza(context);
        this.zza = context;
        this.zzb = zzfwn;
        this.zzg = zzbuq;
        this.zzc = zzdyz;
        this.zzd = zzcmg;
        this.zze = arrayDeque;
        this.zzh = zzdyw;
        this.zzf = zzfgb;
    }

    private final synchronized zzdye zzk(String str) {
        Iterator it2 = this.zze.iterator();
        while (it2.hasNext()) {
            zzdye zzdye = (zzdye) it2.next();
            if (zzdye.zzc.equals(str)) {
                it2.remove();
                return zzdye;
            }
        }
        return null;
    }

    private static zzfwm zzl(zzfwm zzfwm, zzfel zzfel, zzbmz zzbmz, zzffy zzffy, zzffn zzffn) {
        zzbmp zza2 = zzbmz.zza("AFMA_getAdDictionary", zzbmw.zza, zzdxy.zza);
        zzffx.zzd(zzfwm, zzffn);
        zzfdq zza3 = zzfel.zzb(zzfef.BUILD_URL, zzfwm).zzf(zza2).zza();
        zzffx.zzc(zza3, zzffy, zzffn);
        return zza3;
    }

    private static zzfwm zzm(zzbue zzbue, zzfel zzfel, zzerq zzerq) {
        zzdxs zzdxs = new zzdxs(zzerq);
        return zzfel.zzb(zzfef.GMS_SIGNALS, zzfwc.zzh(zzbue.zza)).zzf(zzdxs).zze(zzdxt.zza).zza();
    }

    private final synchronized void zzn(zzdye zzdye) {
        zzo();
        this.zze.addLast(zzdye);
    }

    private final synchronized void zzo() {
        int intValue = ((Long) zzbdl.zzc.zze()).intValue();
        while (this.zze.size() >= intValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzp(zzfwm zzfwm, zzbua zzbua) {
        zzfwc.zzq(zzfwc.zzm(zzfwm, new zzdyb(this), zzcae.zza), new zzdyd(this, zzbua), zzcae.zzf);
    }

    public final zzfwm zzb(zzbue zzbue, int i2) {
        if (!((Boolean) zzbdl.zza.zze()).booleanValue()) {
            return zzfwc.zzg(new Exception("Split request is disabled."));
        }
        zzfcb zzfcb = zzbue.zzi;
        if (zzfcb == null) {
            return zzfwc.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfcb.zzc == 0 || zzfcb.zzd == 0) {
            return zzfwc.zzg(new Exception("Caching is disabled."));
        }
        zzbmz zzb2 = zzt.zzf().zzb(this.zza, zzbzx.zza(), this.zzf);
        zzerq zzp = this.zzd.zzp(zzbue, i2);
        zzfel zzc2 = zzp.zzc();
        zzfwm zzm = zzm(zzbue, zzc2, zzp);
        zzffy zzd2 = zzp.zzd();
        zzffn zza2 = zzffm.zza(this.zza, 9);
        zzfwm zzl = zzl(zzm, zzc2, zzb2, zzd2, zza2);
        return zzc2.zza(zzfef.GET_URL_AND_CACHE_KEY, zzm, zzl).zza(new zzdxx(this, zzl, zzm, zzbue, zza2)).zza();
    }

    public final zzfwm zzc(zzbue zzbue, int i2) {
        zzdye zzdye;
        zzffn zzffn;
        zzfdq zzfdq;
        zzbmz zzb2 = zzt.zzf().zzb(this.zza, zzbzx.zza(), this.zzf);
        zzerq zzp = this.zzd.zzp(zzbue, i2);
        zzbmp zza2 = zzb2.zza("google.afma.response.normalize", zzdyg.zza, zzbmw.zzb);
        if (!((Boolean) zzbdl.zza.zze()).booleanValue()) {
            String str = zzbue.zzj;
            zzdye = null;
            if (str != null && !str.isEmpty()) {
                zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            zzdye = zzk(zzbue.zzh);
            if (zzdye == null) {
                zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        }
        if (zzdye == null) {
            zzffn = zzffm.zza(this.zza, 9);
        } else {
            zzffn = zzdye.zze;
        }
        zzffy zzd2 = zzp.zzd();
        zzd2.zzd(zzbue.zza.getStringArrayList("ad_types"));
        zzdyy zzdyy = new zzdyy(zzbue.zzg, zzd2, zzffn);
        zzdyv zzdyv = new zzdyv(this.zza, zzbue.zzb.zza, this.zzg, i2);
        zzfel zzc2 = zzp.zzc();
        zzffn zza3 = zzffm.zza(this.zza, 11);
        if (zzdye == null) {
            zzfwm zzm = zzm(zzbue, zzc2, zzp);
            zzfwm zzl = zzl(zzm, zzc2, zzb2, zzd2, zzffn);
            zzffn zza4 = zzffm.zza(this.zza, 10);
            zzfdq zza5 = zzc2.zza(zzfef.HTTP, zzl, zzm).zza(new zzdxv(zzm, zzl)).zze(zzdyy).zze(new zzfft(zza4)).zze(zzdyv).zza();
            zzffx.zza(zza5, zzd2, zza4);
            zzffx.zzd(zza5, zza3);
            zzfdq = zzc2.zza(zzfef.PRE_PROCESS, zzm, zzl, zza5).zza(new zzdxw(zza5, zzm, zzl)).zzf(zza2).zza();
        } else {
            zzdyx zzdyx = new zzdyx(zzdye.zzb, zzdye.zza);
            zzffn zza6 = zzffm.zza(this.zza, 10);
            zzfdq zza7 = zzc2.zzb(zzfef.HTTP, zzfwc.zzh(zzdyx)).zze(zzdyy).zze(new zzfft(zza6)).zze(zzdyv).zza();
            zzffx.zza(zza7, zzd2, zza6);
            zzfwm zzh2 = zzfwc.zzh(zzdye);
            zzffx.zzd(zza7, zza3);
            zzfdq = zzc2.zza(zzfef.PRE_PROCESS, zza7, zzh2).zza(new zzdya(zza7, zzh2)).zzf(zza2).zza();
        }
        zzffx.zza(zzfdq, zzd2, zza3);
        return zzfdq;
    }

    public final zzfwm zzd(zzbue zzbue, int i2) {
        zzbmz zzb2 = zzt.zzf().zzb(this.zza, zzbzx.zza(), this.zzf);
        if (!((Boolean) zzbdq.zza.zze()).booleanValue()) {
            return zzfwc.zzg(new Exception("Signal collection disabled."));
        }
        zzerq zzp = this.zzd.zzp(zzbue, i2);
        zzerb zza2 = zzp.zza();
        zzbmp zza3 = zzb2.zza("google.afma.request.getSignals", zzbmw.zza, zzbmw.zzb);
        zzffn zza4 = zzffm.zza(this.zza, 22);
        zzfdq zza5 = zzp.zzc().zzb(zzfef.GET_SIGNALS, zzfwc.zzh(zzbue.zza)).zze(new zzfft(zza4)).zzf(new zzdxz(zza2)).zzb(zzfef.JS_SIGNALS).zzf(zza3).zza();
        zzffy zzd2 = zzp.zzd();
        zzd2.zzd(zzbue.zza.getStringArrayList("ad_types"));
        zzffx.zzb(zza5, zzd2, zza4);
        if (((Boolean) zzbdf.zze.zze()).booleanValue()) {
            zzdyz zzdyz = this.zzc;
            zzdyz.getClass();
            zza5.zzc(new zzdxu(zzdyz), this.zzb);
        }
        return zza5;
    }

    public final void zze(zzbue zzbue, zzbua zzbua) {
        zzp(zzb(zzbue, Binder.getCallingUid()), zzbua);
    }

    public final void zzf(zzbue zzbue, zzbua zzbua) {
        zzp(zzd(zzbue, Binder.getCallingUid()), zzbua);
    }

    public final void zzg(zzbue zzbue, zzbua zzbua) {
        zzfwm zzc2 = zzc(zzbue, Binder.getCallingUid());
        zzp(zzc2, zzbua);
        if (((Boolean) zzbdf.zzc.zze()).booleanValue()) {
            zzdyz zzdyz = this.zzc;
            zzdyz.getClass();
            zzc2.zzc(new zzdxu(zzdyz), this.zzb);
        }
    }

    public final void zzh(String str, zzbua zzbua) {
        zzp(zzi(str), zzbua);
    }

    public final zzfwm zzi(String str) {
        if (!((Boolean) zzbdl.zza.zze()).booleanValue()) {
            return zzfwc.zzg(new Exception("Split request is disabled."));
        }
        zzdyc zzdyc = new zzdyc(this);
        if (zzk(str) == null) {
            return zzfwc.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str))));
        }
        return zzfwc.zzh(zzdyc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzj(zzfwm zzfwm, zzfwm zzfwm2, zzbue zzbue, zzffn zzffn) throws Exception {
        String zzc2 = ((zzbuh) zzfwm.get()).zzc();
        String str = zzbue.zzh;
        zzn(new zzdye((zzbuh) zzfwm.get(), (JSONObject) zzfwm2.get(), str, zzc2, zzffn));
        return new ByteArrayInputStream(zzc2.getBytes(zzfot.zzc));
    }
}
