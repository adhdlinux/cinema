package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbu;
import java.util.concurrent.Executor;

public final class zzeey implements zzeci {
    private final Context zza;
    private final zzdfk zzb;
    private final Executor zzc;

    public zzeey(Context context, zzdfk zzdfk, Executor executor) {
        this.zza = context;
        this.zzb = zzdfk;
        this.zzc = executor;
    }

    private static final boolean zzc(zzezz zzezz, int i2) {
        return zzezz.zza.zza.zzg.contains(Integer.toString(i2));
    }

    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan, zzefu {
        zzdha zzdha;
        zzboh zzD = ((zzfbd) zzecf.zzb).zzD();
        zzboi zzE = ((zzfbd) zzecf.zzb).zzE();
        zzbol zzd = ((zzfbd) zzecf.zzb).zzd();
        if (zzd != null && zzc(zzezz, 6)) {
            zzdha = zzdha.zzs(zzd);
        } else if (zzD != null && zzc(zzezz, 6)) {
            zzdha = zzdha.zzag(zzD);
        } else if (zzD != null && zzc(zzezz, 2)) {
            zzdha = zzdha.zzae(zzD);
        } else if (zzE != null && zzc(zzezz, 6)) {
            zzdha = zzdha.zzah(zzE);
        } else if (zzE == null || !zzc(zzezz, 1)) {
            throw new zzefu(1, "No native ad mappers");
        } else {
            zzdha = zzdha.zzaf(zzE);
        }
        if (zzezz.zza.zza.zzg.contains(Integer.toString(zzdha.zzc()))) {
            zzdhc zze = this.zzb.zze(new zzcrs(zzezz, zzezn, zzecf.zza), new zzdhm(zzdha), new zzdjb(zzE, zzD, zzd));
            ((zzedy) zzecf.zzc).zzc(zze.zzj());
            zze.zzd().zzm(new zzcnd((zzfbd) zzecf.zzb), this.zzc);
            return zze.zza();
        }
        throw new zzefu(1, "No corresponding native ad listener");
    }

    public final void zzb(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan {
        zzfai zzfai = zzezz.zza.zza;
        ((zzfbd) zzecf.zzb).zzp(this.zza, zzezz.zza.zza.zzd, zzezn.zzw.toString(), zzbu.zzl(zzezn.zzt), (zzboc) zzecf.zzc, zzfai.zzi, zzfai.zzg);
    }
}
