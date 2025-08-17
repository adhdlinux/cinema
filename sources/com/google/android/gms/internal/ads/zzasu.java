package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzasu extends zzath {
    private static volatile String zzi;
    private static final Object zzj = new Object();

    public zzasu(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3) {
        super(zzart, "2m6PXcXEiAGusXS1ajjgFu9K1U9p6obL/gDG6se9LFdmc45IuOdD+G2rJwfF1UCD", "fUXpTL496nlEwFWDjJss3QGGSMP1brRky/zh6LpetKA=", zzanq, i2, 1);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzB("E");
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (String) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzB(zzi);
        }
    }
}
