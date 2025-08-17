package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzl;
import java.util.concurrent.Executor;

public final class zzewk implements zzexe {
    private final zzexe zza;
    private final zzexe zzb;
    private final zzfcq zzc;
    private final String zzd;
    private zzcun zze;
    private final Executor zzf;

    public zzewk(zzexe zzexe, zzexe zzexe2, zzfcq zzfcq, String str, Executor executor) {
        this.zza = zzexe;
        this.zzb = zzexe2;
        this.zzc = zzfcq;
        this.zzd = str;
        this.zzf = executor;
    }

    private final zzfwm zzg(zzfcd zzfcd, zzexf zzexf) {
        zzcun zzcun = zzfcd.zza;
        this.zze = zzcun;
        if (zzfcd.zzc != null) {
            if (zzcun.zzf() != null) {
                zzfcd.zzc.zzo().zzbG(zzfcd.zza.zzf());
            }
            return zzfwc.zzh(zzfcd.zzc);
        }
        zzcun.zzb().zzl(zzfcd.zzb);
        return ((zzewu) this.zza).zzb(zzexf, (zzexd) null, zzfcd.zza);
    }

    /* renamed from: zza */
    public final synchronized zzcun zzd() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(zzexf zzexf, zzewj zzewj, zzexd zzexd, zzcun zzcun, zzewp zzewp) throws Exception {
        if (zzewp != null) {
            zzewj zzewj2 = new zzewj(zzewj.zza, zzewj.zzb, zzewj.zzc, zzewj.zzd, zzewj.zze, zzewj.zzf, zzewp.zza);
            if (zzewp.zzc != null) {
                this.zze = null;
                this.zzc.zze(zzewj2);
                return zzg(zzewp.zzc, zzexf);
            }
            zzfwm zza2 = this.zzc.zza(zzewj2);
            if (zza2 != null) {
                this.zze = null;
                return zzfwc.zzm(zza2, new zzewg(this), this.zzf);
            }
            this.zzc.zze(zzewj2);
            zzexf = new zzexf(zzexf.zzb, zzewp.zzb);
        }
        zzfwm zzb2 = ((zzewu) this.zza).zzb(zzexf, zzexd, zzcun);
        this.zze = zzcun;
        return zzb2;
    }

    public final /* bridge */ /* synthetic */ zzfwm zzc(zzexf zzexf, zzexd zzexd, Object obj) {
        return zzf(zzexf, zzexd, (zzcun) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zze(zzfcn zzfcn) throws Exception {
        zzfcp zzfcp;
        if (zzfcn == null || zzfcn.zza == null || (zzfcp = zzfcn.zzb) == null) {
            throw new zzdtx(1, "Empty prefetch");
        }
        zzaxo zza2 = zzaxu.zza();
        zzaxm zza3 = zzaxn.zza();
        zza3.zzd(2);
        zza3.zzb(zzaxr.zzd());
        zza2.zza(zza3);
        zzfcn.zza.zza.zzb().zzc().zzi((zzaxu) zza2.zzal());
        return zzg(zzfcn.zza, ((zzewj) zzfcp).zzb);
    }

    public final synchronized zzfwm zzf(zzexf zzexf, zzexd zzexd, zzcun zzcun) {
        zzexf zzexf2 = zzexf;
        zzexd zzexd2 = zzexd;
        synchronized (this) {
            zzcum zza2 = zzexd2.zza(zzexf2.zzb);
            zza2.zza(new zzewl(this.zzd));
            zzcun zzcun2 = (zzcun) zza2.zzh();
            zzcun2.zzg();
            zzcun2.zzg();
            zzl zzl = zzcun2.zzg().zzd;
            if (zzl.zzs == null) {
                if (zzl.zzx == null) {
                    zzfai zzg = zzcun2.zzg();
                    zzexd zzexd3 = zzexd;
                    zzexf zzexf3 = zzexf;
                    zzfwm zzm = zzfwc.zzm(zzfvt.zzv(((zzewq) this.zzb).zzb(zzexf2, zzexd2, zzcun2)), new zzewh(this, zzexf, new zzewj(zzexd3, zzexf3, zzg.zzd, zzg.zzf, this.zzf, zzg.zzj, (zzfce) null), zzexd, zzcun2), this.zzf);
                    return zzm;
                }
            }
            this.zze = zzcun2;
            zzfwm zzb2 = ((zzewu) this.zza).zzb(zzexf2, zzexd2, zzcun2);
            return zzb2;
        }
    }
}
