package com.google.android.exoplayer2.offline;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public abstract class DownloadService extends Service {
    public static final String ACTION_ADD_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD";
    public static final String ACTION_INIT = "com.google.android.exoplayer.downloadService.action.INIT";
    public static final String ACTION_PAUSE_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS";
    public static final String ACTION_REMOVE_ALL_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS";
    public static final String ACTION_REMOVE_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD";
    private static final String ACTION_RESTART = "com.google.android.exoplayer.downloadService.action.RESTART";
    public static final String ACTION_RESUME_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS";
    public static final String ACTION_SET_REQUIREMENTS = "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS";
    public static final String ACTION_SET_STOP_REASON = "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON";
    public static final long DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL = 1000;
    public static final int FOREGROUND_NOTIFICATION_ID_NONE = 0;
    public static final String KEY_CONTENT_ID = "content_id";
    public static final String KEY_DOWNLOAD_REQUEST = "download_request";
    public static final String KEY_FOREGROUND = "foreground";
    public static final String KEY_REQUIREMENTS = "requirements";
    public static final String KEY_STOP_REASON = "stop_reason";
    private static final String TAG = "DownloadService";
    private static final HashMap<Class<? extends DownloadService>, DownloadManagerHelper> downloadManagerHelpers = new HashMap<>();
    private final int channelDescriptionResourceId;
    private final String channelId;
    private final int channelNameResourceId;
    /* access modifiers changed from: private */
    public DownloadManagerHelper downloadManagerHelper;
    private final ForegroundNotificationUpdater foregroundNotificationUpdater;
    private boolean isDestroyed;
    private boolean isStopped;
    private int lastStartId;
    private boolean startedInForeground;
    private boolean taskRemoved;

    private static final class DownloadManagerHelper implements DownloadManager.Listener {

        /* renamed from: a  reason: collision with root package name */
        private final Context f25586a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final DownloadManager f25587b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f25588c;

        /* renamed from: d  reason: collision with root package name */
        private final Scheduler f25589d;

        /* renamed from: e  reason: collision with root package name */
        private final Class<? extends DownloadService> f25590e;

        /* renamed from: f  reason: collision with root package name */
        private DownloadService f25591f;

        /* renamed from: g  reason: collision with root package name */
        private Requirements f25592g;

        @RequiresNonNull({"scheduler"})
        private void d() {
            Requirements requirements = new Requirements(0);
            if (h(requirements)) {
                this.f25589d.cancel();
                this.f25592g = requirements;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(DownloadService downloadService) {
            downloadService.notifyDownloads(this.f25587b.e());
        }

        private void g() {
            if (this.f25588c) {
                try {
                    Util.Z0(this.f25586a, DownloadService.getIntent(this.f25586a, this.f25590e, DownloadService.ACTION_RESTART));
                } catch (IllegalStateException unused) {
                    Log.i(DownloadService.TAG, "Failed to restart (foreground launch restriction)");
                }
            } else {
                try {
                    this.f25586a.startService(DownloadService.getIntent(this.f25586a, this.f25590e, DownloadService.ACTION_INIT));
                } catch (IllegalStateException unused2) {
                    Log.i(DownloadService.TAG, "Failed to restart (process is idle)");
                }
            }
        }

        private boolean h(Requirements requirements) {
            return !Util.c(this.f25592g, requirements);
        }

        private boolean i() {
            DownloadService downloadService = this.f25591f;
            return downloadService == null || downloadService.isStopped();
        }

        public void c(DownloadService downloadService) {
            boolean z2;
            if (this.f25591f == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            this.f25591f = downloadService;
            if (this.f25587b.l()) {
                Util.y().postAtFrontOfQueue(new f(this, downloadService));
            }
        }

        public void e(DownloadService downloadService) {
            boolean z2;
            if (this.f25591f == downloadService) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            this.f25591f = null;
        }

        public boolean j() {
            boolean m2 = this.f25587b.m();
            if (this.f25589d == null) {
                return !m2;
            }
            if (!m2) {
                d();
                return true;
            }
            Requirements i2 = this.f25587b.i();
            if (!this.f25589d.b(i2).equals(i2)) {
                d();
                return false;
            } else if (!h(i2)) {
                return true;
            } else {
                if (this.f25589d.a(i2, this.f25586a.getPackageName(), DownloadService.ACTION_RESTART)) {
                    this.f25592g = i2;
                    return true;
                }
                Log.i(DownloadService.TAG, "Failed to schedule restart");
                d();
                return false;
            }
        }

        public void onDownloadChanged(DownloadManager downloadManager, Download download, Exception exc) {
            DownloadService downloadService = this.f25591f;
            if (downloadService != null) {
                downloadService.notifyDownloadChanged(download);
            }
            if (i() && DownloadService.needsStartedService(download.f25520b)) {
                Log.i(DownloadService.TAG, "DownloadService wasn't running. Restarting.");
                g();
            }
        }

        public void onDownloadRemoved(DownloadManager downloadManager, Download download) {
            DownloadService downloadService = this.f25591f;
            if (downloadService != null) {
                downloadService.notifyDownloadRemoved();
            }
        }

        public /* synthetic */ void onDownloadsPausedChanged(DownloadManager downloadManager, boolean z2) {
            e.b(this, downloadManager, z2);
        }

        public final void onIdle(DownloadManager downloadManager) {
            DownloadService downloadService = this.f25591f;
            if (downloadService != null) {
                downloadService.onIdle();
            }
        }

        public void onInitialized(DownloadManager downloadManager) {
            DownloadService downloadService = this.f25591f;
            if (downloadService != null) {
                downloadService.notifyDownloads(downloadManager.e());
            }
        }

        public void onRequirementsStateChanged(DownloadManager downloadManager, Requirements requirements, int i2) {
            j();
        }

        public void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean z2) {
            if (!z2 && !downloadManager.g() && i()) {
                List<Download> e2 = downloadManager.e();
                for (int i2 = 0; i2 < e2.size(); i2++) {
                    if (e2.get(i2).f25520b == 0) {
                        g();
                        return;
                    }
                }
            }
        }

        private DownloadManagerHelper(Context context, DownloadManager downloadManager, boolean z2, Scheduler scheduler, Class<? extends DownloadService> cls) {
            this.f25586a = context;
            this.f25587b = downloadManager;
            this.f25588c = z2;
            this.f25589d = scheduler;
            this.f25590e = cls;
            downloadManager.d(this);
            j();
        }
    }

    private final class ForegroundNotificationUpdater {

        /* renamed from: a  reason: collision with root package name */
        private final int f25593a;

        /* renamed from: b  reason: collision with root package name */
        private final long f25594b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f25595c = new Handler(Looper.getMainLooper());

        /* renamed from: d  reason: collision with root package name */
        private boolean f25596d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f25597e;

        public ForegroundNotificationUpdater(int i2, long j2) {
            this.f25593a = i2;
            this.f25594b = j2;
        }

        /* access modifiers changed from: private */
        public void f() {
            DownloadManager b2 = ((DownloadManagerHelper) Assertions.e(DownloadService.this.downloadManagerHelper)).f25587b;
            Notification foregroundNotification = DownloadService.this.getForegroundNotification(b2.e(), b2.h());
            if (!this.f25597e) {
                DownloadService.this.startForeground(this.f25593a, foregroundNotification);
                this.f25597e = true;
            } else {
                ((NotificationManager) DownloadService.this.getSystemService("notification")).notify(this.f25593a, foregroundNotification);
            }
            if (this.f25596d) {
                this.f25595c.removeCallbacksAndMessages((Object) null);
                this.f25595c.postDelayed(new g(this), this.f25594b);
            }
        }

        public void b() {
            if (this.f25597e) {
                f();
            }
        }

        public void c() {
            if (!this.f25597e) {
                f();
            }
        }

        public void d() {
            this.f25596d = true;
            f();
        }

        public void e() {
            this.f25596d = false;
            this.f25595c.removeCallbacksAndMessages((Object) null);
        }
    }

    protected DownloadService(int i2) {
        this(i2, 1000);
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z2) {
        return buildAddDownloadIntent(context, cls, downloadRequest, 0, z2);
    }

    public static Intent buildPauseDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z2) {
        return getIntent(context, cls, ACTION_PAUSE_DOWNLOADS, z2);
    }

    public static Intent buildRemoveAllDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z2) {
        return getIntent(context, cls, ACTION_REMOVE_ALL_DOWNLOADS, z2);
    }

    public static Intent buildRemoveDownloadIntent(Context context, Class<? extends DownloadService> cls, String str, boolean z2) {
        return getIntent(context, cls, ACTION_REMOVE_DOWNLOAD, z2).putExtra("content_id", str);
    }

    public static Intent buildResumeDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z2) {
        return getIntent(context, cls, ACTION_RESUME_DOWNLOADS, z2);
    }

    public static Intent buildSetRequirementsIntent(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z2) {
        return getIntent(context, cls, ACTION_SET_REQUIREMENTS, z2).putExtra(KEY_REQUIREMENTS, requirements);
    }

    public static Intent buildSetStopReasonIntent(Context context, Class<? extends DownloadService> cls, String str, int i2, boolean z2) {
        return getIntent(context, cls, ACTION_SET_STOP_REASON, z2).putExtra("content_id", str).putExtra(KEY_STOP_REASON, i2);
    }

    public static void clearDownloadManagerHelpers() {
        downloadManagerHelpers.clear();
    }

    private static Intent getIntent(Context context, Class<? extends DownloadService> cls, String str, boolean z2) {
        return getIntent(context, cls, str).putExtra(KEY_FOREGROUND, z2);
    }

    /* access modifiers changed from: private */
    public boolean isStopped() {
        return this.isStopped;
    }

    /* access modifiers changed from: private */
    public static boolean needsStartedService(int i2) {
        return i2 == 2 || i2 == 5 || i2 == 7;
    }

    /* access modifiers changed from: private */
    public void notifyDownloadChanged(Download download) {
        if (this.foregroundNotificationUpdater == null) {
            return;
        }
        if (needsStartedService(download.f25520b)) {
            this.foregroundNotificationUpdater.d();
        } else {
            this.foregroundNotificationUpdater.b();
        }
    }

    /* access modifiers changed from: private */
    public void notifyDownloadRemoved() {
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null) {
            foregroundNotificationUpdater2.b();
        }
    }

    /* access modifiers changed from: private */
    public void notifyDownloads(List<Download> list) {
        if (this.foregroundNotificationUpdater != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (needsStartedService(list.get(i2).f25520b)) {
                    this.foregroundNotificationUpdater.d();
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onIdle() {
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null) {
            foregroundNotificationUpdater2.e();
        }
        if (((DownloadManagerHelper) Assertions.e(this.downloadManagerHelper)).j()) {
            if (Util.f28808a >= 28 || !this.taskRemoved) {
                this.isStopped |= stopSelfResult(this.lastStartId);
                return;
            }
            stopSelf();
            this.isStopped = true;
        }
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z2) {
        startService(context, buildAddDownloadIntent(context, cls, downloadRequest, z2), z2);
    }

    public static void sendPauseDownloads(Context context, Class<? extends DownloadService> cls, boolean z2) {
        startService(context, buildPauseDownloadsIntent(context, cls, z2), z2);
    }

    public static void sendRemoveAllDownloads(Context context, Class<? extends DownloadService> cls, boolean z2) {
        startService(context, buildRemoveAllDownloadsIntent(context, cls, z2), z2);
    }

    public static void sendRemoveDownload(Context context, Class<? extends DownloadService> cls, String str, boolean z2) {
        startService(context, buildRemoveDownloadIntent(context, cls, str, z2), z2);
    }

    public static void sendResumeDownloads(Context context, Class<? extends DownloadService> cls, boolean z2) {
        startService(context, buildResumeDownloadsIntent(context, cls, z2), z2);
    }

    public static void sendSetRequirements(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z2) {
        startService(context, buildSetRequirementsIntent(context, cls, requirements, z2), z2);
    }

    public static void sendSetStopReason(Context context, Class<? extends DownloadService> cls, String str, int i2, boolean z2) {
        startService(context, buildSetStopReasonIntent(context, cls, str, i2, z2), z2);
    }

    public static void start(Context context, Class<? extends DownloadService> cls) {
        context.startService(getIntent(context, cls, ACTION_INIT));
    }

    public static void startForeground(Context context, Class<? extends DownloadService> cls) {
        Util.Z0(context, getIntent(context, cls, ACTION_INIT, true));
    }

    private static void startService(Context context, Intent intent, boolean z2) {
        if (z2) {
            Util.Z0(context, intent);
        } else {
            context.startService(intent);
        }
    }

    /* access modifiers changed from: protected */
    public abstract DownloadManager getDownloadManager();

    /* access modifiers changed from: protected */
    public abstract Notification getForegroundNotification(List<Download> list, int i2);

    /* access modifiers changed from: protected */
    public abstract Scheduler getScheduler();

    /* access modifiers changed from: protected */
    public final void invalidateForegroundNotification() {
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null && !this.isDestroyed) {
            foregroundNotificationUpdater2.b();
        }
    }

    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    public void onCreate() {
        boolean z2;
        Scheduler scheduler;
        String str = this.channelId;
        if (str != null) {
            NotificationUtil.a(this, str, this.channelNameResourceId, this.channelDescriptionResourceId, 2);
        }
        Class<?> cls = getClass();
        HashMap<Class<? extends DownloadService>, DownloadManagerHelper> hashMap = downloadManagerHelpers;
        DownloadManagerHelper downloadManagerHelper2 = hashMap.get(cls);
        if (downloadManagerHelper2 == null) {
            boolean z3 = true;
            if (this.foregroundNotificationUpdater != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (Util.f28808a >= 31) {
                z3 = false;
            }
            if (!z2 || !z3) {
                scheduler = null;
            } else {
                scheduler = getScheduler();
            }
            DownloadManager downloadManager = getDownloadManager();
            downloadManager.w();
            downloadManagerHelper2 = new DownloadManagerHelper(getApplicationContext(), downloadManager, z2, scheduler, cls);
            hashMap.put(cls, downloadManagerHelper2);
        }
        this.downloadManagerHelper = downloadManagerHelper2;
        downloadManagerHelper2.c(this);
    }

    public void onDestroy() {
        this.isDestroyed = true;
        ((DownloadManagerHelper) Assertions.e(this.downloadManagerHelper)).e(this);
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null) {
            foregroundNotificationUpdater2.e();
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        String str;
        String str2;
        ForegroundNotificationUpdater foregroundNotificationUpdater2;
        boolean z2;
        this.lastStartId = i3;
        this.taskRemoved = false;
        if (intent != null) {
            str2 = intent.getAction();
            str = intent.getStringExtra("content_id");
            boolean z3 = this.startedInForeground;
            if (intent.getBooleanExtra(KEY_FOREGROUND, false) || ACTION_RESTART.equals(str2)) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.startedInForeground = z3 | z2;
        } else {
            str2 = null;
            str = null;
        }
        if (str2 == null) {
            str2 = ACTION_INIT;
        }
        DownloadManager b2 = ((DownloadManagerHelper) Assertions.e(this.downloadManagerHelper)).f25587b;
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1931239035:
                if (str2.equals(ACTION_ADD_DOWNLOAD)) {
                    c2 = 0;
                    break;
                }
                break;
            case -932047176:
                if (str2.equals(ACTION_RESUME_DOWNLOADS)) {
                    c2 = 1;
                    break;
                }
                break;
            case -871181424:
                if (str2.equals(ACTION_RESTART)) {
                    c2 = 2;
                    break;
                }
                break;
            case -650547439:
                if (str2.equals(ACTION_REMOVE_ALL_DOWNLOADS)) {
                    c2 = 3;
                    break;
                }
                break;
            case -119057172:
                if (str2.equals(ACTION_SET_REQUIREMENTS)) {
                    c2 = 4;
                    break;
                }
                break;
            case 191112771:
                if (str2.equals(ACTION_PAUSE_DOWNLOADS)) {
                    c2 = 5;
                    break;
                }
                break;
            case 671523141:
                if (str2.equals(ACTION_SET_STOP_REASON)) {
                    c2 = 6;
                    break;
                }
                break;
            case 1015676687:
                if (str2.equals(ACTION_INIT)) {
                    c2 = 7;
                    break;
                }
                break;
            case 1547520644:
                if (str2.equals(ACTION_REMOVE_DOWNLOAD)) {
                    c2 = 8;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                DownloadRequest downloadRequest = (DownloadRequest) ((Intent) Assertions.e(intent)).getParcelableExtra(KEY_DOWNLOAD_REQUEST);
                if (downloadRequest != null) {
                    b2.c(downloadRequest, intent.getIntExtra(KEY_STOP_REASON, 0));
                    break;
                } else {
                    Log.c(TAG, "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                }
            case 1:
                b2.w();
                break;
            case 2:
            case 7:
                break;
            case 3:
                b2.u();
                break;
            case 4:
                Requirements requirements = (Requirements) ((Intent) Assertions.e(intent)).getParcelableExtra(KEY_REQUIREMENTS);
                if (requirements != null) {
                    b2.z(requirements);
                    break;
                } else {
                    Log.c(TAG, "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                }
            case 5:
                b2.t();
                break;
            case 6:
                if (((Intent) Assertions.e(intent)).hasExtra(KEY_STOP_REASON)) {
                    b2.A(str, intent.getIntExtra(KEY_STOP_REASON, 0));
                    break;
                } else {
                    Log.c(TAG, "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                }
            case 8:
                if (str != null) {
                    b2.v(str);
                    break;
                } else {
                    Log.c(TAG, "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                }
            default:
                Log.c(TAG, "Ignored unrecognized action: " + str2);
                break;
        }
        if (Util.f28808a >= 26 && this.startedInForeground && (foregroundNotificationUpdater2 = this.foregroundNotificationUpdater) != null) {
            foregroundNotificationUpdater2.c();
        }
        this.isStopped = false;
        if (b2.k()) {
            onIdle();
        }
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        this.taskRemoved = true;
    }

    protected DownloadService(int i2, long j2) {
        this(i2, j2, (String) null, 0, 0);
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i2, boolean z2) {
        return getIntent(context, cls, ACTION_ADD_DOWNLOAD, z2).putExtra(KEY_DOWNLOAD_REQUEST, downloadRequest).putExtra(KEY_STOP_REASON, i2);
    }

    /* access modifiers changed from: private */
    public static Intent getIntent(Context context, Class<? extends DownloadService> cls, String str) {
        return new Intent(context, cls).setAction(str);
    }

    @Deprecated
    protected DownloadService(int i2, long j2, String str, int i3) {
        this(i2, j2, str, i3, 0);
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i2, boolean z2) {
        startService(context, buildAddDownloadIntent(context, cls, downloadRequest, i2, z2), z2);
    }

    protected DownloadService(int i2, long j2, String str, int i3, int i4) {
        if (i2 == 0) {
            this.foregroundNotificationUpdater = null;
            this.channelId = null;
            this.channelNameResourceId = 0;
            this.channelDescriptionResourceId = 0;
            return;
        }
        this.foregroundNotificationUpdater = new ForegroundNotificationUpdater(i2, j2);
        this.channelId = str;
        this.channelNameResourceId = i3;
        this.channelDescriptionResourceId = i4;
    }
}
