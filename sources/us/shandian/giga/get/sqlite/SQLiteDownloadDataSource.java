package us.shandian.giga.get.sqlite;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import us.shandian.giga.get.DownloadDataSource;
import us.shandian.giga.get.DownloadMission;

public class SQLiteDownloadDataSource implements DownloadDataSource {

    /* renamed from: a  reason: collision with root package name */
    private final DownloadMissionSQLiteHelper f42222a;

    public SQLiteDownloadDataSource(Context context) {
        this.f42222a = new DownloadMissionSQLiteHelper(context);
    }

    public void a(DownloadMission downloadMission) {
        if (downloadMission != null) {
            this.f42222a.getWritableDatabase().delete("download_missions", "location = ? AND name = ?", new String[]{downloadMission.f42192d, downloadMission.f42190b});
            return;
        }
        throw new NullPointerException("downloadMission is null");
    }

    public void b(DownloadMission downloadMission) {
        if (downloadMission != null) {
            this.f42222a.getWritableDatabase().insert("download_missions", (String) null, DownloadMissionSQLiteHelper.f(downloadMission));
            return;
        }
        throw new NullPointerException("downloadMission is null");
    }

    public List<DownloadMission> c() {
        Cursor query = this.f42222a.getReadableDatabase().query("download_missions", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, "timestamp");
        int count = query.getCount();
        if (count == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(count);
        while (query.moveToNext()) {
            arrayList.add(DownloadMissionSQLiteHelper.a(query));
        }
        return arrayList;
    }
}
