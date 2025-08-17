package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class zzbbf {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        for (zzbbe zzb2 : this.zzb) {
            String str = (String) zzba.zzc().zzb(zzb2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzbbq.zza());
        return arrayList;
    }

    public final List zzb() {
        List zza2 = zza();
        for (zzbbe zzb2 : this.zzc) {
            String str = (String) zzba.zzc().zzb(zzb2);
            if (!TextUtils.isEmpty(str)) {
                zza2.add(str);
            }
        }
        zza2.addAll(zzbbq.zzb());
        return zza2;
    }

    public final void zzc(zzbbe zzbbe) {
        this.zzb.add(zzbbe);
    }

    public final void zzd(zzbbe zzbbe) {
        this.zza.add(zzbbe);
    }

    public final void zze(SharedPreferences.Editor editor, int i2, JSONObject jSONObject) {
        for (zzbbe zzbbe : this.zza) {
            if (zzbbe.zze() == 1) {
                zzbbe.zzd(editor, zzbbe.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzbzr.zzg("Flag Json is null.");
        }
    }
}
