package com.facebook.ads.internal.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import com.facebook.ads.internal.l.a;
import com.facebook.ads.internal.p.a.p;
import com.facebook.ads.internal.q.c.d;
import com.vungle.ads.internal.model.AdPayload;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20080a = "c";

    /* renamed from: b  reason: collision with root package name */
    private static c f20081b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f20082c;

    private c(Context context) {
        this.f20082c = context;
    }

    private Bitmap a(String str) {
        byte[] d2 = d.a(this.f20082c).a(str, (p) null).d();
        return BitmapFactory.decodeByteArray(d2, 0, d2.length);
    }

    public static c a(Context context) {
        if (f20081b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (c.class) {
                if (f20081b == null) {
                    f20081b = new c(applicationContext);
                }
            }
        }
        return f20081b;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x0076=Splitter:B:34:0x0076, B:47:0x00ab=Splitter:B:47:0x00ab} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r8, android.graphics.Bitmap r9) {
        /*
            r7 = this;
            java.lang.String r0 = ")."
            java.io.File r1 = new java.io.File
            android.content.Context r2 = r7.f20082c
            java.io.File r2 = r2.getCacheDir()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r4 = r8.hashCode()
            r3.append(r4)
            java.lang.String r4 = ".png"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r2, r3)
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x00a9, IOException -> 0x0084, OutOfMemoryError -> 0x0074, all -> 0x0071 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x00a9, IOException -> 0x0084, OutOfMemoryError -> 0x0074, all -> 0x0071 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ FileNotFoundException -> 0x006d, IOException -> 0x0069, OutOfMemoryError -> 0x0065, all -> 0x0060 }
            r5 = 100
            r9.compress(r4, r5, r3)     // Catch:{ FileNotFoundException -> 0x006d, IOException -> 0x0069, OutOfMemoryError -> 0x0065, all -> 0x0060 }
            int r9 = r3.size()     // Catch:{ FileNotFoundException -> 0x006d, IOException -> 0x0069, OutOfMemoryError -> 0x0065, all -> 0x0060 }
            r4 = 3145728(0x300000, float:4.408104E-39)
            if (r9 < r4) goto L_0x0045
            java.lang.String r9 = f20080a     // Catch:{ FileNotFoundException -> 0x006d, IOException -> 0x0069, OutOfMemoryError -> 0x0065, all -> 0x0060 }
            java.lang.String r4 = "Bitmap size exceeds max size for storage"
            android.util.Log.d(r9, r4)     // Catch:{ FileNotFoundException -> 0x006d, IOException -> 0x0069, OutOfMemoryError -> 0x0065, all -> 0x0060 }
            a((java.io.Closeable) r3)
            a((java.io.Closeable) r2)
            return
        L_0x0045:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x006d, IOException -> 0x0069, OutOfMemoryError -> 0x0065, all -> 0x0060 }
            r9.<init>(r1)     // Catch:{ FileNotFoundException -> 0x006d, IOException -> 0x0069, OutOfMemoryError -> 0x0065, all -> 0x0060 }
            r3.writeTo(r9)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x0058, OutOfMemoryError -> 0x0056, all -> 0x0054 }
            r9.flush()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x0058, OutOfMemoryError -> 0x0056, all -> 0x0054 }
            a((java.io.Closeable) r3)
            goto L_0x0080
        L_0x0054:
            r8 = move-exception
            goto L_0x0062
        L_0x0056:
            r8 = move-exception
            goto L_0x0067
        L_0x0058:
            r1 = move-exception
            r2 = r3
            r6 = r1
            r1 = r9
            r9 = r6
            goto L_0x0086
        L_0x005e:
            r8 = move-exception
            goto L_0x006f
        L_0x0060:
            r8 = move-exception
            r9 = r2
        L_0x0062:
            r2 = r3
            goto L_0x00cb
        L_0x0065:
            r8 = move-exception
            r9 = r2
        L_0x0067:
            r2 = r3
            goto L_0x0076
        L_0x0069:
            r9 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x0086
        L_0x006d:
            r8 = move-exception
            r9 = r2
        L_0x006f:
            r2 = r3
            goto L_0x00ab
        L_0x0071:
            r8 = move-exception
            r9 = r2
            goto L_0x00cb
        L_0x0074:
            r8 = move-exception
            r9 = r2
        L_0x0076:
            java.lang.String r0 = f20080a     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = "Unable to write bitmap to output stream"
            android.util.Log.e(r0, r1, r8)     // Catch:{ all -> 0x00ca }
        L_0x007d:
            a((java.io.Closeable) r2)
        L_0x0080:
            a((java.io.Closeable) r9)
            goto L_0x00c9
        L_0x0084:
            r9 = move-exception
            r1 = r2
        L_0x0086:
            java.lang.String r3 = f20080a     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r4.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = "Unable to write bitmap to file (url="
            r4.append(r5)     // Catch:{ all -> 0x00a6 }
            r4.append(r8)     // Catch:{ all -> 0x00a6 }
            r4.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x00a6 }
            android.util.Log.e(r3, r8, r9)     // Catch:{ all -> 0x00a6 }
            a((java.io.Closeable) r2)
            a((java.io.Closeable) r1)
            goto L_0x00c9
        L_0x00a6:
            r8 = move-exception
            r9 = r1
            goto L_0x00cb
        L_0x00a9:
            r8 = move-exception
            r9 = r2
        L_0x00ab:
            java.lang.String r3 = f20080a     // Catch:{ all -> 0x00ca }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            r4.<init>()     // Catch:{ all -> 0x00ca }
            java.lang.String r5 = "Bad output destination (file="
            r4.append(r5)     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x00ca }
            r4.append(r1)     // Catch:{ all -> 0x00ca }
            r4.append(r0)     // Catch:{ all -> 0x00ca }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00ca }
            android.util.Log.e(r3, r0, r8)     // Catch:{ all -> 0x00ca }
            goto L_0x007d
        L_0x00c9:
            return
        L_0x00ca:
            r8 = move-exception
        L_0x00cb:
            a((java.io.Closeable) r2)
            a((java.io.Closeable) r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.d.c.a(java.lang.String, android.graphics.Bitmap):void");
    }

    private boolean a(int i2, int i3) {
        return i2 > 0 && i3 > 0 && a.d(this.f20082c);
    }

    private Bitmap b(String str, int i2, int i3) {
        try {
            Bitmap a2 = a(i2, i3) ? com.facebook.ads.internal.q.b.c.a(str.substring(7), i2, i3) : BitmapFactory.decodeStream(new FileInputStream(str.substring(7)), (Rect) null, (BitmapFactory.Options) null);
            a(str, a2);
            return a2;
        } catch (IOException e2) {
            String str2 = f20080a;
            Log.e(str2, "Failed to copy local image into cache (url=" + str + ").", e2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap c(java.lang.String r5, int r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = "asset:///"
            boolean r0 = r5.startsWith(r0)
            if (r0 == 0) goto L_0x0046
            r0 = 0
            android.content.Context r1 = r4.f20082c     // Catch:{ IOException -> 0x003e, all -> 0x0037 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ IOException -> 0x003e, all -> 0x0037 }
            int r2 = r5.length()     // Catch:{ IOException -> 0x003e, all -> 0x0037 }
            r3 = 9
            java.lang.String r2 = r5.substring(r3, r2)     // Catch:{ IOException -> 0x003e, all -> 0x0037 }
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ IOException -> 0x003e, all -> 0x0037 }
            boolean r2 = r4.a((int) r6, (int) r7)     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
            if (r2 == 0) goto L_0x0028
            android.graphics.Bitmap r6 = com.facebook.ads.internal.q.b.c.a((java.io.InputStream) r1, (int) r6, (int) r7)     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
            goto L_0x002c
        L_0x0028:
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
        L_0x002c:
            if (r1 == 0) goto L_0x0055
            a((java.io.Closeable) r1)
            goto L_0x0055
        L_0x0032:
            r5 = move-exception
            r0 = r1
            goto L_0x0038
        L_0x0035:
            goto L_0x0040
        L_0x0037:
            r5 = move-exception
        L_0x0038:
            if (r0 == 0) goto L_0x003d
            a((java.io.Closeable) r0)
        L_0x003d:
            throw r5
        L_0x003e:
            r1 = r0
        L_0x0040:
            if (r1 == 0) goto L_0x0045
            a((java.io.Closeable) r1)
        L_0x0045:
            return r0
        L_0x0046:
            boolean r0 = r4.a((int) r6, (int) r7)
            if (r0 == 0) goto L_0x0051
            android.graphics.Bitmap r6 = r4.d(r5, r6, r7)     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            android.graphics.Bitmap r6 = r4.a((java.lang.String) r5)
        L_0x0055:
            r4.a((java.lang.String) r5, (android.graphics.Bitmap) r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.d.c.c(java.lang.String, int, int):android.graphics.Bitmap");
    }

    private Bitmap d(String str, int i2, int i3) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        Bitmap a2 = com.facebook.ads.internal.q.b.c.a(inputStream, i2, i3);
        a((Closeable) inputStream);
        return a2;
    }

    public Bitmap a(String str, int i2, int i3) {
        File cacheDir = this.f20082c.getCacheDir();
        File file = new File(cacheDir, str.hashCode() + ".png");
        return !file.exists() ? str.startsWith(AdPayload.FILE_SCHEME) ? b(str, i2, i3) : c(str, i2, i3) : a(i2, i3) ? com.facebook.ads.internal.q.b.c.a(file.getAbsolutePath(), i2, i3) : BitmapFactory.decodeFile(file.getAbsolutePath());
    }
}
