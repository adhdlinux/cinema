package us.shandian.giga.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.Setting;
import com.utils.download.DownloadActivity;
import com.vungle.ads.internal.model.AdPayload;
import com.yoku.marumovie.R;
import java.util.ArrayList;
import java.util.HashMap;
import us.shandian.giga.get.DownloadDataSource;
import us.shandian.giga.get.DownloadManager;
import us.shandian.giga.get.DownloadManagerImpl;
import us.shandian.giga.get.DownloadMission;
import us.shandian.giga.get.sqlite.SQLiteDownloadDataSource;

public class DownloadManagerService extends Service {

    /* renamed from: i  reason: collision with root package name */
    private static final String f42223i = "DownloadManagerService";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public DMBinder f42224b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f42225c;

    /* renamed from: d  reason: collision with root package name */
    private Notification f42226d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f42227e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f42228f = System.currentTimeMillis();

    /* renamed from: g  reason: collision with root package name */
    private DownloadDataSource f42229g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public MissionListener f42230h = new MissionListener();

    public class DMBinder extends Binder {
        public DMBinder() {
        }

        public DownloadManager a() {
            return DownloadManagerService.this.f42225c;
        }

        public void b(DownloadMission downloadMission) {
            downloadMission.c(DownloadManagerService.this.f42230h);
            DownloadManagerService.this.j();
        }

        public void c(DownloadMission downloadMission) {
            downloadMission.r(DownloadManagerService.this.f42230h);
            DownloadManagerService.this.j();
        }
    }

    private class MissionListener implements DownloadMission.MissionListener {
        private MissionListener() {
        }

        public void a(DownloadMission downloadMission) {
            DownloadManagerService.this.j();
            DownloadManagerService.this.i(downloadMission);
        }

        public void b(DownloadMission downloadMission, int i2) {
            DownloadManagerService.this.j();
        }

        public void c(DownloadMission downloadMission, long j2, long j3) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - DownloadManagerService.this.f42228f > 2000) {
                DownloadManagerService.this.j();
                long unused = DownloadManagerService.this.f42228f = currentTimeMillis;
            }
        }
    }

    /* access modifiers changed from: private */
    public void i(DownloadMission downloadMission) {
        sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(AdPayload.FILE_SCHEME + downloadMission.f42192d + "/" + downloadMission.f42190b)));
    }

    /* access modifiers changed from: private */
    public void j() {
        this.f42227e.sendEmptyMessage(0);
    }

    public static void k(Context context, String str, String str2, String str3, boolean z2, int i2, HashMap<String, String> hashMap, String str4) {
        Intent intent = new Intent(context, DownloadManagerService.class);
        intent.setAction("android.intent.action.RUN");
        intent.setData(Uri.parse(str));
        intent.putExtra("DownloadManagerService.extra.name", str3);
        intent.putExtra("DownloadManagerService.extra.location", str2);
        intent.putExtra("DownloadManagerService.extra.is_audio", z2);
        intent.putExtra("DownloadManagerService.extra.threads", i2);
        intent.putExtra("DownloadManagerService.extra.headers", hashMap);
        intent.putExtra("DownloadManagerService.extra.mvinfo", str4);
        context.startService(intent);
    }

    private void l(String str, String str2, String str3, boolean z2, int i2, HashMap<String, String> hashMap, String str4) {
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final boolean z3 = z2;
        final int i3 = i2;
        final HashMap<String, String> hashMap2 = hashMap;
        final String str8 = str4;
        this.f42227e.post(new Runnable() {
            public void run() {
                DownloadManagerService.this.f42224b.b(DownloadManagerService.this.f42225c.e(DownloadManagerService.this.f42225c.d(str5, str6, str7, z3, i3, hashMap2, str8)));
            }
        });
    }

    /* access modifiers changed from: private */
    public void m(int i2) {
        if (i2 == 0) {
            stopForeground(true);
        } else {
            startForeground(969696, this.f42226d);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f42224b;
    }

    public void onCreate() {
        super.onCreate();
        this.f42224b = new DMBinder();
        if (this.f42229g == null) {
            this.f42229g = new SQLiteDownloadDataSource(this);
        }
        if (this.f42225c == null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(Setting.a(this).getAbsolutePath());
            this.f42225c = new DownloadManagerImpl(arrayList, this.f42229g);
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, DownloadActivity.class).setAction("android.intent.action.MAIN"), 67108864);
        this.f42226d = new NotificationCompat.Builder(this, getString(R.string.notification_channel_id)).k(activity).y(17301633).q(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).m(getString(R.string.msg_running)).l(getString(R.string.msg_running_detail)).c();
        HandlerThread handlerThread = new HandlerThread("ServiceMessenger");
        handlerThread.start();
        this.f42227e = new Handler(handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < DownloadManagerService.this.f42225c.getCount(); i3++) {
                        if (DownloadManagerService.this.f42225c.e(i3).f42202n) {
                            i2++;
                        }
                    }
                    DownloadManagerService.this.m(i2);
                }
            }
        };
    }

    public void onDestroy() {
        super.onDestroy();
        for (int i2 = 0; i2 < this.f42225c.getCount(); i2++) {
            this.f42225c.a(i2);
        }
        stopForeground(true);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        String str = f42223i;
        Log.i(str, "Got intent: " + intent);
        String action = intent.getAction();
        if (action == null || !action.equals("android.intent.action.RUN")) {
            return 2;
        }
        String stringExtra = intent.getStringExtra("DownloadManagerService.extra.name");
        String stringExtra2 = intent.getStringExtra("DownloadManagerService.extra.location");
        int intExtra = intent.getIntExtra("DownloadManagerService.extra.threads", 1);
        l(intent.getDataString(), stringExtra2, stringExtra, intent.getBooleanExtra("DownloadManagerService.extra.is_audio", false), intExtra, (HashMap) intent.getSerializableExtra("DownloadManagerService.extra.headers"), intent.getStringExtra("DownloadManagerService.extra.mvinfo"));
        return 2;
    }
}
