package androidx.sqlite.db.framework;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

public final class FrameworkSQLiteOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    public SupportSQLiteOpenHelper a(SupportSQLiteOpenHelper.Configuration configuration) {
        return new FrameworkSQLiteOpenHelper(configuration.f11606a, configuration.f11607b, configuration.f11608c, configuration.f11609d);
    }
}
