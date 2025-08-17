package com.yoku.house.ads.helper.cacheImages;

import android.content.Context;
import android.os.StatFs;
import java.io.File;

public class CacheUtils {
    public static long a(File file) {
        long j2;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j2 = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            j2 = 5242880;
        }
        return Math.max(Math.min(j2, 52428800), 5242880);
    }

    public static File b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
