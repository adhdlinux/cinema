package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.io.IOException;

public final /* synthetic */ class zzawq implements Runnable {
    public final /* synthetic */ zzawt zza;
    public final /* synthetic */ zzawk zzb;
    public final /* synthetic */ zzawl zzc;
    public final /* synthetic */ zzcaj zzd;

    public /* synthetic */ zzawq(zzawt zzawt, zzawk zzawk, zzawl zzawl, zzcaj zzcaj) {
        this.zza = zzawt;
        this.zzb = zzawk;
        this.zzc = zzawl;
        this.zzd = zzcaj;
    }

    public final void run() {
        zzawi zzawi;
        zzawt zzawt = this.zza;
        zzawk zzawk = this.zzb;
        zzawl zzawl = this.zzc;
        zzcaj zzcaj = this.zzd;
        try {
            zzawn zzq = zzawk.zzq();
            if (zzawk.zzp()) {
                zzawi = zzq.zzg(zzawl);
            } else {
                zzawi = zzq.zzf(zzawl);
            }
            if (!zzawi.zze()) {
                zzcaj.zze(new RuntimeException("No entry contents."));
                zzawv.zze(zzawt.zzc);
                return;
            }
            zzaws zzaws = new zzaws(zzawt, zzawi.zzc(), 1);
            int read = zzaws.read();
            if (read != -1) {
                zzaws.unread(read);
                zzcaj.zzd(zzawx.zzb(zzaws, zzawi.zzd(), zzawi.zzg(), zzawi.zza(), zzawi.zzf()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e2) {
            zzbzr.zzh("Unable to obtain a cache service instance.", e2);
            zzcaj.zze(e2);
            zzawv.zze(zzawt.zzc);
        }
    }
}
