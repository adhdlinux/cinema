package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdm extends zzdt {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzee zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdm(zzee zzee, boolean z2) {
        super(zzee, true);
        this.zzb = zzee;
        this.zza = z2;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzb.zzj)).setDataCollectionEnabled(this.zza);
    }
}
