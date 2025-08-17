package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioOffloadSupport;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import com.unity3d.services.core.device.MimeTypes;

public final class DefaultAudioOffloadSupportProvider implements DefaultAudioSink.AudioOffloadSupportProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5722a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f5723b;

    private static final class Api29 {
        private Api29() {
        }

        public static AudioOffloadSupport a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z2) {
            if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
                return AudioOffloadSupport.f5648d;
            }
            return new AudioOffloadSupport.Builder().e(true).g(z2).d();
        }
    }

    private static final class Api31 {
        private Api31() {
        }

        public static AudioOffloadSupport a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z2) {
            boolean z3;
            int a2 = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
            if (a2 == 0) {
                return AudioOffloadSupport.f5648d;
            }
            AudioOffloadSupport.Builder builder = new AudioOffloadSupport.Builder();
            if (Util.f4714a <= 32 || a2 != 2) {
                z3 = false;
            } else {
                z3 = true;
            }
            return builder.e(true).f(z3).g(z2).d();
        }
    }

    public DefaultAudioOffloadSupportProvider() {
        this((Context) null);
    }

    private boolean b(Context context) {
        boolean z2;
        Boolean bool = this.f5723b;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context != null) {
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager != null) {
                String parameters = audioManager.getParameters("offloadVariableRateSupported");
                if (parameters == null || !parameters.equals("offloadVariableRateSupported=1")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.f5723b = Boolean.valueOf(z2);
            } else {
                this.f5723b = Boolean.FALSE;
            }
        } else {
            this.f5723b = Boolean.FALSE;
        }
        return this.f5723b.booleanValue();
    }

    public AudioOffloadSupport a(Format format, androidx.media3.common.AudioAttributes audioAttributes) {
        Assertions.f(format);
        Assertions.f(audioAttributes);
        int i2 = Util.f4714a;
        if (i2 < 29 || format.C == -1) {
            return AudioOffloadSupport.f5648d;
        }
        boolean b2 = b(this.f5722a);
        int f2 = androidx.media3.common.MimeTypes.f((String) Assertions.f(format.f4015n), format.f4011j);
        if (f2 == 0 || i2 < Util.K(f2)) {
            return AudioOffloadSupport.f5648d;
        }
        int M = Util.M(format.B);
        if (M == 0) {
            return AudioOffloadSupport.f5648d;
        }
        try {
            AudioFormat L = Util.L(format.C, M, f2);
            if (i2 >= 31) {
                return Api31.a(L, audioAttributes.a().f3921a, b2);
            }
            return Api29.a(L, audioAttributes.a().f3921a, b2);
        } catch (IllegalArgumentException unused) {
            return AudioOffloadSupport.f5648d;
        }
    }

    public DefaultAudioOffloadSupportProvider(Context context) {
        this.f5722a = context;
    }
}
