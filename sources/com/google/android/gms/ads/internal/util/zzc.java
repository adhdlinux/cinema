package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzbzr;
import java.io.IOException;

final class zzc extends zzb {
    private final Context zza;

    zzc(Context context) {
        this.zza = context;
    }

    public final void zza() {
        boolean z2;
        try {
            z2 = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.zza);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            zzbzr.zzh("Fail to get isAdIdFakeForDebugLogging", e2);
            z2 = false;
        }
        zzbzq.zzj(z2);
        zzbzr.zzj("Update ad debug logging enablement as " + z2);
    }
}
