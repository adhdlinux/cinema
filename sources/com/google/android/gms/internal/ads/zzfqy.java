package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class zzfqy implements zzfsy {
    private transient Set zza;
    private transient Collection zzb;
    private transient Map zzc;

    zzfqy() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfsy)) {
            return false;
        }
        return zzs().equals(((zzfsy) obj).zzs());
    }

    public final int hashCode() {
        return zzs().hashCode();
    }

    public final String toString() {
        return zzs().toString();
    }

    /* access modifiers changed from: package-private */
    public abstract Collection zzf();

    /* access modifiers changed from: package-private */
    public Iterator zzg() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public abstract Map zzj();

    /* access modifiers changed from: package-private */
    public abstract Set zzl();

    public boolean zzq(Object obj, Object obj2) {
        throw null;
    }

    public final Collection zzr() {
        Collection collection = this.zzb;
        if (collection != null) {
            return collection;
        }
        Collection zzf = zzf();
        this.zzb = zzf;
        return zzf;
    }

    public final Map zzs() {
        Map map = this.zzc;
        if (map != null) {
            return map;
        }
        Map zzj = zzj();
        this.zzc = zzj;
        return zzj;
    }

    public final Set zzt() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set zzl = zzl();
        this.zza = zzl;
        return zzl;
    }
}
