package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class zzfkr {
    public static File zza(File file, boolean z2) {
        if (z2 && file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File zzb(String str, String str2, File file) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return new File(zzc(str, file), str2);
    }

    public static File zzc(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file2 = new File(file, str);
        zza(file2, false);
        return file2;
    }

    public static boolean zzd(File file) {
        boolean z2;
        if (!file.exists()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            z2 = true;
            for (File file2 : listFiles) {
                if (file2 == null || !zzd(file2) || !z2) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
        } else {
            z2 = true;
        }
        if (!file.delete() || !z2) {
            return false;
        }
        return true;
    }

    public static boolean zze(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                IOUtils.closeQuietly((Closeable) fileOutputStream2);
                return true;
            } catch (IOException unused) {
                fileOutputStream = fileOutputStream2;
                IOUtils.closeQuietly((Closeable) fileOutputStream);
                return false;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                IOUtils.closeQuietly((Closeable) fileOutputStream);
                throw th;
            }
        } catch (IOException unused2) {
            IOUtils.closeQuietly((Closeable) fileOutputStream);
            return false;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((Closeable) fileOutputStream);
            throw th;
        }
    }
}
