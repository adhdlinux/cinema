package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzetk implements zzeqx {
    private final List zza;

    public zzetk(List list) {
        this.zza = list;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        try {
            ((JSONObject) obj).put("eid", TextUtils.join(",", this.zza));
        } catch (JSONException unused) {
            zze.zza("Failed putting experiment ids.");
        }
    }
}
