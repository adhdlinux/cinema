package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

public final /* synthetic */ class zzelh implements zzeqx {
    public final /* synthetic */ ArrayList zza;

    public /* synthetic */ zzelh(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final void zzh(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.zza);
    }
}
