package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzeba extends SQLiteOpenHelper {
    private final Context zza;
    private final zzfwn zzb;

    public zzeba(Context context, zzfwn zzfwn) {
        super(context, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) zzba.zzc().zzb(zzbbm.zzhU)).intValue());
        this.zza = context;
        this.zzb = zzfwn;
    }

    static /* synthetic */ void zzf(SQLiteDatabase sQLiteDatabase, String str, zzbzw zzbzw) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zzj(sQLiteDatabase, zzbzw);
    }

    static final void zzi(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    /* access modifiers changed from: private */
    public static void zzj(SQLiteDatabase sQLiteDatabase, zzbzw zzbzw) {
        sQLiteDatabase.beginTransaction();
        try {
            String[] strArr = {ImagesContract.URL};
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", strArr, "event_state = " + 1, (String[]) null, (String) null, (String) null, "timestamp ASC", (String) null);
            int count = query.getCount();
            String[] strArr2 = new String[count];
            int i2 = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex(ImagesContract.URL);
                if (columnIndex != -1) {
                    strArr2[i2] = query.getString(columnIndex);
                }
                i2++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            for (int i3 = 0; i3 < count; i3++) {
                zzbzw.zza(strArr2[i3]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(zzebc zzebc, SQLiteDatabase sQLiteDatabase) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzebc.zza));
        contentValues.put("gws_query_id", zzebc.zzb);
        contentValues.put(ImagesContract.URL, zzebc.zzc);
        contentValues.put("event_state", Integer.valueOf(zzebc.zzd - 1));
        sQLiteDatabase.insert("offline_buffered_pings", (String) null, contentValues);
        zzt.zzp();
        zzbr zzv = zzs.zzv(this.zza);
        if (zzv != null) {
            try {
                zzv.zze(ObjectWrapper.wrap(this.zza));
            } catch (RemoteException e2) {
                zze.zzb("Failed to schedule offline ping sender.", e2);
            }
        }
        return null;
    }

    public final void zzc(String str) {
        zze(new zzeax(this, str));
    }

    public final void zzd(zzebc zzebc) {
        zze(new zzeav(this, zzebc));
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzfdo zzfdo) {
        zzfwc.zzq(this.zzb.zzb(new zzeat(this)), new zzeaz(this, zzfdo), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final void zzg(SQLiteDatabase sQLiteDatabase, zzbzw zzbzw, String str) {
        this.zzb.execute(new zzeau(sQLiteDatabase, str, zzbzw));
    }

    public final void zzh(zzbzw zzbzw, String str) {
        zze(new zzeay(this, zzbzw, str));
    }
}
