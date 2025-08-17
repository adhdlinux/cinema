package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class zzfom implements Iterator {
    private Object zza;
    private int zzb = 2;

    protected zzfom() {
    }

    public final boolean hasNext() {
        boolean z2;
        if (this.zzb != 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzfph.zzh(z2);
        int i2 = this.zzb;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        } else if (i3 == 0) {
            return true;
        } else {
            if (i3 != 2) {
                this.zzb = 4;
                this.zza = zza();
                if (this.zzb != 3) {
                    this.zzb = 1;
                    return true;
                }
            }
            return false;
        }
    }

    public final Object next() {
        if (hasNext()) {
            this.zzb = 2;
            Object obj = this.zza;
            this.zza = null;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public abstract Object zza();

    /* access modifiers changed from: protected */
    public final Object zzb() {
        this.zzb = 3;
        return null;
    }
}
