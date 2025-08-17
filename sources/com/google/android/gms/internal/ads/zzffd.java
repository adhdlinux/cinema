package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.List;
import java.util.Map;

public final class zzffd {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public zzffd(Context context, zzbzx zzbzx) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = zzbzx.zza;
    }

    public final void zza(Map map) {
        String str;
        map.put("s", "gmob_sdk");
        map.put("v", "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzt.zzp();
        map.put("device", zzs.zzp());
        map.put("app", this.zzb);
        zzt.zzp();
        String str2 = "0";
        if (true != zzs.zzA(this.zza)) {
            str = str2;
        } else {
            str = "1";
        }
        map.put("is_lite_sdk", str);
        zzbbe zzbbe = zzbbm.zza;
        List zzb2 = zzba.zza().zzb();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgH)).booleanValue()) {
            zzb2.addAll(zzt.zzo().zzh().zzh().zzd());
        }
        map.put("e", TextUtils.join(",", zzb2));
        map.put("sdkVersion", this.zzc);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjN)).booleanValue()) {
            zzt.zzp();
            if (true == zzs.zzx(this.zza)) {
                str2 = "1";
            }
            map.put("is_bstar", str2);
        }
    }
}
