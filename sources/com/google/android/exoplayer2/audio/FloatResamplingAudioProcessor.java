package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

final class FloatResamplingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private static final int f23828i = Float.floatToIntBits(Float.NaN);

    FloatResamplingAudioProcessor() {
    }

    private static void l(int i2, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i2) * 4.656612875245797E-10d));
        if (floatToIntBits == f23828i) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public void c(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.f23736b.f23684c;
        if (i3 == 536870912) {
            byteBuffer2 = k((i2 / 3) * 4);
            while (position < limit) {
                l(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), byteBuffer2);
                position += 3;
            }
        } else if (i3 == 805306368) {
            byteBuffer2 = k(i2);
            while (position < limit) {
                l((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), byteBuffer2);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i2 = audioFormat.f23684c;
        if (!Util.w0(i2)) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        } else if (i2 != 4) {
            return new AudioProcessor.AudioFormat(audioFormat.f23682a, audioFormat.f23683b, 4);
        } else {
            return AudioProcessor.AudioFormat.f23681e;
        }
    }
}
