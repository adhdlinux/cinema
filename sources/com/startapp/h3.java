package com.startapp;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class h3 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34608a = "h3";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f34609b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final String f34610c = "truststore.bin";

    /* renamed from: d  reason: collision with root package name */
    private static final String f34611d = "truststore.bin.sig";

    /* renamed from: e  reason: collision with root package name */
    private static final int f34612e = 10000;

    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r9) {
        /*
            r0 = 0
            com.startapp.u0 r1 = com.startapp.w0.b()     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = r1.CONNECTIVITY_TEST_TRUSTSTORE_URL()     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "[PROJECTID]"
            com.startapp.u0 r3 = com.startapp.w0.b()     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = r3.PROJECT_ID()     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = r1.replace(r2, r3)     // Catch:{ all -> 0x00d8 }
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x00d8 }
            r2.<init>(r1)     // Catch:{ all -> 0x00d8 }
            java.net.URLConnection r1 = r2.openConnection()     // Catch:{ all -> 0x00d8 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = "GET"
            r1.setRequestMethod(r0)     // Catch:{ all -> 0x00d6 }
            r0 = 10000(0x2710, float:1.4013E-41)
            r1.setConnectTimeout(r0)     // Catch:{ all -> 0x00d6 }
            r1.setReadTimeout(r0)     // Catch:{ all -> 0x00d6 }
            com.startapp.x0 r0 = com.startapp.w0.c()     // Catch:{ all -> 0x00d6 }
            long r2 = r0.F()     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = a((long) r2)     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = "If-Modified-Since"
            r1.setRequestProperty(r2, r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = "Connection"
            java.lang.String r2 = "close"
            r1.setRequestProperty(r0, r2)     // Catch:{ all -> 0x00d6 }
            int r0 = r1.getResponseCode()     // Catch:{ all -> 0x00d6 }
            r2 = 304(0x130, float:4.26E-43)
            if (r0 != r2) goto L_0x005c
            com.startapp.x0 r0 = com.startapp.w0.c()     // Catch:{ all -> 0x00d6 }
            long r2 = com.startapp.r2.d()     // Catch:{ all -> 0x00d6 }
            r0.h((long) r2)     // Catch:{ all -> 0x00d6 }
            goto L_0x00e4
        L_0x005c:
            int r0 = r1.getResponseCode()     // Catch:{ all -> 0x00d6 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L_0x00e4
            long r2 = r1.getLastModified()     // Catch:{ all -> 0x00d6 }
            java.io.InputStream r0 = r1.getInputStream()     // Catch:{ all -> 0x00d6 }
            java.io.File r4 = e(r9)     // Catch:{ all -> 0x00d1 }
            a((java.io.InputStream) r0, (java.io.File) r4)     // Catch:{ all -> 0x00d1 }
            r0.close()     // Catch:{ all -> 0x00d6 }
            com.startapp.u0 r0 = com.startapp.w0.b()     // Catch:{ all -> 0x00d6 }
            boolean r0 = r0.CONNECTIVITY_TEST_VERIFY_TRUSTSTORE_SIGNATURE()     // Catch:{ all -> 0x00d6 }
            r4 = 1
            if (r0 == 0) goto L_0x009c
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00d6 }
            java.io.File r5 = e(r9)     // Catch:{ all -> 0x00d6 }
            java.lang.String r6 = "truststore.bin"
            r0.<init>(r5, r6)     // Catch:{ all -> 0x00d6 }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00d6 }
            java.io.File r6 = e(r9)     // Catch:{ all -> 0x00d6 }
            java.lang.String r7 = "truststore.bin.sig"
            r5.<init>(r6, r7)     // Catch:{ all -> 0x00d6 }
            boolean r0 = a((java.io.File) r0, (java.io.File) r5)     // Catch:{ all -> 0x00d6 }
            goto L_0x009d
        L_0x009c:
            r0 = 1
        L_0x009d:
            if (r0 == 0) goto L_0x00c9
            boolean r0 = f(r9)     // Catch:{ all -> 0x00d6 }
            if (r0 == 0) goto L_0x00c1
            boolean r0 = g(r9)     // Catch:{ all -> 0x00d6 }
            if (r0 == 0) goto L_0x00c1
            com.startapp.x0 r0 = com.startapp.w0.c()     // Catch:{ all -> 0x00d6 }
            long r5 = com.startapp.r2.d()     // Catch:{ all -> 0x00d6 }
            r0.h((long) r5)     // Catch:{ all -> 0x00d6 }
            com.startapp.x0 r0 = com.startapp.w0.c()     // Catch:{ all -> 0x00d6 }
            r0.l((long) r2)     // Catch:{ all -> 0x00d6 }
            r1.disconnect()
            return r4
        L_0x00c1:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = "Moving of cached files failed."
            r0.<init>(r2)     // Catch:{ all -> 0x00d6 }
            throw r0     // Catch:{ all -> 0x00d6 }
        L_0x00c9:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = "Verification of downloaded truststore failed"
            r0.<init>(r2)     // Catch:{ all -> 0x00d6 }
            throw r0     // Catch:{ all -> 0x00d6 }
        L_0x00d1:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x00d6 }
            throw r2     // Catch:{ all -> 0x00d6 }
        L_0x00d6:
            r0 = move-exception
            goto L_0x00dc
        L_0x00d8:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
        L_0x00dc:
            com.startapp.l2.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x00e9 }
            b(r9)     // Catch:{ all -> 0x00e9 }
            if (r1 == 0) goto L_0x00e7
        L_0x00e4:
            r1.disconnect()
        L_0x00e7:
            r9 = 0
            return r9
        L_0x00e9:
            r9 = move-exception
            if (r1 == 0) goto L_0x00ef
            r1.disconnect()
        L_0x00ef:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.h3.a(android.content.Context):boolean");
    }

    private static void b(Context context) {
        File file = new File(e(context), f34610c);
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(e(context), f34611d);
        if (file2.exists()) {
            file2.delete();
        }
    }

    public static File c(Context context) {
        File file = new File(context.getFilesDir() + "/insight/truststore/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, f34610c);
    }

    public static File d(Context context) {
        File file = new File(context.getFilesDir() + "/insight/truststore/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, f34611d);
    }

    private static File e(Context context) {
        File file = new File(context.getCacheDir() + "/insight/truststore/", "truststoreunzip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static boolean f(Context context) throws IOException {
        return new File(e(context), f34610c).renameTo(c(context));
    }

    private static boolean g(Context context) throws IOException {
        return new File(e(context), f34611d).renameTo(d(context));
    }

    private static void a(InputStream inputStream, File file) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    File file2 = new File(file, nextEntry.getName());
                    if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                        if (!nextEntry.isDirectory()) {
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            while (true) {
                                int read = zipInputStream.read();
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(read);
                            }
                            zipInputStream.closeEntry();
                            fileOutputStream.close();
                        } else if (!file2.isDirectory()) {
                            file2.mkdirs();
                        }
                    }
                } else {
                    return;
                }
            } finally {
                zipInputStream.close();
            }
        }
    }

    private static String a(long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(Long.valueOf(j2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077 A[SYNTHETIC, Splitter:B:32:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0081 A[SYNTHETIC, Splitter:B:37:0x0081] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r6, java.io.File r7) {
        /*
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0070 }
            r2.<init>(r7)     // Catch:{ all -> 0x0070 }
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x006c }
            r7.<init>()     // Catch:{ all -> 0x006c }
            r3 = 512(0x200, float:7.175E-43)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x006c }
            int r4 = r2.read(r3)     // Catch:{ all -> 0x006c }
        L_0x0014:
            r5 = -1
            if (r4 == r5) goto L_0x001f
            r7.write(r3, r0, r4)     // Catch:{ all -> 0x006c }
            int r4 = r2.read(r3)     // Catch:{ all -> 0x006c }
            goto L_0x0014
        L_0x001f:
            r7.flush()     // Catch:{ all -> 0x006c }
            byte[] r7 = r7.toByteArray()     // Catch:{ all -> 0x006c }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x006c }
            r4.<init>(r6)     // Catch:{ all -> 0x006c }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x006a }
            r6.<init>()     // Catch:{ all -> 0x006a }
            int r1 = r4.read(r3)     // Catch:{ all -> 0x006a }
        L_0x0034:
            if (r1 == r5) goto L_0x003e
            r6.write(r3, r0, r1)     // Catch:{ all -> 0x006a }
            int r1 = r4.read(r3)     // Catch:{ all -> 0x006a }
            goto L_0x0034
        L_0x003e:
            r6.flush()     // Catch:{ all -> 0x006a }
            byte[] r6 = r6.toByteArray()     // Catch:{ all -> 0x006a }
            java.lang.String r1 = "SHA256withRSA"
            java.security.Signature r1 = java.security.Signature.getInstance(r1)     // Catch:{ all -> 0x006a }
            java.security.PublicKey r3 = com.startapp.w0.e()     // Catch:{ all -> 0x006a }
            r1.initVerify(r3)     // Catch:{ all -> 0x006a }
            r1.update(r6)     // Catch:{ all -> 0x006a }
            boolean r6 = r1.verify(r7)     // Catch:{ all -> 0x006a }
            r2.close()     // Catch:{ all -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r7 = move-exception
            com.startapp.l2.b(r7)
        L_0x0061:
            r4.close()     // Catch:{ all -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r7 = move-exception
            com.startapp.l2.b(r7)
        L_0x0069:
            return r6
        L_0x006a:
            r6 = move-exception
            goto L_0x006e
        L_0x006c:
            r6 = move-exception
            r4 = r1
        L_0x006e:
            r1 = r2
            goto L_0x0072
        L_0x0070:
            r6 = move-exception
            r4 = r1
        L_0x0072:
            com.startapp.l2.a((java.lang.Throwable) r6)     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x007f
            r1.close()     // Catch:{ all -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r6 = move-exception
            com.startapp.l2.b(r6)
        L_0x007f:
            if (r4 == 0) goto L_0x0089
            r4.close()     // Catch:{ all -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r6 = move-exception
            com.startapp.l2.b(r6)
        L_0x0089:
            return r0
        L_0x008a:
            r6 = move-exception
            if (r1 == 0) goto L_0x0095
            r1.close()     // Catch:{ all -> 0x0091 }
            goto L_0x0095
        L_0x0091:
            r7 = move-exception
            com.startapp.l2.b(r7)
        L_0x0095:
            if (r4 == 0) goto L_0x009f
            r4.close()     // Catch:{ all -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r7 = move-exception
            com.startapp.l2.b(r7)
        L_0x009f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.h3.a(java.io.File, java.io.File):boolean");
    }
}
