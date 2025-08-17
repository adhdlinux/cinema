package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public final /* synthetic */ class zzdym implements zzfvj {
    public static final /* synthetic */ zzdym zza = new zzdym();

    private /* synthetic */ zzdym() {
    }

    public final zzfwm zza(Object obj) {
        return zzfwc.zzh(new ByteArrayInputStream(((JSONObject) obj).toString().getBytes(StandardCharsets.UTF_8)));
    }
}
