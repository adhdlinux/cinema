package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import com.google.android.gms.cast.framework.media.NotificationOptions;

final class zzpb {
    private final zzpa zza;
    private int zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;

    public zzpb(AudioTrack audioTrack) {
        int i2 = zzfj.zza;
        this.zza = new zzpa(audioTrack);
        zzh(0);
    }

    private final void zzh(int i2) {
        this.zzb = i2;
        long j2 = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
        if (i2 == 0) {
            this.zze = 0;
            this.zzf = -1;
            this.zzc = System.nanoTime() / 1000;
        } else if (i2 != 1) {
            j2 = (i2 == 2 || i2 == 3) ? 10000000 : 500000;
        } else {
            this.zzd = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
            return;
        }
        this.zzd = j2;
    }

    @TargetApi(19)
    public final long zza() {
        return this.zza.zza();
    }

    @TargetApi(19)
    public final long zzb() {
        return this.zza.zzb();
    }

    public final void zzc() {
        if (this.zzb == 4) {
            zzh(0);
        }
    }

    public final void zzd() {
        zzh(4);
    }

    public final void zze() {
        zzh(0);
    }

    public final boolean zzf() {
        return this.zzb == 2;
    }

    @TargetApi(19)
    public final boolean zzg(long j2) {
        zzpa zzpa = this.zza;
        if (j2 - this.zze < this.zzd) {
            return false;
        }
        this.zze = j2;
        boolean zzc2 = zzpa.zzc();
        int i2 = this.zzb;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        if (!zzc2) {
                            return false;
                        }
                        zzh(0);
                        return true;
                    }
                } else if (zzc2) {
                    return true;
                } else {
                    zzh(0);
                    return false;
                }
            } else if (!zzc2) {
                zzh(0);
            } else if (this.zza.zza() > this.zzf) {
                zzh(2);
                return true;
            }
        } else if (zzc2) {
            if (this.zza.zzb() < this.zzc) {
                return false;
            }
            this.zzf = this.zza.zza();
            zzh(1);
            return true;
        } else if (j2 - this.zzc > 500000) {
            zzh(3);
            return false;
        }
        return zzc2;
    }
}
