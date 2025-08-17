package com.google.android.gms.internal.ads;

import com.google.android.gms.common.GooglePlayServicesUtilLight;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class zzeua implements zzeqx {
    public static final /* synthetic */ zzeua zza = new zzeua();

    private /* synthetic */ zzeua() {
    }

    public final void zzh(Object obj) {
        try {
            ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (JSONException unused) {
        }
    }
}
