package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

final class ToFloatPcmAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private static final int f5845i = Float.floatToIntBits(Float.NaN);

    ToFloatPcmAudioProcessor() {
    }

    private static void l(int i2, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i2) * 4.656612875245797E-10d));
        if (floatToIntBits == f5845i) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public void c(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.f4505b.f4502c;
        if (i3 == 21) {
            byteBuffer2 = k((i2 / 3) * 4);
            while (position < limit) {
                l(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), byteBuffer2);
                position += 3;
            }
        } else if (i3 == 22) {
            byteBuffer2 = k(i2);
            while (position < limit) {
                l((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), byteBuffer2);
                position += 4;
            }
        } else if (i3 == 1342177280) {
            byteBuffer2 = k((i2 / 3) * 4);
            while (position < limit) {
                l(((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << 24), byteBuffer2);
                position += 3;
            }
        } else if (i3 == 1610612736) {
            byteBuffer2 = k(i2);
            while (position < limit) {
                l((byteBuffer.get(position + 3) & 255) | ((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << 24), byteBuffer2);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i2 = audioFormat.f4502c;
        if (!Util.E0(i2)) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        } else if (i2 != 4) {
            return new AudioProcessor.AudioFormat(audioFormat.f4500a, audioFormat.f4501b, 4);
        } else {
            return AudioProcessor.AudioFormat.f4499e;
        }
    }
}
