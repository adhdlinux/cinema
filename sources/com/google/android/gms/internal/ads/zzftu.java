package com.google.android.gms.internal.ads;

import java.io.Serializable;

final class zzftu extends zzftl implements Serializable {
    final zzftl zza;

    zzftu(zzftl zzftl) {
        this.zza = zzftl;
    }

    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj2, obj);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzftu) {
            return this.zza.equals(((zzftu) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString().concat(".reverse()");
    }

    public final zzftl zza() {
        return this.zza;
    }
}
