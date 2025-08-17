package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzw;
import java.util.concurrent.Executor;

public abstract class zzeuv implements zzekc {
    protected final zzcgu zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public final zzevl zzd;
    /* access modifiers changed from: private */
    public final zzexe zze;
    private final zzbzx zzf;
    private final ViewGroup zzg;
    /* access modifiers changed from: private */
    public final zzfgb zzh;
    private final zzfag zzi;
    /* access modifiers changed from: private */
    public zzfwm zzj;

    protected zzeuv(Context context, Executor executor, zzcgu zzcgu, zzexe zzexe, zzevl zzevl, zzfag zzfag, zzbzx zzbzx) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcgu;
        this.zze = zzexe;
        this.zzd = zzevl;
        this.zzi = zzfag;
        this.zzf = zzbzx;
        this.zzg = new FrameLayout(context);
        this.zzh = zzcgu.zzy();
    }

    /* access modifiers changed from: private */
    public final synchronized zzcum zzm(zzexc zzexc) {
        zzeuu zzeuu = (zzeuu) zzexc;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzhK)).booleanValue()) {
            zzcoy zzcoy = new zzcoy(this.zzg);
            zzcuo zzcuo = new zzcuo();
            zzcuo.zze(this.zzb);
            zzcuo.zzi(zzeuu.zza);
            zzcuq zzj2 = zzcuo.zzj();
            zzdar zzdar = new zzdar();
            zzdar.zzc(this.zzd, this.zzc);
            zzdar.zzl(this.zzd, this.zzc);
            return zze(zzcoy, zzj2, zzdar.zzn());
        }
        zzevl zzi2 = zzevl.zzi(this.zzd);
        zzdar zzdar2 = new zzdar();
        zzdar2.zzb(zzi2, this.zzc);
        zzdar2.zzg(zzi2, this.zzc);
        zzdar2.zzh(zzi2, this.zzc);
        zzdar2.zzi(zzi2, this.zzc);
        zzdar2.zzc(zzi2, this.zzc);
        zzdar2.zzl(zzi2, this.zzc);
        zzdar2.zzm(zzi2);
        zzcoy zzcoy2 = new zzcoy(this.zzg);
        zzcuo zzcuo2 = new zzcuo();
        zzcuo2.zze(this.zzb);
        zzcuo2.zzi(zzeuu.zza);
        return zze(zzcoy2, zzcuo2.zzj(), zzdar2.zzn());
    }

    public final boolean zza() {
        zzfwm zzfwm = this.zzj;
        return zzfwm != null && !zzfwm.isDone();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056 A[SYNTHETIC, Splitter:B:16:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzb(com.google.android.gms.ads.internal.client.zzl r8, java.lang.String r9, com.google.android.gms.internal.ads.zzeka r10, com.google.android.gms.internal.ads.zzekb r11) throws android.os.RemoteException {
        /*
            r7 = this;
            monitor-enter(r7)
            com.google.android.gms.internal.ads.zzbcr r10 = com.google.android.gms.internal.ads.zzbdd.zzd     // Catch:{ all -> 0x00f4 }
            java.lang.Object r10 = r10.zze()     // Catch:{ all -> 0x00f4 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00f4 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00f4 }
            r0 = 1
            r1 = 0
            if (r10 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzbbe r10 = com.google.android.gms.internal.ads.zzbbm.zzjJ     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00f4 }
            java.lang.Object r10 = r2.zzb(r10)     // Catch:{ all -> 0x00f4 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00f4 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00f4 }
            if (r10 == 0) goto L_0x0025
            r10 = 1
            goto L_0x0026
        L_0x0025:
            r10 = 0
        L_0x0026:
            com.google.android.gms.internal.ads.zzbzx r2 = r7.zzf     // Catch:{ all -> 0x00f4 }
            int r2 = r2.zzc     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zzjK     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzbbk r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00f4 }
            java.lang.Object r3 = r4.zzb(r3)     // Catch:{ all -> 0x00f4 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x00f4 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x00f4 }
            if (r2 < r3) goto L_0x003e
            if (r10 != 0) goto L_0x0043
        L_0x003e:
            java.lang.String r10 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r10)     // Catch:{ all -> 0x00f4 }
        L_0x0043:
            if (r9 != 0) goto L_0x0056
            java.lang.String r8 = "Ad unit ID should not be null for app open ad."
            com.google.android.gms.internal.ads.zzbzr.zzg(r8)     // Catch:{ all -> 0x00f4 }
            java.util.concurrent.Executor r8 = r7.zzc     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzeup r9 = new com.google.android.gms.internal.ads.zzeup     // Catch:{ all -> 0x00f4 }
            r9.<init>(r7)     // Catch:{ all -> 0x00f4 }
            r8.execute(r9)     // Catch:{ all -> 0x00f4 }
            monitor-exit(r7)
            return r1
        L_0x0056:
            com.google.android.gms.internal.ads.zzfwm r10 = r7.zzj     // Catch:{ all -> 0x00f4 }
            if (r10 == 0) goto L_0x005c
            monitor-exit(r7)
            return r1
        L_0x005c:
            com.google.android.gms.internal.ads.zzbcr r10 = com.google.android.gms.internal.ads.zzbcy.zzc     // Catch:{ all -> 0x00f4 }
            java.lang.Object r10 = r10.zze()     // Catch:{ all -> 0x00f4 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00f4 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00f4 }
            r1 = 7
            r2 = 0
            if (r10 == 0) goto L_0x0088
            com.google.android.gms.internal.ads.zzexe r10 = r7.zze     // Catch:{ all -> 0x00f4 }
            java.lang.Object r3 = r10.zzd()     // Catch:{ all -> 0x00f4 }
            if (r3 == 0) goto L_0x0088
            java.lang.Object r10 = r10.zzd()     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzcol r10 = (com.google.android.gms.internal.ads.zzcol) r10     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzffy r10 = r10.zzh()     // Catch:{ all -> 0x00f4 }
            r10.zzh(r1)     // Catch:{ all -> 0x00f4 }
            java.lang.String r3 = r8.zzp     // Catch:{ all -> 0x00f4 }
            r10.zzb(r3)     // Catch:{ all -> 0x00f4 }
            r4 = r10
            goto L_0x0089
        L_0x0088:
            r4 = r2
        L_0x0089:
            android.content.Context r10 = r7.zzb     // Catch:{ all -> 0x00f4 }
            boolean r3 = r8.zzf     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzfbc.zza(r10, r3)     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzbbe r10 = com.google.android.gms.internal.ads.zzbbm.zziu     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzbbk r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00f4 }
            java.lang.Object r10 = r3.zzb(r10)     // Catch:{ all -> 0x00f4 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00f4 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00f4 }
            if (r10 == 0) goto L_0x00af
            boolean r10 = r8.zzf     // Catch:{ all -> 0x00f4 }
            if (r10 == 0) goto L_0x00af
            com.google.android.gms.internal.ads.zzcgu r10 = r7.zza     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzdsx r10 = r10.zzj()     // Catch:{ all -> 0x00f4 }
            r10.zzm(r0)     // Catch:{ all -> 0x00f4 }
        L_0x00af:
            com.google.android.gms.internal.ads.zzfag r10 = r7.zzi     // Catch:{ all -> 0x00f4 }
            r10.zzs(r9)     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.ads.internal.client.zzq r9 = com.google.android.gms.ads.internal.client.zzq.zzb()     // Catch:{ all -> 0x00f4 }
            r10.zzr(r9)     // Catch:{ all -> 0x00f4 }
            r10.zzE(r8)     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzfai r9 = r10.zzG()     // Catch:{ all -> 0x00f4 }
            android.content.Context r10 = r7.zzb     // Catch:{ all -> 0x00f4 }
            int r3 = com.google.android.gms.internal.ads.zzffx.zzf(r9)     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzffn r5 = com.google.android.gms.internal.ads.zzffm.zzb(r10, r3, r1, r8)     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzeuu r6 = new com.google.android.gms.internal.ads.zzeuu     // Catch:{ all -> 0x00f4 }
            r6.<init>(r2)     // Catch:{ all -> 0x00f4 }
            r6.zza = r9     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzexe r8 = r7.zze     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzexf r9 = new com.google.android.gms.internal.ads.zzexf     // Catch:{ all -> 0x00f4 }
            r9.<init>(r6, r2)     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzeuq r10 = new com.google.android.gms.internal.ads.zzeuq     // Catch:{ all -> 0x00f4 }
            r10.<init>(r7)     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzfwm r8 = r8.zzc(r9, r10, r2)     // Catch:{ all -> 0x00f4 }
            r7.zzj = r8     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzeus r9 = new com.google.android.gms.internal.ads.zzeus     // Catch:{ all -> 0x00f4 }
            r1 = r9
            r2 = r7
            r3 = r11
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00f4 }
            java.util.concurrent.Executor r10 = r7.zzc     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.ads.zzfwc.zzq(r8, r9, r10)     // Catch:{ all -> 0x00f4 }
            monitor-exit(r7)
            return r0
        L_0x00f4:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeuv.zzb(com.google.android.gms.ads.internal.client.zzl, java.lang.String, com.google.android.gms.internal.ads.zzeka, com.google.android.gms.internal.ads.zzekb):boolean");
    }

    /* access modifiers changed from: protected */
    public abstract zzcum zze(zzcoy zzcoy, zzcuq zzcuq, zzdat zzdat);

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        this.zzd.zza(zzfbi.zzd(6, (String) null, (zze) null));
    }

    public final void zzl(zzw zzw) {
        this.zzi.zzt(zzw);
    }
}
