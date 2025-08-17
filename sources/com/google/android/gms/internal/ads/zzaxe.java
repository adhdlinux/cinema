package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzaxe {
    final /* synthetic */ zzaxf zza;
    private final byte[] zzb;
    private int zzc;

    /* synthetic */ zzaxe(zzaxf zzaxf, byte[] bArr, zzaxd zzaxd) {
        this.zza = zzaxf;
        this.zzb = bArr;
    }

    /* access modifiers changed from: private */
    public final synchronized void zzd() {
        try {
            zzaxf zzaxf = this.zza;
            if (zzaxf.zzb) {
                zzaxf.zza.zzj(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzg(this.zzc);
                this.zza.zza.zzh((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e2) {
            zzbzr.zzf("Clearcut log failed", e2);
        }
    }

    public final zzaxe zza(int i2) {
        this.zzc = i2;
        return this;
    }

    public final synchronized void zzc() {
        this.zza.zzc.execute(new zzaxc(this));
    }
}
