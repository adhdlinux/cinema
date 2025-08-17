package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzfqg extends zzfst {
    final /* synthetic */ zzfqi zza;

    zzfqg(zzfqi zzfqi) {
        this.zza = zzfqi;
    }

    public final boolean contains(Object obj) {
        return zzfrb.zza(this.zza.zza.entrySet(), obj);
    }

    public final Iterator iterator() {
        return new zzfqh(this.zza);
    }

    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        entry.getClass();
        zzfqv.zzo(this.zza.zzb, entry.getKey());
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Map zza() {
        return this.zza;
    }
}
