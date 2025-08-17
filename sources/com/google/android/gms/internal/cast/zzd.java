package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class zzd implements OnSuccessListener {
    public final /* synthetic */ zzf zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ SharedPreferences zzc;

    public /* synthetic */ zzd(zzf zzf, String str, SharedPreferences sharedPreferences) {
        this.zza = zzf;
        this.zzb = str;
        this.zzc = sharedPreferences;
    }

    public final void onSuccess(Object obj) {
        this.zza.zzb(this.zzb, this.zzc, (Bundle) obj);
    }
}
