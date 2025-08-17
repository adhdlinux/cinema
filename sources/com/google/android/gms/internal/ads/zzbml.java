package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbb;
import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;

public final class zzbml {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final Context zzb;
    private final String zzc;
    private final zzbzx zzd;
    /* access modifiers changed from: private */
    public final zzfgb zze;
    private final zzbb zzf;
    private final zzbb zzg;
    /* access modifiers changed from: private */
    public zzbmk zzh;
    /* access modifiers changed from: private */
    public int zzi = 1;

    public zzbml(Context context, zzbzx zzbzx, String str, zzbb zzbb, zzbb zzbb2, zzfgb zzfgb) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = zzbzx;
        this.zze = zzfgb;
        this.zzf = zzbb;
        this.zzg = zzbb2;
    }

    public final zzbmf zzb(zzaqs zzaqs) {
        synchronized (this.zza) {
            synchronized (this.zza) {
                zzbmk zzbmk = this.zzh;
                if (zzbmk != null && this.zzi == 0) {
                    zzbmk.zzi(new zzblq(this), zzblr.zza);
                }
            }
            zzbmk zzbmk2 = this.zzh;
            if (zzbmk2 != null) {
                if (zzbmk2.zze() != -1) {
                    int i2 = this.zzi;
                    if (i2 == 0) {
                        zzbmf zza2 = this.zzh.zza();
                        return zza2;
                    } else if (i2 == 1) {
                        this.zzi = 2;
                        zzd((zzaqs) null);
                        zzbmf zza3 = this.zzh.zza();
                        return zza3;
                    } else {
                        zzbmf zza4 = this.zzh.zza();
                        return zza4;
                    }
                }
            }
            this.zzi = 2;
            zzbmk zzd2 = zzd((zzaqs) null);
            this.zzh = zzd2;
            zzbmf zza5 = zzd2.zza();
            return zza5;
        }
    }

    /* access modifiers changed from: protected */
    public final zzbmk zzd(zzaqs zzaqs) {
        zzffn zza2 = zzffm.zza(this.zzb, 6);
        zza2.zzh();
        zzbmk zzbmk = new zzbmk(this.zzg);
        zzcae.zze.execute(new zzblu(this, (zzaqs) null, zzbmk));
        zzbmk.zzi(new zzbma(this, zzbmk, zza2), new zzbmb(this, zzbmk, zza2));
        return zzbmk;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0081, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzi(com.google.android.gms.internal.ads.zzbmk r5, com.google.android.gms.internal.ads.zzblg r6, java.util.ArrayList r7, long r8) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zza
            monitor-enter(r0)
            int r1 = r5.zze()     // Catch:{ all -> 0x0082 }
            r2 = -1
            if (r1 == r2) goto L_0x0080
            int r1 = r5.zze()     // Catch:{ all -> 0x0082 }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0080
        L_0x0012:
            r5.zzg()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.ads.zzfwn r1 = com.google.android.gms.internal.ads.zzcae.zze     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.ads.zzbls r2 = new com.google.android.gms.internal.ads.zzbls     // Catch:{ all -> 0x0082 }
            r2.<init>(r6)     // Catch:{ all -> 0x0082 }
            r1.execute(r2)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.ads.zzbbe r6 = com.google.android.gms.internal.ads.zzbbm.zzc     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0082 }
            java.lang.Object r6 = r1.zzb(r6)     // Catch:{ all -> 0x0082 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0082 }
            int r5 = r5.zze()     // Catch:{ all -> 0x0082 }
            int r1 = r4.zzi     // Catch:{ all -> 0x0082 }
            r2 = 0
            java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x0082 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ all -> 0x0082 }
            long r2 = r2.currentTimeMillis()     // Catch:{ all -> 0x0082 }
            long r2 = r2 - r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r8.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r9 = "Could not receive /jsLoaded in "
            r8.append(r9)     // Catch:{ all -> 0x0082 }
            r8.append(r6)     // Catch:{ all -> 0x0082 }
            java.lang.String r6 = " ms. JS engine session reference status(onEngLoadedTimeout) is "
            r8.append(r6)     // Catch:{ all -> 0x0082 }
            r8.append(r5)     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = ". Update status(onEngLoadedTimeout) is "
            r8.append(r5)     // Catch:{ all -> 0x0082 }
            r8.append(r1)     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = ". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is "
            r8.append(r5)     // Catch:{ all -> 0x0082 }
            r8.append(r7)     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = " ms. Total latency(onEngLoadedTimeout) is "
            r8.append(r5)     // Catch:{ all -> 0x0082 }
            r8.append(r2)     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = " ms. Rejecting."
            r8.append(r5)     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.ads.internal.util.zze.zza(r5)     // Catch:{ all -> 0x0082 }
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            return
        L_0x0080:
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            return
        L_0x0082:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbml.zzi(com.google.android.gms.internal.ads.zzbmk, com.google.android.gms.internal.ads.zzblg, java.util.ArrayList, long):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzaqs zzaqs, zzbmk zzbmk) {
        long currentTimeMillis = zzt.zzB().currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            zzblo zzblo = new zzblo(this.zzb, this.zzd, (zzaqs) null, (zza) null);
            zzblo.zzk(new zzblv(this, arrayList, currentTimeMillis, zzbmk, zzblo));
            zzblo.zzq("/jsLoaded", new zzblw(this, currentTimeMillis, zzbmk, zzblo));
            zzca zzca = new zzca();
            zzblx zzblx = new zzblx(this, (zzaqs) null, zzblo, zzca);
            zzca.zzb(zzblx);
            zzblo.zzq("/requestReload", zzblx);
            if (this.zzc.endsWith(".js")) {
                zzblo.zzh(this.zzc);
            } else if (this.zzc.startsWith("<html>")) {
                zzblo.zzf(this.zzc);
            } else {
                zzblo.zzg(this.zzc);
            }
            zzs.zza.postDelayed(new zzblz(this, zzbmk, zzblo, arrayList, currentTimeMillis), (long) ((Integer) zzba.zzc().zzb(zzbbm.zzd)).intValue());
        } catch (Throwable th) {
            zzbzr.zzh("Error creating webview.", th);
            zzt.zzo().zzu(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzbmk.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzblg zzblg) {
        if (zzblg.zzi()) {
            this.zzi = 1;
        }
    }
}
