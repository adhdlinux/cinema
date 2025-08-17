package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.vungle.ads.internal.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class zzffy implements Runnable {
    private final List zza = new ArrayList();
    private final zzfgb zzb;
    private String zzc;
    private String zzd;
    private zzezy zze;
    private zze zzf;
    private Future zzg;
    private int zzh = 2;

    zzffy(zzfgb zzfgb) {
        this.zzb = zzfgb;
    }

    public final synchronized void run() {
        zzg();
    }

    public final synchronized zzffy zza(zzffn zzffn) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            List list = this.zza;
            zzffn.zzi();
            list.add(zzffn);
            Future future = this.zzg;
            if (future != null) {
                future.cancel(false);
            }
            this.zzg = zzcae.zzd.schedule(this, (long) ((Integer) zzba.zzc().zzb(zzbbm.zzin)).intValue(), TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public final synchronized zzffy zzb(String str) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue() && zzffx.zze(str)) {
            this.zzc = str;
        }
        return this;
    }

    public final synchronized zzffy zzc(zze zze2) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            this.zzf = zze2;
        }
        return this;
    }

    public final synchronized zzffy zzd(ArrayList arrayList) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            if (!arrayList.contains("banner")) {
                if (!arrayList.contains(AdFormat.BANNER.name())) {
                    if (!arrayList.contains(Constants.PLACEMENT_TYPE_INTERSTITIAL)) {
                        if (!arrayList.contains(AdFormat.INTERSTITIAL.name())) {
                            if (!arrayList.contains("native")) {
                                if (!arrayList.contains(AdFormat.NATIVE.name())) {
                                    if (!arrayList.contains(Constants.PLACEMENT_TYPE_REWARDED)) {
                                        if (!arrayList.contains(AdFormat.REWARDED.name())) {
                                            if (arrayList.contains("app_open_ad")) {
                                                this.zzh = 7;
                                            } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains(AdFormat.REWARDED_INTERSTITIAL.name())) {
                                                this.zzh = 6;
                                            }
                                        }
                                    }
                                    this.zzh = 5;
                                }
                            }
                            this.zzh = 8;
                        }
                    }
                    this.zzh = 4;
                }
            }
            this.zzh = 3;
        }
        return this;
    }

    public final synchronized zzffy zze(String str) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            this.zzd = str;
        }
        return this;
    }

    public final synchronized zzffy zzf(zzezy zzezy) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            this.zze = zzezy;
        }
        return this;
    }

    public final synchronized void zzg() {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            Future future = this.zzg;
            if (future != null) {
                future.cancel(false);
            }
            for (zzffn zzffn : this.zza) {
                int i2 = this.zzh;
                if (i2 != 2) {
                    zzffn.zzm(i2);
                }
                if (!TextUtils.isEmpty(this.zzc)) {
                    zzffn.zze(this.zzc);
                }
                if (!TextUtils.isEmpty(this.zzd) && !zzffn.zzk()) {
                    zzffn.zzd(this.zzd);
                }
                zzezy zzezy = this.zze;
                if (zzezy != null) {
                    zzffn.zzb(zzezy);
                } else {
                    zze zze2 = this.zzf;
                    if (zze2 != null) {
                        zzffn.zza(zze2);
                    }
                }
                this.zzb.zzb(zzffn.zzl());
            }
            this.zza.clear();
        }
    }

    public final synchronized zzffy zzh(int i2) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            this.zzh = i2;
        }
        return this;
    }
}
