package com.google.android.gms.internal.consent_sdk;

public final class zzck {
    public static <T> T zza(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    public static <T> void zzb(T t2, Class<T> cls) {
        if (t2 == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }
}
