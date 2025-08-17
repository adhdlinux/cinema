package com.google.android.gms.internal.ads;

import androidx.media3.exoplayer.mediacodec.f;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class zzfba {
    public static /* synthetic */ boolean zza(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!f.a(atomicReference, (Object) null, obj2)) {
            if (atomicReference.get() != null) {
                return false;
            }
        }
        return true;
    }
}
