package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzsv implements zzty, zzqp {
    final /* synthetic */ zzsx zza;
    private final Object zzb;
    private zztx zzc;
    private zzqo zzd;

    public zzsv(zzsx zzsx, Object obj) {
        this.zza = zzsx;
        this.zzc = zzsx.zze((zzto) null);
        this.zzd = zzsx.zzc((zzto) null);
        this.zzb = obj;
    }

    private final zztk zzf(zztk zztk) {
        zzsx zzsx = this.zza;
        Object obj = this.zzb;
        long j2 = zztk.zzc;
        zzsx.zzw(obj, j2);
        zzsx zzsx2 = this.zza;
        Object obj2 = this.zzb;
        long j3 = zztk.zzd;
        zzsx2.zzw(obj2, j3);
        if (j2 == zztk.zzc && j3 == zztk.zzd) {
            return zztk;
        }
        return new zztk(1, zztk.zza, zztk.zzb, 0, (Object) null, j2, j3);
    }

    private final boolean zzg(int i2, zzto zzto) {
        zzto zzto2;
        if (zzto != null) {
            zzto2 = this.zza.zzx(this.zzb, zzto);
            if (zzto2 == null) {
                return false;
            }
        } else {
            zzto2 = null;
        }
        this.zza.zzv(this.zzb, 0);
        zztx zztx = this.zzc;
        int i3 = zztx.zza;
        if (!zzfj.zzC(zztx.zzb, zzto2)) {
            this.zzc = this.zza.zzf(0, zzto2);
        }
        zzqo zzqo = this.zzd;
        int i4 = zzqo.zza;
        if (zzfj.zzC(zzqo.zzb, zzto2)) {
            return true;
        }
        this.zzd = this.zza.zzd(0, zzto2);
        return true;
    }

    public final void zzac(int i2, zzto zzto, zztk zztk) {
        if (zzg(0, zzto)) {
            this.zzc.zzc(zzf(zztk));
        }
    }

    public final void zzad(int i2, zzto zzto, zztf zztf, zztk zztk) {
        if (zzg(0, zzto)) {
            this.zzc.zzd(zztf, zzf(zztk));
        }
    }

    public final void zzae(int i2, zzto zzto, zztf zztf, zztk zztk) {
        if (zzg(0, zzto)) {
            this.zzc.zze(zztf, zzf(zztk));
        }
    }

    public final void zzaf(int i2, zzto zzto, zztf zztf, zztk zztk, IOException iOException, boolean z2) {
        if (zzg(0, zzto)) {
            this.zzc.zzf(zztf, zzf(zztk), iOException, z2);
        }
    }

    public final void zzag(int i2, zzto zzto, zztf zztf, zztk zztk) {
        if (zzg(0, zzto)) {
            this.zzc.zzg(zztf, zzf(zztk));
        }
    }
}
