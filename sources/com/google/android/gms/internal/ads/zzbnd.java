package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import org.json.JSONObject;

public final class zzbnd implements zzbmp {
    /* access modifiers changed from: private */
    public final zzbmr zza;
    private final zzbms zzb;
    private final zzbml zzc;
    private final String zzd;

    zzbnd(zzbml zzbml, String str, zzbms zzbms, zzbmr zzbmr) {
        this.zzc = zzbml;
        this.zzd = str;
        this.zzb = zzbms;
        this.zza = zzbmr;
    }

    static /* bridge */ /* synthetic */ void zzd(zzbnd zzbnd, zzbmf zzbmf, zzbmm zzbmm, Object obj, zzcaj zzcaj) {
        try {
            zzt.zzp();
            String uuid = UUID.randomUUID().toString();
            zzbii.zzo.zzc(uuid, new zzbnc(zzbnd, zzbmf, zzcaj));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", uuid);
            jSONObject.put("args", zzbnd.zzb.zzb(obj));
            zzbmm.zzl(zzbnd.zzd, jSONObject);
        } catch (Exception e2) {
            zzcaj.zze(e2);
            zzbzr.zzh("Unable to invokeJavascript", e2);
            zzbmf.zzb();
        } catch (Throwable th) {
            zzbmf.zzb();
            throw th;
        }
    }

    public final zzfwm zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final zzfwm zzb(Object obj) {
        zzcaj zzcaj = new zzcaj();
        zzbmf zzb2 = this.zzc.zzb((zzaqs) null);
        zzb2.zzi(new zzbna(this, zzb2, obj, zzcaj), new zzbnb(this, zzcaj, zzb2));
        return zzcaj;
    }
}
