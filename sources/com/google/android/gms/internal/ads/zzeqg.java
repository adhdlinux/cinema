package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

public final class zzeqg implements zzeqx {
    private final String zza;

    public zzeqg(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!TextUtils.isEmpty(this.zza)) {
            bundle.putString("query_info", this.zza);
        }
    }
}
