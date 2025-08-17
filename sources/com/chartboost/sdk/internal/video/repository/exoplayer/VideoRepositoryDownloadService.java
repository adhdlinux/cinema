package com.chartboost.sdk.internal.video.repository.exoplayer;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import com.chartboost.sdk.impl.h4;
import com.chartboost.sdk.impl.h5;
import com.chartboost.sdk.impl.i3;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.ui.DownloadNotificationHelper;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class VideoRepositoryDownloadService extends DownloadService {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f19183a = LazyKt__LazyJVMKt.b(a.f19185b);

    /* renamed from: b  reason: collision with root package name */
    public DownloadNotificationHelper f19184b;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f19185b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final h5 invoke() {
            return i3.f17882b.d().d();
        }
    }

    public VideoRepositoryDownloadService() {
        super(0);
    }

    public final h5 a() {
        return (h5) this.f19183a.getValue();
    }

    public DownloadManager getDownloadManager() {
        h5 a2 = a();
        a2.a();
        return a2.d();
    }

    public Notification getForegroundNotification(List list, int i2) {
        Intrinsics.f(list, "downloads");
        DownloadNotificationHelper downloadNotificationHelper = this.f19184b;
        if (downloadNotificationHelper == null) {
            Intrinsics.x("downloadNotificationHelper");
            downloadNotificationHelper = null;
        }
        Notification b2 = downloadNotificationHelper.b(this, 0, (PendingIntent) null, (String) null, CollectionsKt__CollectionsKt.f(), 0);
        Intrinsics.e(b2, "downloadNotificationHelp…         0,\n            )");
        return b2;
    }

    public Scheduler getScheduler() {
        return h4.a((Context) this, 0, 2, (Object) null);
    }

    public void onCreate() {
        i3.f17882b.a(this);
        super.onCreate();
        this.f19184b = new DownloadNotificationHelper(this, "chartboost");
    }
}
