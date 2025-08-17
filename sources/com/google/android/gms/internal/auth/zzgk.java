package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzgk extends zzgu {
    zzgk(int i2) {
        super(i2, (zzgt) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i2 = 0; i2 < zzb(); i2++) {
                Map.Entry zzg = zzg(i2);
                if (((zzeo) zzg.getKey()).zzc()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzeo) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
