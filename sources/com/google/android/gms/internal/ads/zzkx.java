package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

final class zzkx implements zzty, zzqp {
    final /* synthetic */ zzlb zza;
    private final zzkz zzb;

    public zzkx(zzlb zzlb, zzkz zzkz) {
        this.zza = zzlb;
        this.zzb = zzkz;
    }

    private final Pair zzf(int i2, zzto zzto) {
        zzto zzto2;
        zzto zzto3 = null;
        if (zzto != null) {
            zzkz zzkz = this.zzb;
            int i3 = 0;
            while (true) {
                if (i3 >= zzkz.zzc.size()) {
                    zzto2 = null;
                    break;
                } else if (((zzto) zzkz.zzc.get(i3)).zzd == zzto.zzd) {
                    zzto2 = zzto.zzc(Pair.create(zzkz.zzb, zzto.zza));
                    break;
                } else {
                    i3++;
                }
            }
            if (zzto2 == null) {
                return null;
            }
            zzto3 = zzto2;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzto3);
    }

    public final void zzac(int i2, zzto zzto, zztk zztk) {
        Pair zzf = zzf(0, zzto);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzkv(this, zzf, zztk));
        }
    }

    public final void zzad(int i2, zzto zzto, zztf zztf, zztk zztk) {
        Pair zzf = zzf(0, zzto);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzku(this, zzf, zztf, zztk));
        }
    }

    public final void zzae(int i2, zzto zzto, zztf zztf, zztk zztk) {
        Pair zzf = zzf(0, zzto);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzkt(this, zzf, zztf, zztk));
        }
    }

    public final void zzaf(int i2, zzto zzto, zztf zztf, zztk zztk, IOException iOException, boolean z2) {
        Pair zzf = zzf(0, zzto);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzks(this, zzf, zztf, zztk, iOException, z2));
        }
    }

    public final void zzag(int i2, zzto zzto, zztf zztf, zztk zztk) {
        Pair zzf = zzf(0, zzto);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzkw(this, zzf, zztf, zztk));
        }
    }
}
