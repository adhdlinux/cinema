package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

public final class zzfmh extends zzfmf {
    private static zzfmh zzc;

    private zzfmh(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzfmh zzj(Context context) {
        zzfmh zzfmh;
        synchronized (zzfmh.class) {
            if (zzc == null) {
                zzc = new zzfmh(context);
            }
            zzfmh = zzc;
        }
        return zzfmh;
    }

    public final zzfme zzh(long j2, boolean z2) throws IOException {
        zzfme zzb;
        synchronized (zzfmh.class) {
            zzb = zzb((String) null, (String) null, j2, z2);
        }
        return zzb;
    }

    public final zzfme zzi(String str, String str2, long j2, boolean z2) throws IOException {
        zzfme zzb;
        synchronized (zzfmh.class) {
            zzb = zzb(str, str2, j2, z2);
        }
        return zzb;
    }

    public final void zzk() throws IOException {
        synchronized (zzfmh.class) {
            zzf(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzfmh.class) {
            zzf(true);
        }
    }
}
