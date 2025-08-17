package androidx.media3.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.unity3d.services.core.device.MimeTypes;

public final class AudioCapabilitiesReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f5632a;

    /* renamed from: b  reason: collision with root package name */
    private final Listener f5633b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f5634c;

    /* renamed from: d  reason: collision with root package name */
    private final AudioDeviceCallbackV23 f5635d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f5636e;

    /* renamed from: f  reason: collision with root package name */
    private final ExternalSurroundSoundSettingObserver f5637f;

    /* renamed from: g  reason: collision with root package name */
    private AudioCapabilities f5638g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public AudioDeviceInfoApi23 f5639h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public AudioAttributes f5640i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5641j;

    private static final class Api23 {
        private Api23() {
        }

        public static void a(Context context, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            ((AudioManager) Assertions.f((AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO))).registerAudioDeviceCallback(audioDeviceCallback, handler);
        }

        public static void b(Context context, AudioDeviceCallback audioDeviceCallback) {
            ((AudioManager) Assertions.f((AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO))).unregisterAudioDeviceCallback(audioDeviceCallback);
        }
    }

    private final class AudioDeviceCallbackV23 extends AudioDeviceCallback {
        private AudioDeviceCallbackV23() {
        }

        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.f(AudioCapabilities.g(audioCapabilitiesReceiver.f5632a, AudioCapabilitiesReceiver.this.f5640i, AudioCapabilitiesReceiver.this.f5639h));
        }

        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (Util.s(audioDeviceInfoArr, AudioCapabilitiesReceiver.this.f5639h)) {
                AudioDeviceInfoApi23 unused = AudioCapabilitiesReceiver.this.f5639h = null;
            }
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.f(AudioCapabilities.g(audioCapabilitiesReceiver.f5632a, AudioCapabilitiesReceiver.this.f5640i, AudioCapabilitiesReceiver.this.f5639h));
        }
    }

    private final class ExternalSurroundSoundSettingObserver extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f5643a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f5644b;

        public ExternalSurroundSoundSettingObserver(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.f5643a = contentResolver;
            this.f5644b = uri;
        }

        public void a() {
            this.f5643a.registerContentObserver(this.f5644b, false, this);
        }

        public void b() {
            this.f5643a.unregisterContentObserver(this);
        }

        public void onChange(boolean z2) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.f(AudioCapabilities.g(audioCapabilitiesReceiver.f5632a, AudioCapabilitiesReceiver.this.f5640i, AudioCapabilitiesReceiver.this.f5639h));
        }
    }

    private final class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        private HdmiAudioPlugBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
                audioCapabilitiesReceiver.f(AudioCapabilities.f(context, intent, audioCapabilitiesReceiver.f5640i, AudioCapabilitiesReceiver.this.f5639h));
            }
        }
    }

    public interface Listener {
        void a(AudioCapabilities audioCapabilities);
    }

    AudioCapabilitiesReceiver(Context context, Listener listener, AudioAttributes audioAttributes, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        AudioDeviceCallbackV23 audioDeviceCallbackV23;
        HdmiAudioPlugBroadcastReceiver hdmiAudioPlugBroadcastReceiver;
        Context applicationContext = context.getApplicationContext();
        this.f5632a = applicationContext;
        this.f5633b = (Listener) Assertions.f(listener);
        this.f5640i = audioAttributes;
        this.f5639h = audioDeviceInfoApi23;
        Handler C = Util.C();
        this.f5634c = C;
        int i2 = Util.f4714a;
        ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = null;
        if (i2 >= 23) {
            audioDeviceCallbackV23 = new AudioDeviceCallbackV23();
        } else {
            audioDeviceCallbackV23 = null;
        }
        this.f5635d = audioDeviceCallbackV23;
        if (i2 >= 21) {
            hdmiAudioPlugBroadcastReceiver = new HdmiAudioPlugBroadcastReceiver();
        } else {
            hdmiAudioPlugBroadcastReceiver = null;
        }
        this.f5636e = hdmiAudioPlugBroadcastReceiver;
        Uri j2 = AudioCapabilities.j();
        this.f5637f = j2 != null ? new ExternalSurroundSoundSettingObserver(C, applicationContext.getContentResolver(), j2) : externalSurroundSoundSettingObserver;
    }

    /* access modifiers changed from: private */
    public void f(AudioCapabilities audioCapabilities) {
        if (this.f5641j && !audioCapabilities.equals(this.f5638g)) {
            this.f5638g = audioCapabilities;
            this.f5633b.a(audioCapabilities);
        }
    }

    public AudioCapabilities g() {
        AudioDeviceCallbackV23 audioDeviceCallbackV23;
        if (this.f5641j) {
            return (AudioCapabilities) Assertions.f(this.f5638g);
        }
        this.f5641j = true;
        ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = this.f5637f;
        if (externalSurroundSoundSettingObserver != null) {
            externalSurroundSoundSettingObserver.a();
        }
        if (Util.f4714a >= 23 && (audioDeviceCallbackV23 = this.f5635d) != null) {
            Api23.a(this.f5632a, audioDeviceCallbackV23, this.f5634c);
        }
        Intent intent = null;
        if (this.f5636e != null) {
            intent = this.f5632a.registerReceiver(this.f5636e, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), (String) null, this.f5634c);
        }
        AudioCapabilities f2 = AudioCapabilities.f(this.f5632a, intent, this.f5640i, this.f5639h);
        this.f5638g = f2;
        return f2;
    }

    public void h(AudioAttributes audioAttributes) {
        this.f5640i = audioAttributes;
        f(AudioCapabilities.g(this.f5632a, audioAttributes, this.f5639h));
    }

    public void i(AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfo audioDeviceInfo2;
        AudioDeviceInfoApi23 audioDeviceInfoApi23 = this.f5639h;
        AudioDeviceInfoApi23 audioDeviceInfoApi232 = null;
        if (audioDeviceInfoApi23 == null) {
            audioDeviceInfo2 = null;
        } else {
            audioDeviceInfo2 = audioDeviceInfoApi23.f5647a;
        }
        if (!Util.c(audioDeviceInfo, audioDeviceInfo2)) {
            if (audioDeviceInfo != null) {
                audioDeviceInfoApi232 = new AudioDeviceInfoApi23(audioDeviceInfo);
            }
            this.f5639h = audioDeviceInfoApi232;
            f(AudioCapabilities.g(this.f5632a, this.f5640i, audioDeviceInfoApi232));
        }
    }

    public void j() {
        AudioDeviceCallbackV23 audioDeviceCallbackV23;
        if (this.f5641j) {
            this.f5638g = null;
            if (Util.f4714a >= 23 && (audioDeviceCallbackV23 = this.f5635d) != null) {
                Api23.b(this.f5632a, audioDeviceCallbackV23);
            }
            BroadcastReceiver broadcastReceiver = this.f5636e;
            if (broadcastReceiver != null) {
                this.f5632a.unregisterReceiver(broadcastReceiver);
            }
            ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = this.f5637f;
            if (externalSurroundSoundSettingObserver != null) {
                externalSurroundSoundSettingObserver.b();
            }
            this.f5641j = false;
        }
    }
}
