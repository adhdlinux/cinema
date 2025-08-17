package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbwn implements zzbws {
    public static final /* synthetic */ int zzb = 0;
    /* access modifiers changed from: private */
    public static final List zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    private final zzgtl zzd;
    private final LinkedHashMap zze;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Context zzh;
    private final zzbwp zzi;
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;
    private final zzbwo zzn;

    public zzbwn(Context context, zzbzx zzbzx, zzbwp zzbwp, String str, zzbwo zzbwo) {
        Preconditions.checkNotNull(zzbwp, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzn = zzbwo;
        this.zzi = zzbwp;
        for (String lowerCase : zzbwp.zze) {
            this.zzk.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzgtl zza2 = zzgva.zza();
        zza2.zzn(9);
        zza2.zzj(str);
        zza2.zzh(str);
        zzgtm zza3 = zzgtn.zza();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zza3.zza(str2);
        }
        zza2.zzg((zzgtn) zza3.zzal());
        zzguu zza4 = zzguv.zza();
        zza4.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str3 = zzbzx.zza;
        if (str3 != null) {
            zza4.zza(str3);
        }
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh);
        if (apkVersion > 0) {
            zza4.zzb(apkVersion);
        }
        zza2.zzf((zzguv) zza4.zzal());
        this.zzd = zza2;
    }

    public final zzbwp zza() {
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(Map map) throws Exception {
        zzfwm zzl2;
        zzgus zzgus;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.zzj) {
                            int length = optJSONArray.length();
                            synchronized (this.zzj) {
                                zzgus = (zzgus) this.zze.get(str);
                            }
                            if (zzgus == null) {
                                zzbwr.zza("Cannot find the corresponding resource object for " + str);
                            } else {
                                boolean z2 = false;
                                for (int i2 = 0; i2 < length; i2++) {
                                    zzgus.zza(optJSONArray.getJSONObject(i2).getString("threat_type"));
                                }
                                boolean z3 = this.zza;
                                if (length > 0) {
                                    z2 = true;
                                }
                                this.zza = z2 | z3;
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                if (((Boolean) zzbdm.zzb.zze()).booleanValue()) {
                    zzbzr.zzf("Failed to get SafeBrowsing metadata", e2);
                }
                return zzfwc.zzg(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zza) {
            synchronized (this.zzj) {
                this.zzd.zzn(10);
            }
        }
        boolean z4 = this.zza;
        if ((!z4 || !this.zzi.zzg) && ((!this.zzm || !this.zzi.zzf) && (z4 || !this.zzi.zzd))) {
            return zzfwc.zzh((Object) null);
        }
        synchronized (this.zzj) {
            for (zzgus zzal : this.zze.values()) {
                this.zzd.zzc((zzgut) zzal.zzal());
            }
            this.zzd.zza(this.zzf);
            this.zzd.zzb(this.zzg);
            if (zzbwr.zzb()) {
                String zzl3 = this.zzd.zzl();
                String zzk2 = this.zzd.zzk();
                StringBuilder sb = new StringBuilder("Sending SB report\n  url: " + zzl3 + "\n  clickUrl: " + zzk2 + "\n  resources: \n");
                for (zzgut zzgut : this.zzd.zzm()) {
                    sb.append("    [");
                    sb.append(zzgut.zza());
                    sb.append("] ");
                    sb.append(zzgut.zze());
                }
                zzbwr.zza(sb.toString());
            }
            byte[] zzax = ((zzgva) this.zzd.zzal()).zzax();
            zzfwm zzb2 = new zzbo(this.zzh).zzb(1, this.zzi.zzb, (Map) null, zzax);
            if (zzbwr.zzb()) {
                zzb2.zzc(zzbwi.zza, zzcae.zza);
            }
            zzl2 = zzfwc.zzl(zzb2, zzbwj.zza, zzcae.zzf);
        }
        return zzl2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(java.lang.String r7, java.util.Map r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.zzj
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x0009
            r2 = 1
            r6.zzm = r2     // Catch:{ all -> 0x00b4 }
        L_0x0009:
            java.util.LinkedHashMap r2 = r6.zze     // Catch:{ all -> 0x00b4 }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x00b4 }
            if (r2 == 0) goto L_0x0021
            if (r9 != r1) goto L_0x001f
            java.util.LinkedHashMap r8 = r6.zze     // Catch:{ all -> 0x00b4 }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzgus r7 = (com.google.android.gms.internal.ads.zzgus) r7     // Catch:{ all -> 0x00b4 }
            r8 = 4
            r7.zze(r8)     // Catch:{ all -> 0x00b4 }
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzgus r1 = com.google.android.gms.internal.ads.zzgut.zzc()     // Catch:{ all -> 0x00b4 }
            int r9 = com.google.android.gms.internal.ads.zzgur.zza(r9)     // Catch:{ all -> 0x00b4 }
            if (r9 == 0) goto L_0x002e
            r1.zze(r9)     // Catch:{ all -> 0x00b4 }
        L_0x002e:
            java.util.LinkedHashMap r9 = r6.zze     // Catch:{ all -> 0x00b4 }
            int r9 = r9.size()     // Catch:{ all -> 0x00b4 }
            r1.zzb(r9)     // Catch:{ all -> 0x00b4 }
            r1.zzd(r7)     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzgty r9 = com.google.android.gms.internal.ads.zzgub.zza()     // Catch:{ all -> 0x00b4 }
            java.util.HashSet r2 = r6.zzk     // Catch:{ all -> 0x00b4 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00b4 }
            if (r2 != 0) goto L_0x00a4
            if (r8 == 0) goto L_0x00a4
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00b4 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00b4 }
        L_0x0050:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00b4 }
            if (r2 == 0) goto L_0x00a4
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00b4 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00b4 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00b4 }
            if (r3 == 0) goto L_0x0069
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00b4 }
            goto L_0x006b
        L_0x0069:
            java.lang.String r3 = ""
        L_0x006b:
            java.lang.Object r4 = r2.getValue()     // Catch:{ all -> 0x00b4 }
            if (r4 == 0) goto L_0x0078
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00b4 }
            goto L_0x007a
        L_0x0078:
            java.lang.String r2 = ""
        L_0x007a:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ all -> 0x00b4 }
            java.util.HashSet r5 = r6.zzk     // Catch:{ all -> 0x00b4 }
            boolean r4 = r5.contains(r4)     // Catch:{ all -> 0x00b4 }
            if (r4 == 0) goto L_0x0050
            com.google.android.gms.internal.ads.zzgtw r4 = com.google.android.gms.internal.ads.zzgtx.zza()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzgoe r3 = com.google.android.gms.internal.ads.zzgoe.zzw(r3)     // Catch:{ all -> 0x00b4 }
            r4.zza(r3)     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzgoe r2 = com.google.android.gms.internal.ads.zzgoe.zzw(r2)     // Catch:{ all -> 0x00b4 }
            r4.zzb(r2)     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzgpm r2 = r4.zzal()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzgtx r2 = (com.google.android.gms.internal.ads.zzgtx) r2     // Catch:{ all -> 0x00b4 }
            r9.zza(r2)     // Catch:{ all -> 0x00b4 }
            goto L_0x0050
        L_0x00a4:
            com.google.android.gms.internal.ads.zzgpm r8 = r9.zzal()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzgub r8 = (com.google.android.gms.internal.ads.zzgub) r8     // Catch:{ all -> 0x00b4 }
            r1.zzc(r8)     // Catch:{ all -> 0x00b4 }
            java.util.LinkedHashMap r8 = r6.zze     // Catch:{ all -> 0x00b4 }
            r8.put(r7, r1)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            return
        L_0x00b4:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbwn.zzd(java.lang.String, java.util.Map, int):void");
    }

    public final void zze() {
        synchronized (this.zzj) {
            this.zze.keySet();
            zzfwm zzh2 = zzfwc.zzh(Collections.emptyMap());
            zzbwk zzbwk = new zzbwk(this);
            zzfwn zzfwn = zzcae.zzf;
            zzfwm zzm2 = zzfwc.zzm(zzh2, zzbwk, zzfwn);
            zzfwm zzn2 = zzfwc.zzn(zzm2, 10, TimeUnit.SECONDS, zzcae.zzd);
            zzfwc.zzq(zzm2, new zzbwm(this, zzn2), zzfwn);
            zzc.add(zzn2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Bitmap bitmap) {
        zzgob zzt = zzgoe.zzt();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzt);
        synchronized (this.zzj) {
            zzgtl zzgtl = this.zzd;
            zzgul zza2 = zzgun.zza();
            zza2.zza(zzt.zzb());
            zza2.zzb("image/png");
            zza2.zzc(2);
            zzgtl.zzi((zzgun) zza2.zzal());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC, Splitter:B:20:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(android.view.View r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbwp r0 = r7.zzi
            boolean r0 = r0.zzc
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r7.zzl
            if (r0 == 0) goto L_0x000c
            return
        L_0x000c:
            com.google.android.gms.ads.internal.zzt.zzp()
            r0 = 1
            r1 = 0
            if (r8 != 0) goto L_0x0014
            goto L_0x006d
        L_0x0014:
            boolean r2 = r8.isDrawingCacheEnabled()     // Catch:{ RuntimeException -> 0x002d }
            r8.setDrawingCacheEnabled(r0)     // Catch:{ RuntimeException -> 0x002d }
            android.graphics.Bitmap r3 = r8.getDrawingCache()     // Catch:{ RuntimeException -> 0x002d }
            if (r3 == 0) goto L_0x0026
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3)     // Catch:{ RuntimeException -> 0x002d }
            goto L_0x0027
        L_0x0026:
            r3 = r1
        L_0x0027:
            r8.setDrawingCacheEnabled(r2)     // Catch:{ RuntimeException -> 0x002b }
            goto L_0x0034
        L_0x002b:
            r2 = move-exception
            goto L_0x002f
        L_0x002d:
            r2 = move-exception
            r3 = r1
        L_0x002f:
            java.lang.String r4 = "Fail to capture the web view"
            com.google.android.gms.internal.ads.zzbzr.zzh(r4, r2)
        L_0x0034:
            if (r3 != 0) goto L_0x006c
            int r2 = r8.getWidth()     // Catch:{ RuntimeException -> 0x0065 }
            int r3 = r8.getHeight()     // Catch:{ RuntimeException -> 0x0065 }
            if (r2 == 0) goto L_0x005f
            if (r3 != 0) goto L_0x0043
            goto L_0x005f
        L_0x0043:
            int r4 = r8.getWidth()     // Catch:{ RuntimeException -> 0x0065 }
            int r5 = r8.getHeight()     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6)     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch:{ RuntimeException -> 0x0065 }
            r5.<init>(r4)     // Catch:{ RuntimeException -> 0x0065 }
            r6 = 0
            r8.layout(r6, r6, r2, r3)     // Catch:{ RuntimeException -> 0x0065 }
            r8.draw(r5)     // Catch:{ RuntimeException -> 0x0065 }
            r1 = r4
            goto L_0x006d
        L_0x005f:
            java.lang.String r8 = "Width or height of view is zero"
            com.google.android.gms.internal.ads.zzbzr.zzj(r8)     // Catch:{ RuntimeException -> 0x0065 }
            goto L_0x006d
        L_0x0065:
            r8 = move-exception
            java.lang.String r2 = "Fail to capture the webview"
            com.google.android.gms.internal.ads.zzbzr.zzh(r2, r8)
            goto L_0x006d
        L_0x006c:
            r1 = r3
        L_0x006d:
            if (r1 != 0) goto L_0x0075
            java.lang.String r8 = "Failed to capture the webview bitmap."
            com.google.android.gms.internal.ads.zzbwr.zza(r8)
            return
        L_0x0075:
            r7.zzl = r0
            com.google.android.gms.internal.ads.zzbwl r8 = new com.google.android.gms.internal.ads.zzbwl
            r8.<init>(r7, r1)
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            java.lang.Thread r0 = r0.getThread()
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            if (r0 == r1) goto L_0x008e
            r8.run()
            return
        L_0x008e:
            com.google.android.gms.internal.ads.zzfwn r0 = com.google.android.gms.internal.ads.zzcae.zza
            r0.execute(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbwn.zzg(android.view.View):void");
    }

    public final void zzh(String str) {
        synchronized (this.zzj) {
            if (str == null) {
                this.zzd.zzd();
            } else {
                this.zzd.zze(str);
            }
        }
    }

    public final boolean zzi() {
        return PlatformVersion.isAtLeastKitKat() && this.zzi.zzc && !this.zzl;
    }
}
