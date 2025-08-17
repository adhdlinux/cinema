package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;

public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributes f3838a;

    /* renamed from: b  reason: collision with root package name */
    public int f3839b;

    static class Builder implements AudioAttributesImpl.Builder {

        /* renamed from: a  reason: collision with root package name */
        final AudioAttributes.Builder f3840a = new AudioAttributes.Builder();

        Builder() {
        }

        /* renamed from: b */
        public Builder a(int i2) {
            this.f3840a.setLegacyStreamType(i2);
            return this;
        }

        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi21(this.f3840a.build());
        }
    }

    public AudioAttributesImplApi21() {
        this.f3839b = -1;
    }

    public int a() {
        int i2 = this.f3839b;
        if (i2 != -1) {
            return i2;
        }
        return AudioAttributesCompat.b(false, b(), c());
    }

    public int b() {
        return this.f3838a.getFlags();
    }

    public int c() {
        return this.f3838a.getUsage();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f3838a.equals(((AudioAttributesImplApi21) obj).f3838a);
    }

    public int hashCode() {
        return this.f3838a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3838a;
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes, int i2) {
        this.f3838a = audioAttributes;
        this.f3839b = i2;
    }
}
