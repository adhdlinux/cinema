package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

public final class zzabn {
    private final zzfa zza = new zzfa(10);

    public final zzbz zza(zzaax zzaax, zzaek zzaek) throws IOException {
        zzbz zzbz = null;
        int i2 = 0;
        while (true) {
            try {
                ((zzaam) zzaax).zzm(this.zza.zzH(), 0, 10, false);
                this.zza.zzF(0);
                if (this.zza.zzm() != 4801587) {
                    break;
                }
                this.zza.zzG(3);
                int zzj = this.zza.zzj();
                int i3 = zzj + 10;
                if (zzbz == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(this.zza.zzH(), 0, bArr, 0, 10);
                    ((zzaam) zzaax).zzm(bArr, 10, zzj, false);
                    zzbz = zzaem.zza(bArr, i3, zzaek, new zzadn());
                } else {
                    ((zzaam) zzaax).zzl(zzj, false);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        zzaax.zzj();
        ((zzaam) zzaax).zzl(i2, false);
        return zzbz;
    }
}
