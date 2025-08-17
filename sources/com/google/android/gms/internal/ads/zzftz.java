package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzftz extends zzfsh {
    final transient Object zza;

    zzftz(Object obj) {
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
        return new zzfsk(this.zza);
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
        objArr[i2] = this.zza;
        return i2 + 1;
    }

    public final zzfsc zzd() {
        return zzfsc.zzm(this.zza);
    }

    public final zzfuc zze() {
        return new zzfsk(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        throw null;
    }
}
