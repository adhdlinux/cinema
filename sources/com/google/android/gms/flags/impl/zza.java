package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zza implements Callable<Boolean> {
    final /* synthetic */ SharedPreferences zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Boolean zzc;

    zza(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.zza = sharedPreferences;
        this.zzb = str;
        this.zzc = bool;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return Boolean.valueOf(this.zza.getBoolean(this.zzb, this.zzc.booleanValue()));
    }
}
