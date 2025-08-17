package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzfnh extends zzfnx {
    final /* synthetic */ zzfnq zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzfno zzc;
    final /* synthetic */ TaskCompletionSource zzd;
    final /* synthetic */ zzfnj zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfnh(zzfnj zzfnj, TaskCompletionSource taskCompletionSource, zzfnq zzfnq, int i2, zzfno zzfno, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zze = zzfnj;
        this.zza = zzfnq;
        this.zzb = i2;
        this.zzc = zzfno;
        this.zzd = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfnt] */
    /* access modifiers changed from: protected */
    public final void zza() {
        try {
            ? zze2 = this.zze.zza.zze();
            zzfnq zzfnq = this.zza;
            String zzb2 = this.zze.zzd;
            int i2 = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("sessionToken", zzfnq.zzb());
            bundle.putInt("displayMode", i2);
            bundle.putString("callerPackage", zzb2);
            bundle.putString("appId", zzfnq.zza());
            zze2.zzg(bundle, new zzfni(this.zze, this.zzc));
        } catch (RemoteException e2) {
            zzfnj.zzb.zzb(e2, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(this.zzb), this.zze.zzd);
            this.zzd.trySetException(new RuntimeException(e2));
        }
    }
}
