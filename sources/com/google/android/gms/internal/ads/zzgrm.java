package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzgrm implements Iterator {
    private final ArrayDeque zza;
    private zzgnz zzb;

    /* synthetic */ zzgrm(zzgoe zzgoe, zzgrl zzgrl) {
        if (zzgoe instanceof zzgro) {
            zzgro zzgro = (zzgro) zzgoe;
            ArrayDeque arrayDeque = new ArrayDeque(zzgro.zzf());
            this.zza = arrayDeque;
            arrayDeque.push(zzgro);
            this.zzb = zzb(zzgro.zzd);
            return;
        }
        this.zza = null;
        this.zzb = (zzgnz) zzgoe;
    }

    private final zzgnz zzb(zzgoe zzgoe) {
        while (zzgoe instanceof zzgro) {
            zzgro zzgro = (zzgro) zzgoe;
            this.zza.push(zzgro);
            zzgoe = zzgro.zzd;
        }
        return (zzgnz) zzgoe;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: zza */
    public final zzgnz next() {
        zzgnz zzgnz;
        zzgnz zzgnz2 = this.zzb;
        if (zzgnz2 != null) {
            do {
                ArrayDeque arrayDeque = this.zza;
                zzgnz = null;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    this.zzb = zzgnz;
                } else {
                    zzgnz = zzb(((zzgro) this.zza.pop()).zze);
                }
            } while (zzgnz.zzd() == 0);
            this.zzb = zzgnz;
            return zzgnz2;
        }
        throw new NoSuchElementException();
    }
}
