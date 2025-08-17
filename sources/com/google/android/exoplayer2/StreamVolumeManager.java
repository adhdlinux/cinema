package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.unity3d.services.core.device.MimeTypes;

final class StreamVolumeManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23467a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Handler f23468b;

    /* renamed from: c  reason: collision with root package name */
    private final Listener f23469c;

    /* renamed from: d  reason: collision with root package name */
    private final AudioManager f23470d;

    /* renamed from: e  reason: collision with root package name */
    private VolumeChangeReceiver f23471e;

    /* renamed from: f  reason: collision with root package name */
    private int f23472f = 3;

    /* renamed from: g  reason: collision with root package name */
    private int f23473g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23474h;

    public interface Listener {
        void p(int i2);

        void v(int i2, boolean z2);
    }

    private final class VolumeChangeReceiver extends BroadcastReceiver {
        private VolumeChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            StreamVolumeManager.this.f23468b.post(new d2(StreamVolumeManager.this));
        }
    }

    public StreamVolumeManager(Context context, Handler handler, Listener listener) {
        Context applicationContext = context.getApplicationContext();
        this.f23467a = applicationContext;
        this.f23468b = handler;
        this.f23469c = listener;
        AudioManager audioManager = (AudioManager) Assertions.i((AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f23470d = audioManager;
        this.f23473g = f(audioManager, 3);
        this.f23474h = e(audioManager, this.f23472f);
        VolumeChangeReceiver volumeChangeReceiver = new VolumeChangeReceiver();
        try {
            applicationContext.registerReceiver(volumeChangeReceiver, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f23471e = volumeChangeReceiver;
        } catch (RuntimeException e2) {
            Log.j("StreamVolumeManager", "Error registering stream volume receiver", e2);
        }
    }

    private static boolean e(AudioManager audioManager, int i2) {
        if (Util.f28808a >= 23) {
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
            Log.j("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i2, e2);
            return audioManager.getStreamMaxVolume(i2);
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        int f2 = f(this.f23470d, this.f23472f);
        boolean e2 = e(this.f23470d, this.f23472f);
        if (this.f23473g != f2 || this.f23474h != e2) {
            this.f23473g = f2;
            this.f23474h = e2;
            this.f23469c.v(f2, e2);
        }
    }

    public int c() {
        return this.f23470d.getStreamMaxVolume(this.f23472f);
    }

    public int d() {
        if (Util.f28808a >= 28) {
            return this.f23470d.getStreamMinVolume(this.f23472f);
        }
        return 0;
    }

    public void g() {
        VolumeChangeReceiver volumeChangeReceiver = this.f23471e;
        if (volumeChangeReceiver != null) {
            try {
                this.f23467a.unregisterReceiver(volumeChangeReceiver);
            } catch (RuntimeException e2) {
                Log.j("StreamVolumeManager", "Error unregistering stream volume receiver", e2);
            }
            this.f23471e = null;
        }
    }

    public void h(int i2) {
        if (this.f23472f != i2) {
            this.f23472f = i2;
            i();
            this.f23469c.p(i2);
        }
    }
}
