package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzasn extends zzath {
    private final zzaru zzi;

    public zzasn(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3, zzaru zzaru) {
        super(zzart, "gO/haGNVF7sBb6Dp7iKXhg7Swim1l/GlLybMc7sdMRAQTJzM+NV+MpiqlcqP3EHg", "3QFFvrLAbfvZBnCmYb/H5Zm44EsMhBJStIcWOORiyIo=", zzanq, i2, 85);
        this.zzi = zzaru;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long[] jArr = (long[]) this.zzf.invoke((Object) null, new Object[]{Long.valueOf(this.zzi.zzd()), Long.valueOf(this.zzi.zzh()), Long.valueOf(this.zzi.zzb()), Long.valueOf(this.zzi.zzf())});
        synchronized (this.zze) {
            this.zze.zzv(jArr[0]);
            this.zze.zzu(jArr[1]);
        }
    }
}
