package com.google.android.gms.internal.ads;

import com.startapp.y1;

final class zzait {
    private final zzabz zza;
    private long zzb;
    private boolean zzc;
    private int zzd;
    private long zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private boolean zzm;

    public zzait(zzabz zzabz) {
        this.zza = zzabz;
    }

    private final void zze(int i2) {
        long j2 = this.zzl;
        if (j2 != -9223372036854775807L) {
            this.zza.zzs(j2, this.zzm ? 1 : 0, (int) (this.zzb - this.zzk), i2, (zzaby) null);
        }
    }

    public final void zza(long j2, int i2, boolean z2) {
        if (this.zzj && this.zzg) {
            this.zzm = this.zzc;
            this.zzj = false;
        } else if (this.zzh || this.zzg) {
            if (z2 && this.zzi) {
                zze(i2 + ((int) (j2 - this.zzb)));
            }
            this.zzk = this.zzb;
            this.zzl = this.zze;
            this.zzm = this.zzc;
            this.zzi = true;
        }
    }

    public final void zzb(byte[] bArr, int i2, int i3) {
        if (this.zzf) {
            int i4 = this.zzd;
            int i5 = (i2 + 2) - i4;
            if (i5 < i3) {
                this.zzg = (bArr[i5] & y1.f36938c) != 0;
                this.zzf = false;
                return;
            }
            this.zzd = i4 + (i3 - i2);
        }
    }

    public final void zzc() {
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = false;
        this.zzj = false;
    }

    public final void zzd(long j2, int i2, int i3, long j3, boolean z2) {
        boolean z3 = false;
        this.zzg = false;
        this.zzh = false;
        this.zze = j3;
        this.zzd = 0;
        this.zzb = j2;
        if (i3 >= 32 && i3 != 40) {
            if (this.zzi && !this.zzj) {
                if (z2) {
                    zze(i2);
                }
                this.zzi = false;
            }
            if (i3 <= 35 || i3 == 39) {
                this.zzh = !this.zzj;
                this.zzj = true;
            }
        }
        boolean z4 = i3 >= 16 && i3 <= 21;
        this.zzc = z4;
        if (z4 || i3 <= 9) {
            z3 = true;
        }
        this.zzf = z3;
    }
}
