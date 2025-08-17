package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Future;

public final class zzawv {
    /* access modifiers changed from: private */
    public zzawk zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final Object zzd = new Object();

    zzawv(Context context) {
        this.zzc = context;
    }

    static /* bridge */ /* synthetic */ void zze(zzawv zzawv) {
        synchronized (zzawv.zzd) {
            zzawk zzawk = zzawv.zza;
            if (zzawk != null) {
                zzawk.disconnect();
                zzawv.zza = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Future zzc(zzawl zzawl) {
        zzawp zzawp = new zzawp(this);
        zzawt zzawt = new zzawt(this, zzawl, zzawp);
        zzawu zzawu = new zzawu(this, zzawp);
        synchronized (this.zzd) {
            zzawk zzawk = new zzawk(this.zzc, zzt.zzt().zzb(), zzawt, zzawu);
            this.zza = zzawk;
            zzawk.checkAvailabilityAndConnect();
        }
        return zzawp;
    }
}
