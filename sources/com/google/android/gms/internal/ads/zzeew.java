package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzeew implements zzeeq {
    private final zzdfk zza;
    private final zzfwn zzb;
    private final zzdjo zzc;
    private final zzfbe zzd;
    private final zzdmd zze;

    public zzeew(zzdfk zzdfk, zzfwn zzfwn, zzdjo zzdjo, zzfbe zzfbe, zzdmd zzdmd) {
        this.zza = zzdfk;
        this.zzb = zzfwn;
        this.zzc = zzdjo;
        this.zzd = zzfbe;
        this.zze = zzdmd;
    }

    private final zzfwm zzg(zzezz zzezz, zzezn zzezn, JSONObject jSONObject) {
        zzfwm zza2 = this.zzd.zza();
        zzfwm zza3 = this.zzc.zza(zzezz, zzezn, jSONObject);
        return zzfwc.zzc(zza2, zza3).zza(new zzeer(this, zza3, zza2, zzezz, zzezn, jSONObject), this.zzb);
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn) {
        return zzfwc.zzm(zzfwc.zzm(this.zzd.zza(), new zzeet(this, zzezn), this.zzb), new zzeeu(this, zzezz, zzezn), this.zzb);
    }

    public final boolean zzb(zzezz zzezz, zzezn zzezn) {
        zzezs zzezs = zzezn.zzt;
        return (zzezs == null || zzezs.zzc == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdgv zzc(zzfwm zzfwm, zzfwm zzfwm2, zzezz zzezz, zzezn zzezn, JSONObject jSONObject) throws Exception {
        zzdha zzdha = (zzdha) zzfwm.get();
        zzdlx zzdlx = (zzdlx) zzfwm2.get();
        zzdhb zzd2 = this.zza.zzd(new zzcrs(zzezz, zzezn, (String) null), new zzdhm(zzdha), new zzdfz(jSONObject, zzdlx));
        zzd2.zzh().zzb();
        zzd2.zzk().zza(zzdlx);
        zzd2.zzg().zza(zzdha.zzr());
        zzd2.zzl().zza(this.zze);
        return zzd2.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzd(zzdlx zzdlx, JSONObject jSONObject) throws Exception {
        this.zzd.zzb(zzfwc.zzh(zzdlx));
        if (jSONObject.optBoolean("success")) {
            return zzfwc.zzh(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzbmo("process json failed");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zze(zzezn zzezn, zzdlx zzdlx) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzid)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzezn.zzt.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzfwc.zzm(zzdlx.zzd("google.afma.nativeAds.preProcessJson", jSONObject2), new zzees(this, zzdlx), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzf(zzezz zzezz, zzezn zzezn, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzfwc.zzg(new zzdtx(3));
        }
        if (zzezz.zza.zza.zzk <= 1) {
            return zzfwc.zzl(zzg(zzezz, zzezn, jSONArray.getJSONObject(0)), zzeev.zza, this.zzb);
        }
        int length = jSONArray.length();
        this.zzd.zzc(Math.min(length, zzezz.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzezz.zza.zza.zzk);
        for (int i2 = 0; i2 < zzezz.zza.zza.zzk; i2++) {
            if (i2 < length) {
                arrayList.add(zzg(zzezz, zzezn, jSONArray.getJSONObject(i2)));
            } else {
                arrayList.add(zzfwc.zzg(new zzdtx(3)));
            }
        }
        return zzfwc.zzh(arrayList);
    }
}
