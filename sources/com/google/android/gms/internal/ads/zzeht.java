package com.google.android.gms.internal.ads;

public final class zzeht implements zzecc {
    private final zzbck zza;
    private final zzfwn zzb;
    private final zzfel zzc;
    /* access modifiers changed from: private */
    public final zzeic zzd;

    public zzeht(zzfel zzfel, zzfwn zzfwn, zzbck zzbck, zzeic zzeic) {
        this.zzc = zzfel;
        this.zzb = zzfwn;
        this.zza = zzbck;
        this.zzd = zzeic;
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn) {
        zzcaj zzcaj = new zzcaj();
        zzehy zzehy = new zzehy();
        zzehy.zzd(new zzehs(this, zzcaj, zzezz, zzezn, zzehy));
        zzezs zzezs = zzezn.zzt;
        zzbcf zzbcf = new zzbcf(zzehy, zzezs.zzb, zzezs.zza);
        zzfel zzfel = this.zzc;
        return zzfdv.zzd(new zzehr(this, zzbcf), this.zzb, zzfef.CUSTOM_RENDER_SYN, zzfel).zzb(zzfef.CUSTOM_RENDER_ACK).zzd(zzcaj).zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzt;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzezz r1, com.google.android.gms.internal.ads.zzezn r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbck r1 = r0.zza
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzezs r1 = r2.zzt
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zza
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeht.zzb(com.google.android.gms.internal.ads.zzezz, com.google.android.gms.internal.ads.zzezn):boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbcf zzbcf) throws Exception {
        this.zza.zze(zzbcf);
    }
}
