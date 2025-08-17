package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbue;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzfwc;
import com.google.android.gms.internal.ads.zzfwm;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;

public final /* synthetic */ class zzaj implements zzfvj {
    public final /* synthetic */ zzbue zza;

    public /* synthetic */ zzaj(zzbue zzbue) {
        this.zza = zzbue;
    }

    public final zzfwm zza(Object obj) {
        zzbue zzbue = this.zza;
        zzam zzam = new zzam(new JsonReader(new InputStreamReader((InputStream) obj)));
        try {
            zzam.zzb = zzay.zzb().zzh(zzbue.zza).toString();
        } catch (JSONException unused) {
            zzam.zzb = JsonUtils.EMPTY_JSON;
        }
        return zzfwc.zzh(zzam);
    }
}
