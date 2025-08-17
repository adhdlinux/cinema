package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzb implements Callable<Integer> {
    final /* synthetic */ SharedPreferences zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Integer zzc;

    zzb(SharedPreferences sharedPreferences, String str, Integer num) {
        this.zza = sharedPreferences;
        this.zzb = str;
        this.zzc = num;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return Integer.valueOf(this.zza.getInt(this.zzb, this.zzc.intValue()));
    }
}
