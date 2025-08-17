package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcn;
import com.google.android.gms.ads.internal.client.zzda;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.util.zzas;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class zzclj extends zzcn {
    private final Context zza;
    private final zzbzx zzb;
    private final zzdnv zzc;
    private final zzece zzd;
    private final zzeii zze;
    private final zzdsc zzf;
    private final zzbxw zzg;
    private final zzdoa zzh;
    private final zzdsx zzi;
    private final zzbdy zzj;
    private final zzfgb zzk;
    private final zzfbb zzl;
    private final zzbbn zzm;
    private boolean zzn = false;

    zzclj(Context context, zzbzx zzbzx, zzdnv zzdnv, zzece zzece, zzeii zzeii, zzdsc zzdsc, zzbxw zzbxw, zzdoa zzdoa, zzdsx zzdsx, zzbdy zzbdy, zzfgb zzfgb, zzfbb zzfbb, zzbbn zzbbn) {
        this.zza = context;
        this.zzb = zzbzx;
        this.zzc = zzdnv;
        this.zzd = zzece;
        this.zze = zzeii;
        this.zzf = zzdsc;
        this.zzg = zzbxw;
        this.zzh = zzdoa;
        this.zzi = zzdsx;
        this.zzj = zzbdy;
        this.zzk = zzfgb;
        this.zzl = zzfbb;
        this.zzm = zzbbn;
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        if (zzt.zzo().zzh().zzO()) {
            if (!zzt.zzs().zzj(this.zza, zzt.zzo().zzh().zzl(), this.zzb.zza)) {
                zzt.zzo().zzh().zzB(false);
                zzt.zzo().zzh().zzA("");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map zze2 = zzt.zzo().zzh().zzh().zze();
        if (!zze2.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzbzr.zzk("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzc.zzd()) {
                HashMap hashMap = new HashMap();
                for (zzbnr zzbnr : zze2.values()) {
                    for (zzbnq zzbnq : zzbnr.zza) {
                        String str = zzbnq.zzk;
                        for (String str2 : zzbnq.zzc) {
                            if (!hashMap.containsKey(str2)) {
                                hashMap.put(str2, new ArrayList());
                            }
                            if (str != null) {
                                ((List) hashMap.get(str2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str3 = (String) entry.getKey();
                    try {
                        zzecf zza2 = this.zzd.zza(str3, jSONObject);
                        if (zza2 != null) {
                            zzfbd zzfbd = (zzfbd) zza2.zzb;
                            if (!zzfbd.zzC() && zzfbd.zzB()) {
                                zzfbd.zzj(this.zza, (zzedz) zza2.zzc, (List) entry.getValue());
                                zzbzr.zze("Initialized rewarded video mediation adapter " + str3);
                            }
                        }
                    } catch (zzfan e2) {
                        zzbzr.zzk("Failed to initialize rewarded video mediation adapter \"" + str3 + "\"", e2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        zzfbl.zzb(this.zza, true);
    }

    public final synchronized float zze() {
        return zzt.zzr().zza();
    }

    public final String zzf() {
        return this.zzb.zza;
    }

    public final List zzg() throws RemoteException {
        return this.zzf.zzg();
    }

    public final void zzh(String str) {
        this.zze.zzf(str);
    }

    public final void zzi() {
        this.zzf.zzl();
    }

    public final void zzj(boolean z2) throws RemoteException {
        try {
            zzfmi.zzi(this.zza).zzn(z2);
        } catch (IOException e2) {
            throw new RemoteException(e2.getMessage());
        }
    }

    public final synchronized void zzk() {
        if (this.zzn) {
            zzbzr.zzj("Mobile ads is initialized already.");
            return;
        }
        zzbbm.zza(this.zza);
        this.zzm.zza();
        zzt.zzo().zzs(this.zza, this.zzb);
        zzt.zzc().zzi(this.zza);
        this.zzn = true;
        this.zzf.zzr();
        this.zze.zzd();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdI)).booleanValue()) {
            this.zzh.zzc();
        }
        this.zzi.zzg();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
            zzcae.zza.execute(new zzclf(this));
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjx)).booleanValue()) {
            zzcae.zza.execute(new zzcle(this));
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcy)).booleanValue()) {
            zzcae.zza.execute(new zzclg(this));
        }
    }

    public final void zzl(String str, IObjectWrapper iObjectWrapper) {
        String str2;
        String str3;
        zzclh zzclh;
        zzbbm.zza(this.zza);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdM)).booleanValue()) {
            zzt.zzp();
            str2 = zzs.zzn(this.zza);
        } else {
            str2 = "";
        }
        boolean z2 = true;
        if (true == TextUtils.isEmpty(str2)) {
            str3 = str;
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            boolean booleanValue = ((Boolean) zzba.zzc().zzb(zzbbm.zzdH)).booleanValue();
            zzbbe zzbbe = zzbbm.zzaN;
            boolean booleanValue2 = booleanValue | ((Boolean) zzba.zzc().zzb(zzbbe)).booleanValue();
            if (((Boolean) zzba.zzc().zzb(zzbbe)).booleanValue()) {
                zzclh = new zzclh(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzclh = null;
                z2 = booleanValue2;
            }
            zzclh zzclh2 = zzclh;
            if (z2) {
                zzt.zza().zza(this.zza, this.zzb, str3, zzclh2, this.zzk);
            }
        }
    }

    public final void zzm(zzda zzda) throws RemoteException {
        this.zzi.zzh(zzda, zzdsw.API);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzbzr.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzbzr.zzg("Context is null. Failed to open debug menu.");
            return;
        }
        zzas zzas = new zzas(context);
        zzas.zzn(str);
        zzas.zzo(this.zzb.zza);
        zzas.zzr();
    }

    public final void zzo(zzbnw zzbnw) throws RemoteException {
        this.zzl.zzf(zzbnw);
    }

    public final synchronized void zzp(boolean z2) {
        zzt.zzr().zzc(z2);
    }

    public final synchronized void zzq(float f2) {
        zzt.zzr().zzd(f2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzr(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            android.content.Context r0 = r7.zza     // Catch:{ all -> 0x0031 }
            com.google.android.gms.internal.ads.zzbbm.zza(r0)     // Catch:{ all -> 0x0031 }
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzdH     // Catch:{ all -> 0x0031 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0031 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x0031 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002f
            com.google.android.gms.ads.internal.zze r1 = com.google.android.gms.ads.internal.zzt.zza()     // Catch:{ all -> 0x0031 }
            android.content.Context r2 = r7.zza     // Catch:{ all -> 0x0031 }
            com.google.android.gms.internal.ads.zzbzx r3 = r7.zzb     // Catch:{ all -> 0x0031 }
            r5 = 0
            com.google.android.gms.internal.ads.zzfgb r6 = r7.zzk     // Catch:{ all -> 0x0031 }
            r4 = r8
            r1.zza(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0031 }
            monitor-exit(r7)
            return
        L_0x002f:
            monitor-exit(r7)
            return
        L_0x0031:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclj.zzr(java.lang.String):void");
    }

    public final void zzs(zzbkm zzbkm) throws RemoteException {
        this.zzf.zzs(zzbkm);
    }

    public final void zzt(String str) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziS)).booleanValue()) {
            zzt.zzo().zzw(str);
        }
    }

    public final void zzu(zzff zzff) throws RemoteException {
        this.zzg.zzq(this.zza, zzff);
    }

    public final synchronized boolean zzv() {
        return zzt.zzr().zze();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw() {
        this.zzj.zza(new zzbtb());
    }
}
