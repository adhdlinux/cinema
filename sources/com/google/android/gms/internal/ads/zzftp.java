package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzftp extends zzfsh {
    private final transient zzfsf zza;
    private final transient zzfsc zzb;

    zzftp(zzfsf zzfsf, zzfsc zzfsc) {
        this.zza = zzfsf;
        this.zzb = zzfsc;
    }

    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        return this.zzb.zza(objArr, i2);
    }

    public final zzfsc zzd() {
        return this.zzb;
    }

    public final zzfuc zze() {
        return this.zzb.listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        throw null;
    }
}
