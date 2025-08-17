package com.google.android.gms.internal.auth;

import android.util.Log;

final class zzcv extends zzdc {
    zzcv(zzcz zzcz, String str, Long l2, boolean z2) {
        super(zzcz, str, l2, true, (zzdb) null);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid long value for " + zzc + ": " + ((String) obj));
            return null;
        }
    }
}
