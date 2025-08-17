package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzatb extends zzath {
    private final zzasa zzi;
    private long zzj;

    public zzatb(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3, zzasa zzasa) {
        super(zzart, "PS6o831i8V9Lqz6DDKDQ5j6oWxrwGrfC/yamzdSOhnJm7ZWz/0eC/urrTkyk/1l+", "xYPp9mA9NiiAUtoW1mf06CeivM3OQ2f/EXuQXBQemfo=", zzanq, i2, 53);
        this.zzi = zzasa;
        if (zzasa != null) {
            this.zzj = zzasa.zza();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            this.zze.zzP(((Long) this.zzf.invoke((Object) null, new Object[]{Long.valueOf(this.zzj)})).longValue());
        }
    }
}
