package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzhi;

final class zzdu extends zzch {
    private final zzhi zza;

    zzdu(zzhi zzhi) {
        this.zza = zzhi;
    }

    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    public final void zze(String str, String str2, Bundle bundle, long j2) {
        this.zza.interceptEvent(str, str2, bundle, j2);
    }
}
