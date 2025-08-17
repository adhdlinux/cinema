package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class DBUtil {
    private DBUtil() {
    }

    /* JADX INFO: finally extract failed */
    public static void a(SupportSQLiteDatabase supportSQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor Z = supportSQLiteDatabase.Z("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (Z.moveToNext()) {
            try {
                arrayList.add(Z.getString(0));
            } catch (Throwable th) {
                Z.close();
                throw th;
            }
        }
        Z.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                supportSQLiteDatabase.g("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    @Deprecated
    public static Cursor b(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z2) {
        return c(roomDatabase, supportSQLiteQuery, z2, (CancellationSignal) null);
    }

    public static Cursor c(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z2, CancellationSignal cancellationSignal) {
        int i2;
        Cursor s2 = roomDatabase.s(supportSQLiteQuery, cancellationSignal);
        if (!z2 || !(s2 instanceof AbstractWindowedCursor)) {
            return s2;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) s2;
        int count = abstractWindowedCursor.getCount();
        if (abstractWindowedCursor.hasWindow()) {
            i2 = abstractWindowedCursor.getWindow().getNumRows();
        } else {
            i2 = count;
        }
        if (Build.VERSION.SDK_INT < 23 || i2 < count) {
            return CursorUtil.a(abstractWindowedCursor);
        }
        return s2;
    }

    public static int d(File file) throws IOException {
        FileChannel fileChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            fileChannel = new FileInputStream(file).getChannel();
            fileChannel.tryLock(60, 4, true);
            fileChannel.position(60);
            if (fileChannel.read(allocate) == 4) {
                allocate.rewind();
                int i2 = allocate.getInt();
                fileChannel.close();
                return i2;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th) {
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }
}
