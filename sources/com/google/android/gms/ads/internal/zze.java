package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbbe;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbmp;
import com.google.android.gms.internal.ads.zzbmt;
import com.google.android.gms.internal.ads.zzbmw;
import com.google.android.gms.internal.ads.zzbmz;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzcah;
import com.google.android.gms.internal.ads.zzffm;
import com.google.android.gms.internal.ads.zzffn;
import com.google.android.gms.internal.ads.zzfgb;
import com.google.android.gms.internal.ads.zzfwc;
import com.google.android.gms.internal.ads.zzfwm;
import com.google.android.gms.internal.ads.zzfwn;
import com.unity3d.ads.metadata.MediationMetaData;
import org.json.JSONObject;

public final class zze {
    private Context zza;
    private long zzb = 0;

    public final void zza(Context context, zzbzx zzbzx, String str, Runnable runnable, zzfgb zzfgb) {
        zzb(context, zzbzx, true, (zzbyu) null, str, (String) null, runnable, zzfgb);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzb(Context context, zzbzx zzbzx, boolean z2, zzbyu zzbyu, String str, String str2, Runnable runnable, zzfgb zzfgb) {
        PackageInfo packageInfo;
        if (zzt.zzB().elapsedRealtime() - this.zzb < 5000) {
            zzbzr.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzt.zzB().elapsedRealtime();
        if (zzbyu != null && !TextUtils.isEmpty(zzbyu.zzc())) {
            if (zzt.zzB().currentTimeMillis() - zzbyu.zza() <= ((Long) zzba.zzc().zzb(zzbbm.zzdN)).longValue() && zzbyu.zzi()) {
                return;
            }
        }
        if (context == null) {
            zzbzr.zzj("Context not provided to fetch application settings");
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.zza = applicationContext;
            zzffn zza2 = zzffm.zza(context, 4);
            zza2.zzh();
            zzbmz zza3 = zzt.zzf().zza(this.zza, zzbzx, zzfgb);
            zzbmt zzbmt = zzbmw.zza;
            zzbmp zza4 = zza3.zza("google.afma.config.fetchAppSettings", zzbmt, zzbmt);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z2);
                jSONObject.put("pn", context.getPackageName());
                zzbbe zzbbe = zzbbm.zza;
                jSONObject.put("experiment_ids", TextUtils.join(",", zzba.zza().zza()));
                jSONObject.put("js", zzbzx.zza);
                try {
                    ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                    if (!(applicationInfo == null || (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) == null)) {
                        jSONObject.put(MediationMetaData.KEY_VERSION, packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
                }
                zzfwm zzb2 = zza4.zzb(jSONObject);
                zzd zzd = new zzd(zzfgb, zza2);
                zzfwn zzfwn = zzcae.zzf;
                zzfwm zzm = zzfwc.zzm(zzb2, zzd, zzfwn);
                if (runnable != null) {
                    zzb2.zzc(runnable, zzfwn);
                }
                zzcah.zza(zzm, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e2) {
                zzbzr.zzh("Error requesting application settings", e2);
                zza2.zzg(e2);
                zza2.zzf(false);
                zzfgb.zzb(zza2.zzl());
            }
        } else {
            zzbzr.zzj("App settings could not be fetched. Required parameters missing");
        }
    }

    public final void zzc(Context context, zzbzx zzbzx, String str, zzbyu zzbyu, zzfgb zzfgb) {
        zzb(context, zzbzx, false, zzbyu, zzbyu != null ? zzbyu.zzb() : null, str, (Runnable) null, zzfgb);
    }
}
