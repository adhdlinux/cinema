package com.google.android.gms.internal.cast;

public class zzsv {
    private static final zzrw zzb = zzrw.zza;
    protected volatile zztp zza;
    private volatile zzrm zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzsv)) {
            return false;
        }
        zzsv zzsv = (zzsv) obj;
        zztp zztp = this.zza;
        zztp zztp2 = zzsv.zza;
        if (zztp == null && zztp2 == null) {
            return zzb().equals(zzsv.zzb());
        }
        if (zztp != null && zztp2 != null) {
            return zztp.equals(zztp2);
        }
        if (zztp != null) {
            zzsv.zzc(zztp.zzs());
            return zztp.equals(zzsv.zza);
        }
        zzc(zztp2.zzs());
        return this.zza.equals(zztp2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzrj) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzt();
        }
        return 0;
    }

    public final zzrm zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzrm zzrm = this.zzc;
                return zzrm;
            }
            if (this.zza == null) {
                this.zzc = zzrm.zzb;
            } else {
                this.zzc = this.zza.zzq();
            }
            zzrm zzrm2 = this.zzc;
            return zzrm2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.cast.zztp r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.cast.zztp r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.cast.zztp r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzss -> 0x0011 }
            com.google.android.gms.internal.cast.zzrm r0 = com.google.android.gms.internal.cast.zzrm.zzb     // Catch:{ zzss -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzss -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.cast.zzrm r2 = com.google.android.gms.internal.cast.zzrm.zzb     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzsv.zzc(com.google.android.gms.internal.cast.zztp):void");
    }
}
