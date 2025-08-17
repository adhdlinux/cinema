package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzd implements Callable<String> {
    final /* synthetic */ SharedPreferences zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;

    zzd(SharedPreferences sharedPreferences, String str, String str2) {
        this.zza = sharedPreferences;
        this.zzb = str;
        this.zzc = str2;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return this.zza.getString(this.zzb, this.zzc);
    }
}
