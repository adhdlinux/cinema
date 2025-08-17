package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

public final class zzbbs {
    private final String zza = ((String) zzbcz.zzb.zze());
    private final Map zzb;
    private final Context zzc;
    private final String zzd;

    public zzbbs(Context context, String str) {
        String str2;
        String str3;
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", "3");
        linkedHashMap.put("os", Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        zzt.zzp();
        linkedHashMap.put("device", zzs.zzp());
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        linkedHashMap.put("app", str2);
        zzt.zzp();
        String str4 = "0";
        if (true != zzs.zzA(context)) {
            str3 = str4;
        } else {
            str3 = "1";
        }
        linkedHashMap.put("is_lite_sdk", str3);
        Future zzb2 = zzt.zzm().zzb(context);
        try {
            linkedHashMap.put("network_coarse", Integer.toString(((zzbuj) zzb2.get()).zzk));
            linkedHashMap.put("network_fine", Integer.toString(((zzbuj) zzb2.get()).zzl));
        } catch (Exception e2) {
            zzt.zzo().zzu(e2, "CsiConfiguration.CsiConfiguration");
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjN)).booleanValue()) {
            Map map = this.zzb;
            zzt.zzp();
            map.put("is_bstar", true == zzs.zzx(context) ? "1" : str4);
        }
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final String zzc() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Map zzd() {
        return this.zzb;
    }
}
