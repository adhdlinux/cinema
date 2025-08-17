package com.google.android.gms.internal.ads;

public final class zzfsg extends zzfrv {
    Object[] zzd;
    private int zze;

    public zzfsg() {
        super(4);
    }

    public final /* bridge */ /* synthetic */ zzfrw zzb(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzfsg zzf(Object obj) {
        int length;
        obj.getClass();
        if (this.zzd == null || zzfsh.zzh(this.zzb) > (length = this.zzd.length)) {
            this.zzd = null;
            super.zza(obj);
            return this;
        }
        int hashCode = obj.hashCode();
        int zza = zzfru.zza(hashCode);
        while (true) {
            Object[] objArr = this.zzd;
            int i2 = zza & (length - 1);
            Object obj2 = objArr[i2];
            if (obj2 != null) {
                if (obj2.equals(obj)) {
                    break;
                }
                zza = i2 + 1;
            } else {
                objArr[i2] = obj;
                this.zze += hashCode;
                super.zza(obj);
                break;
            }
        }
        return this;
    }

    public final zzfsg zzg(Iterable iterable) {
        if (this.zzd != null) {
            for (Object zzf : iterable) {
                zzf(zzf);
            }
        } else {
            super.zzc(iterable);
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.google.android.gms.internal.ads.zzfts} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.internal.ads.zzfsh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.google.android.gms.internal.ads.zzfts} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.google.android.gms.internal.ads.zzfts} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfsh zzh() {
        /*
            r9 = this;
            int r0 = r9.zzb
            if (r0 == 0) goto L_0x0056
            r1 = 1
            if (r0 == r1) goto L_0x0048
            java.lang.Object[] r2 = r9.zzd
            if (r2 == 0) goto L_0x0034
            int r0 = com.google.android.gms.internal.ads.zzfsh.zzh(r0)
            java.lang.Object[] r2 = r9.zzd
            int r2 = r2.length
            if (r0 != r2) goto L_0x0034
            int r0 = r9.zzb
            java.lang.Object[] r2 = r9.zza
            int r3 = r2.length
            boolean r3 = com.google.android.gms.internal.ads.zzfsh.zzt(r0, r3)
            if (r3 == 0) goto L_0x0023
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r0)
        L_0x0023:
            r4 = r2
            com.google.android.gms.internal.ads.zzfts r0 = new com.google.android.gms.internal.ads.zzfts
            int r5 = r9.zze
            java.lang.Object[] r6 = r9.zzd
            int r2 = r6.length
            int r7 = r2 + -1
            int r8 = r9.zzb
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            goto L_0x0042
        L_0x0034:
            int r0 = r9.zzb
            java.lang.Object[] r2 = r9.zza
            com.google.android.gms.internal.ads.zzfsh r0 = com.google.android.gms.internal.ads.zzfsh.zzs(r0, r2)
            int r2 = r0.size()
            r9.zzb = r2
        L_0x0042:
            r9.zzc = r1
            r1 = 0
            r9.zzd = r1
            return r0
        L_0x0048:
            java.lang.Object[] r0 = r9.zza
            r1 = 0
            r0 = r0[r1]
            r0.getClass()
            com.google.android.gms.internal.ads.zzftz r1 = new com.google.android.gms.internal.ads.zzftz
            r1.<init>(r0)
            return r1
        L_0x0056:
            com.google.android.gms.internal.ads.zzfts r0 = com.google.android.gms.internal.ads.zzfts.zza
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfsg.zzh():com.google.android.gms.internal.ads.zzfsh");
    }

    zzfsg(int i2) {
        super(i2);
        this.zzd = new Object[zzfsh.zzh(i2)];
    }
}
