package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class zzej implements Handler.Callback {
    public final /* synthetic */ zzeo zza;

    public /* synthetic */ zzej(zzeo zzeo) {
        this.zza = zzeo;
    }

    public final boolean handleMessage(Message message) {
        zzeo.zzg(this.zza, message);
        return true;
    }
}
