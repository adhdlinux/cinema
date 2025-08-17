package com.google.android.gms.internal.ads;

public final class zzbni {
    private final zzbml zza;
    private zzfwm zzb;

    zzbni(zzbml zzbml) {
        this.zza = zzbml;
    }

    private final void zzd() {
        if (this.zzb == null) {
            zzcaj zzcaj = new zzcaj();
            this.zzb = zzcaj;
            this.zza.zzb((zzaqs) null).zzi(new zzbng(zzcaj), new zzbnh(zzcaj));
        }
    }

    public final zzbnl zza(String str, zzbms zzbms, zzbmr zzbmr) {
        zzd();
        return new zzbnl(this.zzb, "google.afma.activeView.handleUpdate", zzbms, zzbmr);
    }

    public final void zzb(String str, zzbij zzbij) {
        zzd();
        this.zzb = zzfwc.zzm(this.zzb, new zzbne(str, zzbij), zzcae.zzf);
    }

    public final void zzc(String str, zzbij zzbij) {
        this.zzb = zzfwc.zzl(this.zzb, new zzbnf(str, zzbij), zzcae.zzf);
    }
}
