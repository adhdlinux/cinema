package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzero implements zzeqx {
    private final AdvertisingIdClient.Info zza;
    private final String zzb;
    private final zzfme zzc;

    public zzero(AdvertisingIdClient.Info info, String str, zzfme zzfme) {
        this.zza = info;
        this.zzb = str;
        this.zzc = zzfme;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        try {
            JSONObject zzf = zzbu.zzf((JSONObject) obj, "pii");
            AdvertisingIdClient.Info info = this.zza;
            if (info == null || TextUtils.isEmpty(info.getId())) {
                String str = this.zzb;
                if (str != null) {
                    zzf.put("pdid", str);
                    zzf.put("pdidtype", "ssaid");
                    return;
                }
                return;
            }
            zzf.put("rdid", this.zza.getId());
            zzf.put("is_lat", this.zza.isLimitAdTrackingEnabled());
            zzf.put("idtype", "adid");
            zzfme zzfme = this.zzc;
            if (zzfme.zzc()) {
                zzf.put("paidv1_id_android_3p", zzfme.zzb());
                zzf.put("paidv1_creation_time_android_3p", this.zzc.zza());
            }
        } catch (JSONException e2) {
            zze.zzb("Failed putting Ad ID.", e2);
        }
    }
}
