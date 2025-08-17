package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import org.json.JSONObject;

public final class zzbnl implements zzfvj {
    private final zzbmr zza;
    private final zzbms zzb;
    private final String zzc = "google.afma.activeView.handleUpdate";
    private final zzfwm zzd;

    zzbnl(zzfwm zzfwm, String str, zzbms zzbms, zzbmr zzbmr) {
        this.zzd = zzfwm;
        this.zzb = zzbms;
        this.zza = zzbmr;
    }

    public final zzfwm zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final zzfwm zzb(Object obj) {
        return zzfwc.zzm(this.zzd, new zzbnj(this, obj), zzcae.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(Object obj, zzbmm zzbmm) throws Exception {
        zzcaj zzcaj = new zzcaj();
        zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        zzbii.zzo.zzc(uuid, new zzbnk(this, zzcaj));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", uuid);
        jSONObject.put("args", (JSONObject) obj);
        zzbmm.zzl(this.zzc, jSONObject);
        return zzcaj;
    }
}
