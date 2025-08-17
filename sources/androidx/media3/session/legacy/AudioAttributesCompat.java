package androidx.media3.session.legacy;

import android.media.AudioAttributes;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class AudioAttributesCompat {

    /* renamed from: b  reason: collision with root package name */
    private static final SparseIntArray f9652b;

    /* renamed from: c  reason: collision with root package name */
    static boolean f9653c;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f9654d = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};

    /* renamed from: a  reason: collision with root package name */
    public final AudioAttributesImpl f9655a;

    public interface AudioAttributesImpl {

        public interface Builder {
            Builder a(int i2);

            AudioAttributesImpl build();
        }
    }

    public static class AudioAttributesImplApi26 extends AudioAttributesImplApi21 {

        static class Builder extends AudioAttributesImplApi21.Builder {
            Builder() {
            }

            public AudioAttributesImpl build() {
                return new AudioAttributesImplApi26(this.f9658a.build());
            }
        }

        public AudioAttributesImplApi26() {
        }

        AudioAttributesImplApi26(AudioAttributes audioAttributes) {
            super(audioAttributes, -1);
        }
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        final AudioAttributesImpl.Builder f9667a;

        public Builder() {
            if (AudioAttributesCompat.f9653c) {
                this.f9667a = new AudioAttributesImplBase.Builder();
            } else if (Build.VERSION.SDK_INT >= 26) {
                this.f9667a = new AudioAttributesImplApi26.Builder();
            } else {
                this.f9667a = new AudioAttributesImplApi21.Builder();
            }
        }

        public AudioAttributesCompat a() {
            return new AudioAttributesCompat(this.f9667a.build());
        }

        public Builder b(int i2) {
            this.f9667a.a(i2);
            return this;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9652b = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.f9655a = audioAttributesImpl;
    }

    static int a(boolean z2, int i2, int i3) {
        if ((i2 & 1) == 1) {
            return z2 ? 1 : 7;
        }
        if ((i2 & 4) == 4) {
            return z2 ? 0 : 6;
        }
        switch (i3) {
            case 0:
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z2 ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            default:
                if (!z2) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i3 + " in audio attributes");
        }
    }

    static String b(int i2) {
        switch (i2) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 16:
                return "USAGE_ASSISTANT";
            default:
                return "unknown usage " + i2;
        }
    }

    public static AudioAttributesCompat c(Object obj) {
        if (f9653c) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return new AudioAttributesCompat(new AudioAttributesImplApi26((AudioAttributes) obj));
        }
        return new AudioAttributesCompat(new AudioAttributesImplApi21((AudioAttributes) obj));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f9655a;
        if (audioAttributesImpl != null) {
            return audioAttributesImpl.equals(audioAttributesCompat.f9655a);
        }
        if (audioAttributesCompat.f9655a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f9655a.hashCode();
    }

    public String toString() {
        return this.f9655a.toString();
    }

    public static class AudioAttributesImplApi21 implements AudioAttributesImpl {

        /* renamed from: a  reason: collision with root package name */
        public AudioAttributes f9656a;

        /* renamed from: b  reason: collision with root package name */
        public int f9657b;

        static class Builder implements AudioAttributesImpl.Builder {

            /* renamed from: a  reason: collision with root package name */
            final AudioAttributes.Builder f9658a = new AudioAttributes.Builder();

            Builder() {
            }

            /* renamed from: b */
            public Builder a(int i2) {
                this.f9658a.setLegacyStreamType(i2);
                return this;
            }

            public AudioAttributesImpl build() {
                return new AudioAttributesImplApi21(this.f9658a.build());
            }
        }

        public AudioAttributesImplApi21() {
            this.f9657b = -1;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AudioAttributesImplApi21)) {
                return false;
            }
            return Objects.equals(this.f9656a, ((AudioAttributesImplApi21) obj).f9656a);
        }

        public int hashCode() {
            return ((AudioAttributes) Assertions.f(this.f9656a)).hashCode();
        }

        public String toString() {
            return "AudioAttributesCompat: audioattributes=" + this.f9656a;
        }

        AudioAttributesImplApi21(AudioAttributes audioAttributes) {
            this(audioAttributes, -1);
        }

        AudioAttributesImplApi21(AudioAttributes audioAttributes, int i2) {
            this.f9656a = audioAttributes;
            this.f9657b = i2;
        }
    }

    public static class AudioAttributesImplBase implements AudioAttributesImpl {

        /* renamed from: a  reason: collision with root package name */
        public int f9659a;

        /* renamed from: b  reason: collision with root package name */
        public int f9660b;

        /* renamed from: c  reason: collision with root package name */
        public int f9661c;

        /* renamed from: d  reason: collision with root package name */
        public int f9662d;

        static class Builder implements AudioAttributesImpl.Builder {

            /* renamed from: a  reason: collision with root package name */
            private int f9663a = 0;

            /* renamed from: b  reason: collision with root package name */
            private int f9664b = 0;

            /* renamed from: c  reason: collision with root package name */
            private int f9665c = 0;

            /* renamed from: d  reason: collision with root package name */
            private int f9666d = -1;

            Builder() {
            }

            private Builder b(int i2) {
                switch (i2) {
                    case 0:
                        this.f9664b = 1;
                        break;
                    case 1:
                        break;
                    case 2:
                        this.f9664b = 4;
                        break;
                    case 3:
                        this.f9664b = 2;
                        break;
                    case 4:
                        this.f9664b = 4;
                        break;
                    case 5:
                        this.f9664b = 4;
                        break;
                    case 6:
                        this.f9664b = 1;
                        this.f9665c |= 4;
                        break;
                    case 7:
                        this.f9665c = 1 | this.f9665c;
                        break;
                    case 8:
                        this.f9664b = 4;
                        break;
                    case 9:
                        this.f9664b = 4;
                        break;
                    case 10:
                        this.f9664b = 1;
                        break;
                    default:
                        Log.c("AudioAttributesCompat", "Invalid stream type " + i2 + " for AudioAttributesCompat");
                        break;
                }
                this.f9664b = 4;
                this.f9663a = AudioAttributesImplBase.e(i2);
                return this;
            }

            public AudioAttributesImpl build() {
                return new AudioAttributesImplBase(this.f9664b, this.f9665c, this.f9663a, this.f9666d);
            }

            /* renamed from: c */
            public Builder a(int i2) {
                if (i2 != 10) {
                    this.f9666d = i2;
                    return b(i2);
                }
                throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            }
        }

        public AudioAttributesImplBase() {
            this.f9659a = 0;
            this.f9660b = 0;
            this.f9661c = 0;
            this.f9662d = -1;
        }

        static int e(int i2) {
            switch (i2) {
                case 0:
                    return 2;
                case 1:
                case 7:
                    return 13;
                case 2:
                    return 6;
                case 3:
                    return 1;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 2;
                case 8:
                    return 3;
                case 10:
                    return 11;
                default:
                    return 0;
            }
        }

        public int a() {
            return this.f9660b;
        }

        public int b() {
            int i2 = this.f9661c;
            int c2 = c();
            if (c2 == 6) {
                i2 |= 4;
            } else if (c2 == 7) {
                i2 |= 1;
            }
            return i2 & 273;
        }

        public int c() {
            int i2 = this.f9662d;
            if (i2 != -1) {
                return i2;
            }
            return AudioAttributesCompat.a(false, this.f9661c, this.f9659a);
        }

        public int d() {
            return this.f9659a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AudioAttributesImplBase)) {
                return false;
            }
            AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
            if (this.f9660b == audioAttributesImplBase.a() && this.f9661c == audioAttributesImplBase.b() && this.f9659a == audioAttributesImplBase.d() && this.f9662d == audioAttributesImplBase.f9662d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9660b), Integer.valueOf(this.f9661c), Integer.valueOf(this.f9659a), Integer.valueOf(this.f9662d)});
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
            if (this.f9662d != -1) {
                sb.append(" stream=");
                sb.append(this.f9662d);
                sb.append(" derived");
            }
            sb.append(" usage=");
            sb.append(AudioAttributesCompat.b(this.f9659a));
            sb.append(" content=");
            sb.append(this.f9660b);
            sb.append(" flags=0x");
            sb.append(Integer.toHexString(this.f9661c).toUpperCase(Locale.ROOT));
            return sb.toString();
        }

        AudioAttributesImplBase(int i2, int i3, int i4, int i5) {
            this.f9660b = i2;
            this.f9661c = i3;
            this.f9659a = i4;
            this.f9662d = i5;
        }
    }
}
