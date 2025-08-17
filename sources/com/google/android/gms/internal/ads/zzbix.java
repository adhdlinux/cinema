package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbix implements zzbij {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    public final void zza(Object obj, Map map) {
        String str;
        String str2 = (String) map.get("id");
        String str3 = (String) map.get("fail");
        String str4 = (String) map.get("fail_reason");
        String str5 = (String) map.get("fail_stack");
        String str6 = (String) map.get("result");
        if (true == TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str5)) {
            str = "";
        } else {
            str = ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE.concat(String.valueOf(str5));
        }
        synchronized (this.zza) {
            zzbiw zzbiw = (zzbiw) this.zzb.remove(str2);
            if (zzbiw == null) {
                zzbzr.zzj("Received result for unexpected method invocation: " + str2);
            } else if (!TextUtils.isEmpty(str3)) {
                zzbiw.zza(str4 + str);
            } else if (str6 == null) {
                zzbiw.zzb((JSONObject) null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (zze.zzc()) {
                        String jSONObject2 = jSONObject.toString(2);
                        zze.zza("Result GMSG: " + jSONObject2);
                    }
                    zzbiw.zzb(jSONObject);
                } catch (JSONException e2) {
                    zzbiw.zza(e2.getMessage());
                }
            }
        }
    }

    public final zzfwm zzb(zzblp zzblp, String str, JSONObject jSONObject) {
        zzcaj zzcaj = new zzcaj();
        zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        zzc(uuid, new zzbiv(this, zzcaj));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", uuid);
            jSONObject2.put("args", jSONObject);
            zzblp.zzl(str, jSONObject2);
        } catch (Exception e2) {
            zzcaj.zze(e2);
        }
        return zzcaj;
    }

    public final void zzc(String str, zzbiw zzbiw) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbiw);
        }
    }
}
