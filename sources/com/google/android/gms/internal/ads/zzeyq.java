package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.concurrent.atomic.AtomicReference;

public final class zzeyq implements OnAdMetadataChangedListener, zzcwu, zzcvj, zzcvg, zzcvw, zzcxr, zzexb, zzdcu {
    private final zzfbq zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicReference zzh = new AtomicReference();

    public zzeyq(zzfbq zzfbq) {
        this.zza = zzfbq;
    }

    public final void onAdMetadataChanged() {
        zzews.zza(this.zzb, zzeyk.zza);
    }

    public final void zza(zze zze2) {
        int i2 = zze2.zza;
        zzews.zza(this.zzc, new zzexw(zze2));
        zzews.zza(this.zzc, new zzexx(i2));
        zzews.zza(this.zze, new zzexy(i2));
    }

    public final void zzb(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzb.set(onAdMetadataChangedListener);
    }

    public final void zzbG(zzexb zzexb) {
        throw null;
    }

    public final void zzbr() {
        zzews.zza(this.zze, zzeyf.zza);
    }

    public final void zzc(zzdg zzdg) {
        this.zzh.set(zzdg);
    }

    public final void zzd(zzbvq zzbvq) {
        this.zzd.set(zzbvq);
    }

    public final void zze(zzbvu zzbvu) {
        this.zzc.set(zzbvu);
    }

    @Deprecated
    public final void zzf(zzbva zzbva) {
        this.zze.set(zzbva);
    }

    @Deprecated
    public final void zzg(zzbuv zzbuv) {
        this.zzg.set(zzbuv);
    }

    public final void zzh(zzs zzs) {
        zzews.zza(this.zzh, new zzexv(zzs));
    }

    public final void zzi(zzbvv zzbvv) {
        this.zzf.set(zzbvv);
    }

    public final void zzj() {
        this.zza.zza();
        zzews.zza(this.zzd, zzeyc.zza);
        zzews.zza(this.zze, zzeyd.zza);
    }

    public final void zzk(zze zze2) {
        zzews.zza(this.zzd, new zzexz(zze2));
        zzews.zza(this.zzd, new zzeya(zze2));
    }

    public final void zzm() {
        zzews.zza(this.zze, zzeyl.zza);
    }

    public final void zzn() {
        zzews.zza(this.zzc, zzeyi.zza);
        zzews.zza(this.zze, zzeyj.zza);
    }

    public final void zzo() {
        zzews.zza(this.zzd, zzeye.zza);
        zzews.zza(this.zze, zzeyg.zza);
        zzews.zza(this.zzd, zzeyh.zza);
    }

    public final void zzp(zzbuu zzbuu, String str, String str2) {
        zzews.zza(this.zzd, new zzeym(zzbuu));
        zzews.zza(this.zzf, new zzeyn(zzbuu, str, str2));
        zzews.zza(this.zze, new zzeyo(zzbuu));
        zzews.zza(this.zzg, new zzeyp(zzbuu, str, str2));
    }

    public final void zzq() {
        zzews.zza(this.zze, zzeyb.zza);
    }

    public final void zzr() {
        zzews.zza(this.zzd, zzexu.zza);
    }

    public final void zzs() {
    }
}
