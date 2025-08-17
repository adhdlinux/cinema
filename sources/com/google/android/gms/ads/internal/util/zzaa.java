package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcgb;
import com.google.android.gms.internal.ads.zzebl;
import java.io.InputStream;
import java.util.Map;

public class zzaa {
    private zzaa() {
    }

    /* synthetic */ zzaa(zzz zzz) {
    }

    public static zzaa zzo(int i2) {
        return i2 >= 30 ? new zzy() : i2 >= 28 ? new zzx() : i2 >= 26 ? new zzv() : i2 >= 24 ? new zzu() : i2 >= 21 ? new zzt() : new zzaa();
    }

    public int zza() {
        return 1;
    }

    public CookieManager zzb(Context context) {
        zzt.zzp();
        if (zzs.zzB()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzbzr.zzh("Failed to obtain CookieManager.", th);
            zzt.zzo().zzu(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public WebResourceResponse zzc(String str, String str2, int i2, String str3, Map map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    public zzcfg zzd(zzcez zzcez, zzawz zzawz, boolean z2, zzebl zzebl) {
        return new zzcgb(zzcez, zzawz, z2, zzebl);
    }

    public boolean zze(Activity activity, Configuration configuration) {
        return false;
    }

    public Intent zzg(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("app_package", activity.getPackageName());
        intent.putExtra("app_uid", activity.getApplicationInfo().uid);
        return intent;
    }

    public void zzh(Context context, String str, String str2) {
    }

    public boolean zzi(Context context, String str) {
        return false;
    }

    public int zzj(Context context, TelephonyManager telephonyManager) {
        return 1001;
    }

    public int zzk(AudioManager audioManager) {
        return 0;
    }

    public void zzl(Activity activity) {
    }

    public int zzn(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }
}
