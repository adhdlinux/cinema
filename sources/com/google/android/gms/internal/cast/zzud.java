package com.google.android.gms.internal.cast;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzud extends zzun {
    zzud(int i2) {
        super(i2, (zzum) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i2 = 0; i2 < zzb(); i2++) {
                Map.Entry zzg = zzg(i2);
                if (((zzsa) zzg.getKey()).zzc()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzsa) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
