package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

final class zzpo {
    public final zzam zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzdo zzi;
    public final boolean zzj = false;
    public final boolean zzk = false;

    public zzpo(zzam zzam, int i2, int i3, int i4, int i5, int i6, int i7, int i8, zzdo zzdo, boolean z2, boolean z3) {
        this.zza = zzam;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
        this.zzg = i7;
        this.zzh = i8;
        this.zzi = zzdo;
    }

    public final long zza(long j2) {
        return (j2 * 1000000) / ((long) this.zze);
    }

    public final AudioTrack zzb(boolean z2, zzk zzk2, int i2) throws zzov {
        AudioTrack audioTrack;
        boolean z3;
        try {
            int i3 = zzfj.zza;
            if (i3 >= 29) {
                AudioTrack.Builder a2 = new AudioTrack.Builder().setAudioAttributes(zzk2.zza().zza).setAudioFormat(zzfj.zzs(this.zze, this.zzf, this.zzg)).setTransferMode(1).setBufferSizeInBytes(this.zzh).setSessionId(i2);
                if (this.zzc == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                audioTrack = a2.setOffloadedPlayback(z3).build();
            } else if (i3 < 21) {
                int i4 = zzk2.zzc;
                if (i2 == 0) {
                    audioTrack = new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1);
                } else {
                    audioTrack = new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1, i2);
                }
            } else {
                audioTrack = new AudioTrack(zzk2.zza().zza, zzfj.zzs(this.zze, this.zzf, this.zzg), this.zzh, 1, i2);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new zzov(state, this.zze, this.zzf, this.zzh, this.zza, zzc(), (Exception) null);
        } catch (IllegalArgumentException | UnsupportedOperationException e2) {
            throw new zzov(0, this.zze, this.zzf, this.zzh, this.zza, zzc(), e2);
        }
    }

    public final boolean zzc() {
        return this.zzc == 1;
    }
}
