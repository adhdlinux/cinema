package com.google.android.gms.internal.ads;

import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

public final class zzbjb implements zzbij {
    private final zzdsx zza;

    public zzbjb(zzdsx zzdsx) {
        Preconditions.checkNotNull(zzdsx, "The Inspector Manager must not be null");
        this.zza = zzdsx;
    }

    public final void zza(Object obj, Map map) {
        if (map != null && map.containsKey("extras")) {
            boolean containsKey = map.containsKey("expires");
            long j2 = Clock.MAX_TIME;
            if (containsKey) {
                try {
                    j2 = Long.parseLong((String) map.get("expires"));
                } catch (NumberFormatException unused) {
                }
            }
            this.zza.zzi((String) map.get("extras"), j2);
        }
    }
}
