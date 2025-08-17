package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zztx {
    public final int zza;
    public final zzto zzb;
    private final CopyOnWriteArrayList zzc;

    public zztx() {
        this(new CopyOnWriteArrayList(), 0, (zzto) null);
    }

    private zztx(CopyOnWriteArrayList copyOnWriteArrayList, int i2, zzto zzto) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzto;
    }

    public final zztx zza(int i2, zzto zzto) {
        return new zztx(this.zzc, 0, zzto);
    }

    public final void zzb(Handler handler, zzty zzty) {
        this.zzc.add(new zztw(handler, zzty));
    }

    public final void zzc(zztk zztk) {
        Iterator it2 = this.zzc.iterator();
        while (it2.hasNext()) {
            zztw zztw = (zztw) it2.next();
            zzfj.zzF(zztw.zza, new zztr(this, zztw.zzb, zztk));
        }
    }

    public final void zzd(zztf zztf, zztk zztk) {
        Iterator it2 = this.zzc.iterator();
        while (it2.hasNext()) {
            zztw zztw = (zztw) it2.next();
            zzfj.zzF(zztw.zza, new zzts(this, zztw.zzb, zztf, zztk));
        }
    }

    public final void zze(zztf zztf, zztk zztk) {
        Iterator it2 = this.zzc.iterator();
        while (it2.hasNext()) {
            zztw zztw = (zztw) it2.next();
            zzfj.zzF(zztw.zza, new zztv(this, zztw.zzb, zztf, zztk));
        }
    }

    public final void zzf(zztf zztf, zztk zztk, IOException iOException, boolean z2) {
        Iterator it2 = this.zzc.iterator();
        while (it2.hasNext()) {
            zztw zztw = (zztw) it2.next();
            zzfj.zzF(zztw.zza, new zztt(this, zztw.zzb, zztf, zztk, iOException, z2));
        }
    }

    public final void zzg(zztf zztf, zztk zztk) {
        Iterator it2 = this.zzc.iterator();
        while (it2.hasNext()) {
            zztw zztw = (zztw) it2.next();
            zzfj.zzF(zztw.zza, new zztu(this, zztw.zzb, zztf, zztk));
        }
    }

    public final void zzh(zzty zzty) {
        Iterator it2 = this.zzc.iterator();
        while (it2.hasNext()) {
            zztw zztw = (zztw) it2.next();
            if (zztw.zzb == zzty) {
                this.zzc.remove(zztw);
            }
        }
    }
}
