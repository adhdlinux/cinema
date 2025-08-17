package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzews {
    public static void zza(AtomicReference atomicReference, zzewr zzewr) {
        Object obj = atomicReference.get();
        if (obj != null) {
            try {
                zzewr.zza(obj);
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
            } catch (NullPointerException e3) {
                zzbzr.zzk("NullPointerException occurs when invoking a method from a delegating listener.", e3);
            }
        }
    }
}
