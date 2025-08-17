package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.startapp.de;

public final class zzenw implements zzeqx {
    public final String zza;
    public final boolean zzb;

    public zzenw(String str, boolean z2) {
        this.zza = str;
        this.zzb = z2;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zza);
        if (this.zzb) {
            bundle.putString(de.f34377a, "1");
        }
    }
}
