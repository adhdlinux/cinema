package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class zzasx extends zzath {
    private List zzi = null;
    private final Context zzj;

    public zzasx(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3, Context context) {
        super(zzart, "kG8kAzeUJFSjvYuRDtJkr7owBxy52vKH1yfYPq05BRQDWSz1Oa+VomdlwOHttvWk", "SXEqPPoGCAhkrwWNonsWzEV+zX6m6TBLFFDVOqk+hqA=", zzanq, i2, 31);
        this.zzj = context;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzW(-1);
        this.zze.zzS(-1);
        Context context = this.zzj;
        if (context == null) {
            context = this.zzb.zzb();
        }
        if (this.zzi == null) {
            this.zzi = (List) this.zzf.invoke((Object) null, new Object[]{context});
        }
        List list = this.zzi;
        if (list != null && list.size() == 2) {
            synchronized (this.zze) {
                this.zze.zzW(((Long) this.zzi.get(0)).longValue());
                this.zze.zzS(((Long) this.zzi.get(1)).longValue());
            }
        }
    }
}
