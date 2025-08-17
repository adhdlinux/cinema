package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbuo extends zzbup {
    private final Object zza = new Object();
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzbmp zzd;

    public zzbuo(Context context, zzbmp zzbmp) {
        this.zzb = context.getApplicationContext();
        this.zzd = zzbmp;
    }

    public static JSONObject zzc(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzbzx.zza().zza);
            jSONObject.put("mf", zzbdf.zza.zze());
            jSONObject.put("cl", "549114221");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final zzfwm zza() {
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzt.zzB().currentTimeMillis() - this.zzc.getLong("js_last_update", 0) < ((Long) zzbdf.zzb.zze()).longValue()) {
            return zzfwc.zzh((Object) null);
        }
        return zzfwc.zzl(this.zzd.zzb(zzc(this.zzb)), new zzbun(this), zzcae.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzb(JSONObject jSONObject) {
        Context context = this.zzb;
        zzbbe zzbbe = zzbbm.zza;
        zzba.zzb();
        SharedPreferences.Editor edit = zzbbg.zza(context).edit();
        zzba.zza();
        zzbcr zzbcr = zzbcw.zza;
        zzba.zza().zze(edit, 1, jSONObject);
        zzba.zzb();
        edit.commit();
        this.zzc.edit().putLong("js_last_update", zzt.zzB().currentTimeMillis()).apply();
        return null;
    }
}
