package androidx.media.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;

class NotificationCompat$Api34Impl {
    private NotificationCompat$Api34Impl() {
    }

    @SuppressLint({"MissingPermission"})
    static Notification.MediaStyle a(Notification.MediaStyle mediaStyle, CharSequence charSequence, int i2, PendingIntent pendingIntent, Boolean bool) {
        if (bool.booleanValue()) {
            mediaStyle.setRemotePlaybackInfo(charSequence, i2, pendingIntent);
        }
        return mediaStyle;
    }
}
