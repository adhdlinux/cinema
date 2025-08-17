package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzdco extends zzdaq implements zzaua {
    private final Map zzb = new WeakHashMap(1);
    private final Context zzc;
    private final zzezn zzd;

    public zzdco(Context context, Set set, zzezn zzezn) {
        super(set);
        this.zzc = context;
        this.zzd = zzezn;
    }

    public final synchronized void zza(View view) {
        zzaub zzaub = (zzaub) this.zzb.get(view);
        if (zzaub == null) {
            zzaub = new zzaub(this.zzc, view);
            zzaub.zzc(this);
            this.zzb.put(view, zzaub);
        }
        if (this.zzd.zzY) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzbk)).booleanValue()) {
                zzaub.zzg(((Long) zzba.zzc().zzb(zzbbm.zzbj)).longValue());
                return;
            }
        }
        zzaub.zzf();
    }

    public final synchronized void zzb(View view) {
        if (this.zzb.containsKey(view)) {
            ((zzaub) this.zzb.get(view)).zze(this);
            this.zzb.remove(view);
        }
    }

    public final synchronized void zzc(zzatz zzatz) {
        zzp(new zzdcn(zzatz));
    }
}
