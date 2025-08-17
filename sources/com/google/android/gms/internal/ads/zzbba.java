package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

final class zzbba extends zzbbe {
    zzbba(int i2, String str, Long l2) {
        super(1, str, l2, (zzbbd) null);
    }

    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(zzn(), ((Long) zzm()).longValue()));
    }

    public final /* bridge */ /* synthetic */ Object zzb(Bundle bundle) {
        if (bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzn()))) {
            return Long.valueOf(bundle.getLong("com.google.android.gms.ads.flag.".concat(zzn())));
        }
        return (Long) zzm();
    }

    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(zzn(), ((Long) zzm()).longValue()));
    }

    public final /* bridge */ /* synthetic */ void zzd(SharedPreferences.Editor editor, Object obj) {
        editor.putLong(zzn(), ((Long) obj).longValue());
    }
}
