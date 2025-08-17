package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class zzdpv {
    private final ConcurrentHashMap zza;
    private final zzbze zzb;
    private final zzfai zzc;
    private final String zzd;
    private final String zze;

    public zzdpv(zzdqf zzdqf, zzbze zzbze, zzfai zzfai, String str, String str2) {
        ConcurrentHashMap zzc2 = zzdqf.zzc();
        this.zza = zzc2;
        this.zzb = zzbze;
        this.zzc = zzfai;
        this.zzd = str;
        this.zze = str2;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgN)).booleanValue()) {
            int zze2 = zzf.zze(zzfai);
            int i2 = zze2 - 1;
            if (i2 != 0) {
                if (i2 == 1) {
                    zzc2.put("se", "query_g");
                } else if (i2 == 2) {
                    zzc2.put("se", "r_adinfo");
                } else if (i2 != 3) {
                    zzc2.put("se", "r_both");
                } else {
                    zzc2.put("se", "r_adstring");
                }
                zzc2.put("scar", "true");
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzhm)).booleanValue()) {
                    zzc2.put("ad_format", str2);
                }
                if (zze2 == 2) {
                    zzc2.put("rid", str);
                }
                zzd("ragent", zzfai.zzd.zzp);
                zzd("rtype", zzf.zza(zzf.zzb(zzfai.zzd)));
                return;
            }
            zzc2.put("scar", Constants.CASEFIRST_FALSE);
        }
    }

    private final void zzd(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.zza.put(str, str2);
        }
    }

    public final Map zza() {
        return this.zza;
    }

    public final void zzb(zzezz zzezz) {
        String str;
        if (!zzezz.zzb.zza.isEmpty()) {
            switch (((zzezn) zzezz.zzb.zza.get(0)).zzb) {
                case 1:
                    this.zza.put("ad_format", "banner");
                    break;
                case 2:
                    this.zza.put("ad_format", com.vungle.ads.internal.Constants.PLACEMENT_TYPE_INTERSTITIAL);
                    break;
                case 3:
                    this.zza.put("ad_format", "native_express");
                    break;
                case 4:
                    this.zza.put("ad_format", "native_advanced");
                    break;
                case 5:
                    this.zza.put("ad_format", com.vungle.ads.internal.Constants.PLACEMENT_TYPE_REWARDED);
                    break;
                case 6:
                    this.zza.put("ad_format", "app_open_ad");
                    ConcurrentHashMap concurrentHashMap = this.zza;
                    if (true != this.zzb.zzk()) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    concurrentHashMap.put("as", str);
                    break;
                default:
                    this.zza.put("ad_format", "unknown");
                    break;
            }
        }
        zzd("gqi", zzezz.zzb.zzb.zzb);
    }

    public final void zzc(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }
}
