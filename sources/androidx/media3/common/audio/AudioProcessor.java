package androidx.media3.common.audio;

import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface AudioProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f4498a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class AudioFormat {

        /* renamed from: e  reason: collision with root package name */
        public static final AudioFormat f4499e = new AudioFormat(-1, -1, -1);

        /* renamed from: a  reason: collision with root package name */
        public final int f4500a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4501b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4502c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4503d;

        public AudioFormat(Format format) {
            this(format.C, format.B, format.D);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioFormat)) {
                return false;
            }
            AudioFormat audioFormat = (AudioFormat) obj;
            if (this.f4500a == audioFormat.f4500a && this.f4501b == audioFormat.f4501b && this.f4502c == audioFormat.f4502c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(Integer.valueOf(this.f4500a), Integer.valueOf(this.f4501b), Integer.valueOf(this.f4502c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f4500a + ", channelCount=" + this.f4501b + ", encoding=" + this.f4502c + ']';
        }

        public AudioFormat(int i2, int i3, int i4) {
            this.f4500a = i2;
            this.f4501b = i3;
            this.f4502c = i4;
            this.f4503d = Util.F0(i4) ? Util.i0(i4, i3) : -1;
        }
    }

    public static final class UnhandledAudioFormatException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final AudioFormat f4504b;

        public UnhandledAudioFormatException(AudioFormat audioFormat) {
            this("Unhandled input format:", audioFormat);
        }

        public UnhandledAudioFormatException(String str, AudioFormat audioFormat) {
            super(str + " " + audioFormat);
            this.f4504b = audioFormat;
        }
    }

    boolean a();

    ByteBuffer b();

    void c(ByteBuffer byteBuffer);

    void d();

    AudioFormat e(AudioFormat audioFormat) throws UnhandledAudioFormatException;

    void flush();

    boolean isActive();

    void reset();
}
