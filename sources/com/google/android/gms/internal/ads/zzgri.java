package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzgri extends zzgnw {
    final zzgrm zza;
    zzgny zzb = zzb();
    final /* synthetic */ zzgro zzc;

    zzgri(zzgro zzgro) {
        this.zzc = zzgro;
        this.zza = new zzgrm(zzgro, (zzgrl) null);
    }

    private final zzgny zzb() {
        zzgrm zzgrm = this.zza;
        if (zzgrm.hasNext()) {
            return zzgrm.next().iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final byte zza() {
        zzgny zzgny = this.zzb;
        if (zzgny != null) {
            byte zza2 = zzgny.zza();
            if (!this.zzb.hasNext()) {
                this.zzb = zzb();
            }
            return zza2;
        }
        throw new NoSuchElementException();
    }
}
