package com.google.android.gms.internal.ads;

import android.os.IBinder;

public final /* synthetic */ class zzfnz implements IBinder.DeathRecipient {
    public final /* synthetic */ zzfoh zza;

    public /* synthetic */ zzfnz(zzfoh zzfoh) {
        this.zza = zzfoh;
    }

    public final void binderDied() {
        zzfoh.zzj(this.zza);
    }
}
