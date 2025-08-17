package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzfjm {
    private final Context zza;
    private final Looper zzb;

    public zzfjm(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfka zza2 = zzfkc.zza();
        zza2.zza(this.zza.getPackageName());
        zza2.zzc(2);
        zzfjx zza3 = zzfjy.zza();
        zza3.zza(str);
        zza3.zzb(2);
        zza2.zzb(zza3);
        new zzfjn(this.zza, this.zzb, (zzfkc) zza2.zzal()).zza();
    }
}
