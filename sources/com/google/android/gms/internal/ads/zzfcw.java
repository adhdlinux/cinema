package com.google.android.gms.internal.ads;

public final class zzfcw {
    private final zzfcp zza;
    private final zzfwm zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfcw(zzfbu zzfbu, zzfco zzfco, zzfcp zzfcp) {
        this.zza = zzfcp;
        this.zzb = zzfwc.zzf(zzfwc.zzm(zzfco.zza(zzfcp), new zzfcu(this, zzfco, zzfbu, zzfcp), zzfcp.zzb()), Exception.class, new zzfcv(this, zzfco), zzfcp.zzb());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzfwm zza(com.google.android.gms.internal.ads.zzfcp r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzd     // Catch:{ all -> 0x0035 }
            r1 = 0
            if (r0 != 0) goto L_0x0033
            boolean r0 = r2.zzc     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x000b
            goto L_0x0033
        L_0x000b:
            com.google.android.gms.internal.ads.zzfcp r0 = r2.zza     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfce r0 = r0.zza()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzfce r0 = r3.zza()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzfcp r0 = r2.zza     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfce r0 = r0.zza()     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfce r3 = r3.zza()     // Catch:{ all -> 0x0035 }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x002a
            goto L_0x0031
        L_0x002a:
            r3 = 1
            r2.zzc = r3     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfwm r3 = r2.zzb     // Catch:{ all -> 0x0035 }
            monitor-exit(r2)
            return r3
        L_0x0031:
            monitor-exit(r2)
            return r1
        L_0x0033:
            monitor-exit(r2)
            return r1
        L_0x0035:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfcw.zza(com.google.android.gms.internal.ads.zzfcp):com.google.android.gms.internal.ads.zzfwm");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(zzfco zzfco, zzfbu zzfbu, zzfcp zzfcp, zzfcd zzfcd) throws Exception {
        synchronized (this) {
            this.zzd = true;
            zzfco.zzb(zzfcd);
            if (!this.zzc) {
                zzfbu.zzd(zzfcp.zza(), zzfcd);
                zzfwm zzh = zzfwc.zzh((Object) null);
                return zzh;
            }
            zzfwm zzh2 = zzfwc.zzh(new zzfcn(zzfcd, zzfcp));
            return zzh2;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(zzfco zzfco, Exception exc) throws Exception {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }

    public final synchronized void zzd(zzfvy zzfvy) {
        zzfwc.zzq(zzfwc.zzm(this.zzb, zzfct.zza, this.zza.zzb()), zzfvy, this.zza.zzb());
    }
}
