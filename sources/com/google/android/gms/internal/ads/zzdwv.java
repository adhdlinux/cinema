package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class zzdwv implements zzfvj {
    public static final /* synthetic */ zzdwv zza = new zzdwv();

    private /* synthetic */ zzdwv() {
    }

    public final zzfwm zza(Object obj) {
        InputStream inputStream = (InputStream) obj;
        JSONObject jSONObject = new JSONObject();
        if (inputStream == null) {
            return zzfwc.zzh(jSONObject);
        }
        try {
            zzt.zzp();
            jSONObject = new JSONObject(zzs.zzJ(new InputStreamReader(inputStream)));
        } catch (IOException | JSONException e2) {
            zzt.zzo().zzu(e2, "AdsServiceSignalTask.startAdsServiceSignalTask");
        }
        return zzfwc.zzh(jSONObject);
    }
}
