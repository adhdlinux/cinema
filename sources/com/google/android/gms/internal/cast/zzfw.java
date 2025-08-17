package com.google.android.gms.internal.cast;

import java.util.Iterator;

final class zzfw extends zzfl {
    final transient Object zza;

    zzfw(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzfm(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "[" + obj + "]";
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        objArr[0] = this.zza;
        return 1;
    }

    public final zzfh zzd() {
        Object obj = this.zza;
        int i2 = zzfh.zzd;
        Object[] objArr = {obj};
        zzfn.zzb(objArr, 1);
        return zzfh.zzi(objArr, 1);
    }

    public final zzfx zze() {
        return new zzfm(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        throw null;
    }
}
