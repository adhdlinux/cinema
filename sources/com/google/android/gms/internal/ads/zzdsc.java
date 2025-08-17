package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdsc {
    private boolean zza = false;
    private boolean zzb = false;
    /* access modifiers changed from: private */
    public boolean zzc = false;
    /* access modifiers changed from: private */
    public final long zzd;
    /* access modifiers changed from: private */
    public final zzcaj zze = new zzcaj();
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdnv zzh;
    /* access modifiers changed from: private */
    public final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    /* access modifiers changed from: private */
    public final zzdqj zzl;
    private final zzbzx zzm;
    private final Map zzn = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final zzdbx zzo;
    /* access modifiers changed from: private */
    public final zzfgb zzp;
    private boolean zzq = true;

    public zzdsc(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdnv zzdnv, ScheduledExecutorService scheduledExecutorService, zzdqj zzdqj, zzbzx zzbzx, zzdbx zzdbx, zzfgb zzfgb) {
        this.zzh = zzdnv;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdqj;
        this.zzm = zzbzx;
        this.zzo = zzdbx;
        this.zzp = zzfgb;
        this.zzd = zzt.zzB().elapsedRealtime();
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    static /* bridge */ /* synthetic */ void zzj(zzdsc zzdsc, String str) {
        zzdsc zzdsc2 = zzdsc;
        int i2 = 5;
        zzffn zza2 = zzffm.zza(zzdsc2.zzf, 5);
        zza2.zzh();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzffn zza3 = zzffm.zza(zzdsc2.zzf, i2);
                zza3.zzh();
                zza3.zzd(next);
                Object obj = new Object();
                zzcaj zzcaj = new zzcaj();
                zzfwm zzn2 = zzfwc.zzn(zzcaj, ((Long) zzba.zzc().zzb(zzbbm.zzbH)).longValue(), TimeUnit.SECONDS, zzdsc2.zzk);
                zzdsc2.zzl.zzc(next);
                zzdsc2.zzo.zzc(next);
                long elapsedRealtime = zzt.zzB().elapsedRealtime();
                zzdrt zzdrt = r1;
                zzfwm zzfwm = zzn2;
                zzdrt zzdrt2 = new zzdrt(zzdsc, obj, zzcaj, next, elapsedRealtime, zza3);
                zzfwm.zzc(zzdrt, zzdsc2.zzi);
                arrayList.add(zzfwm);
                zzdsb zzdsb = new zzdsb(zzdsc, obj, next, elapsedRealtime, zza3, zzcaj);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        int i3 = 0;
                        while (i3 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                    jSONArray = jSONArray;
                                }
                            }
                            JSONArray jSONArray2 = jSONArray;
                            arrayList2.add(new zzbkp(optString, bundle));
                            i3++;
                            jSONArray = jSONArray2;
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdsc2.zzv(next, false, "", 0);
                try {
                    zzdsc2.zzj.execute(new zzdrx(zzdsc, zzdsc2.zzh.zzc(next, new JSONObject()), zzdsb, arrayList2, next));
                } catch (zzfan unused2) {
                    try {
                        zzdsb.zze("Failed to create Adapter.");
                    } catch (RemoteException e2) {
                        zzbzr.zzh("", e2);
                    }
                }
                i2 = 5;
            }
            zzfwc.zza(arrayList).zza(new zzdru(zzdsc2, zza2), zzdsc2.zzi);
        } catch (JSONException e3) {
            zze.zzb("Malformed CLD response", e3);
            zzdsc2.zzo.zza("MalformedJson");
            zzdsc2.zzl.zza("MalformedJson");
            zzdsc2.zze.zze(e3);
            zzt.zzo().zzu(e3, "AdapterInitializer.updateAdapterStatus");
            zzfgb zzfgb = zzdsc2.zzp;
            zza2.zzg(e3);
            zza2.zzf(false);
            zzfgb.zzb(zza2.zzl());
        }
    }

    private final synchronized zzfwm zzu() {
        String zzc2 = zzt.zzo().zzh().zzh().zzc();
        if (!TextUtils.isEmpty(zzc2)) {
            return zzfwc.zzh(zzc2);
        }
        zzcaj zzcaj = new zzcaj();
        zzt.zzo().zzh().zzq(new zzdry(this, zzcaj));
        return zzcaj;
    }

    /* access modifiers changed from: private */
    public final void zzv(String str, boolean z2, String str2, int i2) {
        this.zzn.put(str, new zzbkf(str, z2, i2, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzf(zzffn zzffn) throws Exception {
        this.zze.zzd(Boolean.TRUE);
        zzfgb zzfgb = this.zzp;
        zzffn.zzf(true);
        zzfgb.zzb(zzffn.zzl());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzbkf zzbkf = (zzbkf) this.zzn.get(str);
            arrayList.add(new zzbkf(str, zzbkf.zzb, zzbkf.zzc, zzbkf.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        synchronized (this) {
            if (!this.zzc) {
                zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzt.zzB().elapsedRealtime() - this.zzd));
                this.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zze.zze(new Exception());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        com.google.android.gms.internal.ads.zzbzr.zzh("", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3.zze("Failed to initialize adapter. " + r5 + " does not implement the initialize() method.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzn(com.google.android.gms.internal.ads.zzfbd r2, com.google.android.gms.internal.ads.zzbkj r3, java.util.List r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.ref.WeakReference r0 = r1.zzg     // Catch:{ zzfan -> 0x0011 }
            java.lang.Object r0 = r0.get()     // Catch:{ zzfan -> 0x0011 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ zzfan -> 0x0011 }
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            android.content.Context r0 = r1.zzf     // Catch:{ zzfan -> 0x0011 }
        L_0x000d:
            r2.zzi(r0, r3, r4)     // Catch:{ zzfan -> 0x0011 }
            return
        L_0x0011:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x002b }
            r2.<init>()     // Catch:{ RemoteException -> 0x002b }
            java.lang.String r4 = "Failed to initialize adapter. "
            r2.append(r4)     // Catch:{ RemoteException -> 0x002b }
            r2.append(r5)     // Catch:{ RemoteException -> 0x002b }
            java.lang.String r4 = " does not implement the initialize() method."
            r2.append(r4)     // Catch:{ RemoteException -> 0x002b }
            java.lang.String r2 = r2.toString()     // Catch:{ RemoteException -> 0x002b }
            r3.zze(r2)     // Catch:{ RemoteException -> 0x002b }
            return
        L_0x002b:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzbzr.zzh(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsc.zzn(com.google.android.gms.internal.ads.zzfbd, com.google.android.gms.internal.ads.zzbkj, java.util.List, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(zzcaj zzcaj) {
        this.zzi.execute(new zzdrr(this, zzcaj));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Object obj, zzcaj zzcaj, String str, long j2, zzffn zzffn) {
        synchronized (obj) {
            if (!zzcaj.isDone()) {
                zzv(str, false, "Timeout.", (int) (zzt.zzB().elapsedRealtime() - j2));
                this.zzl.zzb(str, "timeout");
                this.zzo.zzb(str, "timeout");
                zzfgb zzfgb = this.zzp;
                zzffn.zzc("Timeout");
                zzffn.zzf(false);
                zzfgb.zzb(zzffn.zzl());
                zzcaj.zzd(Boolean.FALSE);
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbdk.zza.zze()).booleanValue()) {
            if (this.zzm.zzc >= ((Integer) zzba.zzc().zzb(zzbbm.zzbG)).intValue() && this.zzq) {
                if (!this.zza) {
                    synchronized (this) {
                        if (!this.zza) {
                            this.zzl.zzf();
                            this.zzo.zzf();
                            this.zze.zzc(new zzdrs(this), this.zzi);
                            this.zza = true;
                            zzfwm zzu = zzu();
                            this.zzk.schedule(new zzdrv(this), ((Long) zzba.zzc().zzb(zzbbm.zzbI)).longValue(), TimeUnit.SECONDS);
                            zzfwc.zzq(zzu, new zzdsa(this), this.zzi);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zza) {
            zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zze.zzd(Boolean.FALSE);
            this.zza = true;
            this.zzb = true;
        }
    }

    public final void zzs(zzbkm zzbkm) {
        this.zze.zzc(new zzdrw(this, zzbkm), this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
