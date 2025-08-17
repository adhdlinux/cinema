package com.google.android.gms.internal.cast;

import java.util.NoSuchElementException;

final class zzfm extends zzfx {
    boolean zza;
    final /* synthetic */ Object zzb;

    zzfm(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return !this.zza;
    }

    public final Object next() {
        if (!this.zza) {
            this.zza = true;
            return this.zzb;
        }
        throw new NoSuchElementException();
    }
}
