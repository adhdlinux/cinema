package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzajk {
    private final List zza;
    private final zzabz[] zzb;

    public zzajk(List list) {
        this.zza = list;
        this.zzb = new zzabz[list.size()];
    }

    public final void zza(long j2, zzfa zzfa) {
        zzaaj.zza(j2, zzfa, this.zzb);
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
            String str2 = zzam.zzb;
            if (str2 == null) {
                str2 = zzajv.zzb();
            }
            zzak zzak = new zzak();
            zzak.zzH(str2);
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
