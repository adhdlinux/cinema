package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

final class zzdzs implements zzfvy {
    final /* synthetic */ zzfdo zza;

    zzdzs(zzdzt zzdzt, zzfdo zzfdo) {
        this.zza = zzfdo;
    }

    public final void zza(Throwable th) {
        zzbzr.zzg("Failed to get offline signal database: ".concat(String.valueOf(th.getMessage())));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e2) {
            zzbzr.zzg("Error executing function on offline signal database: ".concat(String.valueOf(e2.getMessage())));
        }
    }
}
