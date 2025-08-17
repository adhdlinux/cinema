package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

final class zzeaz implements zzfvy {
    final /* synthetic */ zzfdo zza;

    zzeaz(zzeba zzeba, zzfdo zzfdo) {
        this.zza = zzfdo;
    }

    public final void zza(Throwable th) {
        zzbzr.zzg("Failed to get offline buffered ping database: ".concat(String.valueOf(th.getMessage())));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e2) {
            zzbzr.zzg("Error executing function on offline buffered ping database: ".concat(String.valueOf(e2.getMessage())));
        }
    }
}
