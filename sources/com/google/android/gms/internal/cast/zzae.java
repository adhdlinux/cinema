package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zzae extends zzt {
    @VisibleForTesting
    public final Set zza = Collections.synchronizedSet(new HashSet());

    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this);
    }

    public final void zzc() {
        for (zzad zza2 : this.zza) {
            zza2.zza();
        }
    }

    public final void zzd() {
        for (zzad zzb : this.zza) {
            zzb.zzb();
        }
    }

    public final void zze(zzad zzad) {
        this.zza.add(zzad);
    }
}
