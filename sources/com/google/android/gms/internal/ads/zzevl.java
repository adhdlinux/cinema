package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicReference;

public final class zzevl implements zzcvj, zzcxf, zzexb, zzo, zzcxr, zzcvw, zzdcu {
    private final zzfbq zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private zzevl zzh = null;

    public zzevl(zzfbq zzfbq) {
        this.zza = zzfbq;
    }

    public static zzevl zzi(zzevl zzevl) {
        zzevl zzevl2 = new zzevl(zzevl.zza);
        zzevl2.zzh = zzevl;
        return zzevl2;
    }

    public final void zza(zze zze2) {
        zzevl zzevl = this.zzh;
        if (zzevl != null) {
            zzevl.zza(zze2);
            return;
        }
        zzews.zza(this.zzb, new zzeuw(zze2));
        zzews.zza(this.zzb, new zzevc(zze2));
    }

    public final void zzb() {
        zzevl zzevl = this.zzh;
        if (zzevl != null) {
            zzevl.zzb();
            return;
        }
        zzews.zza(this.zzf, zzeve.zza);
        zzews.zza(this.zzd, zzevf.zza);
        zzews.zza(this.zzd, zzevg.zza);
    }

    public final void zzbF() {
    }

    public final void zzbG(zzexb zzexb) {
        this.zzh = (zzevl) zzexb;
    }

    public final void zzbo() {
    }

    public final void zzby() {
        zzevl zzevl = this.zzh;
        if (zzevl != null) {
            zzevl.zzby();
        } else {
            zzews.zza(this.zzf, zzevb.zza);
        }
    }

    public final void zze() {
        zzevl zzevl = this.zzh;
        if (zzevl != null) {
            zzevl.zze();
        } else {
            zzews.zza(this.zzf, zzevi.zza);
        }
    }

    public final void zzf(int i2) {
        zzevl zzevl = this.zzh;
        if (zzevl != null) {
            zzevl.zzf(i2);
        } else {
            zzews.zza(this.zzf, new zzeva(i2));
        }
    }

    public final void zzg() {
        zzevl zzevl = this.zzh;
        if (zzevl != null) {
            zzevl.zzg();
        } else {
            zzews.zza(this.zze, zzevk.zza);
        }
    }

    public final void zzh(zzs zzs) {
        zzevl zzevl = this.zzh;
        if (zzevl != null) {
            zzevl.zzh(zzs);
        } else {
            zzews.zza(this.zzg, new zzeuz(zzs));
        }
    }

    public final void zzj() {
        zzevl zzevl = this.zzh;
        if (zzevl != null) {
            zzevl.zzj();
            return;
        }
        this.zza.zza();
        zzews.zza(this.zzc, zzeux.zza);
        zzews.zza(this.zzd, zzeuy.zza);
    }

    public final void zzk(zze zze2) {
        zzevl zzevl = this.zzh;
        if (zzevl != null) {
            zzevl.zzk(zze2);
        } else {
            zzews.zza(this.zzd, new zzevh(zze2));
        }
    }

    public final void zzl(zzavt zzavt) {
        zzevl zzevl = this.zzh;
        if (zzevl != null) {
            zzevl.zzl(zzavt);
        } else {
            zzews.zza(this.zzb, new zzevd(zzavt));
        }
    }

    public final void zzn(zzo zzo) {
        this.zzf.set(zzo);
    }

    public final void zzo(zzdg zzdg) {
        this.zzg.set(zzdg);
    }

    public final void zzp(zzavw zzavw) {
        this.zzb.set(zzavw);
    }

    public final void zzq(zzawa zzawa) {
        this.zzd.set(zzawa);
    }

    public final void zzr() {
        zzevl zzevl = this.zzh;
        if (zzevl != null) {
            zzevl.zzr();
        } else {
            zzews.zza(this.zzd, zzevj.zza);
        }
    }

    public final void zzs() {
    }
}
