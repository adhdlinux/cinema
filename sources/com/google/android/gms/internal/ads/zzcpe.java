package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

final class zzcpe extends zzcpb {
    private final Context zzc;
    private final View zzd;
    private final zzcez zze;
    private final zzezo zzf;
    private final zzcrb zzg;
    private final zzdhl zzh;
    private final zzdcw zzi;
    private final zzgvy zzj;
    private final Executor zzk;
    private zzq zzl;

    zzcpe(zzcrc zzcrc, Context context, zzezo zzezo, View view, zzcez zzcez, zzcrb zzcrb, zzdhl zzdhl, zzdcw zzdcw, zzgvy zzgvy, Executor executor) {
        super(zzcrc);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcez;
        this.zzf = zzezo;
        this.zzg = zzcrb;
        this.zzh = zzdhl;
        this.zzi = zzdcw;
        this.zzj = zzgvy;
        this.zzk = executor;
    }

    public static /* synthetic */ void zzi(zzcpe zzcpe) {
        zzdhl zzdhl = zzcpe.zzh;
        if (zzdhl.zze() != null) {
            try {
                zzdhl.zze().zze((zzbu) zzcpe.zzj.zzb(), ObjectWrapper.wrap(zzcpe.zzc));
            } catch (RemoteException e2) {
                zzbzr.zzh("RemoteException when notifyAdLoad is called", e2);
            }
        }
    }

    public final int zza() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() && this.zzb.zzah) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzht)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    public final View zzc() {
        return this.zzd;
    }

    public final zzdq zzd() {
        try {
            return this.zzg.zza();
        } catch (zzfan unused) {
            return null;
        }
    }

    public final zzezo zze() {
        zzq zzq = this.zzl;
        if (zzq != null) {
            return zzfam.zzb(zzq);
        }
        zzezn zzezn = this.zzb;
        if (zzezn.zzad) {
            for (String str : zzezn.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            return new zzezo(this.zzd.getWidth(), this.zzd.getHeight(), false);
        }
        return (zzezo) this.zzb.zzs.get(0);
    }

    public final zzezo zzf() {
        return this.zzf;
    }

    public final void zzg() {
        this.zzi.zza();
    }

    public final void zzh(ViewGroup viewGroup, zzq zzq) {
        zzcez zzcez;
        if (viewGroup != null && (zzcez = this.zze) != null) {
            zzcez.zzag(zzcgo.zzc(zzq));
            viewGroup.setMinimumHeight(zzq.zzc);
            viewGroup.setMinimumWidth(zzq.zzf);
            this.zzl = zzq;
        }
    }

    public final void zzj() {
        this.zzk.execute(new zzcpd(this));
        super.zzj();
    }
}
