package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

public final /* synthetic */ class zzeax implements zzfdo {
    public final /* synthetic */ zzeba zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzeax(zzeba zzeba, String str) {
        this.zza = zzeba;
        this.zzb = str;
    }

    public final Object zza(Object obj) {
        zzeba.zzi((SQLiteDatabase) obj, this.zzb);
        return null;
    }
}
