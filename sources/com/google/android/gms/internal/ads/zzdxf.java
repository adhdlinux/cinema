package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

public final /* synthetic */ class zzdxf implements zzfdo {
    public final /* synthetic */ JSONObject zza;
    public final /* synthetic */ zzbuh zzb;

    public /* synthetic */ zzdxf(JSONObject jSONObject, zzbuh zzbuh) {
        this.zza = jSONObject;
        this.zzb = zzbuh;
    }

    public final Object zza(Object obj) {
        return new zzdyg(zzdyu.zza(new InputStreamReader((InputStream) obj)), this.zza, this.zzb);
    }
}
