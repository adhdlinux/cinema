package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

public final /* synthetic */ class zzelw implements zzeqx {
    public final /* synthetic */ ArrayList zza;

    public /* synthetic */ zzelw(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final void zzh(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zza);
    }
}
