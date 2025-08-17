package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzbkl;
import java.util.ArrayList;
import java.util.List;

final class zzei extends zzbkl {
    final /* synthetic */ zzej zza;

    /* synthetic */ zzei(zzej zzej, zzeh zzeh) {
        this.zza = zzej;
    }

    public final void zzb(List list) throws RemoteException {
        int i2;
        ArrayList arrayList;
        synchronized (this.zza.zzb) {
            this.zza.zzd = false;
            this.zza.zze = true;
            arrayList = new ArrayList(this.zza.zzc);
            this.zza.zzc.clear();
        }
        InitializationStatus zzd = zzej.zzy(list);
        int size = arrayList.size();
        for (i2 = 0; i2 < size; i2++) {
            ((OnInitializationCompleteListener) arrayList.get(i2)).onInitializationComplete(zzd);
        }
    }
}
