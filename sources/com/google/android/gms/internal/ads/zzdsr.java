package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.cast.MediaTrack;
import com.unity3d.ads.metadata.MediationMetaData;
import org.json.JSONException;
import org.json.JSONObject;

final class zzdsr {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private final int zzf;
    private final boolean zzg;

    public zzdsr(String str, String str2, String str3, int i2, String str4, int i3, boolean z2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = i2;
        this.zze = str4;
        this.zzf = i3;
        this.zzg = z2;
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adapterClassName", this.zza);
        jSONObject.put(MediationMetaData.KEY_VERSION, this.zzc);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziO)).booleanValue()) {
            jSONObject.put("sdkVersion", this.zzb);
        }
        jSONObject.put("status", this.zzd);
        jSONObject.put(MediaTrack.ROLE_DESCRIPTION, this.zze);
        jSONObject.put("initializationLatencyMillis", this.zzf);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziP)).booleanValue()) {
            jSONObject.put("supportsInitialization", this.zzg);
        }
        return jSONObject;
    }
}
