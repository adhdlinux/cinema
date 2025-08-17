package androidx.media.session;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.content.ContextCompat;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {

    private static final class Api31 {
        private Api31() {
        }

        public static ForegroundServiceStartNotAllowedException a(IllegalStateException illegalStateException) {
            return (ForegroundServiceStartNotAllowedException) illegalStateException;
        }

        public static boolean b(IllegalStateException illegalStateException) {
            return illegalStateException instanceof ForegroundServiceStartNotAllowedException;
        }
    }

    private static class MediaButtonConnectionCallback extends MediaBrowserCompat.ConnectionCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Context f3869a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f3870b;

        /* renamed from: c  reason: collision with root package name */
        private final BroadcastReceiver.PendingResult f3871c;

        /* renamed from: d  reason: collision with root package name */
        private MediaBrowserCompat f3872d;

        MediaButtonConnectionCallback(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f3869a = context;
            this.f3870b = intent;
            this.f3871c = pendingResult;
        }

        private void a() {
            this.f3872d.disconnect();
            this.f3871c.finish();
        }

        /* access modifiers changed from: package-private */
        public void b(MediaBrowserCompat mediaBrowserCompat) {
            this.f3872d = mediaBrowserCompat;
        }

        public void onConnected() {
            new MediaControllerCompat(this.f3869a, this.f3872d.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.f3870b.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            a();
        }

        public void onConnectionFailed() {
            a();
        }

        public void onConnectionSuspended() {
            a();
        }
    }

    public static ComponentName a(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        } else if (queryBroadcastReceivers.size() <= 1) {
            return null;
        } else {
            Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
            return null;
        }
    }

    private static ComponentName b(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }

    /* access modifiers changed from: protected */
    public void c(Intent intent, ForegroundServiceStartNotAllowedException foregroundServiceStartNotAllowedException) {
        Log.e("MediaButtonReceiver", "caught exception when trying to start a foreground service from the background: " + foregroundServiceStartNotAllowedException.getMessage());
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName b2 = b(context, "android.intent.action.MEDIA_BUTTON");
        if (b2 != null) {
            intent.setComponent(b2);
            try {
                ContextCompat.startForegroundService(context, intent);
            } catch (IllegalStateException e2) {
                if (Build.VERSION.SDK_INT < 31 || !Api31.b(e2)) {
                    throw e2;
                }
                c(intent, Api31.a(e2));
            }
        } else {
            ComponentName b3 = b(context, "android.media.browse.MediaBrowserService");
            if (b3 != null) {
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Context applicationContext = context.getApplicationContext();
                MediaButtonConnectionCallback mediaButtonConnectionCallback = new MediaButtonConnectionCallback(applicationContext, intent, goAsync);
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, b3, mediaButtonConnectionCallback, (Bundle) null);
                mediaButtonConnectionCallback.b(mediaBrowserCompat);
                mediaBrowserCompat.connect();
                return;
            }
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
    }
}
