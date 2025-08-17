package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzfto extends zzfsh {
    private final transient zzfsf zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc;

    zzfto(zzfsf zzfsf, Object[] objArr, int i2, int i3) {
        this.zza = zzfsf;
        this.zzb = objArr;
        this.zzc = i3;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        return zzd().zza(objArr, i2);
    }

    public final zzfuc zze() {
        return zzd().listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final zzfsc zzi() {
        return new zzftn(this);
    }
}
