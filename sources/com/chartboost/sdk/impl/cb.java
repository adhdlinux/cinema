package com.chartboost.sdk.impl;

import android.util.Log;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.RandomAccessFile;

public final class cb {
    public final File a(File file, String str) {
        if (file == null || str == null) {
            return null;
        }
        return new File(file, str + DefaultDiskStorage.FileType.TEMP);
    }

    public final boolean b(File file, String str) {
        if (!(file == null || str == null)) {
            try {
                File a2 = a(file, str);
                if (a2 != null) {
                    return a2.exists();
                }
                return false;
            } catch (Exception e2) {
                Log.d(db.f17464a, e2.toString());
            }
        }
        return false;
    }

    public final RandomAccessFile a(File file) {
        if (file != null) {
            return new RandomAccessFile(file, "rwd");
        }
        return null;
    }
}
