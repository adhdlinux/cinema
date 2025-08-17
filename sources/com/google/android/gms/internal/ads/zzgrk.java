package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

final class zzgrk {
    private final ArrayDeque zza = new ArrayDeque();

    private zzgrk() {
    }

    static /* bridge */ /* synthetic */ zzgoe zza(zzgrk zzgrk, zzgoe zzgoe, zzgoe zzgoe2) {
        zzgrk.zzb(zzgoe);
        zzgrk.zzb(zzgoe2);
        zzgoe zzgoe3 = (zzgoe) zzgrk.zza.pop();
        while (!zzgrk.zza.isEmpty()) {
            zzgoe3 = new zzgro((zzgoe) zzgrk.zza.pop(), zzgoe3);
        }
        return zzgoe3;
    }

    private final void zzb(zzgoe zzgoe) {
        if (zzgoe.zzh()) {
            int zzc = zzc(zzgoe.zzd());
            int zzc2 = zzgro.zzc(zzc + 1);
            if (this.zza.isEmpty() || ((zzgoe) this.zza.peek()).zzd() >= zzc2) {
                this.zza.push(zzgoe);
                return;
            }
            int zzc3 = zzgro.zzc(zzc);
            zzgoe zzgoe2 = (zzgoe) this.zza.pop();
            while (!this.zza.isEmpty() && ((zzgoe) this.zza.peek()).zzd() < zzc3) {
                zzgoe2 = new zzgro((zzgoe) this.zza.pop(), zzgoe2);
            }
            zzgro zzgro = new zzgro(zzgoe2, zzgoe);
            while (!this.zza.isEmpty() && ((zzgoe) this.zza.peek()).zzd() < zzgro.zzc(zzc(zzgro.zzd()) + 1)) {
                zzgro = new zzgro((zzgoe) this.zza.pop(), zzgro);
            }
            this.zza.push(zzgro);
        } else if (zzgoe instanceof zzgro) {
            zzgro zzgro2 = (zzgro) zzgoe;
            zzb(zzgro2.zzd);
            zzb(zzgro2.zze);
        } else {
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzgoe.getClass())));
        }
    }

    private static final int zzc(int i2) {
        int binarySearch = Arrays.binarySearch(zzgro.zza, i2);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzgrk(zzgrj zzgrj) {
    }
}
