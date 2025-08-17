package com.google.android.gms.internal.cast;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final /* synthetic */ class zzpz {
    public static /* synthetic */ boolean zza(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Object obj2, Object obj3) {
        while (!a.a(atomicReferenceFieldUpdater, obj, obj2, obj3)) {
            if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                return false;
            }
        }
        return true;
    }
}
