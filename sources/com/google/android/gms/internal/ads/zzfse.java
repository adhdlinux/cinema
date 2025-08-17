package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzfse {
    Object[] zza;
    int zzb;
    zzfsd zzc;

    public zzfse() {
        this(4);
    }

    private final void zzd(int i2) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i3 = i2 + i2;
        if (i3 > length) {
            this.zza = Arrays.copyOf(objArr, zzfrw.zze(length, i3));
        }
    }

    public final zzfse zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzfqz.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i2 = this.zzb;
        int i3 = i2 + i2;
        objArr[i3] = obj;
        objArr[i3 + 1] = obj2;
        this.zzb = i2 + 1;
        return this;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfse zzb(java.lang.Iterable r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof java.util.Collection
            if (r0 == 0) goto L_0x000e
            int r0 = r2.zzb
            int r1 = r3.size()
            int r0 = r0 + r1
            r2.zzd(r0)
        L_0x000e:
            java.util.Iterator r3 = r3.iterator()
        L_0x0012:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.Object r0 = r0.getValue()
            r2.zza(r1, r0)
            goto L_0x0012
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfse.zzb(java.lang.Iterable):com.google.android.gms.internal.ads.zzfse");
    }

    public final zzfsf zzc() {
        zzfsd zzfsd = this.zzc;
        if (zzfsd == null) {
            zzftr zzj = zzftr.zzj(this.zzb, this.zza, this);
            zzfsd zzfsd2 = this.zzc;
            if (zzfsd2 == null) {
                return zzj;
            }
            throw zzfsd2.zza();
        }
        throw zzfsd.zza();
    }

    zzfse(int i2) {
        this.zza = new Object[(i2 + i2)];
        this.zzb = 0;
    }
}
