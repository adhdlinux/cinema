package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzasy extends zzath {
    private final boolean zzi;

    public zzasy(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3) {
        super(zzart, "A7zcecnbEz2swWqo3WVKoAX31f8JEZNN1OTPmTjY02NSqN3cKNpjtt6CyXhCVvfg", "7m0w40FyWBTdaJl9AjXhb9wQqUd7oM1ZB0Gz0iv7tis=", zzanq, i2, 61);
        this.zzi = zzart.zzs();
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb(), Boolean.valueOf(this.zzi)})).longValue();
        synchronized (this.zze) {
            this.zze.zzE(longValue);
        }
    }
}
