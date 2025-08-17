package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzmd implements Iterator {
    final /* synthetic */ zzmh zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzmd(zzmh zzmh, zzmc zzmc) {
        this.zza = zzmh;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        if (this.zzb + 1 < this.zza.zzb.size()) {
            return true;
        }
        if (this.zza.zzc.isEmpty() || !zza().hasNext()) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i2 = this.zzb + 1;
        this.zzb = i2;
        if (i2 < this.zza.zzb.size()) {
            return (Map.Entry) this.zza.zzb.get(this.zzb);
        }
        return (Map.Entry) zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzn();
            if (this.zzb < this.zza.zzb.size()) {
                zzmh zzmh = this.zza;
                int i2 = this.zzb;
                this.zzb = i2 - 1;
                Object unused = zzmh.zzl(i2);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
