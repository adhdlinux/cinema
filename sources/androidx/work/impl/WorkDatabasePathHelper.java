package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WorkDatabasePathHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12282a = Logger.f("WrkDbPathHelper");

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f12283b = {"-journal", "-shm", "-wal"};

    private WorkDatabasePathHelper() {
    }

    public static File a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return b(context);
        }
        return c(context, "androidx.work.workdb");
    }

    public static File b(Context context) {
        return context.getDatabasePath("androidx.work.workdb");
    }

    private static File c(Context context, String str) {
        return new File(context.getNoBackupFilesDir(), str);
    }

    public static String d() {
        return "androidx.work.workdb";
    }

    public static void e(Context context) {
        String str;
        File b2 = b(context);
        if (Build.VERSION.SDK_INT >= 23 && b2.exists()) {
            Logger.c().a(f12282a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            Map<File, File> f2 = f(context);
            for (File next : f2.keySet()) {
                File file = f2.get(next);
                if (next.exists() && file != null) {
                    if (file.exists()) {
                        Logger.c().h(f12282a, String.format("Over-writing contents of %s", new Object[]{file}), new Throwable[0]);
                    }
                    if (next.renameTo(file)) {
                        str = String.format("Migrated %s to %s", new Object[]{next, file});
                    } else {
                        str = String.format("Renaming %s to %s failed", new Object[]{next, file});
                    }
                    Logger.c().a(f12282a, str, new Throwable[0]);
                }
            }
        }
    }

    public static Map<File, File> f(Context context) {
        HashMap hashMap = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            File b2 = b(context);
            File a2 = a(context);
            hashMap.put(b2, a2);
            for (String str : f12283b) {
                hashMap.put(new File(b2.getPath() + str), new File(a2.getPath() + str));
            }
        }
        return hashMap;
    }
}
