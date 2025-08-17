package androidx.sqlite.db;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

public interface SupportSQLiteDatabase extends Closeable {
    Cursor C(SupportSQLiteQuery supportSQLiteQuery);

    SupportSQLiteStatement S(String str);

    Cursor Z(String str);

    void beginTransaction();

    List<Pair<String, String>> e();

    boolean e0();

    void endTransaction();

    void g(String str) throws SQLException;

    String getPath();

    boolean isOpen();

    Cursor n(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal);

    void setTransactionSuccessful();

    void u(String str, Object[] objArr) throws SQLException;
}
