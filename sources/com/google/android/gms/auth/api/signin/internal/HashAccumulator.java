package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
public class HashAccumulator {
    @VisibleForTesting
    static int zaa = 31;
    private int zab = 1;

    @KeepForSdk
    public HashAccumulator addObject(Object obj) {
        this.zab = (zaa * this.zab) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.zab;
    }

    public final HashAccumulator zaa(boolean z2) {
        this.zab = (zaa * this.zab) + (z2 ? 1 : 0);
        return this;
    }
}
