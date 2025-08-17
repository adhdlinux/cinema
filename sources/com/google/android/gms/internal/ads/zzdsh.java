package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdsh {
    private final Context zza;
    private final ApplicationInfo zzb;
    private final int zzc;
    private final int zzd;
    private String zze = "";

    public zzdsh(Context context) {
        this.zza = context;
        this.zzb = context.getApplicationInfo();
        this.zzc = ((Integer) zzba.zzc().zzb(zzbbm.zziH)).intValue();
        this.zzd = ((Integer) zzba.zzc().zzb(zzbbm.zziI)).intValue();
    }

    public final JSONObject zza() throws JSONException {
        Drawable drawable;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", Wrappers.packageManager(this.zza).getApplicationLabel(this.zzb.packageName));
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONObject.put("packageName", this.zzb.packageName);
        zzt.zzp();
        jSONObject.put("adMobAppId", zzs.zzn(this.zza));
        if (this.zze.isEmpty()) {
            try {
                drawable = (Drawable) Wrappers.packageManager(this.zza).getApplicationLabelAndIcon(this.zzb.packageName).f2722b;
            } catch (PackageManager.NameNotFoundException unused2) {
                drawable = null;
            }
            if (drawable == null) {
                str = "";
            } else {
                drawable.setBounds(0, 0, this.zzc, this.zzd);
                Bitmap createBitmap = Bitmap.createBitmap(this.zzc, this.zzd, Bitmap.Config.ARGB_8888);
                drawable.draw(new Canvas(createBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            }
            this.zze = str;
        }
        if (!this.zze.isEmpty()) {
            jSONObject.put("icon", this.zze);
            jSONObject.put("iconWidthPx", this.zzc);
            jSONObject.put("iconHeightPx", this.zzd);
        }
        return jSONObject;
    }
}
