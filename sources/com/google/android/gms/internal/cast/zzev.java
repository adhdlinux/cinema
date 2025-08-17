package com.google.android.gms.internal.cast;

final class zzev extends zzeq {
    private final Object zza;

    zzev(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzev) {
            return this.zza.equals(((zzev) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "Optional.of(" + obj + ")";
    }

    public final Object zza() {
        return this.zza;
    }
}
