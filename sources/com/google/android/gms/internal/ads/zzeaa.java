package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

public final /* synthetic */ class zzeaa implements zzfdo {
    public final /* synthetic */ zzeab zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzeaa(zzeab zzeab, long j2) {
        this.zza = zzeab;
        this.zzb = j2;
    }

    public final Object zza(Object obj) {
        zzeab zzeab = this.zza;
        long j2 = this.zzb;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (zzeab.zzf()) {
            return null;
        }
        zzazh zzg = zzazi.zzg();
        zzg.zzh(j2);
        byte[] zzax = ((zzazi) zzg.zzal()).zzax();
        zzeai.zzg(sQLiteDatabase, false, false);
        zzeai.zzd(sQLiteDatabase, j2, zzax);
        return null;
    }
}
