package com.google.android.gms.internal.ads;

final class zzajg {
    private final zzaij zza;
    private final zzfh zzb;
    private final zzez zzc = new zzez(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzajg(zzaij zzaij, zzfh zzfh) {
        this.zza = zzaij;
        this.zzb = zzfh;
    }

    public final void zza(zzfa zzfa) throws zzcd {
        long j2;
        zzfa zzfa2 = zzfa;
        zzfa2.zzB(this.zzc.zza, 0, 3);
        this.zzc.zzj(0);
        this.zzc.zzl(8);
        this.zzd = this.zzc.zzn();
        this.zze = this.zzc.zzn();
        this.zzc.zzl(6);
        zzfa2.zzB(this.zzc.zza, 0, this.zzc.zzd(8));
        this.zzc.zzj(0);
        if (this.zzd) {
            this.zzc.zzl(4);
            long zzd2 = (long) this.zzc.zzd(3);
            this.zzc.zzl(1);
            int zzd3 = this.zzc.zzd(15) << 15;
            this.zzc.zzl(1);
            long zzd4 = (long) this.zzc.zzd(15);
            this.zzc.zzl(1);
            if (!this.zzf && this.zze) {
                this.zzc.zzl(4);
                this.zzc.zzl(1);
                this.zzc.zzl(1);
                long zzd5 = (long) this.zzc.zzd(15);
                this.zzc.zzl(1);
                this.zzb.zzb(((long) (this.zzc.zzd(15) << 15)) | (((long) this.zzc.zzd(3)) << 30) | zzd5);
                this.zzf = true;
            }
            j2 = this.zzb.zzb((zzd2 << 30) | ((long) zzd3) | zzd4);
        } else {
            j2 = 0;
        }
        this.zza.zzd(j2, 4);
        this.zza.zza(zzfa2);
        this.zza.zzc();
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zze();
    }
}
