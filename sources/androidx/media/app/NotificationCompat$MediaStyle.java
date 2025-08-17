package androidx.media.app;

import android.app.PendingIntent;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;

public class NotificationCompat$MediaStyle extends NotificationCompat.Style {

    /* renamed from: e  reason: collision with root package name */
    int[] f3863e = null;

    /* renamed from: f  reason: collision with root package name */
    MediaSessionCompat.Token f3864f;

    /* renamed from: g  reason: collision with root package name */
    CharSequence f3865g;

    /* renamed from: h  reason: collision with root package name */
    int f3866h;

    /* renamed from: i  reason: collision with root package name */
    PendingIntent f3867i;

    /* renamed from: j  reason: collision with root package name */
    boolean f3868j = false;

    public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 34) {
            NotificationCompat$Api21Impl.d(notificationBuilderWithBuilderAccessor.a(), NotificationCompat$Api21Impl.b(NotificationCompat$Api34Impl.a(NotificationCompat$Api21Impl.a(), this.f3865g, this.f3866h, this.f3867i, Boolean.valueOf(this.f3868j)), this.f3863e, this.f3864f));
        } else {
            NotificationCompat$Api21Impl.d(notificationBuilderWithBuilderAccessor.a(), NotificationCompat$Api21Impl.b(NotificationCompat$Api21Impl.a(), this.f3863e, this.f3864f));
        }
    }

    public RemoteViews d(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    public RemoteViews e(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    public NotificationCompat$MediaStyle h(MediaSessionCompat.Token token) {
        this.f3864f = token;
        return this;
    }

    public NotificationCompat$MediaStyle i(int... iArr) {
        this.f3863e = iArr;
        return this;
    }
}
