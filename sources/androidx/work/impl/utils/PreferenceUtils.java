package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

public class PreferenceUtils {

    /* renamed from: a  reason: collision with root package name */
    private final WorkDatabase f12589a;

    public PreferenceUtils(WorkDatabase workDatabase) {
        this.f12589a = workDatabase;
    }

    public static void b(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j2 = 0;
            long j3 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
            if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                j2 = 1;
            }
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.u("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j3)});
                supportSQLiteDatabase.u("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j2)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }

    public boolean a() {
        Long b2 = this.f12589a.z().b("reschedule_needed");
        if (b2 == null || b2.longValue() != 1) {
            return false;
        }
        return true;
    }

    public void c(boolean z2) {
        this.f12589a.z().a(new Preference("reschedule_needed", z2));
    }
}
