package com.google.android.gms.cast.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zzd extends zzp {
    private final List zzb = Collections.synchronizedList(new ArrayList());

    public zzd(String str, String str2, String str3) {
        super(str, "MediaControlChannel", (String) null);
    }

    /* access modifiers changed from: protected */
    public final List zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        synchronized (this.zzb) {
            for (zzav zzc : this.zzb) {
                zzc.zzc(2002);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(zzav zzav) {
        this.zzb.add(zzav);
    }
}
