package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdsl implements zzcvj, zzcyb, zzcwy {
    private final zzdsx zza;
    private final String zzb;
    private final String zzc;
    private int zzd = 0;
    private zzdsk zze = zzdsk.AD_REQUESTED;
    private zzcuz zzf;
    private zze zzg;
    private String zzh;
    private String zzi;
    private boolean zzj;
    private boolean zzk;

    zzdsl(zzdsx zzdsx, zzfai zzfai, String str) {
        this.zza = zzdsx;
        this.zzc = str;
        this.zzb = zzfai.zzf;
    }

    private static JSONObject zzh(zze zze2) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("errorDomain", zze2.zzc);
        jSONObject2.put("errorCode", zze2.zza);
        jSONObject2.put("errorDescription", zze2.zzb);
        zze zze3 = zze2.zzd;
        if (zze3 == null) {
            jSONObject = null;
        } else {
            jSONObject = zzh(zze3);
        }
        jSONObject2.put("underlyingError", jSONObject);
        return jSONObject2;
    }

    private final JSONObject zzi(zzcuz zzcuz) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("winningAdapterClassName", zzcuz.zzg());
        jSONObject2.put("responseSecsSinceEpoch", zzcuz.zzc());
        jSONObject2.put("responseId", zzcuz.zzi());
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziL)).booleanValue()) {
            String zzd2 = zzcuz.zzd();
            if (!TextUtils.isEmpty(zzd2)) {
                zzbzr.zze("Bidding data: ".concat(String.valueOf(zzd2)));
                jSONObject2.put("biddingData", new JSONObject(zzd2));
            }
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            jSONObject2.put("adRequestUrl", this.zzh);
        }
        if (!TextUtils.isEmpty(this.zzi)) {
            jSONObject2.put("postBody", this.zzi);
        }
        JSONArray jSONArray = new JSONArray();
        for (zzu zzu : zzcuz.zzj()) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("adapterClassName", zzu.zza);
            jSONObject3.put("latencyMillis", zzu.zzb);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zziM)).booleanValue()) {
                jSONObject3.put("credentials", zzay.zzb().zzh(zzu.zzd));
            }
            zze zze2 = zzu.zzc;
            if (zze2 == null) {
                jSONObject = null;
            } else {
                jSONObject = zzh(zze2);
            }
            jSONObject3.put(MRAIDPresenter.ERROR, jSONObject);
            jSONArray.put(jSONObject3);
        }
        jSONObject2.put("adNetworks", jSONArray);
        return jSONObject2;
    }

    public final void zza(zze zze2) {
        this.zze = zzdsk.AD_LOAD_FAILED;
        this.zzg = zze2;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziQ)).booleanValue()) {
            this.zza.zzf(this.zzb, this);
        }
    }

    public final void zzb(zzezz zzezz) {
        if (!zzezz.zzb.zza.isEmpty()) {
            this.zzd = ((zzezn) zzezz.zzb.zza.get(0)).zzb;
        }
        if (!TextUtils.isEmpty(zzezz.zzb.zzb.zzk)) {
            this.zzh = zzezz.zzb.zzb.zzk;
        }
        if (!TextUtils.isEmpty(zzezz.zzb.zzb.zzl)) {
            this.zzi = zzezz.zzb.zzb.zzl;
        }
    }

    public final void zzbA(zzbue zzbue) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zziQ)).booleanValue()) {
            this.zza.zzf(this.zzb, this);
        }
    }

    public final void zzbD(zzcrd zzcrd) {
        this.zzf = zzcrd.zzl();
        this.zze = zzdsk.AD_LOADED;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziQ)).booleanValue()) {
            this.zza.zzf(this.zzb, this);
        }
    }

    public final String zzc() {
        return this.zzc;
    }

    public final JSONObject zzd() throws JSONException {
        JSONObject jSONObject;
        IBinder iBinder;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(AdOperationMetric.INIT_STATE, this.zze);
        jSONObject2.put("format", zzezn.zza(this.zzd));
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziQ)).booleanValue()) {
            jSONObject2.put("isOutOfContext", this.zzj);
            if (this.zzj) {
                jSONObject2.put("shown", this.zzk);
            }
        }
        zzcuz zzcuz = this.zzf;
        if (zzcuz != null) {
            jSONObject = zzi(zzcuz);
        } else {
            zze zze2 = this.zzg;
            JSONObject jSONObject3 = null;
            if (!(zze2 == null || (iBinder = zze2.zze) == null)) {
                zzcuz zzcuz2 = (zzcuz) iBinder;
                jSONObject3 = zzi(zzcuz2);
                if (zzcuz2.zzj().isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(zzh(this.zzg));
                    jSONObject3.put("errors", jSONArray);
                }
            }
            jSONObject = jSONObject3;
        }
        jSONObject2.put("responseInfo", jSONObject);
        return jSONObject2;
    }

    public final void zze() {
        this.zzj = true;
    }

    public final void zzf() {
        this.zzk = true;
    }

    public final boolean zzg() {
        return this.zze != zzdsk.AD_REQUESTED;
    }
}
