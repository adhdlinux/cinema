package androidx.media;

import android.util.Log;
import androidx.media.AudioAttributesImpl;
import java.util.Arrays;

public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public int f3841a;

    /* renamed from: b  reason: collision with root package name */
    public int f3842b;

    /* renamed from: c  reason: collision with root package name */
    public int f3843c;

    /* renamed from: d  reason: collision with root package name */
    public int f3844d;

    static class Builder implements AudioAttributesImpl.Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f3845a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f3846b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f3847c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f3848d = -1;

        Builder() {
        }

        private Builder b(int i2) {
            switch (i2) {
                case 0:
                    this.f3846b = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.f3846b = 4;
                    break;
                case 3:
                    this.f3846b = 2;
                    break;
                case 4:
                    this.f3846b = 4;
                    break;
                case 5:
                    this.f3846b = 4;
                    break;
                case 6:
                    this.f3846b = 1;
                    this.f3847c |= 4;
                    break;
                case 7:
                    this.f3847c = 1 | this.f3847c;
                    break;
                case 8:
                    this.f3846b = 4;
                    break;
                case 9:
                    this.f3846b = 4;
                    break;
                case 10:
                    this.f3846b = 1;
                    break;
                default:
                    Log.e("AudioAttributesCompat", "Invalid stream type " + i2 + " for AudioAttributesCompat");
                    break;
            }
            this.f3846b = 4;
            this.f3845a = AudioAttributesImplBase.e(i2);
            return this;
        }

        public AudioAttributesImpl build() {
            return new AudioAttributesImplBase(this.f3846b, this.f3847c, this.f3845a, this.f3848d);
        }

        /* renamed from: c */
        public Builder a(int i2) {
            if (i2 != 10) {
                this.f3848d = i2;
                return b(i2);
            }
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }
    }

    public AudioAttributesImplBase() {
        this.f3841a = 0;
        this.f3842b = 0;
        this.f3843c = 0;
        this.f3844d = -1;
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
        int i2 = this.f3844d;
        if (i2 != -1) {
            return i2;
        }
        return AudioAttributesCompat.b(false, this.f3843c, this.f3841a);
    }

    public int b() {
        return this.f3842b;
    }

    public int c() {
        int i2 = this.f3843c;
        int a2 = a();
        if (a2 == 6) {
            i2 |= 4;
        } else if (a2 == 7) {
            i2 |= 1;
        }
        return i2 & 273;
    }

    public int d() {
        return this.f3841a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f3842b == audioAttributesImplBase.b() && this.f3843c == audioAttributesImplBase.c() && this.f3841a == audioAttributesImplBase.d() && this.f3844d == audioAttributesImplBase.f3844d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3842b), Integer.valueOf(this.f3843c), Integer.valueOf(this.f3841a), Integer.valueOf(this.f3844d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3844d != -1) {
            sb.append(" stream=");
            sb.append(this.f3844d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.c(this.f3841a));
        sb.append(" content=");
        sb.append(this.f3842b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3843c).toUpperCase());
        return sb.toString();
    }

    AudioAttributesImplBase(int i2, int i3, int i4, int i5) {
        this.f3842b = i2;
        this.f3843c = i3;
        this.f3841a = i4;
        this.f3844d = i5;
    }
}
