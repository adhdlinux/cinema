package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzfvb extends zzfvh {
    private static final Logger zza = Logger.getLogger(zzfvb.class.getName());
    private zzfrx zzb;
    private final boolean zzc;
    private final boolean zze;

    zzfvb(zzfrx zzfrx, boolean z2, boolean z3) {
        super(zzfrx.size());
        this.zzb = zzfrx;
        this.zzc = z2;
        this.zze = z3;
    }

    private final void zzH(int i2, Future future) {
        try {
            zzg(i2, zzfwc.zzo(future));
        } catch (ExecutionException e2) {
            zzJ(e2.getCause());
        } catch (Error | RuntimeException e3) {
            zzJ(e3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzI */
    public final void zzy(zzfrx zzfrx) {
        boolean z2;
        int zzB = zzB();
        int i2 = 0;
        if (zzB >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzfph.zzi(z2, "Less than 0 remaining futures");
        if (zzB == 0) {
            if (zzfrx != null) {
                zzfuc zze2 = zzfrx.iterator();
                while (zze2.hasNext()) {
                    Future future = (Future) zze2.next();
                    if (!future.isCancelled()) {
                        zzH(i2, future);
                    }
                    i2++;
                }
            }
            zzG();
            zzv();
            zzz(2);
        }
    }

    private final void zzJ(Throwable th) {
        th.getClass();
        if (this.zzc && !zze(th) && zzL(zzD(), th)) {
            zzK(th);
        } else if (th instanceof Error) {
            zzK(th);
        }
    }

    private static void zzK(Throwable th) {
        String str;
        if (true != (th instanceof Error)) {
            str = "Got more than one input Future failure. Logging failures after the first";
        } else {
            str = "Input Future failed with Error";
        }
        zza.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", str, th);
    }

    private static boolean zzL(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final String zza() {
        zzfrx zzfrx = this.zzb;
        if (zzfrx != null) {
            return "futures=".concat(zzfrx.toString());
        }
        return super.zza();
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzfrx zzfrx = this.zzb;
        boolean z2 = true;
        zzz(1);
        boolean isCancelled = isCancelled();
        if (zzfrx == null) {
            z2 = false;
        }
        if (z2 && isCancelled) {
            boolean zzu = zzu();
            zzfuc zze2 = zzfrx.iterator();
            while (zze2.hasNext()) {
                ((Future) zze2.next()).cancel(zzu);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Set set) {
        set.getClass();
        if (!isCancelled()) {
            Throwable zzm = zzm();
            zzm.getClass();
            zzL(set, zzm);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void zzg(int i2, Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzv();

    /* access modifiers changed from: package-private */
    public final void zzw() {
        zzfrx zzfrx;
        zzfrx zzfrx2 = this.zzb;
        zzfrx2.getClass();
        if (zzfrx2.isEmpty()) {
            zzv();
        } else if (this.zzc) {
            zzfuc zze2 = this.zzb.iterator();
            int i2 = 0;
            while (zze2.hasNext()) {
                zzfwm zzfwm = (zzfwm) zze2.next();
                zzfwm.zzc(new zzfuz(this, zzfwm, i2), zzfvq.INSTANCE);
                i2++;
            }
        } else {
            if (this.zze) {
                zzfrx = this.zzb;
            } else {
                zzfrx = null;
            }
            zzfva zzfva = new zzfva(this, zzfrx);
            zzfuc zze3 = this.zzb.iterator();
            while (zze3.hasNext()) {
                ((zzfwm) zze3.next()).zzc(zzfva, zzfvq.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzx(zzfwm zzfwm, int i2) {
        try {
            if (zzfwm.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzH(i2, zzfwm);
            }
        } finally {
            zzy((zzfrx) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzz(int i2) {
        this.zzb = null;
    }
}
