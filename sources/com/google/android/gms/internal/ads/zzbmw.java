package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbmw {
    public static final zzbmt zza = new zzbmv();
    public static final zzbmr zzb = zzbmu.zza;
    private static final Charset zzc = Charset.forName("UTF-8");

    static /* synthetic */ InputStream zza(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zzc));
    }
}
