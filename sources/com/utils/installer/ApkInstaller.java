package com.utils.installer;

import android.content.IntentFilter;
import android.content.pm.PackageInstaller;
import android.os.Build;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ApkInstaller {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f37659d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final PackageInstallerService f37660a;

    /* renamed from: b  reason: collision with root package name */
    private final PackageInstaller f37661b;

    /* renamed from: c  reason: collision with root package name */
    private final ApkInstaller$installActionReceiver$1 f37662c;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public enum InstallProgressStatus {
        Preparing,
        Downloading,
        Installing,
        Installed,
        Failed;

        static {
            InstallProgressStatus[] a2;
            f37669h = EnumEntriesKt.a(a2);
        }
    }

    public ApkInstaller(PackageInstallerService packageInstallerService) {
        Intrinsics.f(packageInstallerService, "service");
        this.f37660a = packageInstallerService;
        PackageInstaller packageInstaller = packageInstallerService.getPackageManager().getPackageInstaller();
        Intrinsics.e(packageInstaller, "getPackageInstaller(...)");
        this.f37661b = packageInstaller;
        ApkInstaller$installActionReceiver$1 apkInstaller$installActionReceiver$1 = new ApkInstaller$installActionReceiver$1();
        this.f37662c = apkInstaller$installActionReceiver$1;
        if (Build.VERSION.SDK_INT >= 34) {
            packageInstallerService.registerReceiver(apkInstaller$installActionReceiver$1, new IntentFilter("ApkInstaller.INSTALL_ACTION"), 2);
        } else {
            packageInstallerService.registerReceiver(apkInstaller$installActionReceiver$1, new IntentFilter("ApkInstaller.INSTALL_ACTION"));
        }
        packageInstallerService.f().add(apkInstaller$installActionReceiver$1);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r18, java.io.File r19, kotlin.jvm.functions.Function2<? super java.lang.Float, ? super com.utils.installer.ApkInstaller.InstallProgressStatus, kotlin.Unit> r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.f(r0, r4)
            java.lang.String r4 = "apkFile"
            kotlin.jvm.internal.Intrinsics.f(r2, r4)
            java.lang.String r4 = "installProgress"
            kotlin.jvm.internal.Intrinsics.f(r3, r4)
            r4 = 0
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            com.utils.installer.ApkInstaller$InstallProgressStatus r5 = com.utils.installer.ApkInstaller.InstallProgressStatus.Preparing
            r3.invoke(r4, r5)
            r5 = 0
            android.content.pm.PackageManager r7 = r18.getPackageManager()     // Catch:{ Exception -> 0x00db }
            android.content.pm.PackageInstaller r7 = r7.getPackageInstaller()     // Catch:{ Exception -> 0x00db }
            java.lang.String r8 = "getPackageInstaller(...)"
            kotlin.jvm.internal.Intrinsics.e(r7, r8)     // Catch:{ Exception -> 0x00db }
            android.content.pm.PackageInstaller$SessionParams r8 = new android.content.pm.PackageInstaller$SessionParams     // Catch:{ Exception -> 0x00db }
            r9 = 1
            r8.<init>(r9)     // Catch:{ Exception -> 0x00db }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00db }
            r10 = 31
            if (r9 < r10) goto L_0x0044
            r9 = 2
            r8.setRequireUserAction(r9)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r0 = move-exception
            r6 = 0
            goto L_0x00de
        L_0x0044:
            int r8 = r7.createSession(r8)     // Catch:{ Exception -> 0x00db }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00db }
            int r9 = r8.intValue()     // Catch:{ Exception -> 0x00d8 }
            android.content.pm.PackageInstaller$Session r7 = r7.openSession(r9)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r9 = "openSession(...)"
            kotlin.jvm.internal.Intrinsics.e(r7, r9)     // Catch:{ Exception -> 0x00d8 }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00d8 }
            r9.<init>(r2)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r12 = r19.getName()     // Catch:{ all -> 0x00cf }
            r13 = 0
            long r15 = r19.length()     // Catch:{ all -> 0x00cf }
            r11 = r7
            java.io.OutputStream r11 = r11.openWrite(r12, r13, r15)     // Catch:{ all -> 0x00cf }
            r12 = 4096(0x1000, float:5.74E-42)
            byte[] r12 = new byte[r12]     // Catch:{ all -> 0x00c6 }
            long r13 = r19.length()     // Catch:{ all -> 0x00c6 }
            r15 = 0
        L_0x0077:
            int r2 = r9.read(r12)     // Catch:{ all -> 0x00c6 }
            r10 = -1
            if (r2 == r10) goto L_0x0094
            r11.write(r12, r5, r2)     // Catch:{ all -> 0x00c6 }
            long r5 = (long) r2     // Catch:{ all -> 0x00c6 }
            long r5 = r5 + r15
            float r2 = (float) r5     // Catch:{ all -> 0x00c6 }
            float r15 = (float) r13     // Catch:{ all -> 0x00c6 }
            float r2 = r2 / r15
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ all -> 0x00c6 }
            com.utils.installer.ApkInstaller$InstallProgressStatus r15 = com.utils.installer.ApkInstaller.InstallProgressStatus.Installing     // Catch:{ all -> 0x00c6 }
            r3.invoke(r2, r15)     // Catch:{ all -> 0x00c6 }
            r15 = r5
            r5 = 0
            r10 = 31
            goto L_0x0077
        L_0x0094:
            r7.fsync(r11)     // Catch:{ all -> 0x00c6 }
            kotlin.Unit r2 = kotlin.Unit.f40298a     // Catch:{ all -> 0x00c6 }
            r2 = 0
            kotlin.io.CloseableKt.a(r11, r2)     // Catch:{ all -> 0x00cf }
            kotlin.io.CloseableKt.a(r9, r2)     // Catch:{ Exception -> 0x00d8 }
            int r2 = r8.intValue()     // Catch:{ Exception -> 0x00d8 }
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r6 = "ApkInstaller.INSTALL_ACTION"
            r5.<init>(r6)     // Catch:{ Exception -> 0x00d8 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00d8 }
            r9 = 31
            if (r6 < r9) goto L_0x00b4
            r6 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x00b5
        L_0x00b4:
            r6 = 0
        L_0x00b5:
            android.app.PendingIntent r0 = android.app.PendingIntent.getBroadcast(r0, r2, r5, r6)     // Catch:{ Exception -> 0x00d8 }
            android.content.IntentSender r0 = r0.getIntentSender()     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r2 = "getIntentSender(...)"
            kotlin.jvm.internal.Intrinsics.e(r0, r2)     // Catch:{ Exception -> 0x00d8 }
            r7.commit(r0)     // Catch:{ Exception -> 0x00d8 }
            goto L_0x0101
        L_0x00c6:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x00c9 }
        L_0x00c9:
            r0 = move-exception
            r5 = r0
            kotlin.io.CloseableKt.a(r11, r2)     // Catch:{ all -> 0x00cf }
            throw r5     // Catch:{ all -> 0x00cf }
        L_0x00cf:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x00d2 }
        L_0x00d2:
            r0 = move-exception
            r5 = r0
            kotlin.io.CloseableKt.a(r9, r2)     // Catch:{ Exception -> 0x00d8 }
            throw r5     // Catch:{ Exception -> 0x00d8 }
        L_0x00d8:
            r0 = move-exception
            r6 = r8
            goto L_0x00de
        L_0x00db:
            r0 = move-exception
            r2 = 0
            r6 = r2
        L_0x00de:
            timber.log.Timber$Forest r2 = timber.log.Timber.f42178a
            java.lang.String r5 = r0.getMessage()
            r7 = 0
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r2.d(r0, r5, r7)
            com.utils.installer.PackageInstallerService r0 = r1.f37660a
            com.utils.installer.ApkInstaller$installActionReceiver$1 r2 = r1.f37662c
            r0.unregisterReceiver(r2)
            com.utils.installer.ApkInstaller$InstallProgressStatus r0 = com.utils.installer.ApkInstaller.InstallProgressStatus.Failed
            r3.invoke(r4, r0)
            if (r6 == 0) goto L_0x0101
            int r0 = r6.intValue()
            android.content.pm.PackageInstaller r2 = r1.f37661b
            r2.abandonSession(r0)
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.installer.ApkInstaller.a(android.content.Context, java.io.File, kotlin.jvm.functions.Function2):void");
    }
}
