package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzcns {
    private final String zza;
    private final zzbni zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public zzcnx zzd;
    private final zzbij zze = new zzcnp(this);
    private final zzbij zzf = new zzcnr(this);

    public zzcns(String str, zzbni zzbni, Executor executor) {
        this.zza = str;
        this.zzb = zzbni;
        this.zzc = executor;
    }

    static /* bridge */ /* synthetic */ boolean zzg(zzcns zzcns, Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(zzcns.zza)) {
            return false;
        }
        return true;
    }

    public final void zzc(zzcnx zzcnx) {
        this.zzb.zzb("/updateActiveView", this.zze);
        this.zzb.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzcnx;
    }

    public final void zzd(zzcez zzcez) {
        zzcez.zzad("/updateActiveView", this.zze);
        zzcez.zzad("/untrackActiveViewUnit", this.zzf);
    }

    public final void zze() {
        this.zzb.zzc("/updateActiveView", this.zze);
        this.zzb.zzc("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzf(zzcez zzcez) {
        zzcez.zzau("/updateActiveView", this.zze);
        zzcez.zzau("/untrackActiveViewUnit", this.zzf);
    }
}
