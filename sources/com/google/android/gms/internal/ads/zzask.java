package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzask extends zzath {
    private final long zzi;

    public zzask(zzart zzart, String str, String str2, zzanq zzanq, long j2, int i2, int i3) {
        super(zzart, "NMP1pkZrrrrQ0P+ZBWjqO+z0j/WpBuzawmkUKjAkUeiPRyMNSyS1dkwhVpRyfOJm", "AZMD/mGrEYmMNAgrqG/aC8rQLooaM7BFn42uxO3SldA=", zzanq, i2, 25);
        this.zzi = j2;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzf.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zze) {
            this.zze.zzt(longValue);
            long j2 = this.zzi;
            if (j2 != 0) {
                this.zze.zzT(longValue - j2);
                this.zze.zzU(this.zzi);
            }
        }
    }
}
