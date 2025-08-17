package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzbsp {
    /* access modifiers changed from: private */
    public View zza;
    /* access modifiers changed from: private */
    public final Map zzb = new HashMap();

    public final zzbsp zzb(View view) {
        this.zza = view;
        return this;
    }

    public final zzbsp zzc(Map map) {
        this.zzb.clear();
        for (Map.Entry entry : map.entrySet()) {
            View view = (View) entry.getValue();
            if (view != null) {
                this.zzb.put((String) entry.getKey(), new WeakReference(view));
            }
        }
        return this;
    }
}
