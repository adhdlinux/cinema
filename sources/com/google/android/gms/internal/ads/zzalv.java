package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

final class zzalv {
    public static final boolean zza = zzalw.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    zzalv() {
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        if (!this.zzc) {
            zzb("Request on the loose");
            zzalw.zzb("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public final synchronized void zza(String str, long j2) {
        if (!this.zzc) {
            this.zzb.add(new zzalu(str, j2, SystemClock.elapsedRealtime()));
        } else {
            throw new IllegalStateException("Marker added to finished log");
        }
    }

    public final synchronized void zzb(String str) {
        long j2;
        this.zzc = true;
        if (this.zzb.size() == 0) {
            j2 = 0;
        } else {
            long j3 = ((zzalu) this.zzb.get(0)).zzc;
            List list = this.zzb;
            j2 = ((zzalu) list.get(list.size() - 1)).zzc - j3;
        }
        if (j2 > 0) {
            long j4 = ((zzalu) this.zzb.get(0)).zzc;
            zzalw.zza("(%-4d ms) %s", Long.valueOf(j2), str);
            for (zzalu zzalu : this.zzb) {
                long j5 = zzalu.zzc;
                zzalw.zza("(+%-4d) [%2d] %s", Long.valueOf(j5 - j4), Long.valueOf(zzalu.zzb), zzalu.zza);
                j4 = j5;
            }
        }
    }
}
