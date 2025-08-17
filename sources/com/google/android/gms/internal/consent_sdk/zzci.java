package com.google.android.gms.internal.consent_sdk;

public final class zzci<T> implements zzch<T> {
    private static final zzci<Object> zza = new zzci<>((Object) null);
    private final T zzb;

    private zzci(T t2) {
        this.zzb = t2;
    }

    public static <T> zzch<T> zza(T t2) {
        if (t2 != null) {
            return new zzci(t2);
        }
        throw new NullPointerException("instance cannot be null");
    }

    public final T zzb() {
        return this.zzb;
    }
}
