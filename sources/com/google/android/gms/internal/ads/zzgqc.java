package com.google.android.gms.internal.ads;

public class zzgqc {
    private static final zzgoy zzb = zzgoy.zza;
    protected volatile zzgqw zza;
    private volatile zzgoe zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgqc)) {
            return false;
        }
        zzgqc zzgqc = (zzgqc) obj;
        zzgqw zzgqw = this.zza;
        zzgqw zzgqw2 = zzgqc.zza;
        if (zzgqw == null && zzgqw2 == null) {
            return zzb().equals(zzgqc.zzb());
        }
        if (zzgqw != null && zzgqw2 != null) {
            return zzgqw.equals(zzgqw2);
        }
        if (zzgqw != null) {
            zzgqc.zzc(zzgqw.zzbf());
            return zzgqw.equals(zzgqc.zza);
        }
        zzc(zzgqw2.zzbf());
        return this.zza.equals(zzgqw2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzgoa) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzaz();
        }
        return 0;
    }

    public final zzgoe zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzgoe zzgoe = this.zzc;
                return zzgoe;
            }
            if (this.zza == null) {
                this.zzc = zzgoe.zzb;
            } else {
                this.zzc = this.zza.zzau();
            }
            zzgoe zzgoe2 = this.zzc;
            return zzgoe2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.ads.zzgqw r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzgqw r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzgqw r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzgpy -> 0x0011 }
            com.google.android.gms.internal.ads.zzgoe r0 = com.google.android.gms.internal.ads.zzgoe.zzb     // Catch:{ zzgpy -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzgpy -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzgoe r2 = com.google.android.gms.internal.ads.zzgoe.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqc.zzc(com.google.android.gms.internal.ads.zzgqw):void");
    }
}
