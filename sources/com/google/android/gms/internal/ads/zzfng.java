package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzfng extends zzfnx {
    final /* synthetic */ zzfna zza;
    final /* synthetic */ zzfno zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfnj zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfng(zzfnj zzfnj, TaskCompletionSource taskCompletionSource, zzfna zzfna, zzfno zzfno, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzd = zzfnj;
        this.zza = zzfna;
        this.zzb = zzfno;
        this.zzc = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfnt] */
    /* access modifiers changed from: protected */
    public final void zza() {
        try {
            ? zze = this.zzd.zza.zze();
            zzfna zzfna = this.zza;
            String zzb2 = this.zzd.zzd;
            Bundle bundle = new Bundle();
            bundle.putString("sessionToken", zzfna.zzb());
            bundle.putString("callerPackage", zzb2);
            bundle.putString("appId", zzfna.zza());
            zze.zze(bundle, new zzfni(this.zzd, this.zzb));
        } catch (RemoteException e2) {
            zzfnj.zzb.zzb(e2, "dismiss overlay display from: %s", this.zzd.zzd);
            this.zzc.trySetException(new RuntimeException(e2));
        }
    }
}
