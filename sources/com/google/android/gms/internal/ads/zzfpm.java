package com.google.android.gms.internal.ads;

final class zzfpm extends zzfpd {
    private final Object zza;

    zzfpm(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzfpm) {
            return this.zza.equals(((zzfpm) obj).zza);
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

    public final zzfpd zza(zzfov zzfov) {
        Object apply = zzfov.apply(this.zza);
        zzfph.zzc(apply, "the Function passed to Optional.transform() must not return null.");
        return new zzfpm(apply);
    }

    public final Object zzb(Object obj) {
        return this.zza;
    }
}
