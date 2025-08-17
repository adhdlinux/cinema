package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private final Context f11509b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11510c;

    /* renamed from: d  reason: collision with root package name */
    private final File f11511d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11512e;

    /* renamed from: f  reason: collision with root package name */
    private final SupportSQLiteOpenHelper f11513f;

    /* renamed from: g  reason: collision with root package name */
    private DatabaseConfiguration f11514g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11515h;

    SQLiteCopyOpenHelper(Context context, String str, File file, int i2, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.f11509b = context;
        this.f11510c = str;
        this.f11511d = file;
        this.f11512e = i2;
        this.f11513f = supportSQLiteOpenHelper;
    }

    private void a(File file) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.f11510c != null) {
            readableByteChannel = Channels.newChannel(this.f11509b.getAssets().open(this.f11510c));
        } else if (this.f11511d != null) {
            readableByteChannel = new FileInputStream(this.f11511d).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", DefaultDiskStorage.FileType.TEMP, this.f11509b.getCacheDir());
        createTempFile.deleteOnExit();
        FileUtil.a(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        } else if (!createTempFile.renameTo(file)) {
            throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
        }
    }

    private void i() {
        boolean z2;
        String databaseName = getDatabaseName();
        File databasePath = this.f11509b.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.f11514g;
        if (databaseConfiguration == null || databaseConfiguration.f11391j) {
            z2 = true;
        } else {
            z2 = false;
        }
        CopyLock copyLock = new CopyLock(databaseName, this.f11509b.getFilesDir(), z2);
        try {
            copyLock.b();
            if (!databasePath.exists()) {
                a(databasePath);
                copyLock.c();
            } else if (this.f11514g == null) {
                copyLock.c();
            } else {
                try {
                    int d2 = DBUtil.d(databasePath);
                    int i2 = this.f11512e;
                    if (d2 == i2) {
                        copyLock.c();
                    } else if (this.f11514g.a(d2, i2)) {
                        copyLock.c();
                    } else {
                        if (this.f11509b.deleteDatabase(databaseName)) {
                            try {
                                a(databasePath);
                            } catch (IOException e2) {
                                Log.w("ROOM", "Unable to copy database file.", e2);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                        }
                        copyLock.c();
                    }
                } catch (IOException e3) {
                    Log.w("ROOM", "Unable to read database version.", e3);
                    copyLock.c();
                }
            }
        } catch (IOException e4) {
            throw new RuntimeException("Unable to copy database file.", e4);
        } catch (Throwable th) {
            copyLock.c();
            throw th;
        }
    }

    public synchronized void close() {
        this.f11513f.close();
        this.f11515h = false;
    }

    /* access modifiers changed from: package-private */
    public void f(DatabaseConfiguration databaseConfiguration) {
        this.f11514g = databaseConfiguration;
    }

    public String getDatabaseName() {
        return this.f11513f.getDatabaseName();
    }

    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        if (!this.f11515h) {
            i();
            this.f11515h = true;
        }
        return this.f11513f.getWritableDatabase();
    }

    public void setWriteAheadLoggingEnabled(boolean z2) {
        this.f11513f.setWriteAheadLoggingEnabled(z2);
    }
}
