package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zze;
import java.util.HashSet;

public final class zzfbo implements zzcvj {
    private final HashSet zza = new HashSet();
    private final Context zzb;
    private final zzbze zzc;

    public zzfbo(Context context, zzbze zzbze) {
        this.zzb = context;
        this.zzc = zzbze;
    }

    public final synchronized void zza(zze zze) {
        if (zze.zza != 3) {
            this.zzc.zzj(this.zza);
        }
    }

    public final Bundle zzb() {
        return this.zzc.zzl(this.zzb, this);
    }

    public final synchronized void zzc(HashSet hashSet) {
        this.zza.clear();
        this.zza.addAll(hashSet);
    }
}
