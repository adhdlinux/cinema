package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzfl;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.zzs;
import java.util.ArrayList;
import java.util.List;

public final class zzfai {
    public final zzfl zza;
    public final zzbkr zzb;
    public final zzejm zzc;
    public final zzl zzd;
    public final zzq zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbef zzi;
    public final zzw zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final zzcb zzn;
    public final zzezv zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final zzcf zzr;

    /* synthetic */ zzfai(zzfag zzfag, zzfah zzfah) {
        zzfl zzfl;
        zzbef zzbef;
        this.zze = zzfag.zzb;
        this.zzf = zzfag.zzc;
        this.zzr = zzfag.zzs;
        int i2 = zzfag.zza.zza;
        long j2 = zzfag.zza.zzb;
        Bundle bundle = zzfag.zza.zzc;
        int i3 = zzfag.zza.zzd;
        List list = zzfag.zza.zze;
        boolean z2 = zzfag.zza.zzf;
        int i4 = zzfag.zza.zzg;
        boolean z3 = true;
        if (!zzfag.zza.zzh && !zzfag.zze) {
            z3 = false;
        }
        this.zzd = new zzl(i2, j2, bundle, i3, list, z2, i4, z3, zzfag.zza.zzi, zzfag.zza.zzj, zzfag.zza.zzk, zzfag.zza.zzl, zzfag.zza.zzm, zzfag.zza.zzn, zzfag.zza.zzo, zzfag.zza.zzp, zzfag.zza.zzq, zzfag.zza.zzr, zzfag.zza.zzs, zzfag.zza.zzt, zzfag.zza.zzu, zzfag.zza.zzv, zzs.zza(zzfag.zza.zzw), zzfag.zza.zzx);
        if (zzfag.zzd != null) {
            zzfl = zzfag.zzd;
        } else if (zzfag.zzh != null) {
            zzfl = zzfag.zzh.zzf;
        } else {
            zzfl = null;
        }
        this.zza = zzfl;
        this.zzg = zzfag.zzf;
        this.zzh = zzfag.zzg;
        if (zzfag.zzf == null) {
            zzbef = null;
        } else if (zzfag.zzh == null) {
            zzbef = new zzbef(new NativeAdOptions.Builder().build());
        } else {
            zzbef = zzfag.zzh;
        }
        this.zzi = zzbef;
        this.zzj = zzfag.zzi;
        this.zzk = zzfag.zzm;
        this.zzl = zzfag.zzj;
        this.zzm = zzfag.zzk;
        this.zzn = zzfag.zzl;
        this.zzb = zzfag.zzn;
        this.zzo = new zzezv(zzfag.zzo, (zzezu) null);
        this.zzp = zzfag.zzp;
        this.zzc = zzfag.zzq;
        this.zzq = zzfag.zzr;
    }

    public final zzbgi zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzb();
        }
        return this.zzl.zza();
    }

    public final boolean zzb() {
        return this.zzf.matches((String) zzba.zzc().zzb(zzbbm.zzcO));
    }
}
