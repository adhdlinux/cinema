package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzasj extends zzath {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzasj(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3) {
        super(zzart, "iZXNXN9xUbn1GVaYCV3sL1wKWUe/HGVr+Kc3Vh94EyUz5Y8L5QIgpXYgDdLj2Tdj", "bBmsyCj4vQqoPhkiTKWAfAhlVNxJgrtws7pZHadifrc=", zzanq, i2, 44);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (Long) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzo(zzi.longValue());
        }
    }
}
