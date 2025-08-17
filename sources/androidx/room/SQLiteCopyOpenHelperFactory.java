package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;

class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final String f11516a;

    /* renamed from: b  reason: collision with root package name */
    private final File f11517b;

    /* renamed from: c  reason: collision with root package name */
    private final SupportSQLiteOpenHelper.Factory f11518c;

    SQLiteCopyOpenHelperFactory(String str, File file, SupportSQLiteOpenHelper.Factory factory) {
        this.f11516a = str;
        this.f11517b = file;
        this.f11518c = factory;
    }

    public SupportSQLiteOpenHelper a(SupportSQLiteOpenHelper.Configuration configuration) {
        return new SQLiteCopyOpenHelper(configuration.f11606a, this.f11516a, this.f11517b, configuration.f11608c.f11605a, this.f11518c.a(configuration));
    }
}
