package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zztj extends LinkedHashMap {
    private static final zztj zza;
    private boolean zzb = true;

    static {
        zztj zztj = new zztj();
        zza = zztj;
        zztj.zzb = false;
    }

    private zztj() {
    }

    private static int zze(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = zzsq.zzd;
            int length = bArr.length;
            int zzb2 = zzsq.zzb(length, bArr, 0, length);
            if (zzb2 == 0) {
                return 1;
            }
            return zzb2;
        } else if (!(obj instanceof zzsj)) {
            return obj.hashCode();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private final void zzf() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzf();
        super.clear();
    }

    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final boolean equals(Object obj) {
        boolean z2;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                z2 = value.equals(obj2);
                continue;
            } else {
                z2 = Arrays.equals((byte[]) value, (byte[]) obj2);
                continue;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 0;
        for (Map.Entry entry : entrySet()) {
            i2 += zze(entry.getValue()) ^ zze(entry.getKey());
        }
        return i2;
    }

    public final Object put(Object obj, Object obj2) {
        zzf();
        byte[] bArr = zzsq.zzd;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    public final void putAll(Map map) {
        zzf();
        for (Object next : map.keySet()) {
            byte[] bArr = zzsq.zzd;
            next.getClass();
            map.get(next).getClass();
        }
        super.putAll(map);
    }

    public final Object remove(Object obj) {
        zzf();
        return super.remove(obj);
    }

    public final zztj zza() {
        return isEmpty() ? new zztj() : new zztj(this);
    }

    public final void zzb() {
        this.zzb = false;
    }

    public final void zzc(zztj zztj) {
        zzf();
        if (!zztj.isEmpty()) {
            putAll(zztj);
        }
    }

    public final boolean zzd() {
        return this.zzb;
    }

    private zztj(Map map) {
        super(map);
    }
}
