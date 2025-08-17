package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzxm {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzxn zzxn) {
        zzc(zzxn);
        this.zza.add(new zzxl(handler, zzxn));
    }

    public final void zzb(int i2, long j2, long j3) {
        Iterator it2 = this.zza.iterator();
        while (it2.hasNext()) {
            zzxl zzxl = (zzxl) it2.next();
            if (!zzxl.zzc) {
                zzxl.zza.post(new zzxk(zzxl, i2, j2, j3));
            }
        }
    }

    public final void zzc(zzxn zzxn) {
        Iterator it2 = this.zza.iterator();
        while (it2.hasNext()) {
            zzxl zzxl = (zzxl) it2.next();
            if (zzxl.zzb == zzxn) {
                zzxl.zzc();
                this.zza.remove(zzxl);
            }
        }
    }
}
