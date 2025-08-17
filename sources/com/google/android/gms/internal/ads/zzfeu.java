package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.vungle.ads.internal.Constants;
import java.util.HashMap;
import java.util.Map;

public final class zzfeu {
    private final HashMap zza;
    private final zzffa zzb = new zzffa(zzt.zzB());

    private zzfeu() {
        HashMap hashMap = new HashMap();
        this.zza = hashMap;
        hashMap.put("new_csi", "1");
    }

    public static zzfeu zzb(String str) {
        zzfeu zzfeu = new zzfeu();
        zzfeu.zza.put("action", str);
        return zzfeu;
    }

    public static zzfeu zzc(String str) {
        zzfeu zzfeu = new zzfeu();
        zzfeu.zza.put("request_id", str);
        return zzfeu;
    }

    public final zzfeu zza(String str, String str2) {
        this.zza.put(str, str2);
        return this;
    }

    public final zzfeu zzd(String str) {
        this.zzb.zzb(str);
        return this;
    }

    public final zzfeu zze(String str, String str2) {
        this.zzb.zzc(str, str2);
        return this;
    }

    public final zzfeu zzf(zzezn zzezn) {
        this.zza.put("aai", zzezn.zzx);
        return this;
    }

    public final zzfeu zzg(zzezq zzezq) {
        if (!TextUtils.isEmpty(zzezq.zzb)) {
            this.zza.put("gqi", zzezq.zzb);
        }
        return this;
    }

    public final zzfeu zzh(zzezz zzezz, zzbze zzbze) {
        String str;
        zzezy zzezy = zzezz.zzb;
        zzg(zzezy.zzb);
        if (!zzezy.zza.isEmpty()) {
            switch (((zzezn) zzezy.zza.get(0)).zzb) {
                case 1:
                    this.zza.put("ad_format", "banner");
                    break;
                case 2:
                    this.zza.put("ad_format", Constants.PLACEMENT_TYPE_INTERSTITIAL);
                    break;
                case 3:
                    this.zza.put("ad_format", "native_express");
                    break;
                case 4:
                    this.zza.put("ad_format", "native_advanced");
                    break;
                case 5:
                    this.zza.put("ad_format", Constants.PLACEMENT_TYPE_REWARDED);
                    break;
                case 6:
                    this.zza.put("ad_format", "app_open_ad");
                    if (zzbze != null) {
                        HashMap hashMap = this.zza;
                        if (true != zzbze.zzk()) {
                            str = "0";
                        } else {
                            str = "1";
                        }
                        hashMap.put("as", str);
                        break;
                    }
                    break;
                default:
                    this.zza.put("ad_format", "unknown");
                    break;
            }
        }
        return this;
    }

    public final zzfeu zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
        return this;
    }

    public final Map zzj() {
        HashMap hashMap = new HashMap(this.zza);
        for (zzfez zzfez : this.zzb.zza()) {
            hashMap.put(zzfez.zza, zzfez.zzb);
        }
        return hashMap;
    }
}
