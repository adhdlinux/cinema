package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class zzfrh implements Iterator {
    int zzb;
    int zzc;
    int zzd = -1;
    final /* synthetic */ zzfrl zze;

    /* synthetic */ zzfrh(zzfrl zzfrl, zzfrg zzfrg) {
        this.zze = zzfrl;
        this.zzb = zzfrl.zzf;
        this.zzc = zzfrl.zze();
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    public final Object next() {
        zzb();
        if (hasNext()) {
            int i2 = this.zzc;
            this.zzd = i2;
            Object zza = zza(i2);
            this.zzc = this.zze.zzf(this.zzc);
            return zza;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        boolean z2;
        zzb();
        if (this.zzd >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzfph.zzi(z2, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        zzfrl zzfrl = this.zze;
        int i2 = this.zzd;
        Object[] objArr = zzfrl.zzb;
        objArr.getClass();
        zzfrl.remove(objArr[i2]);
        this.zzc--;
        this.zzd = -1;
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza(int i2);
}
