package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzasi extends zzath {
    public zzasi(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3) {
        super(zzart, "61r5RjlUpp0Sx9otiMiZNQFewfAHPXct4XNb20i2Qy085lteyha1wknNg1lweS6E", "BxKk+MigL5QcJoHkNRs0ALc6QE50Izh8oVpecosSZ5s=", zzanq, i2, 5);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzm(-1);
        this.zze.zzl(-1);
        int[] iArr = (int[]) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()});
        synchronized (this.zze) {
            this.zze.zzm((long) iArr[0]);
            this.zze.zzl((long) iArr[1]);
            int i2 = iArr[2];
            if (i2 != Integer.MIN_VALUE) {
                this.zze.zzk((long) i2);
            }
        }
    }
}
