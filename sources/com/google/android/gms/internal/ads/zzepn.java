package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzepn implements zzeqy {
    private final Context zza;
    private final zzfwn zzb;
    private final zzfai zzc;
    private final zzbzx zzd;

    zzepn(Context context, zzfwn zzfwn, zzfai zzfai, zzbzx zzbzx) {
        this.zza = context;
        this.zzb = zzfwn;
        this.zzc = zzfai;
        this.zzd = zzbzx;
    }

    public final int zza() {
        return 53;
    }

    public final zzfwm zzb() {
        return this.zzb.zzb(new zzepm(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0054, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzcE)).booleanValue() != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
        r1 = com.google.android.gms.internal.ads.zzfmh.zzj(r0).zzh(((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzcP)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzh().zzP());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00bb, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzcD)).booleanValue() == false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cf, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzcF)).booleanValue() != false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d1, code lost:
        r0 = com.google.android.gms.internal.ads.zzfmi.zzi(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e9, code lost:
        if (r8.zzd.zzc < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzcM)).intValue()) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00eb, code lost:
        r2 = r0.zzh(((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzcQ)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzh().zzP());
        r3 = r0.zzo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x010f, code lost:
        r6 = r0.zzp();
        r4 = r2;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzcC)).booleanValue() == false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzepo zzc() throws java.lang.Exception {
        /*
            r8 = this;
            android.content.Context r0 = r8.zza     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzfai r1 = r8.zzc     // Catch:{ IOException -> 0x0122 }
            boolean r7 = r1.zzb()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzfme r1 = new com.google.android.gms.internal.ads.zzfme     // Catch:{ IOException -> 0x0122 }
            r1.<init>()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzfme r2 = new com.google.android.gms.internal.ads.zzfme     // Catch:{ IOException -> 0x0122 }
            r2.<init>()     // Catch:{ IOException -> 0x0122 }
            r3 = 1
            if (r7 == 0) goto L_0x002e
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzcG     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbk r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 != 0) goto L_0x002e
            com.google.android.gms.internal.ads.zzepo r0 = new com.google.android.gms.internal.ads.zzepo     // Catch:{ IOException -> 0x0122 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0122 }
            goto L_0x0121
        L_0x002e:
            if (r7 != 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzcC     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbk r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 != 0) goto L_0x0056
        L_0x0042:
            if (r7 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzcE     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbk r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 == 0) goto L_0x007a
        L_0x0056:
            com.google.android.gms.internal.ads.zzfmh r1 = com.google.android.gms.internal.ads.zzfmh.zzj(r0)     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzcP     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbk r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ IOException -> 0x0122 }
            long r4 = r4.longValue()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbza r6 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.ads.internal.util.zzg r6 = r6.zzh()     // Catch:{ IOException -> 0x0122 }
            boolean r6 = r6.zzP()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzfme r1 = r1.zzh(r4, r6)     // Catch:{ IOException -> 0x0122 }
        L_0x007a:
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzcN     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbk r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 == 0) goto L_0x00a9
            com.google.android.gms.internal.ads.zzbzx r4 = r8.zzd     // Catch:{ IOException -> 0x0122 }
            int r4 = r4.zzc     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbe r5 = com.google.android.gms.internal.ads.zzbbm.zzcM     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbk r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r5 = r6.zzb(r5)     // Catch:{ IOException -> 0x0122 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IOException -> 0x0122 }
            int r5 = r5.intValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 >= r5) goto L_0x00a9
            com.google.android.gms.internal.ads.zzfmi r4 = com.google.android.gms.internal.ads.zzfmi.zzi(r0)     // Catch:{ IOException -> 0x0122 }
            r4.zzj()     // Catch:{ IOException -> 0x0122 }
        L_0x00a9:
            if (r7 != 0) goto L_0x00bd
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzcD     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbk r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 != 0) goto L_0x00d1
        L_0x00bd:
            if (r7 == 0) goto L_0x0117
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzcF     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbk r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 == 0) goto L_0x0117
        L_0x00d1:
            com.google.android.gms.internal.ads.zzfmi r0 = com.google.android.gms.internal.ads.zzfmi.zzi(r0)     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbzx r4 = r8.zzd     // Catch:{ IOException -> 0x0122 }
            int r4 = r4.zzc     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbe r5 = com.google.android.gms.internal.ads.zzbbm.zzcM     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbk r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r5 = r6.zzb(r5)     // Catch:{ IOException -> 0x0122 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IOException -> 0x0122 }
            int r5 = r5.intValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 < r5) goto L_0x010f
            com.google.android.gms.internal.ads.zzbbe r2 = com.google.android.gms.internal.ads.zzbbm.zzcQ     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbk r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r2 = r3.zzb(r2)     // Catch:{ IOException -> 0x0122 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x0122 }
            long r2 = r2.longValue()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbza r4 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.ads.internal.util.zzg r4 = r4.zzh()     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.zzP()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzfme r2 = r0.zzh(r2, r4)     // Catch:{ IOException -> 0x0122 }
            boolean r3 = r0.zzo()     // Catch:{ IOException -> 0x0122 }
        L_0x010f:
            boolean r0 = r0.zzp()     // Catch:{ IOException -> 0x0122 }
            r6 = r0
            r4 = r2
            r5 = r3
            goto L_0x011a
        L_0x0117:
            r4 = r2
            r5 = 1
            r6 = 1
        L_0x011a:
            com.google.android.gms.internal.ads.zzepo r0 = new com.google.android.gms.internal.ads.zzepo     // Catch:{ IOException -> 0x0122 }
            r2 = r0
            r3 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x0122 }
        L_0x0121:
            return r0
        L_0x0122:
            r0 = move-exception
            java.lang.String r1 = "PerAppIdSignal"
            com.google.android.gms.internal.ads.zzbza r2 = com.google.android.gms.ads.internal.zzt.zzo()
            r2.zzu(r0, r1)
            com.google.android.gms.internal.ads.zzepo r0 = new com.google.android.gms.internal.ads.zzepo
            com.google.android.gms.internal.ads.zzfai r1 = r8.zzc
            boolean r1 = r1.zzb()
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepn.zzc():com.google.android.gms.internal.ads.zzepo");
    }
}
