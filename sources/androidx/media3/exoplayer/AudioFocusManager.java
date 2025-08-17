package androidx.media3.exoplayer;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.unity3d.services.core.device.MimeTypes;

final class AudioFocusManager {

    /* renamed from: a  reason: collision with root package name */
    private final AudioManager f5122a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioFocusListener f5123b;

    /* renamed from: c  reason: collision with root package name */
    private PlayerControl f5124c;

    /* renamed from: d  reason: collision with root package name */
    private AudioAttributes f5125d;

    /* renamed from: e  reason: collision with root package name */
    private int f5126e;

    /* renamed from: f  reason: collision with root package name */
    private int f5127f;

    /* renamed from: g  reason: collision with root package name */
    private float f5128g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    private AudioFocusRequest f5129h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5130i;

    private class AudioFocusListener implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f5131a;

        public AudioFocusListener(Handler handler) {
            this.f5131a = handler;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2) {
            AudioFocusManager.this.h(i2);
        }

        public void onAudioFocusChange(int i2) {
            this.f5131a.post(new a(this, i2));
        }
    }

    public interface PlayerControl {
        void y(float f2);

        void z(int i2);
    }

    public AudioFocusManager(Context context, Handler handler, PlayerControl playerControl) {
        this.f5122a = (AudioManager) Assertions.f((AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f5124c = playerControl;
        this.f5123b = new AudioFocusListener(handler);
        this.f5126e = 0;
    }

    private void a() {
        this.f5122a.abandonAudioFocus(this.f5123b);
    }

    private void b() {
        int i2 = this.f5126e;
        if (i2 != 1 && i2 != 0) {
            if (Util.f4714a >= 26) {
                c();
            } else {
                a();
            }
        }
    }

    private void c() {
        AudioFocusRequest audioFocusRequest = this.f5129h;
        if (audioFocusRequest != null) {
            int unused = this.f5122a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private static int e(AudioAttributes audioAttributes) {
        if (audioAttributes == null) {
            return 0;
        }
        switch (audioAttributes.f3917c) {
            case 0:
                Log.h("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                break;
            case 11:
                if (audioAttributes.f3915a == 1) {
                    return 2;
                }
                break;
            case 16:
                return 4;
            default:
                Log.h("AudioFocusManager", "Unidentified audio usage: " + audioAttributes.f3917c);
                return 0;
        }
        return 3;
    }

    private void f(int i2) {
        PlayerControl playerControl = this.f5124c;
        if (playerControl != null) {
            playerControl.z(i2);
        }
    }

    /* access modifiers changed from: private */
    public void h(int i2) {
        if (i2 == -3 || i2 == -2) {
            if (i2 == -2 || q()) {
                f(0);
                n(3);
                return;
            }
            n(4);
        } else if (i2 == -1) {
            f(-1);
            b();
            n(1);
        } else if (i2 != 1) {
            Log.h("AudioFocusManager", "Unknown focus change type: " + i2);
        } else {
            n(2);
            f(1);
        }
    }

    private int j() {
        int i2;
        if (this.f5126e == 2) {
            return 1;
        }
        if (Util.f4714a >= 26) {
            i2 = l();
        } else {
            i2 = k();
        }
        if (i2 == 1) {
            n(2);
            return 1;
        }
        n(1);
        return -1;
    }

    private int k() {
        return this.f5122a.requestAudioFocus(this.f5123b, Util.m0(((AudioAttributes) Assertions.f(this.f5125d)).f3917c), this.f5127f);
    }

    private int l() {
        AudioFocusRequest.Builder builder;
        AudioFocusRequest audioFocusRequest = this.f5129h;
        if (audioFocusRequest == null || this.f5130i) {
            if (audioFocusRequest == null) {
                builder = new AudioFocusRequest.Builder(this.f5127f);
            } else {
                builder = new AudioFocusRequest.Builder(this.f5129h);
            }
            this.f5129h = builder.setAudioAttributes(((AudioAttributes) Assertions.f(this.f5125d)).a().f3921a).setWillPauseWhenDucked(q()).setOnAudioFocusChangeListener(this.f5123b).build();
            this.f5130i = false;
        }
        return this.f5122a.requestAudioFocus(this.f5129h);
    }

    private void n(int i2) {
        float f2;
        if (this.f5126e != i2) {
            this.f5126e = i2;
            if (i2 == 4) {
                f2 = 0.2f;
            } else {
                f2 = 1.0f;
            }
            if (this.f5128g != f2) {
                this.f5128g = f2;
                PlayerControl playerControl = this.f5124c;
                if (playerControl != null) {
                    playerControl.y(f2);
                }
            }
        }
    }

    private boolean o(int i2) {
        return i2 != 1 && this.f5127f == 1;
    }

    private boolean q() {
        AudioAttributes audioAttributes = this.f5125d;
        return audioAttributes != null && audioAttributes.f3915a == 1;
    }

    public float g() {
        return this.f5128g;
    }

    public void i() {
        this.f5124c = null;
        b();
        n(0);
    }

    public void m(AudioAttributes audioAttributes) {
        if (!Util.c(this.f5125d, audioAttributes)) {
            this.f5125d = audioAttributes;
            int e2 = e(audioAttributes);
            this.f5127f = e2;
            boolean z2 = true;
            if (!(e2 == 1 || e2 == 0)) {
                z2 = false;
            }
            Assertions.b(z2, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }

    public int p(boolean z2, int i2) {
        if (!o(i2)) {
            b();
            n(0);
            return 1;
        } else if (z2) {
            return j();
        } else {
            int i3 = this.f5126e;
            if (i3 == 1) {
                return -1;
            }
            if (i3 != 3) {
                return 1;
            }
            return 0;
        }
    }
}
