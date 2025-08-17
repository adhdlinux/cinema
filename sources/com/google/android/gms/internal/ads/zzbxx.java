package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class zzbxx {
    static zzbxx zza;

    public static synchronized zzbxx zzd(Context context) {
        synchronized (zzbxx.class) {
            zzbxx zzbxx = zza;
            if (zzbxx != null) {
                return zzbxx;
            }
            Context applicationContext = context.getApplicationContext();
            zzbbm.zza(applicationContext);
            zzg zzh = zzt.zzo().zzh();
            zzh.zzr(applicationContext);
            zzbxb zzbxb = new zzbxb((zzbxa) null);
            zzbxb.zzb(applicationContext);
            zzbxb.zzc(zzt.zzB());
            zzbxb.zza(zzh);
            zzbxb.zzd(zzt.zzn());
            zzbxx zze = zzbxb.zze();
            zza = zze;
            zze.zza().zza();
            zza.zzb().zzc();
            zzbyb zzc = zza.zzc();
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzar)).booleanValue()) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject((String) zzba.zzc().zzb(zzbbm.zzat));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        HashSet hashSet = new HashSet();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                String optString = optJSONArray.optString(i2);
                                if (optString != null) {
                                    hashSet.add(optString);
                                }
                            }
                            hashMap.put(next, hashSet);
                        }
                    }
                    for (String zzc2 : hashMap.keySet()) {
                        zzc.zzc(zzc2);
                    }
                    zzc.zzd(new zzbxz(zzc, hashMap));
                } catch (JSONException e2) {
                    zzbzr.zzf("Failed to parse listening list", e2);
                }
            }
            zzbxx zzbxx2 = zza;
            return zzbxx2;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract zzbwu zza();

    /* access modifiers changed from: package-private */
    public abstract zzbwy zzb();

    /* access modifiers changed from: package-private */
    public abstract zzbyb zzc();
}
