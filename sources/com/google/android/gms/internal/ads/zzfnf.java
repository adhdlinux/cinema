package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzfnf extends zzfnx {
    final /* synthetic */ zzfnl zza;
    final /* synthetic */ zzfno zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfnj zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfnf(zzfnj zzfnj, TaskCompletionSource taskCompletionSource, zzfnl zzfnl, zzfno zzfno, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzd = zzfnj;
        this.zza = zzfnl;
        this.zzb = zzfno;
        this.zzc = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfnt] */
    /* access modifiers changed from: protected */
    public final void zza() {
        try {
            ? zze = this.zzd.zza.zze();
            zzfnj zzfnj = this.zzd;
            String zzb2 = zzfnj.zzd;
            zzfnl zzfnl = this.zza;
            String zzb3 = zzfnj.zzd;
            Bundle bundle = new Bundle();
            bundle.putBinder("windowToken", zzfnl.zze());
            bundle.putString("adFieldEnifd", zzfnl.zzf());
            bundle.putInt("layoutGravity", zzfnl.zzc());
            bundle.putFloat("layoutVerticalMargin", zzfnl.zza());
            bundle.putInt("displayMode", 0);
            bundle.putInt("windowWidthPx", zzfnl.zzd());
            bundle.putBoolean("stableSessionToken", false);
            bundle.putString("callerPackage", zzb3);
            if (zzfnl.zzg() != null) {
                bundle.putString("appId", zzfnl.zzg());
            }
            zze.zzf(zzb2, bundle, new zzfni(this.zzd, this.zzb));
        } catch (RemoteException e2) {
            zzfnj.zzb.zzb(e2, "show overlay display from: %s", this.zzd.zzd);
            this.zzc.trySetException(new RuntimeException(e2));
        }
    }
}
