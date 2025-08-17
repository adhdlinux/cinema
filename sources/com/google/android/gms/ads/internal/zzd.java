package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzffn;
import com.google.android.gms.internal.ads.zzfgb;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzfwc;
import com.google.android.gms.internal.ads.zzfwm;
import org.json.JSONObject;

public final /* synthetic */ class zzd implements zzfvj {
    public final /* synthetic */ zzfgb zza;
    public final /* synthetic */ zzffn zzb;

    public /* synthetic */ zzd(zzfgb zzfgb, zzffn zzffn) {
        this.zza = zzfgb;
        this.zzb = zzffn;
    }

    public final zzfwm zza(Object obj) {
        zzfgb zzfgb = this.zza;
        zzffn zzffn = this.zzb;
        JSONObject jSONObject = (JSONObject) obj;
        boolean optBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (optBoolean) {
            zzt.zzo().zzh().zzu(jSONObject.getString("appSettingsJson"));
        }
        zzffn.zzf(optBoolean);
        zzfgb.zzb(zzffn.zzl());
        return zzfwc.zzh((Object) null);
    }
}
