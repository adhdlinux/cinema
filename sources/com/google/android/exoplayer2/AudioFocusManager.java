package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.unity3d.services.core.device.MimeTypes;

final class AudioFocusManager {

    /* renamed from: a  reason: collision with root package name */
    private final AudioManager f22789a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioFocusListener f22790b;

    /* renamed from: c  reason: collision with root package name */
    private PlayerControl f22791c;

    /* renamed from: d  reason: collision with root package name */
    private AudioAttributes f22792d;

    /* renamed from: e  reason: collision with root package name */
    private int f22793e;

    /* renamed from: f  reason: collision with root package name */
    private int f22794f;

    /* renamed from: g  reason: collision with root package name */
    private float f22795g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    private AudioFocusRequest f22796h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f22797i;

    private class AudioFocusListener implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f22798a;

        public AudioFocusListener(Handler handler) {
            this.f22798a = handler;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2) {
            AudioFocusManager.this.h(i2);
        }

        public void onAudioFocusChange(int i2) {
            this.f22798a.post(new a(this, i2));
        }
    }

    public interface PlayerControl {
        void y(float f2);

        void z(int i2);
    }

    public AudioFocusManager(Context context, Handler handler, PlayerControl playerControl) {
        this.f22789a = (AudioManager) Assertions.e((AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f22791c = playerControl;
        this.f22790b = new AudioFocusListener(handler);
        this.f22793e = 0;
    }

    private void a() {
        this.f22789a.abandonAudioFocus(this.f22790b);
    }

    private void b() {
        if (this.f22793e != 0) {
            if (Util.f28808a >= 26) {
                c();
            } else {
                a();
            }
            n(0);
        }
    }

    private void c() {
        AudioFocusRequest audioFocusRequest = this.f22796h;
        if (audioFocusRequest != null) {
            int unused = this.f22789a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private static int e(AudioAttributes audioAttributes) {
        if (audioAttributes == null) {
            return 0;
        }
        switch (audioAttributes.f23664d) {
            case 0:
                Log.i("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
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
                if (audioAttributes.f23662b == 1) {
                    return 2;
                }
                break;
            case 16:
                if (Util.f28808a >= 19) {
                    return 4;
                }
                return 2;
            default:
                Log.i("AudioFocusManager", "Unidentified audio usage: " + audioAttributes.f23664d);
                return 0;
        }
        return 3;
    }

    private void f(int i2) {
        PlayerControl playerControl = this.f22791c;
        if (playerControl != null) {
            playerControl.z(i2);
        }
    }

    /* access modifiers changed from: private */
    public void h(int i2) {
        if (i2 == -3 || i2 == -2) {
            if (i2 == -2 || q()) {
                f(0);
                n(2);
                return;
            }
            n(3);
        } else if (i2 == -1) {
            f(-1);
            b();
        } else if (i2 != 1) {
            Log.i("AudioFocusManager", "Unknown focus change type: " + i2);
        } else {
            n(1);
            f(1);
        }
    }

    private int j() {
        int i2;
        if (this.f22793e == 1) {
            return 1;
        }
        if (Util.f28808a >= 26) {
            i2 = l();
        } else {
            i2 = k();
        }
        if (i2 == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    private int k() {
        return this.f22789a.requestAudioFocus(this.f22790b, Util.h0(((AudioAttributes) Assertions.e(this.f22792d)).f23664d), this.f22794f);
    }

    private int l() {
        AudioFocusRequest.Builder builder;
        AudioFocusRequest audioFocusRequest = this.f22796h;
        if (audioFocusRequest == null || this.f22797i) {
            if (audioFocusRequest == null) {
                builder = new AudioFocusRequest.Builder(this.f22794f);
            } else {
                builder = new AudioFocusRequest.Builder(this.f22796h);
            }
            this.f22796h = builder.setAudioAttributes(((AudioAttributes) Assertions.e(this.f22792d)).b().f23668a).setWillPauseWhenDucked(q()).setOnAudioFocusChangeListener(this.f22790b).build();
            this.f22797i = false;
        }
        return this.f22789a.requestAudioFocus(this.f22796h);
    }

    private void n(int i2) {
        float f2;
        if (this.f22793e != i2) {
            this.f22793e = i2;
            if (i2 == 3) {
                f2 = 0.2f;
            } else {
                f2 = 1.0f;
            }
            if (this.f22795g != f2) {
                this.f22795g = f2;
                PlayerControl playerControl = this.f22791c;
                if (playerControl != null) {
                    playerControl.y(f2);
                }
            }
        }
    }

    private boolean o(int i2) {
        return i2 == 1 || this.f22794f != 1;
    }

    private boolean q() {
        AudioAttributes audioAttributes = this.f22792d;
        return audioAttributes != null && audioAttributes.f23662b == 1;
    }

    public float g() {
        return this.f22795g;
    }

    public void i() {
        this.f22791c = null;
        b();
    }

    public void m(AudioAttributes audioAttributes) {
        if (!Util.c(this.f22792d, audioAttributes)) {
            this.f22792d = audioAttributes;
            int e2 = e(audioAttributes);
            this.f22794f = e2;
            boolean z2 = true;
            if (!(e2 == 1 || e2 == 0)) {
                z2 = false;
            }
            Assertions.b(z2, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }

    public int p(boolean z2, int i2) {
        if (o(i2)) {
            b();
            if (z2) {
                return 1;
            }
            return -1;
        } else if (z2) {
            return j();
        } else {
            return -1;
        }
    }
}
