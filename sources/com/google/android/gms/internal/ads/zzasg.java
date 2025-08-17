package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzasg extends zzath {
    private static final zzati zzi = new zzati();
    private final Context zzj;

    public zzasg(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3, Context context) {
        super(zzart, "x244HDzWeCJXpaVmJz6ZDJ8SomiOjqvEXNm93LF/UprnziaRy0GWl7kRtW31unI7", "QfNmx51vMYu7RTw3f+TZAS23f16Jqr3kM4ALSpqOw0Y=", zzanq, i2, 29);
        this.zzj = context;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzn("E");
        AtomicReference zza = zzi.zza(this.zzj.getPackageName());
        if (zza.get() == null) {
            synchronized (zza) {
                if (zza.get() == null) {
                    zza.set((String) this.zzf.invoke((Object) null, new Object[]{this.zzj}));
                }
            }
        }
        String str = (String) zza.get();
        synchronized (this.zze) {
            this.zze.zzn(zzapd.zza(str.getBytes(), true));
        }
    }
}
