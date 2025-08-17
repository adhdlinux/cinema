package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.facebook.common.time.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zznw implements zzoa {
    public static final zzfpx zza = zznu.zza;
    private static final Random zzb = new Random();
    /* access modifiers changed from: private */
    public final zzcv zzc;
    /* access modifiers changed from: private */
    public final zzct zzd;
    private final HashMap zze;
    private final zzfpx zzf;
    private zznz zzg;
    private zzcw zzh;
    private String zzi;

    public zznw() {
        throw null;
    }

    private final zznv zzk(int i2, zzto zzto) {
        int i3;
        long j2 = Clock.MAX_TIME;
        zznv zznv = null;
        for (zznv zznv2 : this.zze.values()) {
            zznv2.zzg(i2, zzto);
            if (zznv2.zzj(i2, zzto)) {
                long zzb2 = zznv2.zzd;
                if (zzb2 == -1 || zzb2 < j2) {
                    zznv = zznv2;
                    j2 = zzb2;
                } else if (i3 == 0) {
                    int i4 = zzfj.zza;
                    if (!(zznv.zze == null || zznv2.zze == null)) {
                        zznv = zznv2;
                    }
                }
            }
        }
        if (zznv != null) {
            return zznv;
        }
        String zzl = zzl();
        zznv zznv3 = new zznv(this, zzl, i2, zzto);
        this.zze.put(zzl, zznv3);
        return zznv3;
    }

    /* access modifiers changed from: private */
    public static String zzl() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @RequiresNonNull({"listener"})
    private final void zzm(zzlt zzlt) {
        if (zzlt.zzb.zzo()) {
            this.zzi = null;
            return;
        }
        zznv zznv = (zznv) this.zze.get(this.zzi);
        zznv zzk = zzk(zzlt.zzc, zzlt.zzd);
        this.zzi = zzk.zzb;
        zzh(zzlt);
        zzto zzto = zzlt.zzd;
        if (zzto != null && zzto.zzb()) {
            if (zznv == null || zznv.zzd != zzlt.zzd.zzd || zznv.zze == null || zznv.zze.zzb != zzlt.zzd.zzb || zznv.zze.zzc != zzlt.zzd.zzc) {
                zzto zzto2 = zzlt.zzd;
                String unused = zzk(zzlt.zzc, new zzto(zzto2.zza, zzto2.zzd)).zzb;
                String unused2 = zzk.zzb;
            }
        }
    }

    public final synchronized String zzd() {
        return this.zzi;
    }

    public final synchronized String zze(zzcw zzcw, zzto zzto) {
        return zzk(zzcw.zzn(zzto.zza, this.zzd).zzd, zzto).zzb;
    }

    public final synchronized void zzf(zzlt zzlt) {
        zznz zznz;
        this.zzi = null;
        Iterator it2 = this.zze.values().iterator();
        while (it2.hasNext()) {
            zznv zznv = (zznv) it2.next();
            it2.remove();
            if (zznv.zzf && (zznz = this.zzg) != null) {
                zznz.zzd(zzlt, zznv.zzb, false);
            }
        }
    }

    public final void zzg(zznz zznz) {
        this.zzg = zznz;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        if (r8.zzd.zzd < com.google.android.gms.internal.ads.zznv.zzb(r0)) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzh(com.google.android.gms.internal.ads.zzlt r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.google.android.gms.internal.ads.zznz r0 = r7.zzg     // Catch:{ all -> 0x00c5 }
            r0.getClass()
            com.google.android.gms.internal.ads.zzcw r0 = r8.zzb     // Catch:{ all -> 0x00c5 }
            boolean r0 = r0.zzo()     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x0010
            monitor-exit(r7)
            return
        L_0x0010:
            java.util.HashMap r0 = r7.zze     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = r7.zzi     // Catch:{ all -> 0x00c5 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zznv r0 = (com.google.android.gms.internal.ads.zznv) r0     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzto r1 = r8.zzd     // Catch:{ all -> 0x00c5 }
            if (r1 == 0) goto L_0x0041
            if (r0 == 0) goto L_0x0041
            long r1 = r0.zzd     // Catch:{ all -> 0x00c5 }
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0033
            int r0 = r0.zzc     // Catch:{ all -> 0x00c5 }
            int r1 = r8.zzc     // Catch:{ all -> 0x00c5 }
            if (r0 != r1) goto L_0x003f
            goto L_0x0041
        L_0x0033:
            com.google.android.gms.internal.ads.zzto r1 = r8.zzd     // Catch:{ all -> 0x00c5 }
            long r1 = r1.zzd     // Catch:{ all -> 0x00c5 }
            long r3 = r0.zzd     // Catch:{ all -> 0x00c5 }
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0041
        L_0x003f:
            monitor-exit(r7)
            return
        L_0x0041:
            int r0 = r8.zzc     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzto r1 = r8.zzd     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zznv r0 = r7.zzk(r0, r1)     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = r7.zzi     // Catch:{ all -> 0x00c5 }
            if (r1 != 0) goto L_0x0053
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00c5 }
            r7.zzi = r1     // Catch:{ all -> 0x00c5 }
        L_0x0053:
            com.google.android.gms.internal.ads.zzto r1 = r8.zzd     // Catch:{ all -> 0x00c5 }
            r2 = 1
            if (r1 == 0) goto L_0x0097
            boolean r3 = r1.zzb()     // Catch:{ all -> 0x00c5 }
            if (r3 == 0) goto L_0x0097
            com.google.android.gms.internal.ads.zzto r3 = new com.google.android.gms.internal.ads.zzto     // Catch:{ all -> 0x00c5 }
            java.lang.Object r4 = r1.zza     // Catch:{ all -> 0x00c5 }
            long r5 = r1.zzd     // Catch:{ all -> 0x00c5 }
            int r1 = r1.zzb     // Catch:{ all -> 0x00c5 }
            r3.<init>(r4, r5, r1)     // Catch:{ all -> 0x00c5 }
            int r1 = r8.zzc     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zznv r1 = r7.zzk(r1, r3)     // Catch:{ all -> 0x00c5 }
            boolean r3 = r1.zzf     // Catch:{ all -> 0x00c5 }
            if (r3 != 0) goto L_0x0097
            r1.zzf = true     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzcw r3 = r8.zzb     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzto r4 = r8.zzd     // Catch:{ all -> 0x00c5 }
            java.lang.Object r4 = r4.zza     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzct r5 = r7.zzd     // Catch:{ all -> 0x00c5 }
            r3.zzn(r4, r5)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzct r3 = r7.zzd     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzto r4 = r8.zzd     // Catch:{ all -> 0x00c5 }
            int r4 = r4.zzb     // Catch:{ all -> 0x00c5 }
            r3.zzi(r4)     // Catch:{ all -> 0x00c5 }
            r3 = 0
            com.google.android.gms.internal.ads.zzfj.zzq(r3)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzfj.zzq(r3)     // Catch:{ all -> 0x00c5 }
            java.lang.String unused = r1.zzb     // Catch:{ all -> 0x00c5 }
        L_0x0097:
            boolean r1 = r0.zzf     // Catch:{ all -> 0x00c5 }
            if (r1 != 0) goto L_0x00a3
            r0.zzf = true     // Catch:{ all -> 0x00c5 }
            java.lang.String unused = r0.zzb     // Catch:{ all -> 0x00c5 }
        L_0x00a3:
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r7.zzi     // Catch:{ all -> 0x00c5 }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x00c5 }
            if (r1 == 0) goto L_0x00c3
            boolean r1 = r0.zzg     // Catch:{ all -> 0x00c5 }
            if (r1 != 0) goto L_0x00c3
            r0.zzg = true     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.ads.zznz r1 = r7.zzg     // Catch:{ all -> 0x00c5 }
            java.lang.String r0 = r0.zzb     // Catch:{ all -> 0x00c5 }
            r1.zzc(r8, r0)     // Catch:{ all -> 0x00c5 }
            monitor-exit(r7)
            return
        L_0x00c3:
            monitor-exit(r7)
            return
        L_0x00c5:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznw.zzh(com.google.android.gms.internal.ads.zzlt):void");
    }

    public final synchronized void zzi(zzlt zzlt, int i2) {
        this.zzg.getClass();
        Iterator it2 = this.zze.values().iterator();
        while (it2.hasNext()) {
            zznv zznv = (zznv) it2.next();
            if (zznv.zzk(zzlt)) {
                it2.remove();
                if (zznv.zzf) {
                    boolean equals = zznv.zzb.equals(this.zzi);
                    boolean z2 = false;
                    if (i2 == 0 && equals && zznv.zzg) {
                        z2 = true;
                    }
                    if (equals) {
                        this.zzi = null;
                    }
                    this.zzg.zzd(zzlt, zznv.zzb, z2);
                }
            }
        }
        zzm(zzlt);
    }

    public final synchronized void zzj(zzlt zzlt) {
        this.zzg.getClass();
        zzcw zzcw = this.zzh;
        this.zzh = zzlt.zzb;
        Iterator it2 = this.zze.values().iterator();
        while (it2.hasNext()) {
            zznv zznv = (zznv) it2.next();
            if (!zznv.zzl(zzcw, this.zzh) || zznv.zzk(zzlt)) {
                it2.remove();
                if (zznv.zzf) {
                    if (zznv.zzb.equals(this.zzi)) {
                        this.zzi = null;
                    }
                    this.zzg.zzd(zzlt, zznv.zzb, false);
                }
            }
        }
        zzm(zzlt);
    }

    public zznw(zzfpx zzfpx) {
        this.zzf = zzfpx;
        this.zzc = new zzcv();
        this.zzd = new zzct();
        this.zze = new HashMap();
        this.zzh = zzcw.zza;
    }
}
