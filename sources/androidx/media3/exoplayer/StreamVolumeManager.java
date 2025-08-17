package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.unity3d.services.core.device.MimeTypes;

final class StreamVolumeManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5522a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Handler f5523b;

    /* renamed from: c  reason: collision with root package name */
    private final Listener f5524c;

    /* renamed from: d  reason: collision with root package name */
    private final AudioManager f5525d;

    /* renamed from: e  reason: collision with root package name */
    private VolumeChangeReceiver f5526e;

    /* renamed from: f  reason: collision with root package name */
    private int f5527f = 3;

    /* renamed from: g  reason: collision with root package name */
    private int f5528g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5529h;

    public interface Listener {
        void p(int i2);

        void v(int i2, boolean z2);
    }

    private final class VolumeChangeReceiver extends BroadcastReceiver {
        private VolumeChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            StreamVolumeManager.this.f5523b.post(new x0(StreamVolumeManager.this));
        }
    }

    public StreamVolumeManager(Context context, Handler handler, Listener listener) {
        Context applicationContext = context.getApplicationContext();
        this.f5522a = applicationContext;
        this.f5523b = handler;
        this.f5524c = listener;
        AudioManager audioManager = (AudioManager) Assertions.j((AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f5525d = audioManager;
        this.f5528g = f(audioManager, 3);
        this.f5529h = e(audioManager, this.f5527f);
        VolumeChangeReceiver volumeChangeReceiver = new VolumeChangeReceiver();
        try {
            applicationContext.registerReceiver(volumeChangeReceiver, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f5526e = volumeChangeReceiver;
        } catch (RuntimeException e2) {
            Log.i("StreamVolumeManager", "Error registering stream volume receiver", e2);
        }
    }

    private static boolean e(AudioManager audioManager, int i2) {
        if (Util.f4714a >= 23) {
            return audioManager.isStreamMute(i2);
        }
        if (f(audioManager, i2) == 0) {
            return true;
        }
        return false;
    }

    private static int f(AudioManager audioManager, int i2) {
        try {
            return audioManager.getStreamVolume(i2);
        } catch (RuntimeException e2) {
            Log.i("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i2, e2);
            return audioManager.getStreamMaxVolume(i2);
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        int f2 = f(this.f5525d, this.f5527f);
        boolean e2 = e(this.f5525d, this.f5527f);
        if (this.f5528g != f2 || this.f5529h != e2) {
            this.f5528g = f2;
            this.f5529h = e2;
            this.f5524c.v(f2, e2);
        }
    }

    public int c() {
        return this.f5525d.getStreamMaxVolume(this.f5527f);
    }

    public int d() {
        if (Util.f4714a >= 28) {
            return this.f5525d.getStreamMinVolume(this.f5527f);
        }
        return 0;
    }

    public void g() {
        VolumeChangeReceiver volumeChangeReceiver = this.f5526e;
        if (volumeChangeReceiver != null) {
            try {
                this.f5522a.unregisterReceiver(volumeChangeReceiver);
            } catch (RuntimeException e2) {
                Log.i("StreamVolumeManager", "Error unregistering stream volume receiver", e2);
            }
            this.f5526e = null;
        }
    }

    public void h(int i2) {
        if (this.f5527f != i2) {
            this.f5527f = i2;
            i();
            this.f5524c.p(i2);
        }
    }
}
