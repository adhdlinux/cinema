package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

final class zzbxd extends zzbxx {
    private final Clock zzb;
    private final zzbxd zzc = this;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;
    private final zzgwr zzj;
    private final zzgwr zzk;

    /* synthetic */ zzbxd(Context context, Clock clock, zzg zzg2, zzbxw zzbxw, zzbxc zzbxc) {
        this.zzb = clock;
        zzgwe zza = zzgwf.zza(context);
        this.zzd = zza;
        zzgwe zza2 = zzgwf.zza(zzg2);
        this.zze = zza2;
        zzgwe zza3 = zzgwf.zza(zzbxw);
        this.zzf = zza3;
        this.zzg = zzgwd.zzc(new zzbwv(zza, zza2, zza3));
        zzgwe zza4 = zzgwf.zza(clock);
        this.zzh = zza4;
        zzgwr zzc2 = zzgwd.zzc(new zzbwx(zza4, zza2, zza3));
        this.zzi = zzc2;
        zzbwz zzbwz = new zzbwz(zza4, zzc2);
        this.zzj = zzbwz;
        this.zzk = zzgwd.zzc(new zzbyc(zza, zzbwz));
    }

    /* access modifiers changed from: package-private */
    public final zzbwu zza() {
        return (zzbwu) this.zzg.zzb();
    }

    /* access modifiers changed from: package-private */
    public final zzbwy zzb() {
        return new zzbwy(this.zzb, (zzbww) this.zzi.zzb());
    }

    /* access modifiers changed from: package-private */
    public final zzbyb zzc() {
        return (zzbyb) this.zzk.zzb();
    }
}
