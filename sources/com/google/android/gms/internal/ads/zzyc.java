package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class zzyc {
    public static final zzxw zza = new zzxw(0, -9223372036854775807L, (zzxv) null);
    public static final zzxw zzb = new zzxw(1, -9223372036854775807L, (zzxv) null);
    public static final zzxw zzc = new zzxw(2, -9223372036854775807L, (zzxv) null);
    public static final zzxw zzd = new zzxw(3, -9223372036854775807L, (zzxv) null);
    /* access modifiers changed from: private */
    public final ExecutorService zze = zzfj.zzA("ExoPlayer:Loader:ProgressiveMediaPeriod");
    /* access modifiers changed from: private */
    public zzxx zzf;
    /* access modifiers changed from: private */
    public IOException zzg;

    public zzyc(String str) {
    }

    public static zzxw zzb(boolean z2, long j2) {
        return new zzxw(z2 ? 1 : 0, j2, (zzxv) null);
    }

    public final long zza(zzxy zzxy, zzxu zzxu, int i2) {
        Looper myLooper = Looper.myLooper();
        zzdy.zzb(myLooper);
        this.zzg = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzxx(this, myLooper, zzxy, zzxu, i2, elapsedRealtime).zzc(0);
        return elapsedRealtime;
    }

    public final void zzg() {
        zzxx zzxx = this.zzf;
        zzdy.zzb(zzxx);
        zzxx.zza(false);
    }

    public final void zzh() {
        this.zzg = null;
    }

    public final void zzi(int i2) throws IOException {
        IOException iOException = this.zzg;
        if (iOException == null) {
            zzxx zzxx = this.zzf;
            if (zzxx != null) {
                zzxx.zzb(i2);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzj(zzxz zzxz) {
        zzxx zzxx = this.zzf;
        if (zzxx != null) {
            zzxx.zza(true);
        }
        this.zze.execute(new zzya(zzxz));
        this.zze.shutdown();
    }

    public final boolean zzk() {
        return this.zzg != null;
    }

    public final boolean zzl() {
        return this.zzf != null;
    }
}
