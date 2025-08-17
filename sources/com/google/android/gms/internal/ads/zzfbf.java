package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzfbf {
    public static /* synthetic */ void zza(Throwable th, Throwable th2) {
        Class<Throwable> cls = Throwable.class;
        try {
            cls.getDeclaredMethod("addSuppressed", new Class[]{cls}).invoke(th, new Object[]{th2});
        } catch (Exception unused) {
        }
    }
}
