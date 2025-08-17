package com.google.android.gms.internal.ads;

import java.util.Comparator;

public abstract class zzftl implements Comparator {
    protected zzftl() {
    }

    public static zzftl zzb(Comparator comparator) {
        if (comparator instanceof zzftl) {
            return (zzftl) comparator;
        }
        return new zzfrn(comparator);
    }

    public static zzftl zzc() {
        return zzftj.zza;
    }

    public abstract int compare(Object obj, Object obj2);

    public zzftl zza() {
        return new zzftu(this);
    }
}
