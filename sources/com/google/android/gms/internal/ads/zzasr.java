package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzasr extends zzath {
    private final zzarl zzi;

    public zzasr(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3, zzarl zzarl) {
        super(zzart, "bdLwb+FSMvnkuJhbzKDCMXfu1B/xx4c1DUAXM+xzbUjcDvNDxjFjT1GT/o1T/BYK", "os/73Qwr79ouqjFLpLjJlgtKKsT75hksFSajjoaerIA=", zzanq, i2, 94);
        this.zzi = zzarl;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        int intValue = ((Integer) this.zzf.invoke((Object) null, new Object[]{this.zzi.zza()})).intValue();
        synchronized (this.zze) {
            this.zze.zzae(zzaoe.zza(intValue));
        }
    }
}
