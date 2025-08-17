package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class zzfsf implements Map, Serializable {
    private transient zzfsh zza;
    private transient zzfsh zzb;
    private transient zzfrx zzc;

    zzfsf() {
    }

    public static zzfsf zzc(Map map) {
        int i2;
        Set entrySet = map.entrySet();
        if (entrySet instanceof Collection) {
            i2 = entrySet.size();
        } else {
            i2 = 4;
        }
        zzfse zzfse = new zzfse(i2);
        zzfse.zzb(entrySet);
        return zzfse.zzc();
    }

    public static zzfsf zzd() {
        return zzftr.zza;
    }

    public static zzfsf zze(Object obj, Object obj2) {
        zzfqz.zzb("dialog_not_shown_reason", obj2);
        return zzftr.zzj(1, new Object[]{"dialog_not_shown_reason", obj2}, (zzfse) null);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(Object obj) {
        return zzfsx.zzb(this, obj);
    }

    public abstract Object get(Object obj);

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzfty.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzfqz.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
        sb.append('{');
        boolean z2 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z2 = false;
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public abstract zzfrx zza();

    /* renamed from: zzb */
    public final zzfrx values() {
        zzfrx zzfrx = this.zzc;
        if (zzfrx != null) {
            return zzfrx;
        }
        zzfrx zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzfsh zzf();

    /* access modifiers changed from: package-private */
    public abstract zzfsh zzg();

    /* renamed from: zzh */
    public final zzfsh entrySet() {
        zzfsh zzfsh = this.zza;
        if (zzfsh != null) {
            return zzfsh;
        }
        zzfsh zzf = zzf();
        this.zza = zzf;
        return zzf;
    }

    /* renamed from: zzi */
    public final zzfsh keySet() {
        zzfsh zzfsh = this.zzb;
        if (zzfsh != null) {
            return zzfsh;
        }
        zzfsh zzg = zzg();
        this.zzb = zzg;
        return zzg;
    }
}
