package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;

public final class zzevz implements zzekc {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcgu zzc;
    /* access modifiers changed from: private */
    public final zzejm zzd;
    /* access modifiers changed from: private */
    public final zzejq zze;
    /* access modifiers changed from: private */
    public final ViewGroup zzf;
    private zzbck zzg;
    /* access modifiers changed from: private */
    public final zzcxv zzh;
    /* access modifiers changed from: private */
    public final zzfgb zzi;
    /* access modifiers changed from: private */
    public final zzdac zzj;
    private final zzfag zzk;
    /* access modifiers changed from: private */
    public zzfwm zzl;

    public zzevz(Context context, Executor executor, zzq zzq, zzcgu zzcgu, zzejm zzejm, zzejq zzejq, zzfag zzfag, zzdac zzdac) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgu;
        this.zzd = zzejm;
        this.zze = zzejq;
        this.zzk = zzfag;
        this.zzh = zzcgu.zze();
        this.zzi = zzcgu.zzy();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdac;
        zzfag.zzr(zzq);
    }

    public final boolean zza() {
        zzfwm zzfwm = this.zzl;
        return zzfwm != null && !zzfwm.isDone();
    }

    public final boolean zzb(zzl zzl2, String str, zzeka zzeka, zzekb zzekb) throws RemoteException {
        zzcpy zzcpy;
        zzffy zzffy;
        if (str == null) {
            zzbzr.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new zzevv(this));
            return false;
        } else if (zza()) {
            return false;
        } else {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue() && zzl2.zzf) {
                this.zzc.zzj().zzm(true);
            }
            zzfag zzfag = this.zzk;
            zzfag.zzs(str);
            zzfag.zzE(zzl2);
            zzfai zzG = zzfag.zzG();
            zzffn zzb2 = zzffm.zzb(this.zza, zzffx.zzf(zzG), 3, zzl2);
            if (!((Boolean) zzbdk.zzd.zze()).booleanValue() || !this.zzk.zzg().zzk) {
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzhJ)).booleanValue()) {
                    zzcpx zzd2 = this.zzc.zzd();
                    zzcuo zzcuo = new zzcuo();
                    zzcuo.zze(this.zza);
                    zzcuo.zzi(zzG);
                    zzd2.zzi(zzcuo.zzj());
                    zzdar zzdar = new zzdar();
                    zzdar.zzj(this.zzd, this.zzb);
                    zzdar.zzk(this.zzd, this.zzb);
                    zzd2.zzf(zzdar.zzn());
                    zzd2.zze(new zzehv(this.zzg));
                    zzd2.zzd(new zzdff(zzdhl.zza, (zzbh) null));
                    zzd2.zzg(new zzcqv(this.zzh, this.zzj));
                    zzd2.zzc(new zzcoy(this.zzf));
                    zzcpy = zzd2.zzk();
                } else {
                    zzcpx zzd3 = this.zzc.zzd();
                    zzcuo zzcuo2 = new zzcuo();
                    zzcuo2.zze(this.zza);
                    zzcuo2.zzi(zzG);
                    zzd3.zzi(zzcuo2.zzj());
                    zzdar zzdar2 = new zzdar();
                    zzdar2.zzj(this.zzd, this.zzb);
                    zzdar2.zza(this.zzd, this.zzb);
                    zzdar2.zza(this.zze, this.zzb);
                    zzdar2.zzl(this.zzd, this.zzb);
                    zzdar2.zzd(this.zzd, this.zzb);
                    zzdar2.zze(this.zzd, this.zzb);
                    zzdar2.zzf(this.zzd, this.zzb);
                    zzdar2.zzb(this.zzd, this.zzb);
                    zzdar2.zzk(this.zzd, this.zzb);
                    zzdar2.zzi(this.zzd, this.zzb);
                    zzd3.zzf(zzdar2.zzn());
                    zzd3.zze(new zzehv(this.zzg));
                    zzd3.zzd(new zzdff(zzdhl.zza, (zzbh) null));
                    zzd3.zzg(new zzcqv(this.zzh, this.zzj));
                    zzd3.zzc(new zzcoy(this.zzf));
                    zzcpy = zzd3.zzk();
                }
                zzcpy zzcpy2 = zzcpy;
                if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
                    zzffy zzj2 = zzcpy2.zzj();
                    zzj2.zzh(3);
                    zzj2.zzb(zzl2.zzp);
                    zzffy = zzj2;
                } else {
                    zzffy = null;
                }
                zzcsk zzd4 = zzcpy2.zzd();
                zzfwm zzi2 = zzd4.zzi(zzd4.zzj());
                this.zzl = zzi2;
                zzfwc.zzq(zzi2, new zzevy(this, zzekb, zzffy, zzb2, zzcpy2), this.zzb);
                return true;
            }
            zzejm zzejm = this.zzd;
            if (zzejm != null) {
                zzejm.zza(zzfbi.zzd(7, (String) null, (zze) null));
            }
            return false;
        }
    }

    public final ViewGroup zzd() {
        return this.zzf;
    }

    public final zzfag zzi() {
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        this.zzd.zza(zzfbi.zzd(6, (String) null, (zze) null));
    }

    public final void zzn() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzo(zzbe zzbe) {
        this.zze.zza(zzbe);
    }

    public final void zzp(zzcxw zzcxw) {
        this.zzh.zzm(zzcxw, this.zzb);
    }

    public final void zzq(zzbck zzbck) {
        this.zzg = zzbck;
    }

    public final boolean zzr() {
        ViewParent parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        zzt.zzp();
        return zzs.zzS(view, view.getContext());
    }
}
