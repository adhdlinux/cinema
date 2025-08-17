package com.google.android.gms.internal.ads;

public final class zzfcg implements zzfce {
    private final String zza;

    public zzfcg(String str) {
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfcg)) {
            return false;
        }
        return this.zza.equals(((zzfcg) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
