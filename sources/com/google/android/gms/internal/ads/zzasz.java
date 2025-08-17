package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzasz extends zzath {
    private final StackTraceElement[] zzi;

    public zzasz(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3, StackTraceElement[] stackTraceElementArr) {
        super(zzart, "qzPpYppPAZhPHZoGToPEj4gLCkf1GlGnviIXlGI2ic/egZu+qobDN2aG3wSrxpBD", "7Q6sBeEdJYI+qvX8cIFUZRRQ8J+ckQm34FYdYCYSS2Q=", zzanq, i2, 45);
        this.zzi = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        Object obj = this.zzi;
        if (obj != null) {
            int i2 = 1;
            zzark zzark = new zzark((String) this.zzf.invoke((Object) null, new Object[]{obj}));
            synchronized (this.zze) {
                this.zze.zzF(zzark.zza.longValue());
                if (zzark.zzb.booleanValue()) {
                    zzanq zzanq = this.zze;
                    if (true != zzark.zzc.booleanValue()) {
                        i2 = 2;
                    }
                    zzanq.zzac(i2);
                } else {
                    this.zze.zzac(3);
                }
            }
        }
    }
}
