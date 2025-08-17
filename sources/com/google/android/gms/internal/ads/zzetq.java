package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzetq implements zzeqx {
    private final Bundle zza;

    public zzetq(Bundle bundle) {
        this.zza = bundle;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.zza != null) {
            try {
                zzbu.zzf(zzbu.zzf(jSONObject, "device"), "play_store").put("parental_controls", zzay.zzb().zzh(this.zza));
            } catch (JSONException unused) {
                zze.zza("Failed putting parental controls bundle.");
            }
        }
    }
}
