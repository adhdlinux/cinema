package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzekl implements zzeqx {
    private final boolean zza;

    public zzekl(boolean z2) {
        this.zza = z2;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        String str;
        Bundle bundle = (Bundle) obj;
        if (true != this.zza) {
            str = "0";
        } else {
            str = "1";
        }
        bundle.putString("adid_p", str);
    }
}
