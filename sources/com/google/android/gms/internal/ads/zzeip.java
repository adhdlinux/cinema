package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbn;
import com.google.android.gms.ads.internal.client.zzbp;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzq;

public final class zzeip extends zzbp {
    final zzfag zza;
    final zzdhj zzb = new zzdhj();
    private final Context zzc;
    private final zzcgu zzd;
    private zzbh zze;

    public zzeip(zzcgu zzcgu, Context context, String str) {
        zzfag zzfag = new zzfag();
        this.zza = zzfag;
        this.zzd = zzcgu;
        zzfag.zzs(str);
        this.zzc = context;
    }

    public final zzbn zze() {
        zzdhl zzg = this.zzb.zzg();
        this.zza.zzB(zzg.zzi());
        this.zza.zzC(zzg.zzh());
        zzfag zzfag = this.zza;
        if (zzfag.zzg() == null) {
            zzfag.zzr(zzq.zzc());
        }
        return new zzeiq(this.zzc, this.zzd, this.zza, zzg, this.zze);
    }

    public final void zzf(zzbfp zzbfp) {
        this.zzb.zza(zzbfp);
    }

    public final void zzg(zzbfs zzbfs) {
        this.zzb.zzb(zzbfs);
    }

    public final void zzh(String str, zzbfy zzbfy, zzbfv zzbfv) {
        this.zzb.zzc(str, zzbfy, zzbfv);
    }

    public final void zzi(zzbla zzbla) {
        this.zzb.zzd(zzbla);
    }

    public final void zzj(zzbgc zzbgc, zzq zzq) {
        this.zzb.zze(zzbgc);
        this.zza.zzr(zzq);
    }

    public final void zzk(zzbgf zzbgf) {
        this.zzb.zzf(zzbgf);
    }

    public final void zzl(zzbh zzbh) {
        this.zze = zzbh;
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzq(adManagerAdViewOptions);
    }

    public final void zzn(zzbkr zzbkr) {
        this.zza.zzv(zzbkr);
    }

    public final void zzo(zzbef zzbef) {
        this.zza.zzA(zzbef);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzD(publisherAdViewOptions);
    }

    public final void zzq(zzcf zzcf) {
        this.zza.zzQ(zzcf);
    }
}
