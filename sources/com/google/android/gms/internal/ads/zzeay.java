package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

public final /* synthetic */ class zzeay implements zzfdo {
    public final /* synthetic */ zzeba zza;
    public final /* synthetic */ zzbzw zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzeay(zzeba zzeba, zzbzw zzbzw, String str) {
        this.zza = zzeba;
        this.zzb = zzbzw;
        this.zzc = str;
    }

    public final Object zza(Object obj) {
        this.zza.zzg((SQLiteDatabase) obj, this.zzb, this.zzc);
        return null;
    }
}
