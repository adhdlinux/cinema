package com.google.android.gms.ads;

import android.os.IBinder;
import com.google.android.gms.ads.internal.client.zze;
import org.json.JSONException;
import org.json.JSONObject;

public class AdError {
    public static final String UNDEFINED_DOMAIN = "undefined";
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final AdError zzd;

    public AdError(int i2, String str, String str2) {
        this(i2, str, str2, (AdError) null);
    }

    public AdError(int i2, String str, String str2, AdError adError) {
        this.zza = i2;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = adError;
    }

    public AdError getCause() {
        return this.zzd;
    }

    public int getCode() {
        return this.zza;
    }

    public String getDomain() {
        return this.zzc;
    }

    public String getMessage() {
        return this.zzb;
    }

    public String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final zze zza() {
        zze zze;
        if (this.zzd == null) {
            zze = null;
        } else {
            AdError adError = this.zzd;
            zze = new zze(adError.zza, adError.zzb, adError.zzc, (zze) null, (IBinder) null);
        }
        return new zze(this.zza, this.zzb, this.zzc, zze, (IBinder) null);
    }

    public JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.zza);
        jSONObject.put("Message", this.zzb);
        jSONObject.put("Domain", this.zzc);
        AdError adError = this.zzd;
        if (adError == null) {
            jSONObject.put("Cause", "null");
        } else {
            jSONObject.put("Cause", adError.zzb());
        }
        return jSONObject;
    }
}
