package com.google.android.gms.internal.ads;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

final class zzpa {
    private final AudioTrack zza;
    private final AudioTimestamp zzb = new AudioTimestamp();
    private long zzc;
    private long zzd;
    private long zze;

    public zzpa(AudioTrack audioTrack) {
        this.zza = audioTrack;
    }

    public final long zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzb.nanoTime / 1000;
    }

    public final boolean zzc() {
        boolean timestamp = this.zza.getTimestamp(this.zzb);
        if (timestamp) {
            long j2 = this.zzb.framePosition;
            if (this.zzd > j2) {
                this.zzc++;
            }
            this.zzd = j2;
            this.zze = j2 + (this.zzc << 32);
        }
        return timestamp;
    }
}
