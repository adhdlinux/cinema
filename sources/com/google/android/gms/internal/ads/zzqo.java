package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzqo {
    public final int zza;
    public final zzto zzb;
    private final CopyOnWriteArrayList zzc;

    public zzqo() {
        this(new CopyOnWriteArrayList(), 0, (zzto) null);
    }

    private zzqo(CopyOnWriteArrayList copyOnWriteArrayList, int i2, zzto zzto) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzto;
    }

    public final zzqo zza(int i2, zzto zzto) {
        return new zzqo(this.zzc, 0, zzto);
    }

    public final void zzb(Handler handler, zzqp zzqp) {
        this.zzc.add(new zzqn(handler, zzqp));
    }

    public final void zzc(zzqp zzqp) {
        Iterator it2 = this.zzc.iterator();
        while (it2.hasNext()) {
            zzqn zzqn = (zzqn) it2.next();
            if (zzqn.zzb == zzqp) {
                this.zzc.remove(zzqn);
            }
        }
    }
}
