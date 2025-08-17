package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

public final class zzbvx implements RewardItem {
    private final zzbvk zza;

    public zzbvx(zzbvk zzbvk) {
        this.zza = zzbvk;
    }

    public final int getAmount() {
        zzbvk zzbvk = this.zza;
        if (zzbvk != null) {
            try {
                return zzbvk.zze();
            } catch (RemoteException e2) {
                zzbzr.zzk("Could not forward getAmount to RewardItem", e2);
            }
        }
        return 0;
    }

    public final String getType() {
        zzbvk zzbvk = this.zza;
        if (zzbvk != null) {
            try {
                return zzbvk.zzf();
            } catch (RemoteException e2) {
                zzbzr.zzk("Could not forward getType to RewardItem", e2);
            }
        }
        return null;
    }
}
