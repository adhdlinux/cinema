package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

public abstract class zzfed {
    /* access modifiers changed from: private */
    public static final zzfwm zza = zzfwc.zzh((Object) null);
    /* access modifiers changed from: private */
    public final zzfwn zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final zzfee zzd;

    public zzfed(zzfwn zzfwn, ScheduledExecutorService scheduledExecutorService, zzfee zzfee) {
        this.zzb = zzfwn;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfee;
    }

    public final zzfdt zza(Object obj, zzfwm... zzfwmArr) {
        return new zzfdt(this, obj, Arrays.asList(zzfwmArr), (zzfds) null);
    }

    public final zzfec zzb(Object obj, zzfwm zzfwm) {
        return new zzfec(this, obj, (String) null, zzfwm, Collections.singletonList(zzfwm), zzfwm, (zzfeb) null);
    }

    /* access modifiers changed from: protected */
    public abstract String zzf(Object obj);
}
