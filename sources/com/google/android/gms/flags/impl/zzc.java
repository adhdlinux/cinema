package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzc implements Callable<Long> {
    final /* synthetic */ SharedPreferences zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Long zzc;

    zzc(SharedPreferences sharedPreferences, String str, Long l2) {
        this.zza = sharedPreferences;
        this.zzb = str;
        this.zzc = l2;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return Long.valueOf(this.zza.getLong(this.zzb, this.zzc.longValue()));
    }
}
