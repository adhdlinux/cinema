package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Comparator;

final class zzfrn extends zzftl implements Serializable {
    final Comparator zza;

    zzfrn(Comparator comparator) {
        this.zza = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj, obj2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfrn) {
            return this.zza.equals(((zzfrn) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }
}
