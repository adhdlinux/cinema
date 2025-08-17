package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfuq;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzfvh extends zzfuq.zzi {
    private static final zzfvd zzbb;
    private static final Logger zzbc;
    /* access modifiers changed from: private */
    public volatile int remaining;
    /* access modifiers changed from: private */
    public volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable th;
        zzfvd zzfvd;
        Class<zzfvh> cls = zzfvh.class;
        zzbc = Logger.getLogger(cls.getName());
        try {
            zzfvd = new zzfve(AtomicReferenceFieldUpdater.newUpdater(cls, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(cls, "remaining"));
            th = null;
        } catch (Error | RuntimeException e2) {
            zzfvd = new zzfvg((zzfvf) null);
            th = e2;
        }
        zzbb = zzfvd;
        if (th != null) {
            zzbc.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzfvh(int i2) {
        this.remaining = i2;
    }

    /* access modifiers changed from: package-private */
    public final int zzB() {
        return zzbb.zza(this);
    }

    /* access modifiers changed from: package-private */
    public final Set zzD() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzf(newSetFromMap);
        zzbb.zzb(this, (Set) null, newSetFromMap);
        Set<Throwable> set2 = this.seenExceptions;
        set2.getClass();
        return set2;
    }

    /* access modifiers changed from: package-private */
    public final void zzG() {
        this.seenExceptions = null;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzf(Set set);
}
