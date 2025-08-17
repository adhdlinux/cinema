package com.utils.installer;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.cast.MediaTrack;
import com.utils.Coroutines;
import com.utils.installer.ApkInstaller;
import com.yoku.marumovie.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

public final class PackageInstallerService extends Service {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f37670e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final List<BroadcastReceiver> f37671b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f37672c = LazyKt__LazyJVMKt.b(new PackageInstallerService$baseNotification$2(this));

    /* renamed from: d  reason: collision with root package name */
    private final Mutex f37673d = MutexKt.b(false, 1, (Object) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37674a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.utils.installer.ApkInstaller$InstallProgressStatus[] r0 = com.utils.installer.ApkInstaller.InstallProgressStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.utils.installer.ApkInstaller$InstallProgressStatus r1 = com.utils.installer.ApkInstaller.InstallProgressStatus.Installing     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.utils.installer.ApkInstaller$InstallProgressStatus r1 = com.utils.installer.ApkInstaller.InstallProgressStatus.Preparing     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.utils.installer.ApkInstaller$InstallProgressStatus r1 = com.utils.installer.ApkInstaller.InstallProgressStatus.Downloading     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.utils.installer.ApkInstaller$InstallProgressStatus r1 = com.utils.installer.ApkInstaller.InstallProgressStatus.Failed     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.utils.installer.ApkInstaller$InstallProgressStatus r1 = com.utils.installer.ApkInstaller.InstallProgressStatus.Installed     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f37674a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.utils.installer.PackageInstallerService.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a8 A[Catch:{ Exception -> 0x013f }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ea A[Catch:{ all -> 0x013a, Exception -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f8 A[Catch:{ all -> 0x013a, Exception -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(java.lang.String r18, java.lang.String r19, kotlin.coroutines.Continuation<? super java.lang.Boolean> r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof com.utils.installer.PackageInstallerService$downloadUpdate$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.utils.installer.PackageInstallerService$downloadUpdate$1 r3 = (com.utils.installer.PackageInstallerService$downloadUpdate$1) r3
            int r4 = r3.f37682o
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f37682o = r4
            goto L_0x001e
        L_0x0019:
            com.utils.installer.PackageInstallerService$downloadUpdate$1 r3 = new com.utils.installer.PackageInstallerService$downloadUpdate$1
            r3.<init>(r1, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f37680m
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r5 = r3.f37682o
            r7 = 0
            r8 = 0
            r9 = 1
            if (r5 == 0) goto L_0x0052
            if (r5 != r9) goto L_0x004a
            java.lang.Object r0 = r3.f37679l
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r4 = r3.f37678k
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r3.f37677j
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.f37676i
            com.utils.installer.PackageInstallerService r3 = (com.utils.installer.PackageInstallerService) r3
            kotlin.ResultKt.b(r2)     // Catch:{ Exception -> 0x0047 }
            r16 = r5
            r5 = r0
            r0 = r16
            goto L_0x00db
        L_0x0047:
            r0 = move-exception
            goto L_0x0141
        L_0x004a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0052:
            kotlin.ResultKt.b(r2)
            java.lang.String r2 = "PackageInstallerService"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013f }
            r5.<init>()     // Catch:{ Exception -> 0x013f }
            java.lang.String r10 = "Downloading update: "
            r5.append(r10)     // Catch:{ Exception -> 0x013f }
            r5.append(r0)     // Catch:{ Exception -> 0x013f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x013f }
            android.util.Log.d(r2, r5)     // Catch:{ Exception -> 0x013f }
            java.lang.String r2 = r17.h(r18)     // Catch:{ Exception -> 0x013f }
            java.lang.String r5 = "apk"
            java.io.File r10 = r17.getCacheDir()     // Catch:{ Exception -> 0x013f }
            java.io.File[] r10 = r10.listFiles()     // Catch:{ Exception -> 0x013f }
            if (r10 == 0) goto L_0x00c6
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x013f }
            r11.<init>()     // Catch:{ Exception -> 0x013f }
            int r12 = r10.length     // Catch:{ Exception -> 0x013f }
            r13 = 0
        L_0x0082:
            if (r13 >= r12) goto L_0x00ae
            r14 = r10[r13]     // Catch:{ Exception -> 0x013f }
            java.lang.String r15 = r14.getName()     // Catch:{ Exception -> 0x013f }
            java.lang.String r6 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.e(r15, r6)     // Catch:{ Exception -> 0x013f }
            r6 = 2
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.G(r15, r2, r8, r6, r7)     // Catch:{ Exception -> 0x013f }
            if (r6 == 0) goto L_0x00a5
            kotlin.jvm.internal.Intrinsics.c(r14)     // Catch:{ Exception -> 0x013f }
            java.lang.String r6 = kotlin.io.FilesKt__UtilsKt.g(r14)     // Catch:{ Exception -> 0x013f }
            boolean r6 = kotlin.jvm.internal.Intrinsics.a(r6, r5)     // Catch:{ Exception -> 0x013f }
            if (r6 == 0) goto L_0x00a5
            r6 = 1
            goto L_0x00a6
        L_0x00a5:
            r6 = 0
        L_0x00a6:
            if (r6 == 0) goto L_0x00ab
            r11.add(r14)     // Catch:{ Exception -> 0x013f }
        L_0x00ab:
            int r13 = r13 + 1
            goto L_0x0082
        L_0x00ae:
            java.util.Iterator r5 = r11.iterator()     // Catch:{ Exception -> 0x013f }
        L_0x00b2:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x013f }
            if (r6 == 0) goto L_0x00c6
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x013f }
            java.io.File r6 = (java.io.File) r6     // Catch:{ Exception -> 0x013f }
            java.lang.String r6 = r6.getPath()     // Catch:{ Exception -> 0x013f }
            com.utils.Utils.c(r6)     // Catch:{ Exception -> 0x013f }
            goto L_0x00b2
        L_0x00c6:
            kotlinx.coroutines.sync.Mutex r5 = r1.f37673d     // Catch:{ Exception -> 0x013f }
            r3.f37676i = r1     // Catch:{ Exception -> 0x013f }
            r3.f37677j = r0     // Catch:{ Exception -> 0x013f }
            r3.f37678k = r2     // Catch:{ Exception -> 0x013f }
            r3.f37679l = r5     // Catch:{ Exception -> 0x013f }
            r3.f37682o = r9     // Catch:{ Exception -> 0x013f }
            java.lang.Object r3 = r5.a(r7, r3)     // Catch:{ Exception -> 0x013f }
            if (r3 != r4) goto L_0x00d9
            return r4
        L_0x00d9:
            r3 = r1
            r4 = r2
        L_0x00db:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x013a }
            java.io.File r6 = r3.getCacheDir()     // Catch:{ all -> 0x013a }
            r2.<init>(r6, r4)     // Catch:{ all -> 0x013a }
            boolean r6 = r2.exists()     // Catch:{ all -> 0x013a }
            if (r6 == 0) goto L_0x00f8
            com.utils.installer.ApkInstaller r0 = new com.utils.installer.ApkInstaller     // Catch:{ all -> 0x013a }
            r0.<init>(r3)     // Catch:{ all -> 0x013a }
            com.utils.installer.PackageInstallerService$downloadUpdate$4$1 r4 = new com.utils.installer.PackageInstallerService$downloadUpdate$4$1     // Catch:{ all -> 0x013a }
            r4.<init>(r3)     // Catch:{ all -> 0x013a }
            r0.a(r3, r2, r4)     // Catch:{ all -> 0x013a }
            goto L_0x0130
        L_0x00f8:
            com.utils.installer.ApkInstaller$InstallProgressStatus r2 = com.utils.installer.ApkInstaller.InstallProgressStatus.Downloading     // Catch:{ all -> 0x013a }
            r6 = 0
            r3.g(r6, r2)     // Catch:{ all -> 0x013a }
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder     // Catch:{ all -> 0x013a }
            r2.<init>()     // Catch:{ all -> 0x013a }
            okhttp3.Request$Builder r0 = r2.url((java.lang.String) r0)     // Catch:{ all -> 0x013a }
            okhttp3.Request r0 = r0.build()     // Catch:{ all -> 0x013a }
            okhttp3.OkHttpClient$Builder r2 = new okhttp3.OkHttpClient$Builder     // Catch:{ all -> 0x013a }
            r2.<init>()     // Catch:{ all -> 0x013a }
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x013a }
            r10 = 30
            okhttp3.OkHttpClient$Builder r2 = r2.connectTimeout(r10, r6)     // Catch:{ all -> 0x013a }
            okhttp3.OkHttpClient$Builder r2 = r2.writeTimeout(r10, r6)     // Catch:{ all -> 0x013a }
            okhttp3.OkHttpClient$Builder r2 = r2.readTimeout(r10, r6)     // Catch:{ all -> 0x013a }
            okhttp3.OkHttpClient r2 = r2.build()     // Catch:{ all -> 0x013a }
            okhttp3.Call r0 = r2.newCall(r0)     // Catch:{ all -> 0x013a }
            com.utils.installer.PackageInstallerService$downloadUpdate$4$2 r2 = new com.utils.installer.PackageInstallerService$downloadUpdate$4$2     // Catch:{ all -> 0x013a }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x013a }
            r0.enqueue(r2)     // Catch:{ all -> 0x013a }
        L_0x0130:
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x013a }
            r5.b(r7)     // Catch:{ Exception -> 0x0047 }
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.a(r9)     // Catch:{ Exception -> 0x0047 }
            return r0
        L_0x013a:
            r0 = move-exception
            r5.b(r7)     // Catch:{ Exception -> 0x0047 }
            throw r0     // Catch:{ Exception -> 0x0047 }
        L_0x013f:
            r0 = move-exception
            r3 = r1
        L_0x0141:
            timber.log.Timber$Forest r2 = timber.log.Timber.f42178a
            r2.c(r0)
            com.utils.installer.ApkInstaller$InstallProgressStatus r0 = com.utils.installer.ApkInstaller.InstallProgressStatus.Failed
            r2 = 0
            r3.g(r2, r0)
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.a(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.installer.PackageInstallerService.d(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final NotificationCompat.Builder e() {
        return (NotificationCompat.Builder) this.f37672c.getValue();
    }

    /* access modifiers changed from: private */
    public final void g(float f2, ApkInstaller.InstallProgressStatus installProgressStatus) {
        int i2;
        int i3 = WhenMappings.f37674a[installProgressStatus.ordinal()];
        if (i3 == 1) {
            i2 = R.string.update_notification_installing;
        } else if (i3 == 2 || i3 == 3) {
            i2 = R.string.update_notification_downloading;
        } else if (i3 == 4) {
            i2 = R.string.update_notification_failed;
        } else if (i3 == 5) {
            i2 = R.string.update_notification_success;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intent intent = new Intent("PROGRESS_UPDATE_ACTION");
        intent.putExtra("EXTRA_PROGRESS", (int) (f2 * ((float) 100)));
        intent.putExtra("EXTRA_INSTALL_STATUS", getString(i2));
        sendBroadcast(intent);
    }

    private final String h(String str) {
        List v02 = StringsKt__StringsKt.v0(str, new String[]{"/"}, false, 0, 6, (Object) null);
        return ((String) v02.get(v02.size() - 2)) + '_' + ((String) CollectionsKt___CollectionsKt.K(v02));
    }

    public final void c(Context context, String str, String str2, String str3) {
        Intrinsics.f(context, "<this>");
        Intrinsics.f(str, "channelId");
        Intrinsics.f(str2, "channelName");
        Intrinsics.f(str3, MediaTrack.ROLE_DESCRIPTION);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(str, str2, 3);
            notificationChannel.setDescription(str3);
            Object systemService = context.getSystemService("notification");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
        }
    }

    public final List<BroadcastReceiver> f() {
        return this.f37671b;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        c(this, "cinema.updates", "App Updates", "App updates notification channel");
        if (Build.VERSION.SDK_INT >= 29) {
            startForeground(-634354165, e().c(), 1);
        } else {
            startForeground(-634354165, e().c());
        }
    }

    public void onDestroy() {
        for (BroadcastReceiver unregisterReceiver : this.f37671b) {
            try {
                unregisterReceiver(unregisterReceiver);
            } catch (IllegalArgumentException unused) {
            }
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        String stringExtra;
        String stringExtra2;
        if (intent == null || (stringExtra = intent.getStringExtra("EXTRA_URL")) == null || (stringExtra2 = intent.getStringExtra("EXTRA_PACKAGE_NAME")) == null) {
            return 2;
        }
        Coroutines.f37223a.a(this, new PackageInstallerService$onStartCommand$1(this, stringExtra, stringExtra2, (Continuation<? super PackageInstallerService$onStartCommand$1>) null));
        return 2;
    }
}
