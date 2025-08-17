package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface AudioProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f23680a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class AudioFormat {

        /* renamed from: e  reason: collision with root package name */
        public static final AudioFormat f23681e = new AudioFormat(-1, -1, -1);

        /* renamed from: a  reason: collision with root package name */
        public final int f23682a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23683b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23684c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23685d;

        public AudioFormat(int i2, int i3, int i4) {
            int i5;
            this.f23682a = i2;
            this.f23683b = i3;
            this.f23684c = i4;
            if (Util.x0(i4)) {
                i5 = Util.f0(i4, i3);
            } else {
                i5 = -1;
            }
            this.f23685d = i5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioFormat)) {
                return false;
            }
            AudioFormat audioFormat = (AudioFormat) obj;
            if (this.f23682a == audioFormat.f23682a && this.f23683b == audioFormat.f23683b && this.f23684c == audioFormat.f23684c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(Integer.valueOf(this.f23682a), Integer.valueOf(this.f23683b), Integer.valueOf(this.f23684c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f23682a + ", channelCount=" + this.f23683b + ", encoding=" + this.f23684c + ']';
        }
    }

    public static final class UnhandledAudioFormatException extends Exception {
        public UnhandledAudioFormatException(AudioFormat audioFormat) {
            super("Unhandled format: " + audioFormat);
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
