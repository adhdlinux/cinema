package com.utils.installer;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;

public final class PackageInstallerService$downloadUpdate$4$2 implements Callback {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PackageInstallerService f37684b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f37685c;

    PackageInstallerService$downloadUpdate$4$2(PackageInstallerService packageInstallerService, String str) {
        this.f37684b = packageInstallerService;
        this.f37685c = str;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.f(call, "call");
        Intrinsics.f(iOException, "e");
        iOException.printStackTrace();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.CloseableKt.a(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0080, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
        kotlin.io.CloseableKt.a(r0, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
        throw r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResponse(okhttp3.Call r10, okhttp3.Response r11) {
        /*
            r9 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            java.lang.String r10 = "response"
            kotlin.jvm.internal.Intrinsics.f(r11, r10)
            okhttp3.ResponseBody r10 = r11.body()
            if (r10 == 0) goto L_0x0085
            com.utils.installer.PackageInstallerService r11 = r9.f37684b
            java.lang.String r0 = r9.f37685c
            long r1 = r10.contentLength()
            java.io.File r3 = new java.io.File
            java.io.File r4 = r11.getCacheDir()
            r3.<init>(r4, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r3)
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x007e }
            java.io.InputStream r10 = r10.byteStream()     // Catch:{ all -> 0x007e }
            r5 = 0
        L_0x0030:
            int r7 = r10.read(r4)     // Catch:{ all -> 0x0077 }
            r8 = -1
            if (r7 == r8) goto L_0x0046
            r8 = 0
            r0.write(r4, r8, r7)     // Catch:{ all -> 0x0077 }
            long r7 = (long) r7     // Catch:{ all -> 0x0077 }
            long r5 = r5 + r7
            float r7 = (float) r5     // Catch:{ all -> 0x0077 }
            float r8 = (float) r1     // Catch:{ all -> 0x0077 }
            float r7 = r7 / r8
            com.utils.installer.ApkInstaller$InstallProgressStatus r8 = com.utils.installer.ApkInstaller.InstallProgressStatus.Downloading     // Catch:{ all -> 0x0077 }
            r11.g(r7, r8)     // Catch:{ all -> 0x0077 }
            goto L_0x0030
        L_0x0046:
            kotlin.Unit r1 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0077 }
            r1 = 0
            kotlin.io.CloseableKt.a(r10, r1)     // Catch:{ all -> 0x007e }
            kotlin.io.CloseableKt.a(r0, r1)
            com.utils.installer.ApkInstaller r10 = new com.utils.installer.ApkInstaller
            r10.<init>(r11)
            com.utils.installer.PackageInstallerService$downloadUpdate$4$2$onResponse$1$2 r0 = new com.utils.installer.PackageInstallerService$downloadUpdate$4$2$onResponse$1$2
            r0.<init>(r11)
            r10.a(r11, r3, r0)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "APK saved to "
            r10.append(r11)
            java.lang.String r11 = r3.getAbsolutePath()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "APK Download"
            android.util.Log.d(r11, r10)
            goto L_0x0085
        L_0x0077:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r10, r11)     // Catch:{ all -> 0x007e }
            throw r1     // Catch:{ all -> 0x007e }
        L_0x007e:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r11 = move-exception
            kotlin.io.CloseableKt.a(r0, r10)
            throw r11
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.installer.PackageInstallerService$downloadUpdate$4$2.onResponse(okhttp3.Call, okhttp3.Response):void");
    }
}
