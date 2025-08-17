package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.ScheduledExecutorService;

public final class zzekj implements zzekc {
    private final zzfag zza;
    /* access modifiers changed from: private */
    public final zzcgu zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final zzejz zzd;
    /* access modifiers changed from: private */
    public final zzfgb zze;
    private zzcrr zzf;

    public zzekj(zzcgu zzcgu, Context context, zzejz zzejz, zzfag zzfag) {
        this.zzb = zzcgu;
        this.zzc = context;
        this.zzd = zzejz;
        this.zza = zzfag;
        this.zze = zzcgu.zzy();
        zzfag.zzu(zzejz.zzd());
    }

    public final boolean zza() {
        zzcrr zzcrr = this.zzf;
        return zzcrr != null && zzcrr.zzf();
    }

    public final boolean zzb(zzl zzl, String str, zzeka zzeka, zzekb zzekb) throws RemoteException {
        zzffy zzffy;
        zzt.zzp();
        if (zzs.zzD(this.zzc) && zzl.zzs == null) {
            zzbzr.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzA().execute(new zzeke(this));
            return false;
        } else if (str == null) {
            zzbzr.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzA().execute(new zzekf(this));
            return false;
        } else {
            zzfbc.zza(this.zzc, zzl.zzf);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue() && zzl.zzf) {
                this.zzb.zzj().zzm(true);
            }
            int i2 = ((zzekd) zzeka).zza;
            zzfag zzfag = this.zza;
            zzfag.zzE(zzl);
            zzfag.zzz(i2);
            zzfai zzG = zzfag.zzG();
            zzffn zzb2 = zzffm.zzb(this.zzc, zzffx.zzf(zzG), 8, zzl);
            zzcb zzcb = zzG.zzn;
            if (zzcb != null) {
                this.zzd.zzd().zzi(zzcb);
            }
            zzdfj zzg = this.zzb.zzg();
            zzcuo zzcuo = new zzcuo();
            zzcuo.zze(this.zzc);
            zzcuo.zzi(zzG);
            zzg.zzf(zzcuo.zzj());
            zzdar zzdar = new zzdar();
            zzdar.zzk(this.zzd.zzd(), this.zzb.zzA());
            zzg.zze(zzdar.zzn());
            zzg.zzd(this.zzd.zzc());
            zzg.zzc(new zzcoy((ViewGroup) null));
            zzdfk zzg2 = zzg.zzg();
            if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
                zzffy zzf2 = zzg2.zzf();
                zzf2.zzh(8);
                zzf2.zzb(zzl.zzp);
                zzffy = zzf2;
            } else {
                zzffy = null;
            }
            this.zzb.zzw().zzc(1);
            zzfwn zzfwn = zzcae.zza;
            zzgwm.zzb(zzfwn);
            ScheduledExecutorService zzB = this.zzb.zzB();
            zzcsk zza2 = zzg2.zza();
            zzcrr zzcrr = new zzcrr(zzfwn, zzB, zza2.zzi(zza2.zzj()));
            this.zzf = zzcrr;
            zzcrr.zze(new zzeki(this, zzekb, zzffy, zzb2, zzg2));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        this.zzd.zza().zza(zzfbi.zzd(4, (String) null, (zze) null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzd.zza().zza(zzfbi.zzd(6, (String) null, (zze) null));
    }
}
