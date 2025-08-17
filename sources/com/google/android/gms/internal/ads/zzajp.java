package com.google.android.gms.internal.ads;

final class zzajp implements zzaji {
    final /* synthetic */ zzajr zza;
    private final zzez zzb = new zzez(new byte[4], 4);

    public zzajp(zzajr zzajr) {
        this.zza = zzajr;
    }

    public final void zza(zzfa zzfa) {
        if (zzfa.zzk() == 0 && (zzfa.zzk() & 128) != 0) {
            zzfa.zzG(6);
            int zza2 = zzfa.zza() / 4;
            for (int i2 = 0; i2 < zza2; i2++) {
                zzfa.zzA(this.zzb, 4);
                int zzd = this.zzb.zzd(16);
                this.zzb.zzl(3);
                if (zzd == 0) {
                    this.zzb.zzl(13);
                } else {
                    int zzd2 = this.zzb.zzd(13);
                    if (this.zza.zzf.get(zzd2) == null) {
                        zzajr zzajr = this.zza;
                        zzajr.zzf.put(zzd2, new zzajj(new zzajq(zzajr, zzd2)));
                        zzajr zzajr2 = this.zza;
                        zzajr2.zzl = zzajr2.zzl + 1;
                    }
                }
            }
            this.zza.zzf.remove(0);
        }
    }

    public final void zzb(zzfh zzfh, zzaaz zzaaz, zzajv zzajv) {
    }
}
