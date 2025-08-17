package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzasp extends zzath {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzasp(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3) {
        super(zzart, "fbH/fa1wW07iSX89yPc9WELG9OXmO7CRAKCAHB+qo5oZEtCfcaUJh4I9rxcwLdCb", "uNsygnspdKDmMOnOPr9Pza3D3EK7R75fzmNVkfwdpkg=", zzanq, i2, 22);
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
            this.zze.zzy(zzi.longValue());
        }
    }
}
