package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

final class zzaaq {
    private final zzaap zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public zzaaq(zzaap zzaap) {
        this.zza = zzaap;
    }

    public final zzaaw zza(Object... objArr) {
        Constructor constructor;
        synchronized (this.zzb) {
            if (!this.zzb.get()) {
                try {
                    constructor = this.zza.zza();
                } catch (ClassNotFoundException unused) {
                    this.zzb.set(true);
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating extension", e2);
                }
            }
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        try {
            return (zzaaw) constructor.newInstance(objArr);
        } catch (Exception e3) {
            throw new IllegalStateException("Unexpected error creating extractor", e3);
        }
    }
}
