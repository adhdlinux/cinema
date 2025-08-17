package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

final class zzys {
    private static Constructor zza;
    private static Method zzb;
    private static Method zzc;

    public static zzae zza(float f2) throws Exception {
        if (zza == null || zzb == null || zzc == null) {
            Class<?> cls = Class.forName("androidx.media3.effect.ScaleAndRotateTransformation$Builder");
            zza = cls.getConstructor(new Class[0]);
            zzb = cls.getMethod("setRotationDegrees", new Class[]{Float.TYPE});
            zzc = cls.getMethod("build", new Class[0]);
        }
        Object newInstance = zza.newInstance(new Object[0]);
        zzb.invoke(newInstance, new Object[]{Float.valueOf(f2)});
        Object invoke = zzc.invoke(newInstance, new Object[0]);
        invoke.getClass();
        return (zzae) invoke;
    }
}
