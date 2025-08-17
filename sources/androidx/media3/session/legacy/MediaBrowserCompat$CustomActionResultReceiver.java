package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

@SuppressLint({"RestrictedApi"})
class MediaBrowserCompat$CustomActionResultReceiver extends ResultReceiver {

    /* renamed from: b  reason: collision with root package name */
    private final String f9671b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f9672c;

    /* renamed from: d  reason: collision with root package name */
    private final MediaBrowserCompat$CustomActionCallback f9673d;

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        if (this.f9673d != null) {
            MediaSessionCompat.a(bundle);
            if (i2 == -1) {
                this.f9673d.a(this.f9671b, this.f9672c, bundle);
            } else if (i2 == 0) {
                this.f9673d.c(this.f9671b, this.f9672c, bundle);
            } else if (i2 != 1) {
                Log.w("MediaBrowserCompat", "Unknown result code: " + i2 + " (extras=" + this.f9672c + ", resultData=" + bundle + ")");
            } else {
                this.f9673d.b(this.f9671b, this.f9672c, bundle);
            }
        }
    }
}
