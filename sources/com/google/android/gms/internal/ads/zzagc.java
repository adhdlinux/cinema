package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzagc extends zzage {
    public final long zza;
    public final List zzb = new ArrayList();
    public final List zzc = new ArrayList();

    public zzagc(int i2, long j2) {
        super(i2);
        this.zza = j2;
    }

    public final String toString() {
        String zzf = zzage.zzf(this.zzd);
        String arrays = Arrays.toString(this.zzb.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        return zzf + " leaves: " + arrays + " containers: " + arrays2;
    }

    public final zzagc zza(int i2) {
        int size = this.zzc.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzagc zzagc = (zzagc) this.zzc.get(i3);
            if (zzagc.zzd == i2) {
                return zzagc;
            }
        }
        return null;
    }

    public final zzagd zzb(int i2) {
        int size = this.zzb.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzagd zzagd = (zzagd) this.zzb.get(i3);
            if (zzagd.zzd == i2) {
                return zzagd;
            }
        }
        return null;
    }

    public final void zzc(zzagc zzagc) {
        this.zzc.add(zzagc);
    }

    public final void zzd(zzagd zzagd) {
        this.zzb.add(zzagd);
    }
}
