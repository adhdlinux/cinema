package com.google.android.gms.internal.ads;

final class zzif implements zzkl {
    private final zzlp zza;
    private final zzie zzb;
    private zzli zzc;
    private zzkl zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzif(zzie zzie, zzdz zzdz) {
        this.zzb = zzie;
        this.zza = new zzlp(zzdz);
    }

    public final long zza() {
        throw null;
    }

    public final long zzb(boolean z2) {
        zzli zzli = this.zzc;
        if (zzli == null || zzli.zzP() || (!this.zzc.zzQ() && (z2 || this.zzc.zzJ()))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        } else {
            zzkl zzkl = this.zzd;
            zzkl.getClass();
            long zza2 = zzkl.zza();
            if (this.zze) {
                if (zza2 < this.zza.zza()) {
                    this.zza.zze();
                } else {
                    this.zze = false;
                    if (this.zzf) {
                        this.zza.zzd();
                    }
                }
            }
            this.zza.zzb(zza2);
            zzch zzc2 = zzkl.zzc();
            if (!zzc2.equals(this.zza.zzc())) {
                this.zza.zzg(zzc2);
                this.zzb.zza(zzc2);
            }
        }
        if (this.zze) {
            return this.zza.zza();
        }
        zzkl zzkl2 = this.zzd;
        zzkl2.getClass();
        return zzkl2.zza();
    }

    public final zzch zzc() {
        zzkl zzkl = this.zzd;
        return zzkl != null ? zzkl.zzc() : this.zza.zzc();
    }

    public final void zzd(zzli zzli) {
        if (zzli == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzli zzli) throws zzih {
        zzkl zzkl;
        zzkl zzi = zzli.zzi();
        if (zzi != null && zzi != (zzkl = this.zzd)) {
            if (zzkl == null) {
                this.zzd = zzi;
                this.zzc = zzli;
                zzi.zzg(this.zza.zzc());
                return;
            }
            throw zzih.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
    }

    public final void zzf(long j2) {
        this.zza.zzb(j2);
    }

    public final void zzg(zzch zzch) {
        zzkl zzkl = this.zzd;
        if (zzkl != null) {
            zzkl.zzg(zzch);
            zzch = this.zzd.zzc();
        }
        this.zza.zzg(zzch);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }
}
