package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbqv extends zzbqw implements zzbij {
    DisplayMetrics zza;
    int zzb = -1;
    int zzc = -1;
    int zzd = -1;
    int zze = -1;
    int zzf = -1;
    int zzg = -1;
    private final zzcez zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbaw zzk;
    private float zzl;
    private int zzm;

    public zzbqv(zzcez zzcez, Context context, zzbaw zzbaw) {
        super(zzcez, "");
        this.zzh = zzcez;
        this.zzi = context;
        this.zzk = zzbaw;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObject;
        zzcez zzcez = (zzcez) obj;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        zzay.zzb();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = zzbzk.zzv(displayMetrics, displayMetrics.widthPixels);
        zzay.zzb();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = zzbzk.zzv(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzi2 = this.zzh.zzi();
        if (zzi2 == null || zzi2.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            zzt.zzp();
            int[] zzM = zzs.zzM(zzi2);
            zzay.zzb();
            this.zzd = zzbzk.zzv(this.zza, zzM[0]);
            zzay.zzb();
            this.zze = zzbzk.zzv(this.zza, zzM[1]);
        }
        if (this.zzh.zzO().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            this.zzh.measure(0, 0);
        }
        zzi(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbqu zzbqu = new zzbqu();
        zzbaw zzbaw = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbqu.zze(zzbaw.zza(intent));
        zzbaw zzbaw2 = this.zzk;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbqu.zzc(zzbaw2.zza(intent2));
        zzbqu.zza(this.zzk.zzb());
        zzbqu.zzd(this.zzk.zzc());
        zzbqu.zzb(true);
        boolean zzh2 = zzbqu.zza;
        boolean zzj2 = zzbqu.zzb;
        boolean zzf2 = zzbqu.zzc;
        boolean zzi3 = zzbqu.zzd;
        boolean zzg2 = zzbqu.zze;
        zzcez zzcez2 = this.zzh;
        try {
            jSONObject = new JSONObject().put("sms", zzh2).put("tel", zzj2).put("calendar", zzf2).put("storePicture", zzi3).put("inlineVideo", zzg2);
        } catch (JSONException e2) {
            zzbzr.zzh("Error occurred while obtaining the MRAID capabilities.", e2);
            jSONObject = null;
        }
        zzcez2.zze("onDeviceFeaturesReceived", jSONObject);
        int[] iArr = new int[2];
        this.zzh.getLocationOnScreen(iArr);
        zzb(zzay.zzb().zzb(this.zzi, iArr[0]), zzay.zzb().zzb(this.zzi, iArr[1]));
        if (zzbzr.zzm(2)) {
            zzbzr.zzi("Dispatching Ready Event.");
        }
        zzh(this.zzh.zzn().zza);
    }

    public final void zzb(int i2, int i3) {
        int i4;
        int i5 = 0;
        if (this.zzi instanceof Activity) {
            zzt.zzp();
            i4 = zzs.zzN((Activity) this.zzi)[0];
        } else {
            i4 = 0;
        }
        if (this.zzh.zzO() == null || !this.zzh.zzO().zzi()) {
            int width = this.zzh.getWidth();
            int height = this.zzh.getHeight();
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzS)).booleanValue()) {
                if (width == 0) {
                    if (this.zzh.zzO() != null) {
                        width = this.zzh.zzO().zzb;
                    } else {
                        width = 0;
                    }
                }
                if (height == 0) {
                    if (this.zzh.zzO() != null) {
                        i5 = this.zzh.zzO().zza;
                    }
                    this.zzf = zzay.zzb().zzb(this.zzi, width);
                    this.zzg = zzay.zzb().zzb(this.zzi, i5);
                }
            }
            i5 = height;
            this.zzf = zzay.zzb().zzb(this.zzi, width);
            this.zzg = zzay.zzb().zzb(this.zzi, i5);
        }
        zzf(i2, i3 - i4, this.zzf, this.zzg);
        this.zzh.zzN().zzB(i2, i3);
    }
}
