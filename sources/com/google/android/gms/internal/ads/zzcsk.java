package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class zzcsk {
    private final zzdvg zza;
    private final zzfai zzb;
    private final zzfel zzc;
    private final zzcmh zzd;
    private final zzefw zze;
    /* access modifiers changed from: private */
    public final zzdal zzf;
    private zzezz zzg;
    private final zzdwl zzh;
    private final zzcuk zzi;
    private final Executor zzj;
    private final zzdvx zzk;
    private final zzech zzl;
    private final zzdxb zzm;
    private final zzdxi zzn;

    zzcsk(zzdvg zzdvg, zzfai zzfai, zzfel zzfel, zzcmh zzcmh, zzefw zzefw, zzdal zzdal, zzezz zzezz, zzdwl zzdwl, zzcuk zzcuk, Executor executor, zzdvx zzdvx, zzech zzech, zzdxb zzdxb, zzdxi zzdxi) {
        this.zza = zzdvg;
        this.zzb = zzfai;
        this.zzc = zzfel;
        this.zzd = zzcmh;
        this.zze = zzefw;
        this.zzf = zzdal;
        this.zzg = zzezz;
        this.zzh = zzdwl;
        this.zzi = zzcuk;
        this.zzj = executor;
        this.zzk = zzdvx;
        this.zzl = zzech;
        this.zzm = zzdxb;
        this.zzn = zzdxi;
    }

    public final zze zza(Throwable th) {
        return zzfbi.zzb(th, this.zzl);
    }

    public final zzdal zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzezz zzd(zzezz zzezz) throws Exception {
        this.zzd.zza(zzezz);
        return zzezz;
    }

    public final zzfwm zze(zzfcb zzfcb) {
        zzfdq zza2 = this.zzc.zzb(zzfef.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzcsh(this, zzfcb)).zza();
        zzfwc.zzq(zza2, new zzcsi(this), this.zzj);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzf(zzfcb zzfcb, zzbue zzbue) throws Exception {
        zzbue.zzi = zzfcb;
        return this.zzh.zza(zzbue);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzg(zzfwm zzfwm, zzfwm zzfwm2, zzfwm zzfwm3) throws Exception {
        return this.zzn.zzc((zzbue) zzfwm.get(), (JSONObject) zzfwm2.get(), (zzbuh) zzfwm3.get());
    }

    public final zzfwm zzh(zzbue zzbue) {
        zzfdq zza2 = this.zzc.zzb(zzfef.NOTIFY_CACHE_HIT, this.zzh.zzg(zzbue)).zza();
        zzfwc.zzq(zza2, new zzcsj(this), this.zzj);
        return zza2;
    }

    public final zzfwm zzi(zzfwm zzfwm) {
        zzfec zzf2 = this.zzc.zzb(zzfef.RENDERER, zzfwm).zze(new zzcsg(this)).zzf(this.zze);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzfl)).booleanValue()) {
            zzf2 = zzf2.zzi((long) ((Integer) zzba.zzc().zzb(zzbbm.zzfm)).intValue(), TimeUnit.SECONDS);
        }
        return zzf2.zza();
    }

    public final zzfwm zzj() {
        zzl zzl2 = this.zzb.zzd;
        if (zzl2.zzx == null && zzl2.zzs == null) {
            return zzk(this.zzi.zzc());
        }
        zzfel zzfel = this.zzc;
        return zzfdv.zzc(this.zza.zza(), zzfef.PRELOADED_LOADER, zzfel).zza();
    }

    public final zzfwm zzk(zzfwm zzfwm) {
        zzezz zzezz = this.zzg;
        if (zzezz != null) {
            zzfel zzfel = this.zzc;
            return zzfdv.zzc(zzfwc.zzh(zzezz), zzfef.SERVER_TRANSACTION, zzfel).zza();
        }
        zzt.zzc().zzj();
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjT)).booleanValue() || ((Boolean) zzbdk.zzb.zze()).booleanValue()) {
            return this.zzc.zzb(zzfef.SERVER_TRANSACTION, zzfwm).zzf(new zzcsf(this.zzk)).zza();
        }
        zzfwm zzm2 = zzfwc.zzm(zzfwm, new zzcsb(this.zzm), this.zzj);
        zzfdq zza2 = this.zzc.zzb(zzfef.BUILD_URL, zzm2).zzf(new zzcsc(this.zzh)).zza();
        return this.zzc.zza(zzfef.SERVER_TRANSACTION, zzfwm, zzm2, zza2).zza(new zzcsd(this, zzfwm, zzm2, zza2)).zzf(zzcse.zza).zza();
    }

    public final void zzl(zzezz zzezz) {
        this.zzg = zzezz;
    }
}
