package com.google.android.gms.internal.ads;

import com.facebook.react.uimanager.ViewProps;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import org.json.JSONException;
import org.json.JSONObject;

public class zzbqw {
    private final zzcez zza;
    private final String zzb;

    public zzbqw(zzcez zzcez, String str) {
        this.zza = zzcez;
        this.zzb = str;
    }

    public final void zzf(int i2, int i3, int i4, int i5) {
        try {
            this.zza.zze("onDefaultPositionReceived", new JSONObject().put("x", i2).put("y", i3).put("width", i4).put("height", i5));
        } catch (JSONException e2) {
            zzbzr.zzh("Error occurred while dispatching default position.", e2);
        }
    }

    public final void zzg(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put("action", this.zzb);
            zzcez zzcez = this.zza;
            if (zzcez != null) {
                zzcez.zze("onError", put);
            }
        } catch (JSONException e2) {
            zzbzr.zzh("Error occurred while dispatching error event.", e2);
        }
    }

    public final void zzh(String str) {
        try {
            this.zza.zze("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e2) {
            zzbzr.zzh("Error occurred while dispatching ready Event.", e2);
        }
    }

    public final void zzi(int i2, int i3, int i4, int i5, float f2, int i6) {
        try {
            this.zza.zze("onScreenInfoChanged", new JSONObject().put("width", i2).put("height", i3).put("maxSizeWidth", i4).put("maxSizeHeight", i5).put("density", (double) f2).put(ViewProps.ROTATION, i6));
        } catch (JSONException e2) {
            zzbzr.zzh("Error occurred while obtaining screen information.", e2);
        }
    }

    public final void zzj(int i2, int i3, int i4, int i5) {
        try {
            this.zza.zze("onSizeChanged", new JSONObject().put("x", i2).put("y", i3).put("width", i4).put("height", i5));
        } catch (JSONException e2) {
            zzbzr.zzh("Error occurred while dispatching size change.", e2);
        }
    }

    public final void zzk(String str) {
        try {
            this.zza.zze("onStateChanged", new JSONObject().put(AdOperationMetric.INIT_STATE, str));
        } catch (JSONException e2) {
            zzbzr.zzh("Error occurred while dispatching state change.", e2);
        }
    }
}
