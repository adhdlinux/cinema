package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzfpu {
    /* access modifiers changed from: private */
    public final zzfos zza;
    private final zzfpt zzb;

    private zzfpu(zzfpt zzfpt) {
        zzfor zzfor = zzfor.zza;
        this.zzb = zzfpt;
        this.zza = zzfor;
    }

    public static zzfpu zzb(int i2) {
        return new zzfpu(new zzfpq(4000));
    }

    public static zzfpu zzc(zzfos zzfos) {
        return new zzfpu(new zzfpo(zzfos));
    }

    /* access modifiers changed from: private */
    public final Iterator zzg(CharSequence charSequence) {
        return this.zzb.zza(this, charSequence);
    }

    public final Iterable zzd(CharSequence charSequence) {
        charSequence.getClass();
        return new zzfpr(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        Iterator zzg = zzg(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzg.hasNext()) {
            arrayList.add((String) zzg.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
