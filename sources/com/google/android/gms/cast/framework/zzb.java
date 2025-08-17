package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.internal.cast.zzf;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class zzb implements OnSuccessListener {
    public final /* synthetic */ CastContext zza;

    public /* synthetic */ zzb(CastContext castContext) {
        this.zza = castContext;
    }

    public final void onSuccess(Object obj) {
        zzf.zza(this.zza.zze, this.zza.zzl, this.zza.zzg, this.zza.zzp, this.zza.zza).zzc((Bundle) obj);
    }
}
