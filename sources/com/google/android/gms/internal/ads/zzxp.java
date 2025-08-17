package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzxp {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzxi[] zzd = new zzxi[100];

    public zzxp(boolean z2, int i2) {
    }

    public final synchronized int zza() {
        return this.zzb * 65536;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzxi zzb() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.zzb     // Catch:{ all -> 0x0038 }
            int r0 = r0 + 1
            r4.zzb = r0     // Catch:{ all -> 0x0038 }
            int r0 = r4.zzc     // Catch:{ all -> 0x0038 }
            if (r0 <= 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzxi[] r1 = r4.zzd     // Catch:{ all -> 0x0038 }
            int r0 = r0 + -1
            r4.zzc = r0     // Catch:{ all -> 0x0038 }
            r2 = r1[r0]     // Catch:{ all -> 0x0038 }
            r2.getClass()
            r3 = 0
            r1[r0] = r3     // Catch:{ all -> 0x0038 }
            goto L_0x002b
        L_0x001a:
            com.google.android.gms.internal.ads.zzxi r2 = new com.google.android.gms.internal.ads.zzxi     // Catch:{ all -> 0x0038 }
            r0 = 65536(0x10000, float:9.18355E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0038 }
            r1 = 0
            r2.<init>(r0, r1)     // Catch:{ all -> 0x0038 }
            int r0 = r4.zzb     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.ads.zzxi[] r1 = r4.zzd     // Catch:{ all -> 0x0038 }
            int r3 = r1.length     // Catch:{ all -> 0x0038 }
            if (r0 > r3) goto L_0x002d
        L_0x002b:
            monitor-exit(r4)
            return r2
        L_0x002d:
            int r3 = r3 + r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r3)     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.ads.zzxi[] r0 = (com.google.android.gms.internal.ads.zzxi[]) r0     // Catch:{ all -> 0x0038 }
            r4.zzd = r0     // Catch:{ all -> 0x0038 }
            monitor-exit(r4)
            return r2
        L_0x0038:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxp.zzb():com.google.android.gms.internal.ads.zzxi");
    }

    public final synchronized void zzc(zzxi zzxi) {
        zzxi[] zzxiArr = this.zzd;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        zzxiArr[i2] = zzxi;
        this.zzb--;
        notifyAll();
    }

    public final synchronized void zzd(zzxj zzxj) {
        while (zzxj != null) {
            zzxi[] zzxiArr = this.zzd;
            int i2 = this.zzc;
            this.zzc = i2 + 1;
            zzxiArr[i2] = zzxj.zzc();
            this.zzb--;
            zzxj = zzxj.zzd();
        }
        notifyAll();
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i2) {
        int i3 = this.zza;
        this.zza = i2;
        if (i2 < i3) {
            zzg();
        }
    }

    public final synchronized void zzg() {
        int i2 = this.zza;
        int i3 = zzfj.zza;
        int max = Math.max(0, ((i2 + 65535) / 65536) - this.zzb);
        int i4 = this.zzc;
        if (max < i4) {
            Arrays.fill(this.zzd, max, i4, (Object) null);
            this.zzc = max;
        }
    }
}
