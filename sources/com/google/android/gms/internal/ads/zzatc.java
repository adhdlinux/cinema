package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzatc extends zzath {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzatc(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3) {
        super(zzart, "pFqkMlhSSaQ2eu0bhmIAWpk2TrQlPQpWFME4RoGI1ncpKXXKi44CuFe8cYNKvx1r", "fb3OlLRM7e1GWXw1pgCRp7yxLrLt+HeY8mbhCjTXXm8=", zzanq, i2, 33);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (Long) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzV(zzi.longValue());
        }
    }
}
