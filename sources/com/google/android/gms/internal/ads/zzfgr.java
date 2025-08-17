package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class zzfgr {
    private final Context zza;
    private final Executor zzb;
    private final zzbzw zzc;
    private final zzfgb zzd;

    zzfgr(Context context, Executor executor, zzbzw zzbzw, zzfgb zzfgb) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzbzw;
        this.zzd = zzfgb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        this.zzc.zza(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(String str, zzffy zzffy) {
        zzffn zza2 = zzffm.zza(this.zza, 14);
        zza2.zzh();
        zza2.zzf(this.zzc.zza(str));
        if (zzffy == null) {
            this.zzd.zzb(zza2.zzl());
            return;
        }
        zzffy.zza(zza2);
        zzffy.zzg();
    }

    public final void zzc(String str, zzffy zzffy) {
        if (!zzfgb.zza() || !((Boolean) zzbcy.zzd.zze()).booleanValue()) {
            this.zzb.execute(new zzfgp(this, str));
        } else {
            this.zzb.execute(new zzfgq(this, str, zzffy));
        }
    }

    public final void zzd(List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            zzc((String) it2.next(), (zzffy) null);
        }
    }
}
