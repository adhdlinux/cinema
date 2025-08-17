package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zze implements Callable<SharedPreferences> {
    final /* synthetic */ Context zza;

    zze(Context context) {
        this.zza = context;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return this.zza.getSharedPreferences("google_sdk_flags", 0);
    }
}
