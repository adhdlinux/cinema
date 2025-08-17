package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class zzbi implements OnSuccessListener {
    public final /* synthetic */ zzbm zza;

    public /* synthetic */ zzbi(zzbm zzbm) {
        this.zza = zzbm;
    }

    public final void onSuccess(Object obj) {
        zzbm.zzd(this.zza, (SessionState) obj);
    }
}
