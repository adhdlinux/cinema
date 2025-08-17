package com.startapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ka {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Bitmap> f34839a = new ConcurrentHashMap();

    public static Bitmap a(Context context, String str) {
        Bitmap b2 = b(context, str);
        return b2 == null ? b(context, str) : b2;
    }

    public static Bitmap b(Context context, String str) {
        FileInputStream fileInputStream;
        int i2;
        Map<String, Bitmap> map = f34839a;
        Bitmap bitmap = map.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(context.getFilesDir().getPath() + "/" + str);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                Resources resources = context.getResources();
                if (context.getResources() != null) {
                    i2 = resources.getDisplayMetrics().densityDpi;
                } else {
                    i2 = 160;
                }
                decodeStream.setDensity(i2);
                map.put(str, decodeStream);
                lb.a((Closeable) fileInputStream);
                return decodeStream;
            } catch (Exception unused) {
                lb.a((Closeable) fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                lb.a((Closeable) fileInputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
            lb.a((Closeable) fileInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            lb.a((Closeable) fileInputStream2);
            throw th;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        if (!f34839a.containsKey(str)) {
            if (!new File(context.getFilesDir().getPath() + "/" + str).exists()) {
                return false;
            }
        }
        return true;
    }
}
