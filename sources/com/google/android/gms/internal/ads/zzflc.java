package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;

public final class zzflc {
    final /* synthetic */ zzfld zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzflc(zzfld zzfld, byte[] bArr, zzflb zzflb) {
        this.zza = zzfld;
        this.zzb = bArr;
    }

    public final zzflc zza(int i2) {
        this.zzd = i2;
        return this;
    }

    public final zzflc zzb(int i2) {
        this.zzc = i2;
        return this;
    }

    public final synchronized void zzc() {
        try {
            zzfld zzfld = this.zza;
            if (zzfld.zzb) {
                zzfld.zza.zzj(this.zzb);
                this.zza.zza.zzi(this.zzc);
                this.zza.zza.zzg(this.zzd);
                this.zza.zza.zzh((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e2) {
            Log.d("GASS", "Clearcut log failed", e2);
        }
    }
}
