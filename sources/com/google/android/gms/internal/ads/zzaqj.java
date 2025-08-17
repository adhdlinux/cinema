package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

final class zzaqj implements zzfkw {
    final /* synthetic */ zzfiw zza;

    zzaqj(zzaql zzaql, zzfiw zzfiw) {
        this.zza = zzfiw;
    }

    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
