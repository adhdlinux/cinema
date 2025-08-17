package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

final class zzff implements zzei {
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzff(Handler handler) {
        this.zzb = handler;
    }

    static /* bridge */ /* synthetic */ void zzl(zzfe zzfe) {
        List list = zza;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(zzfe);
            }
        }
    }

    private static zzfe zzm() {
        zzfe zzfe;
        List list = zza;
        synchronized (list) {
            if (list.isEmpty()) {
                zzfe = new zzfe((zzfd) null);
            } else {
                zzfe = (zzfe) list.remove(list.size() - 1);
            }
        }
        return zzfe;
    }

    public final Looper zza() {
        return this.zzb.getLooper();
    }

    public final zzeh zzb(int i2) {
        zzfe zzm = zzm();
        zzm.zzb(this.zzb.obtainMessage(i2), this);
        return zzm;
    }

    public final zzeh zzc(int i2, Object obj) {
        zzfe zzm = zzm();
        zzm.zzb(this.zzb.obtainMessage(i2, obj), this);
        return zzm;
    }

    public final zzeh zzd(int i2, int i3, int i4) {
        zzfe zzm = zzm();
        zzm.zzb(this.zzb.obtainMessage(1, i3, i4), this);
        return zzm;
    }

    public final void zze(Object obj) {
        this.zzb.removeCallbacksAndMessages((Object) null);
    }

    public final void zzf(int i2) {
        this.zzb.removeMessages(i2);
    }

    public final boolean zzg(int i2) {
        return this.zzb.hasMessages(0);
    }

    public final boolean zzh(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    public final boolean zzi(int i2) {
        return this.zzb.sendEmptyMessage(i2);
    }

    public final boolean zzj(int i2, long j2) {
        return this.zzb.sendEmptyMessageAtTime(2, j2);
    }

    public final boolean zzk(zzeh zzeh) {
        return ((zzfe) zzeh).zzc(this.zzb);
    }
}
