package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

public final /* synthetic */ class zzepw implements Callable {
    public final /* synthetic */ List zza;
    public final /* synthetic */ Bundle zzb;

    public /* synthetic */ zzepw(List list, Bundle bundle) {
        this.zza = list;
        this.zzb = bundle;
    }

    public final Object call() {
        List<zzfwm> list = this.zza;
        Bundle bundle = this.zzb;
        JSONArray jSONArray = new JSONArray();
        for (zzfwm zzfwm : list) {
            if (((JSONObject) zzfwm.get()) != null) {
                jSONArray.put(zzfwm.get());
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzeqa(jSONArray.toString(), bundle);
    }
}
