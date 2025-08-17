package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzath implements Callable {
    protected final String zza = getClass().getSimpleName();
    protected final zzart zzb;
    protected final String zzc;
    protected final String zzd;
    protected final zzanq zze;
    protected Method zzf;
    protected final int zzg;
    protected final int zzh;

    public zzath(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3) {
        this.zzb = zzart;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzanq;
        this.zzg = i2;
        this.zzh = i3;
    }

    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzl();
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzl() throws Exception {
        int i2;
        try {
            long nanoTime = System.nanoTime();
            Method zzj = this.zzb.zzj(this.zzc, this.zzd);
            this.zzf = zzj;
            if (zzj == null) {
                return null;
            }
            zza();
            zzaqn zzd2 = this.zzb.zzd();
            if (!(zzd2 == null || (i2 = this.zzg) == Integer.MIN_VALUE)) {
                zzd2.zzc(this.zzh, i2, (System.nanoTime() - nanoTime) / 1000, (String) null, (Exception) null);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
