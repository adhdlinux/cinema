package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

public class IdGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final WorkDatabase f12587a;

    public IdGenerator(WorkDatabase workDatabase) {
        this.f12587a = workDatabase;
    }

    public static void a(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i2 = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i3 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.u("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i2)});
                supportSQLiteDatabase.u("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i3)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }

    private int c(String str) {
        int i2;
        this.f12587a.c();
        try {
            Long b2 = this.f12587a.z().b(str);
            int i3 = 0;
            if (b2 != null) {
                i2 = b2.intValue();
            } else {
                i2 = 0;
            }
            if (i2 != Integer.MAX_VALUE) {
                i3 = i2 + 1;
            }
            e(str, i3);
            this.f12587a.t();
            return i2;
        } finally {
            this.f12587a.g();
        }
    }

    private void e(String str, int i2) {
        this.f12587a.z().a(new Preference(str, (long) i2));
    }

    public int b() {
        int c2;
        synchronized (IdGenerator.class) {
            c2 = c("next_alarm_manager_id");
        }
        return c2;
    }

    public int d(int i2, int i3) {
        synchronized (IdGenerator.class) {
            int c2 = c("next_job_scheduler_id");
            if (c2 >= i2) {
                if (c2 <= i3) {
                    i2 = c2;
                }
            }
            e("next_job_scheduler_id", i2 + 1);
        }
        return i2;
    }
}
