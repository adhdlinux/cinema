package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final /* synthetic */ class zzek implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzel zzc;

    public /* synthetic */ zzek(CopyOnWriteArraySet copyOnWriteArraySet, int i2, zzel zzel) {
        this.zza = copyOnWriteArraySet;
        this.zzb = i2;
        this.zzc = zzel;
    }

    public final void run() {
        CopyOnWriteArraySet copyOnWriteArraySet = this.zza;
        int i2 = this.zzb;
        zzel zzel = this.zzc;
        Iterator it2 = copyOnWriteArraySet.iterator();
        while (it2.hasNext()) {
            ((zzen) it2.next()).zza(i2, zzel);
        }
    }
}
