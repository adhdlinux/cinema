package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzdsw;
import com.google.android.gms.internal.ads.zzdsx;
import com.google.android.gms.internal.ads.zzfwm;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzaw {
    protected String zza = "";
    private final Object zzb = new Object();
    private String zzc = "";
    private String zzd = "";
    private boolean zze = false;
    private boolean zzf = false;
    private zzdsx zzg;

    protected static final String zzo(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzt.zzp().zzc(context, str2));
        zzfwm zzb2 = new zzbo(context).zzb(0, str, hashMap, (byte[]) null);
        try {
            return (String) zzb2.get((long) ((Integer) zzba.zzc().zzb(zzbbm.zzey)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e2) {
            zzbzr.zzh("Timeout while retrieving a response from: ".concat(String.valueOf(str)), e2);
            zzb2.cancel(true);
            return null;
        } catch (InterruptedException e3) {
            zzbzr.zzh("Interrupted while retrieving a response from: ".concat(String.valueOf(str)), e3);
            zzb2.cancel(true);
            return null;
        } catch (Exception e4) {
            zzbzr.zzh("Error retrieving a response from: ".concat(String.valueOf(str)), e4);
            return null;
        }
    }

    private final Uri zzp(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        synchronized (this.zzb) {
            if (TextUtils.isEmpty(this.zzc)) {
                zzt.zzp();
                try {
                    str5 = new String(IOUtils.readInputStreamFully(context.openFileInput("debug_signals_id.txt"), true), "UTF-8");
                } catch (IOException unused) {
                    zzbzr.zze("Error reading from internal storage.");
                    str5 = "";
                }
                this.zzc = str5;
                if (TextUtils.isEmpty(str5)) {
                    zzt.zzp();
                    this.zzc = UUID.randomUUID().toString();
                    zzt.zzp();
                    String str6 = this.zzc;
                    try {
                        FileOutputStream openFileOutput = context.openFileOutput("debug_signals_id.txt", 0);
                        openFileOutput.write(str6.getBytes("UTF-8"));
                        openFileOutput.close();
                    } catch (Exception e2) {
                        zzbzr.zzh("Error writing to file in internal storage.", e2);
                    }
                }
            }
            str4 = this.zzc;
        }
        buildUpon.appendQueryParameter("linkedDeviceId", str4);
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    public final zzdsx zza() {
        return this.zzg;
    }

    public final String zzb() {
        String str;
        synchronized (this.zzb) {
            str = this.zzd;
        }
        return str;
    }

    public final void zzc(Context context) {
        zzdsx zzdsx;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziJ)).booleanValue() && (zzdsx = this.zzg) != null) {
            zzdsx.zzh(new zzat(this, context), zzdsw.DEBUG_MENU);
        }
    }

    public final void zzd(Context context, String str, String str2) {
        zzt.zzp();
        zzs.zzQ(context, zzp(context, (String) zzba.zzc().zzb(zzbbm.zzeu), str, str2));
    }

    public final void zze(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzp(context, (String) zzba.zzc().zzb(zzbbm.zzex), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzt.zzp();
        zzs.zzH(context, str, buildUpon.build().toString());
    }

    public final void zzf(boolean z2) {
        synchronized (this.zzb) {
            this.zzf = z2;
            if (((Boolean) zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
                zzt.zzo().zzh().zzB(z2);
                zzdsx zzdsx = this.zzg;
                if (zzdsx != null) {
                    zzdsx.zzj(z2);
                }
            }
        }
    }

    public final void zzg(zzdsx zzdsx) {
        this.zzg = zzdsx;
    }

    public final void zzh(boolean z2) {
        synchronized (this.zzb) {
            this.zze = z2;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzi(Context context, String str, boolean z2, boolean z3) {
        if (!(context instanceof Activity)) {
            zzbzr.zzi("Can not create dialog without Activity Context");
        } else {
            zzs.zza.post(new zzav(this, context, str, z2, z3));
        }
    }

    public final boolean zzj(Context context, String str, String str2) {
        String zzo = zzo(context, zzp(context, (String) zzba.zzc().zzb(zzbbm.zzew), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzo)) {
            zzbzr.zze("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzo.trim()).optString("debug_mode"));
            zzf(equals);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
                zzg zzh = zzt.zzo().zzh();
                if (true != equals) {
                    str = "";
                }
                zzh.zzA(str);
            }
            return equals;
        } catch (JSONException e2) {
            zzbzr.zzk("Fail to get debug mode response json.", e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074 A[Catch:{ JSONException -> 0x0083 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzk(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzev
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.String r0 = (java.lang.String) r0
            android.net.Uri r0 = r3.zzp(r4, r0, r5, r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = zzo(r4, r0, r6)
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            r0 = 0
            if (r6 == 0) goto L_0x0025
            java.lang.String r4 = "Not linked for in app preview."
            com.google.android.gms.internal.ads.zzbzr.zze(r4)
            return r0
        L_0x0025:
            java.lang.String r4 = r4.trim()
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0083 }
            r6.<init>(r4)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r4 = "gct"
            java.lang.String r4 = r6.optString(r4)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r1 = "status"
            java.lang.String r6 = r6.optString(r1)     // Catch:{ JSONException -> 0x0083 }
            r3.zza = r6     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.internal.ads.zzbbe r6 = com.google.android.gms.internal.ads.zzbbm.zziJ     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ JSONException -> 0x0083 }
            java.lang.Object r6 = r1.zzb(r6)     // Catch:{ JSONException -> 0x0083 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ JSONException -> 0x0083 }
            boolean r6 = r6.booleanValue()     // Catch:{ JSONException -> 0x0083 }
            r1 = 1
            if (r6 == 0) goto L_0x0079
            java.lang.String r6 = "0"
            java.lang.String r2 = r3.zza     // Catch:{ JSONException -> 0x0083 }
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x0083 }
            if (r6 != 0) goto L_0x0066
            java.lang.String r6 = "2"
            java.lang.String r2 = r3.zza     // Catch:{ JSONException -> 0x0083 }
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x0083 }
            if (r6 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r6 = 0
            goto L_0x0067
        L_0x0066:
            r6 = 1
        L_0x0067:
            r3.zzf(r6)     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.internal.ads.zzbza r2 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.ads.internal.util.zzg r2 = r2.zzh()     // Catch:{ JSONException -> 0x0083 }
            if (r6 != 0) goto L_0x0076
            java.lang.String r5 = ""
        L_0x0076:
            r2.zzA(r5)     // Catch:{ JSONException -> 0x0083 }
        L_0x0079:
            java.lang.Object r5 = r3.zzb
            monitor-enter(r5)
            r3.zzd = r4     // Catch:{ all -> 0x0080 }
            monitor-exit(r5)     // Catch:{ all -> 0x0080 }
            return r1
        L_0x0080:
            r4 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0080 }
            throw r4
        L_0x0083:
            r4 = move-exception
            java.lang.String r5 = "Fail to get in app preview response json."
            com.google.android.gms.internal.ads.zzbzr.zzk(r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzaw.zzk(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public final boolean zzl() {
        boolean z2;
        synchronized (this.zzb) {
            z2 = this.zzf;
        }
        return z2;
    }

    public final boolean zzm() {
        boolean z2;
        synchronized (this.zzb) {
            z2 = this.zze;
        }
        return z2;
    }

    public final boolean zzn(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzm()) {
            return false;
        }
        zzbzr.zze("Sending troubleshooting signals to the server.");
        zze(context, str, str2, str3);
        return true;
    }
}
