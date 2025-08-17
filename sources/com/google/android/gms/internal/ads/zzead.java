package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public final /* synthetic */ class zzead implements zzfdo {
    public final /* synthetic */ zzeae zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ ArrayList zzc;
    public final /* synthetic */ zzazd zzd;
    public final /* synthetic */ zzazm zze;

    public /* synthetic */ zzead(zzeae zzeae, boolean z2, ArrayList arrayList, zzazd zzazd, zzazm zzazm) {
        this.zza = zzeae;
        this.zzb = z2;
        this.zzc = arrayList;
        this.zzd = zzazd;
        this.zze = zzazm;
    }

    public final Object zza(Object obj) {
        zzeae zzeae = this.zza;
        boolean z2 = this.zzb;
        ArrayList arrayList = this.zzc;
        zzazd zzazd = this.zzd;
        zzazm zzazm = this.zze;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (zzeae.zzb.zzf()) {
            return null;
        }
        byte[] zze2 = zzeaf.zze(zzeae.zzb, z2, arrayList, zzazd, zzazm);
        zzeai.zzg(sQLiteDatabase, z2, true);
        zzeai.zzd(sQLiteDatabase, zzeae.zzb.zzf.zzd(), zze2);
        return null;
    }
}
