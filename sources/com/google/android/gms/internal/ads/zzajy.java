package com.google.android.gms.internal.ads;

import java.util.List;

final class zzajy {
    private final List zza;
    private final zzabz[] zzb;

    public zzajy(List list) {
        this.zza = list;
        this.zzb = new zzabz[list.size()];
    }

    public final void zza(long j2, zzfa zzfa) {
        if (zzfa.zza() >= 9) {
            int zze = zzfa.zze();
            int zze2 = zzfa.zze();
            int zzk = zzfa.zzk();
            if (zze == 434 && zze2 == 1195456820 && zzk == 3) {
                zzaaj.zzb(j2, zzfa, this.zzb);
            }
        }
    }

    public final void zzb(zzaaz zzaaz, zzajv zzajv) {
        for (int i2 = 0; i2 < this.zzb.length; i2++) {
            zzajv.zzc();
            zzabz zzv = zzaaz.zzv(zzajv.zza(), 3);
            zzam zzam = (zzam) this.zza.get(i2);
            String str = zzam.zzm;
            boolean z2 = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z2 = false;
            }
            zzdy.zze(z2, "Invalid closed caption MIME type provided: ".concat(String.valueOf(str)));
            zzak zzak = new zzak();
            zzak.zzH(zzajv.zzb());
            zzak.zzS(str);
            zzak.zzU(zzam.zze);
            zzak.zzK(zzam.zzd);
            zzak.zzu(zzam.zzE);
            zzak.zzI(zzam.zzo);
            zzv.zzk(zzak.zzY());
            this.zzb[i2] = zzv;
        }
    }
}
