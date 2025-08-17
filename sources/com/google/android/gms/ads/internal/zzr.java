package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbct;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzeqv;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;

final class zzr {
    private final Context zza;
    private final String zzb;
    private final Map zzc = new TreeMap();
    private String zzd;
    private String zze;
    private final String zzf;

    public zzr(Context context, String str) {
        String str2;
        this.zza = context.getApplicationContext();
        this.zzb = str;
        String packageName = context.getPackageName();
        try {
            str2 = packageName + "-" + Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            zzbzr.zzh("Unable to get package version name for reporting", e2);
            str2 = String.valueOf(packageName).concat("-missing");
        }
        this.zzf = str2;
    }

    public final String zza() {
        return this.zzf;
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final Map zze() {
        return this.zzc;
    }

    public final void zzf(zzl zzl, zzbzx zzbzx) {
        Bundle bundle;
        this.zzd = zzl.zzj.zza;
        Bundle bundle2 = zzl.zzm;
        if (bundle2 != null) {
            bundle = bundle2.getBundle(AdMobAdapter.class.getName());
        } else {
            bundle = null;
        }
        if (bundle != null) {
            String str = (String) zzbct.zzc.zze();
            for (String next : bundle.keySet()) {
                if (str.equals(next)) {
                    this.zze = bundle.getString(next);
                } else if (next.startsWith("csa_")) {
                    this.zzc.put(next.substring(4), bundle.getString(next));
                }
            }
            this.zzc.put("SDKVersion", zzbzx.zza);
            if (((Boolean) zzbct.zza.zze()).booleanValue()) {
                try {
                    Bundle zzc2 = zzeqv.zzc(this.zza, new JSONArray((String) zzbct.zzb.zze()));
                    for (String next2 : zzc2.keySet()) {
                        this.zzc.put(next2, zzc2.get(next2).toString());
                    }
                } catch (JSONException e2) {
                    zzbzr.zzh("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e2);
                }
            }
        }
    }
}
