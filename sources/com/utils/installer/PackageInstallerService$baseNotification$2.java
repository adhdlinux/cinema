package com.utils.installer;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.movie.ui.activity.MainActivity;
import com.yoku.marumovie.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class PackageInstallerService$baseNotification$2 extends Lambda implements Function0<NotificationCompat.Builder> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PackageInstallerService f37675f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PackageInstallerService$baseNotification$2(PackageInstallerService packageInstallerService) {
        super(0);
        this.f37675f = packageInstallerService;
    }

    /* renamed from: b */
    public final NotificationCompat.Builder invoke() {
        int i2;
        if (Build.VERSION.SDK_INT >= 31) {
            i2 = 33554432;
        } else {
            i2 = 0;
        }
        return new NotificationCompat.Builder(this.f37675f, "cinema.updates").g(false).j(true).t(true).x(true).u(0).m(this.f37675f.getString(R.string.update_notification_downloading)).k(PendingIntent.getActivity(this.f37675f, 0, new Intent(this.f37675f, MainActivity.class), i2)).y(R.drawable.ic_tv);
    }
}
