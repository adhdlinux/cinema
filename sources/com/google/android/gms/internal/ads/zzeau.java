package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

public final /* synthetic */ class zzeau implements Runnable {
    public final /* synthetic */ SQLiteDatabase zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbzw zzc;

    public /* synthetic */ zzeau(SQLiteDatabase sQLiteDatabase, String str, zzbzw zzbzw) {
        this.zza = sQLiteDatabase;
        this.zzb = str;
        this.zzc = zzbzw;
    }

    public final void run() {
        zzeba.zzf(this.zza, this.zzb, this.zzc);
    }
}
