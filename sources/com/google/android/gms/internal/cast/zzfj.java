package com.google.android.gms.internal.cast;

import java.util.Arrays;

public final class zzfj {
    Object[] zza;
    int zzb;
    zzfi zzc;

    public zzfj() {
        this(4);
    }

    private final void zzb(int i2) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i3 = i2 + i2;
        if (i3 > length) {
            this.zza = Arrays.copyOf(objArr, zzfc.zza(length, i3));
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.cast.zzfj zza(java.lang.Iterable r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L_0x000e
            int r0 = r5.zzb
            int r1 = r6.size()
            int r0 = r0 + r1
            r5.zzb(r0)
        L_0x000e:
            java.util.Iterator r6 = r6.iterator()
        L_0x0012:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0041
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.Object r0 = r0.getValue()
            int r2 = r5.zzb
            int r2 = r2 + 1
            r5.zzb(r2)
            com.google.android.gms.internal.cast.zzey.zza(r1, r0)
            java.lang.Object[] r2 = r5.zza
            int r3 = r5.zzb
            int r4 = r3 + r3
            r2[r4] = r1
            int r4 = r4 + 1
            r2[r4] = r0
            int r3 = r3 + 1
            r5.zzb = r3
            goto L_0x0012
        L_0x0041:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzfj.zza(java.lang.Iterable):com.google.android.gms.internal.cast.zzfj");
    }

    zzfj(int i2) {
        this.zza = new Object[(i2 + i2)];
        this.zzb = 0;
    }
}
