package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class zzbn implements OnSuccessListener {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ zzbq zzb;

    public /* synthetic */ zzbn(zzbp zzbp, zzbq zzbq) {
        this.zza = zzbp;
        this.zzb = zzbq;
    }

    public final void onSuccess(Object obj) {
        zzbp zzbp = this.zza;
        Void voidR = (Void) obj;
        int i2 = CastSession.zza;
        zzbp.setResult(new Status(0));
    }
}
