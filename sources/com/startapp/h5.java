package com.startapp;

import com.startapp.sdk.ads.video.player.VideoPlayerInterface;

public class h5 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f34614a = true;

    /* renamed from: b  reason: collision with root package name */
    public VideoPlayerInterface.a f34615b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f34616c = null;

    public interface a {
        void a(String str);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final h5 f34617a = new h5();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0122 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0125 */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0141 A[SYNTHETIC, Splitter:B:78:0x0141] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x014c A[Catch:{ all -> 0x0145 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(android.content.Context r21, java.net.URL r22, java.lang.String r23, com.startapp.h5.a r24) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r0 = r23
            r3 = r24
            java.lang.String r4 = ".temp"
            java.lang.String r5 = r22.toString()
            r1.f34616c = r5
            r5 = 1
            r1.f34614a = r5
            r6 = 0
            com.startapp.sdk.adsbase.AdsCommonMetaData r7 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h     // Catch:{ all -> 0x013a }
            com.startapp.sdk.adsbase.VideoConfig r7 = r7.G()     // Catch:{ all -> 0x013a }
            int r7 = r7.j()     // Catch:{ all -> 0x013a }
            java.lang.String r8 = com.startapp.p.a((android.content.Context) r2, (java.lang.String) r0)     // Catch:{ all -> 0x013a }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x013a }
            r9.<init>(r8)     // Catch:{ all -> 0x013a }
            boolean r10 = r9.exists()     // Catch:{ all -> 0x013a }
            if (r10 == 0) goto L_0x0039
            r1.f34616c = r6
            com.startapp.lb.a((java.io.Closeable) r6)
            com.startapp.lb.a((java.io.Closeable) r6)
            com.startapp.lb.a((java.io.Closeable) r6)
            return r8
        L_0x0039:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x013a }
            r10.<init>()     // Catch:{ all -> 0x013a }
            r10.append(r0)     // Catch:{ all -> 0x013a }
            r10.append(r4)     // Catch:{ all -> 0x013a }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x013a }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x013a }
            r10.<init>()     // Catch:{ all -> 0x013a }
            r10.append(r8)     // Catch:{ all -> 0x013a }
            r10.append(r4)     // Catch:{ all -> 0x013a }
            java.lang.String r4 = r10.toString()     // Catch:{ all -> 0x013a }
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x013a }
            java.lang.String r11 = com.startapp.p.a((android.content.Context) r2, (java.lang.String) r0)     // Catch:{ all -> 0x013a }
            r10.<init>(r11)     // Catch:{ all -> 0x013a }
            java.net.URLConnection r11 = r22.openConnection()     // Catch:{ all -> 0x0136 }
            r11.connect()     // Catch:{ all -> 0x0136 }
            int r12 = r11.getContentLength()     // Catch:{ all -> 0x0136 }
            java.io.InputStream r11 = r11.getInputStream()     // Catch:{ all -> 0x0136 }
            java.io.DataInputStream r13 = new java.io.DataInputStream     // Catch:{ all -> 0x0134 }
            r13.<init>(r11)     // Catch:{ all -> 0x0134 }
            r14 = 4096(0x1000, float:5.74E-42)
            byte[] r14 = new byte[r14]     // Catch:{ all -> 0x0131 }
            r15 = 0
            java.io.FileOutputStream r5 = r2.openFileOutput(r0, r15)     // Catch:{ all -> 0x0131 }
            r0 = 0
            r16 = 0
            r17 = 0
        L_0x0082:
            int r6 = r13.read(r14)     // Catch:{ all -> 0x012f }
            if (r6 <= 0) goto L_0x00de
            boolean r15 = r1.f34614a     // Catch:{ all -> 0x012f }
            if (r15 == 0) goto L_0x00de
            r15 = 0
            r5.write(r14, r15, r6)     // Catch:{ all -> 0x012f }
            int r0 = r0 + r6
            r23 = r14
            double r14 = (double) r0     // Catch:{ all -> 0x012f }
            r18 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r14 = r14 * r18
            r18 = r8
            r19 = r9
            double r8 = (double) r12     // Catch:{ all -> 0x012f }
            double r14 = r14 / r8
            int r15 = (int) r14     // Catch:{ all -> 0x012f }
            if (r15 < r7) goto L_0x00d6
            if (r16 != 0) goto L_0x00b8
            if (r3 == 0) goto L_0x00b8
            android.os.Handler r6 = new android.os.Handler     // Catch:{ all -> 0x012f }
            android.os.Looper r8 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x012f }
            r6.<init>(r8)     // Catch:{ all -> 0x012f }
            com.startapp.f5 r8 = new com.startapp.f5     // Catch:{ all -> 0x012f }
            r8.<init>(r1, r3, r4)     // Catch:{ all -> 0x012f }
            r6.post(r8)     // Catch:{ all -> 0x012f }
            r16 = 1
        L_0x00b8:
            int r6 = r17 + 1
            if (r15 < r6) goto L_0x00d6
            com.startapp.sdk.ads.video.player.VideoPlayerInterface$a r6 = r1.f34615b     // Catch:{ all -> 0x012f }
            if (r6 == 0) goto L_0x00d1
            android.os.Handler r6 = new android.os.Handler     // Catch:{ all -> 0x012f }
            android.os.Looper r8 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x012f }
            r6.<init>(r8)     // Catch:{ all -> 0x012f }
            com.startapp.g5 r8 = new com.startapp.g5     // Catch:{ all -> 0x012f }
            r8.<init>(r1, r15)     // Catch:{ all -> 0x012f }
            r6.post(r8)     // Catch:{ all -> 0x012f }
        L_0x00d1:
            r14 = r23
            r17 = r15
            goto L_0x00d8
        L_0x00d6:
            r14 = r23
        L_0x00d8:
            r8 = r18
            r9 = r19
            r15 = 0
            goto L_0x0082
        L_0x00de:
            r18 = r8
            r19 = r9
            boolean r0 = r1.f34614a     // Catch:{ all -> 0x012f }
            if (r0 != 0) goto L_0x00fa
            if (r6 <= 0) goto L_0x00fa
            r10.delete()     // Catch:{ all -> 0x012f }
            r2 = 0
            r1.f34616c = r2
            com.startapp.lb.a((java.io.Closeable) r11)
            com.startapp.lb.a((java.io.Closeable) r13)
            com.startapp.lb.a((java.io.Closeable) r5)
            java.lang.String r0 = "downloadInterrupted"
            return r0
        L_0x00fa:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0123, all -> 0x0119 }
            r3.<init>(r10)     // Catch:{ Exception -> 0x0123, all -> 0x0119 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0124, all -> 0x0117 }
            r0 = r19
            r4.<init>(r0)     // Catch:{ Exception -> 0x0124, all -> 0x0117 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0125, all -> 0x0115 }
        L_0x010a:
            int r6 = r3.read(r0)     // Catch:{ Exception -> 0x0125, all -> 0x0115 }
            if (r6 <= 0) goto L_0x0125
            r7 = 0
            r4.write(r0, r7, r6)     // Catch:{ Exception -> 0x0125, all -> 0x0115 }
            goto L_0x010a
        L_0x0115:
            r0 = move-exception
            goto L_0x011c
        L_0x0117:
            r0 = move-exception
            goto L_0x011b
        L_0x0119:
            r0 = move-exception
            r3 = 0
        L_0x011b:
            r4 = 0
        L_0x011c:
            r3.close()     // Catch:{ Exception -> 0x0122 }
            r4.close()     // Catch:{ Exception -> 0x0122 }
        L_0x0122:
            throw r0     // Catch:{ all -> 0x012f }
        L_0x0123:
            r3 = 0
        L_0x0124:
            r4 = 0
        L_0x0125:
            r3.close()     // Catch:{ Exception -> 0x012b }
            r4.close()     // Catch:{ Exception -> 0x012b }
        L_0x012b:
            r8 = r18
            r2 = 0
            goto L_0x0156
        L_0x012f:
            r0 = move-exception
            goto L_0x013f
        L_0x0131:
            r0 = move-exception
            r5 = 0
            goto L_0x013f
        L_0x0134:
            r0 = move-exception
            goto L_0x0138
        L_0x0136:
            r0 = move-exception
            r11 = 0
        L_0x0138:
            r5 = 0
            goto L_0x013e
        L_0x013a:
            r0 = move-exception
            r5 = 0
            r10 = 0
            r11 = 0
        L_0x013e:
            r13 = 0
        L_0x013f:
            if (r10 == 0) goto L_0x0148
            r10.delete()     // Catch:{ all -> 0x0145 }
            goto L_0x0148
        L_0x0145:
            r0 = move-exception
            r2 = 0
            goto L_0x0162
        L_0x0148:
            boolean r3 = r0 instanceof java.io.IOException     // Catch:{ all -> 0x0145 }
            if (r3 != 0) goto L_0x0154
            boolean r3 = r0 instanceof java.lang.OutOfMemoryError     // Catch:{ all -> 0x0145 }
            if (r3 == 0) goto L_0x0151
            goto L_0x0154
        L_0x0151:
            com.startapp.y8.a((android.content.Context) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0145 }
        L_0x0154:
            r2 = 0
            r8 = 0
        L_0x0156:
            r1.f34616c = r2
            com.startapp.lb.a((java.io.Closeable) r11)
            com.startapp.lb.a((java.io.Closeable) r13)
            com.startapp.lb.a((java.io.Closeable) r5)
            return r8
        L_0x0162:
            r1.f34616c = r2
            com.startapp.lb.a((java.io.Closeable) r11)
            com.startapp.lb.a((java.io.Closeable) r13)
            com.startapp.lb.a((java.io.Closeable) r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.h5.a(android.content.Context, java.net.URL, java.lang.String, com.startapp.h5$a):java.lang.String");
    }
}
