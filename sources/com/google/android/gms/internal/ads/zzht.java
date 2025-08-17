package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

final class zzht {
    private final Context zza;
    private final zzhr zzb;

    public zzht(Context context, Handler handler, zzhs zzhs) {
        this.zza = context.getApplicationContext();
        this.zzb = new zzhr(this, handler, zzhs);
    }
}
