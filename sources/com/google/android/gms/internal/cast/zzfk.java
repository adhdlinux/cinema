package com.google.android.gms.internal.cast;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public abstract class zzfk implements Map, Serializable {
    private transient zzfl zza;
    private transient zzfl zzb;
    private transient zzfd zzc;

    zzfk() {
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.cast.zzfk zzc(java.lang.Iterable r2) {
        /*
            boolean r0 = r2 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0009
            int r0 = r2.size()
            goto L_0x000a
        L_0x0009:
            r0 = 4
        L_0x000a:
            com.google.android.gms.internal.cast.zzfj r1 = new com.google.android.gms.internal.cast.zzfj
            r1.<init>(r0)
            r1.zza(r2)
            com.google.android.gms.internal.cast.zzfi r2 = r1.zzc
            if (r2 != 0) goto L_0x0028
            int r2 = r1.zzb
            java.lang.Object[] r0 = r1.zza
            com.google.android.gms.internal.cast.zzft r2 = com.google.android.gms.internal.cast.zzft.zzh(r2, r0, r1)
            com.google.android.gms.internal.cast.zzfi r0 = r1.zzc
            if (r0 != 0) goto L_0x0023
            return r2
        L_0x0023:
            java.lang.IllegalArgumentException r2 = r0.zza()
            throw r2
        L_0x0028:
            java.lang.IllegalArgumentException r2 = r2.zza()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzfk.zzc(java.lang.Iterable):com.google.android.gms.internal.cast.zzfk");
    }

    public static zzfk zzd() {
        return zzft.zza;
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
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    public abstract Object get(Object obj);

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzfv.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzfl zzfl = this.zzb;
        if (zzfl != null) {
            return zzfl;
        }
        zzfl zzf = zzf();
        this.zzb = zzf;
        return zzf;
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
        if (size >= 0) {
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
        throw new IllegalArgumentException("size cannot be negative but was: " + size);
    }

    /* access modifiers changed from: package-private */
    public abstract zzfd zza();

    /* renamed from: zzb */
    public final zzfd values() {
        zzfd zzfd = this.zzc;
        if (zzfd != null) {
            return zzfd;
        }
        zzfd zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzfl zze();

    /* access modifiers changed from: package-private */
    public abstract zzfl zzf();

    /* renamed from: zzg */
    public final zzfl entrySet() {
        zzfl zzfl = this.zza;
        if (zzfl != null) {
            return zzfl;
        }
        zzfl zze = zze();
        this.zza = zze;
        return zze;
    }
}
