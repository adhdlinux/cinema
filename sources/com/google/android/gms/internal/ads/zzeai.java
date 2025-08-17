package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;

public final class zzeai {
    public static int zza(SQLiteDatabase sQLiteDatabase, int i2) {
        int i3 = 0;
        if (i2 == 2) {
            return 0;
        }
        Cursor zzh = zzh(sQLiteDatabase, i2);
        if (zzh.getCount() > 0) {
            zzh.moveToNext();
            i3 = zzh.getInt(zzh.getColumnIndexOrThrow(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        }
        zzh.close();
        return i3;
    }

    public static long zzb(SQLiteDatabase sQLiteDatabase, int i2) {
        long j2;
        Cursor zzh = zzh(sQLiteDatabase, 2);
        if (zzh.getCount() > 0) {
            zzh.moveToNext();
            j2 = zzh.getLong(zzh.getColumnIndexOrThrow(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        } else {
            j2 = 0;
        }
        zzh.close();
        return j2;
    }

    public static ArrayList zzc(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        while (query.moveToNext()) {
            try {
                arrayList.add(zzazi.zzi(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
            } catch (zzgpy e2) {
                zzbzr.zzg("Unable to deserialize proto from offline signals database:");
                zzbzr.zzg(e2.getMessage());
            }
        }
        query.close();
        return arrayList;
    }

    public static void zzd(SQLiteDatabase sQLiteDatabase, long j2, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(j2));
        contentValues.put("serialized_proto_data", bArr);
        if (sQLiteDatabase.update("offline_signal_contents", contentValues, "timestamp = ?", new String[]{String.valueOf(j2)}) == 0) {
            sQLiteDatabase.insert("offline_signal_contents", (String) null, contentValues);
        }
    }

    public static void zze(SQLiteDatabase sQLiteDatabase) {
        zzi(sQLiteDatabase, "failed_requests", 0);
        zzi(sQLiteDatabase, "total_requests", 0);
        zzi(sQLiteDatabase, "completed_requests", 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("statistic_name", "last_successful_request_time");
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0L);
        sQLiteDatabase.insert("offline_signal_statistics", (String) null, contentValues);
    }

    public static void zzf(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("offline_signal_contents", (String) null, (String[]) null);
        zzj(sQLiteDatabase, "failed_requests", 0);
        zzj(sQLiteDatabase, "total_requests", 0);
        zzj(sQLiteDatabase, "completed_requests", 0);
    }

    public static void zzg(SQLiteDatabase sQLiteDatabase, boolean z2, boolean z3) {
        if (!z3) {
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"total_requests"}));
            return;
        }
        sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"completed_requests"}));
        if (!z2) {
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"failed_requests"}));
        }
    }

    private static Cursor zzh(SQLiteDatabase sQLiteDatabase, int i2) {
        String[] strArr = {AppMeasurementSdk.ConditionalUserProperty.VALUE};
        String[] strArr2 = new String[1];
        if (i2 == 0) {
            strArr2[0] = "failed_requests";
        } else if (i2 == 1) {
            strArr2[0] = "total_requests";
        } else if (i2 != 2) {
            strArr2[0] = "completed_requests";
        } else {
            strArr2[0] = "last_successful_request_time";
        }
        return sQLiteDatabase.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, (String) null, (String) null, (String) null);
    }

    private static void zzi(SQLiteDatabase sQLiteDatabase, String str, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("statistic_name", str);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0);
        sQLiteDatabase.insert("offline_signal_statistics", (String) null, contentValues);
    }

    private static void zzj(SQLiteDatabase sQLiteDatabase, String str, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = ?", new String[]{str});
    }
}
