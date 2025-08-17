package us.shandian.giga.get.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Map;
import us.shandian.giga.get.DownloadMission;

public class DownloadMissionSQLiteHelper extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private final String f42221b = "DownloadMissionHelper";

    DownloadMissionSQLiteHelper(Context context) {
        super(context, "downloads.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007b, code lost:
        r1 = r0 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static us.shandian.giga.get.DownloadMission a(android.database.Cursor r5) {
        /*
            if (r5 == 0) goto L_0x0097
            java.lang.String r0 = "name"
            int r0 = r5.getColumnIndexOrThrow(r0)
            java.lang.String r0 = r5.getString(r0)
            java.lang.String r1 = "location"
            int r1 = r5.getColumnIndexOrThrow(r1)
            java.lang.String r1 = r5.getString(r1)
            java.lang.String r2 = "url"
            int r2 = r5.getColumnIndexOrThrow(r2)
            java.lang.String r2 = r5.getString(r2)
            us.shandian.giga.get.DownloadMission r3 = new us.shandian.giga.get.DownloadMission
            r4 = 0
            r3.<init>(r0, r2, r1, r4)
            java.lang.String r0 = "bytes_downloaded"
            int r0 = r5.getColumnIndexOrThrow(r0)
            long r0 = r5.getLong(r0)
            r3.f42197i = r0
            java.lang.String r0 = "timestamp"
            int r0 = r5.getColumnIndexOrThrow(r0)
            long r0 = r5.getLong(r0)
            r3.f42206r = r0
            java.lang.String r0 = "mvinfos"
            int r0 = r5.getColumnIndexOrThrow(r0)
            java.lang.String r0 = r5.getString(r0)
            r3.f42196h = r0
            java.lang.String r0 = "headers"
            int r0 = r5.getColumnIndexOrThrow(r0)
            java.lang.String r5 = r5.getString(r0)
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L_0x0093
            java.lang.String r0 = "@@"
            java.lang.String[] r5 = r5.split(r0)
            r0 = 0
        L_0x0061:
            int r1 = r5.length
            int r1 = r1 + -2
            if (r0 >= r1) goto L_0x0093
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r3.f42195g
            if (r1 != 0) goto L_0x0071
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3.f42195g = r1
        L_0x0071:
            r1 = r5[r0]
            if (r1 == 0) goto L_0x0090
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0090
            int r1 = r0 + 1
            r2 = r5[r1]
            if (r2 == 0) goto L_0x0090
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0090
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r3.f42195g
            r4 = r5[r0]
            r1 = r5[r1]
            r2.put(r4, r1)
        L_0x0090:
            int r0 = r0 + 1
            goto L_0x0061
        L_0x0093:
            r5 = 1
            r3.f42203o = r5
            return r3
        L_0x0097:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "cursor is null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.shandian.giga.get.sqlite.DownloadMissionSQLiteHelper.a(android.database.Cursor):us.shandian.giga.get.DownloadMission");
    }

    public static ContentValues f(DownloadMission downloadMission) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ImagesContract.URL, downloadMission.f42191c);
        contentValues.put("location", downloadMission.f42192d);
        contentValues.put("name", downloadMission.f42190b);
        contentValues.put("bytes_downloaded", Long.valueOf(downloadMission.f42197i));
        contentValues.put("timestamp", Long.valueOf(downloadMission.f42206r));
        HashMap<String, String> hashMap = downloadMission.f42195g;
        String str = "";
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                str = str + ((String) next.getKey()) + "@@" + ((String) next.getValue()) + "@@";
            }
        }
        contentValues.put("mvinfos", downloadMission.f42196h);
        contentValues.put("headers", str);
        return contentValues;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE download_missions (location TEXT NOT NULL, name TEXT NOT NULL, url TEXT NOT NULL, bytes_downloaded INTEGER NOT NULL, timestamp INTEGER NOT NULL, headers TEXT NOT NULL, mvinfos TEXT NOT NULL,  UNIQUE(location, name));");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
