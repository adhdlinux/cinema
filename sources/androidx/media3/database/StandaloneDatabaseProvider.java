package androidx.media3.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.media3.common.util.Log;

public class StandaloneDatabaseProvider extends SQLiteOpenHelper implements DatabaseProvider {
    public StandaloneDatabaseProvider(Context context) {
        super(context.getApplicationContext(), "exoplayer_internal.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        String str;
        Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{"type", "name"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        while (query.moveToNext()) {
            try {
                String string = query.getString(0);
                String string2 = query.getString(1);
                if (!"sqlite_sequence".equals(string2)) {
                    str = "DROP " + string + " IF EXISTS " + string2;
                    sQLiteDatabase.execSQL(str);
                }
            } catch (SQLException e2) {
                Log.d("SADatabaseProvider", "Error executing " + str, e2);
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        query.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
