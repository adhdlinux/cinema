package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzab;
import com.google.android.gms.ads.internal.zzt;
import com.unity3d.services.core.device.MimeTypes;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcnt implements zzbms {
    private final Context zza;
    private final zzatw zzb;
    private final PowerManager zzc;

    public zzcnt(Context context, zzatw zzatw) {
        this.zza = context;
        this.zzb = zzatw;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzb(zzcnw zzcnw) throws JSONException {
        JSONObject jSONObject;
        Integer num;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzatz zzatz = zzcnw.zzf;
        if (zzatz == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzd() != null) {
            boolean z2 = zzatz.zza;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("afmaVersion", this.zzb.zzb()).put("activeViewJSON", this.zzb.zzd()).put("timestamp", zzcnw.zzd).put("adFormat", this.zzb.zza()).put("hashCode", this.zzb.zzc()).put("isMraid", false).put("isStopped", false).put("isPaused", zzcnw.zzb).put("isNative", this.zzb.zze()).put("isScreenOn", this.zzc.isInteractive()).put("appMuted", zzt.zzr().zze()).put("appVolume", (double) zzt.zzr().zza()).put("deviceVolume", (double) zzab.zzb(this.zza.getApplicationContext()));
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzfv)).booleanValue()) {
                AudioManager audioManager = (AudioManager) this.zza.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                if (audioManager == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(audioManager.getMode());
                }
                if (num != null) {
                    jSONObject3.put("audioMode", num);
                }
            }
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzatz.zzb).put("isAttachedToWindow", z2).put("viewBox", new JSONObject().put(ViewProps.TOP, zzatz.zzc.top).put(ViewProps.BOTTOM, zzatz.zzc.bottom).put(ViewProps.LEFT, zzatz.zzc.left).put(ViewProps.RIGHT, zzatz.zzc.right)).put("adBox", new JSONObject().put(ViewProps.TOP, zzatz.zzd.top).put(ViewProps.BOTTOM, zzatz.zzd.bottom).put(ViewProps.LEFT, zzatz.zzd.left).put(ViewProps.RIGHT, zzatz.zzd.right)).put("globalVisibleBox", new JSONObject().put(ViewProps.TOP, zzatz.zze.top).put(ViewProps.BOTTOM, zzatz.zze.bottom).put(ViewProps.LEFT, zzatz.zze.left).put(ViewProps.RIGHT, zzatz.zze.right)).put("globalVisibleBoxVisible", zzatz.zzf).put("localVisibleBox", new JSONObject().put(ViewProps.TOP, zzatz.zzg.top).put(ViewProps.BOTTOM, zzatz.zzg.bottom).put(ViewProps.LEFT, zzatz.zzg.left).put(ViewProps.RIGHT, zzatz.zzg.right)).put("localVisibleBoxVisible", zzatz.zzh).put("hitBox", new JSONObject().put(ViewProps.TOP, zzatz.zzi.top).put(ViewProps.BOTTOM, zzatz.zzi.bottom).put(ViewProps.LEFT, zzatz.zzi.left).put(ViewProps.RIGHT, zzatz.zzi.right)).put("screenDensity", (double) this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzcnw.zza);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzbl)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzatz.zzk;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put(ViewProps.TOP, rect2.top).put(ViewProps.BOTTOM, rect2.bottom).put(ViewProps.LEFT, rect2.left).put(ViewProps.RIGHT, rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzcnw.zze)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
