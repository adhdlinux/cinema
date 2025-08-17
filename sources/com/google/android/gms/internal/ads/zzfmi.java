package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

public final class zzfmi extends zzfmf {
    private static zzfmi zzc;

    private zzfmi(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzfmi zzi(Context context) {
        zzfmi zzfmi;
        synchronized (zzfmi.class) {
            if (zzc == null) {
                zzc = new zzfmi(context);
            }
            zzfmi = zzc;
        }
        return zzfmi;
    }

    public final zzfme zzh(long j2, boolean z2) throws IOException {
        synchronized (zzfmi.class) {
            if (!zzo()) {
                zzfme zzfme = new zzfme();
                return zzfme;
            }
            zzfme zzb = zzb((String) null, (String) null, j2, z2);
            return zzb;
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzfmi.class) {
            if (zzg(false)) {
                zzf(false);
            }
        }
    }

    public final void zzk() throws IOException {
        this.zzb.zze("paidv2_publisher_option");
    }

    public final void zzl() throws IOException {
        this.zzb.zze("paidv2_user_option");
    }

    public final void zzm(boolean z2) throws IOException {
        this.zzb.zzd("paidv2_user_option", Boolean.valueOf(z2));
    }

    public final void zzn(boolean z2) throws IOException {
        this.zzb.zzd("paidv2_publisher_option", Boolean.valueOf(z2));
        if (!z2) {
            zzj();
        }
    }

    public final boolean zzo() {
        return this.zzb.zzf("paidv2_publisher_option", true);
    }

    public final boolean zzp() {
        return this.zzb.zzf("paidv2_user_option", true);
    }
}
