package com.google.android.gms.internal.ads;

public abstract class zzgvw {
    public static zzgvw zzb(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzgvr(cls.getSimpleName());
        }
        return new zzgvt(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
