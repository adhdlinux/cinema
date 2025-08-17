package com.google.android.gms.internal.ads;

public final class zzid implements zzkk {
    private final zzxp zzb;
    private final long zzc = zzfj.zzo(50000);
    private final long zzd = zzfj.zzo(50000);
    private final long zze = zzfj.zzo(2500);
    private final long zzf = zzfj.zzo(5000);
    private final long zzg = zzfj.zzo(0);
    private int zzh = 13107200;
    private boolean zzi;

    public zzid() {
        zzxp zzxp = new zzxp(true, 65536);
        zzj(2500, 0, "bufferForPlaybackMs", "0");
        zzj(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzj(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzj(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzj(50000, 50000, "maxBufferMs", "minBufferMs");
        zzj(0, 0, "backBufferDurationMs", "0");
        this.zzb = zzxp;
    }

    private static void zzj(int i2, int i3, String str, String str2) {
        zzdy.zze(i2 >= i3, str + " cannot be less than " + str2);
    }

    private final void zzk(boolean z2) {
        this.zzh = 13107200;
        this.zzi = false;
        if (z2) {
            this.zzb.zze();
        }
    }

    public final long zza() {
        return this.zzg;
    }

    public final void zzb() {
        zzk(false);
    }

    public final void zzc() {
        zzk(true);
    }

    public final void zzd() {
        zzk(true);
    }

    public final void zze(zzcw zzcw, zzbw zzbw, zzli[] zzliArr, zzvn zzvn, zzxa[] zzxaArr) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int length = zzliArr.length;
            int i4 = 13107200;
            if (i2 < 2) {
                if (zzxaArr[i2] != null) {
                    if (zzliArr[i2].zzb() != 1) {
                        i4 = 131072000;
                    }
                    i3 += i4;
                }
                i2++;
            } else {
                int max = Math.max(13107200, i3);
                this.zzh = max;
                this.zzb.zzf(max);
                return;
            }
        }
    }

    public final boolean zzf() {
        return false;
    }

    public final boolean zzg(long j2, long j3, float f2) {
        int zza = this.zzb.zza();
        int i2 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
        int i3 = this.zzh;
        long j4 = this.zzc;
        if (i2 > 0) {
            j4 = Math.min(zzfj.zzm(j4, f2), this.zzd);
        }
        boolean z2 = false;
        if (j3 < Math.max(j4, 500000)) {
            if (zza < i3) {
                z2 = true;
            }
            this.zzi = z2;
            if (!z2 && j3 < 500000) {
                zzer.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j3 >= this.zzd || zza >= i3) {
            this.zzi = false;
        }
        return this.zzi;
    }

    public final boolean zzh(zzcw zzcw, zzbw zzbw, long j2, float f2, boolean z2, long j3) {
        long j4;
        long zzn = zzfj.zzn(j2, f2);
        if (z2) {
            j4 = this.zzf;
        } else {
            j4 = this.zze;
        }
        if (j3 != -9223372036854775807L) {
            j4 = Math.min(j3 / 2, j4);
        }
        if (j4 <= 0 || zzn >= j4 || this.zzb.zza() >= this.zzh) {
            return true;
        }
        return false;
    }

    public final zzxp zzi() {
        return this.zzb;
    }
}
