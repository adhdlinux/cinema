package com.google.android.gms.internal.ads;

final class zzqe implements zzow {
    final /* synthetic */ zzqf zza;

    /* synthetic */ zzqe(zzqf zzqf, zzqd zzqd) {
        this.zza = zzqf;
    }

    public final void zza(Exception exc) {
        zzer.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }

    public final void zzb() {
        zzqf zzqf = this.zza;
        if (zzqf.zzm != null) {
            zzqf.zzm.zzb();
        }
    }
}
