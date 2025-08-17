package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbcy;
import com.google.android.gms.internal.ads.zzbyf;
import com.google.android.gms.internal.ads.zzbym;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzdpv;
import com.google.android.gms.internal.ads.zzdqf;
import com.google.android.gms.internal.ads.zzffn;
import com.google.android.gms.internal.ads.zzffy;
import com.google.android.gms.internal.ads.zzfvy;
import com.google.android.gms.internal.ads.zzfwm;
import org.json.JSONException;
import org.json.JSONObject;

final class zzw implements zzfvy {
    final /* synthetic */ zzfwm zza;
    final /* synthetic */ zzbym zzb;
    final /* synthetic */ zzbyf zzc;
    final /* synthetic */ zzffn zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzaa zzf;

    zzw(zzaa zzaa, zzfwm zzfwm, zzbym zzbym, zzbyf zzbyf, zzffn zzffn, long j2) {
        this.zzf = zzaa;
        this.zza = zzfwm;
        this.zzb = zzbym;
        this.zzc = zzbyf;
        this.zzd = zzffn;
        this.zze = j2;
    }

    public final void zza(Throwable th) {
        long currentTimeMillis = zzt.zzB().currentTimeMillis() - this.zze;
        String message = th.getMessage();
        zzt.zzo().zzu(th, "SignalGeneratorImpl.generateSignals");
        zzaa zzaa = this.zzf;
        zzf.zzc(zzaa.zzr, zzaa.zzj, "sgf", new Pair("sgf_reason", message), new Pair("tqgt", String.valueOf(currentTimeMillis)));
        zzffy zzr = zzaa.zzr(this.zza, this.zzb);
        if (((Boolean) zzbcy.zze.zze()).booleanValue() && zzr != null) {
            zzffn zzffn = this.zzd;
            zzffn.zzg(th);
            zzffn.zzf(false);
            zzr.zza(zzffn);
            zzr.zzg();
        }
        try {
            zzbyf zzbyf = this.zzc;
            zzbyf.zzb("Internal error. " + message);
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzam zzam = (zzam) obj;
        zzffy zzr = zzaa.zzr(this.zza, this.zzb);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzho)).booleanValue()) {
            try {
                this.zzc.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e2) {
                zzbzr.zzg("QueryInfo generation has been disabled.".concat(e2.toString()));
            }
            if (((Boolean) zzbcy.zze.zze()).booleanValue() && zzr != null) {
                zzffn zzffn = this.zzd;
                zzffn.zzc("QueryInfo generation has been disabled.");
                zzffn.zzf(false);
                zzr.zza(zzffn);
                zzr.zzg();
                return;
            }
            return;
        }
        long currentTimeMillis = zzt.zzB().currentTimeMillis() - this.zze;
        if (zzam == null) {
            try {
                this.zzc.zzc((String) null, (String) null, (Bundle) null);
                zzaa zzaa = this.zzf;
                zzf.zzc(zzaa.zzr, zzaa.zzj, "sgs", new Pair("rid", "-1"));
                this.zzd.zzf(true);
                if (((Boolean) zzbcy.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzg();
                }
            } catch (RemoteException e3) {
                zzffn zzffn2 = this.zzd;
                zzffn2.zzg(e3);
                zzffn2.zzf(false);
                zzbzr.zzh("", e3);
                zzt.zzo().zzu(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (((Boolean) zzbcy.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzg();
                }
            } catch (Throwable th) {
                if (((Boolean) zzbcy.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzg();
                }
                throw th;
            }
        } else {
            try {
                JSONObject jSONObject = new JSONObject(zzam.zzb);
                String optString = jSONObject.optString("request_id", "");
                if (TextUtils.isEmpty(optString)) {
                    zzbzr.zzj("The request ID is empty in request JSON.");
                    this.zzc.zzb("Internal error: request ID is empty in request JSON.");
                    zzaa zzaa2 = this.zzf;
                    zzf.zzc(zzaa2.zzr, zzaa2.zzj, "sgf", new Pair("sgf_reason", "rid_missing"));
                    zzffn zzffn3 = this.zzd;
                    zzffn3.zzc("Request ID empty");
                    zzffn3.zzf(false);
                    if (((Boolean) zzbcy.zze.zze()).booleanValue() && zzr != null) {
                        zzr.zza(this.zzd);
                        zzr.zzg();
                        return;
                    }
                    return;
                }
                zzaa zzaa3 = this.zzf;
                zzaa.zzG(zzaa3, optString, zzam.zzb, zzaa3.zzj);
                Bundle bundle = zzam.zzc;
                zzaa zzaa4 = this.zzf;
                if (zzaa4.zzw && bundle != null && bundle.getInt(zzaa4.zzy, -1) == -1) {
                    zzaa zzaa5 = this.zzf;
                    bundle.putInt(zzaa5.zzy, zzaa5.zzz.get());
                }
                zzaa zzaa6 = this.zzf;
                if (zzaa6.zzv && bundle != null && TextUtils.isEmpty(bundle.getString(zzaa6.zzx))) {
                    if (TextUtils.isEmpty(this.zzf.zzB)) {
                        zzaa zzaa7 = this.zzf;
                        zzs zzp = zzt.zzp();
                        zzaa zzaa8 = this.zzf;
                        zzaa7.zzB = zzp.zzc(zzaa8.zzg, zzaa8.zzA.zza);
                    }
                    zzaa zzaa9 = this.zzf;
                    bundle.putString(zzaa9.zzx, zzaa9.zzB);
                }
                this.zzc.zzc(zzam.zza, zzam.zzb, bundle);
                zzaa zzaa10 = this.zzf;
                zzdqf zzp2 = zzaa10.zzr;
                zzdpv zzo = zzaa10.zzj;
                Pair[] pairArr = new Pair[2];
                pairArr[0] = new Pair("tqgt", String.valueOf(currentTimeMillis));
                String str = "na";
                if (((Boolean) zzba.zzc().zzb(zzbbm.zziZ)).booleanValue()) {
                    try {
                        str = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? "1" : "0";
                    } catch (JSONException e4) {
                        zzbzr.zzh("Error retrieving JSONObject from the requestJson, ", e4);
                    }
                }
                pairArr[1] = new Pair("tpc", str);
                zzf.zzc(zzp2, zzo, "sgs", pairArr);
                this.zzd.zzf(true);
                if (((Boolean) zzbcy.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzg();
                }
            } catch (JSONException e5) {
                zzbzr.zzj("Failed to create JSON object from the request string.");
                zzbyf zzbyf = this.zzc;
                String obj2 = e5.toString();
                zzbyf.zzb("Internal error for request JSON: " + obj2);
                zzaa zzaa11 = this.zzf;
                zzf.zzc(zzaa11.zzr, zzaa11.zzj, "sgf", new Pair("sgf_reason", "request_invalid"));
                zzffn zzffn4 = this.zzd;
                zzffn4.zzg(e5);
                zzffn4.zzf(false);
                zzt.zzo().zzu(e5, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (((Boolean) zzbcy.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzg();
                }
            }
        }
    }
}
