package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

public final class zzbwe extends zzbvj {
    private final String zza;
    private final int zzb;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzbwe(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public final int zze() throws RemoteException {
        return this.zzb;
    }

    public final String zzf() throws RemoteException {
        return this.zza;
    }

    public zzbwe(String str, int i2) {
        this.zza = str;
        this.zzb = i2;
    }
}
