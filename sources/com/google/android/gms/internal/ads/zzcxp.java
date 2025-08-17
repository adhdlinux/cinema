package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcxp extends zzdaq implements zzcwa, zzcxf {
    private final zzezn zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzcxp(Set set, zzezn zzezn) {
        super(set);
        this.zzb = zzezn;
    }

    private final void zzb() {
        zzs zzs;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzhr)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzs = this.zzb.zzaf) != null && zzs.zza == 3) {
            zzp(new zzcxo(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzcxr zzcxr) throws Exception {
        zzcxr.zzh(this.zzb.zzaf);
    }

    public final void zzg() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    public final void zzl() {
        int i2 = this.zzb.zzb;
        if (i2 == 2 || i2 == 5 || i2 == 4 || i2 == 6 || i2 == 7) {
            zzb();
        }
    }
}
