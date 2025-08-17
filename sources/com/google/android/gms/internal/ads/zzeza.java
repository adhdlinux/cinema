package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import java.util.concurrent.Executor;

public final class zzeza implements zzekc {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcgu zzc;
    /* access modifiers changed from: private */
    public final zzeyq zzd;
    /* access modifiers changed from: private */
    public final zzexe zze;
    private final zzfaa zzf;
    /* access modifiers changed from: private */
    public final zzfgb zzg;
    private final zzfag zzh;
    private zzfwm zzi;

    public zzeza(Context context, Executor executor, zzcgu zzcgu, zzexe zzexe, zzeyq zzeyq, zzfag zzfag, zzfaa zzfaa) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgu;
        this.zze = zzexe;
        this.zzd = zzeyq;
        this.zzh = zzfag;
        this.zzf = zzfaa;
        this.zzg = zzcgu.zzy();
    }

    /* access modifiers changed from: private */
    public final zzdmq zzk(zzexc zzexc) {
        zzdmq zzh2 = this.zzc.zzh();
        zzcuo zzcuo = new zzcuo();
        zzcuo.zze(this.zza);
        zzcuo.zzi(((zzeyz) zzexc).zza);
        zzcuo.zzh(this.zzf);
        zzh2.zzd(zzcuo.zzj());
        zzh2.zzc(new zzdar().zzn());
        return zzh2;
    }

    public final boolean zza() {
        throw null;
    }

    public final boolean zzb(zzl zzl, String str, zzeka zzeka, zzekb zzekb) throws RemoteException {
        zzffy zzffy;
        zzbvb zzbvb = new zzbvb(zzl, str);
        if (zzbvb.zzb == null) {
            zzbzr.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new zzeyt(this));
            return false;
        }
        zzfwm zzfwm = this.zzi;
        if (zzfwm != null && !zzfwm.isDone()) {
            return false;
        }
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            zzexe zzexe = this.zze;
            if (zzexe.zzd() != null) {
                zzffy zzh2 = ((zzdmr) zzexe.zzd()).zzh();
                zzh2.zzh(5);
                zzh2.zzb(zzbvb.zza.zzp);
                zzffy = zzh2;
                zzfbc.zza(this.zza, zzbvb.zza.zzf);
                if (((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue() && zzbvb.zza.zzf) {
                    this.zzc.zzj().zzm(true);
                }
                zzfag zzfag = this.zzh;
                zzfag.zzs(zzbvb.zzb);
                zzfag.zzr(zzq.zzd());
                zzfag.zzE(zzbvb.zza);
                zzfai zzG = zzfag.zzG();
                zzffn zzb2 = zzffm.zzb(this.zza, zzffx.zzf(zzG), 5, zzbvb.zza);
                zzeyz zzeyz = new zzeyz((zzeyy) null);
                zzeyz.zza = zzG;
                zzfwm zzc2 = this.zze.zzc(new zzexf(zzeyz, (zzbue) null), new zzeyu(this), (Object) null);
                this.zzi = zzc2;
                zzfwc.zzq(zzc2, new zzeyx(this, zzekb, zzffy, zzb2, zzeyz), this.zzb);
                return true;
            }
        }
        zzffy = null;
        zzfbc.zza(this.zza, zzbvb.zza.zzf);
        this.zzc.zzj().zzm(true);
        zzfag zzfag2 = this.zzh;
        zzfag2.zzs(zzbvb.zzb);
        zzfag2.zzr(zzq.zzd());
        zzfag2.zzE(zzbvb.zza);
        zzfai zzG2 = zzfag2.zzG();
        zzffn zzb22 = zzffm.zzb(this.zza, zzffx.zzf(zzG2), 5, zzbvb.zza);
        zzeyz zzeyz2 = new zzeyz((zzeyy) null);
        zzeyz2.zza = zzG2;
        zzfwm zzc22 = this.zze.zzc(new zzexf(zzeyz2, (zzbue) null), new zzeyu(this), (Object) null);
        this.zzi = zzc22;
        zzfwc.zzq(zzc22, new zzeyx(this, zzekb, zzffy, zzb22, zzeyz2), this.zzb);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zzd.zza(zzfbi.zzd(6, (String) null, (zze) null));
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i2) {
        this.zzh.zzo().zza(i2);
    }
}
