package com.google.android.gms.internal.ads;

final class zzagf {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzfa zzf;
    private final zzfa zzg;
    private int zzh;
    private int zzi;

    public zzagf(zzfa zzfa, zzfa zzfa2, boolean z2) throws zzcd {
        this.zzg = zzfa;
        this.zzf = zzfa2;
        this.zze = z2;
        zzfa2.zzF(12);
        this.zza = zzfa2.zzn();
        zzfa.zzF(12);
        this.zzi = zzfa.zzn();
        zzaba.zzb(zzfa.zze() != 1 ? false : true, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        long j2;
        int i2 = this.zzb + 1;
        this.zzb = i2;
        if (i2 == this.zza) {
            return false;
        }
        if (this.zze) {
            j2 = this.zzf.zzt();
        } else {
            j2 = this.zzf.zzs();
        }
        this.zzd = j2;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzn();
            this.zzg.zzG(4);
            int i3 = -1;
            int i4 = this.zzi - 1;
            this.zzi = i4;
            if (i4 > 0) {
                i3 = -1 + this.zzg.zzn();
            }
            this.zzh = i3;
        }
        return true;
    }
}
