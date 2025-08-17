package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.util.Assertions;
import java.nio.ByteBuffer;

final class ChannelMappingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private int[] f5711i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f5712j;

    ChannelMappingAudioProcessor() {
    }

    public void c(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) Assertions.f(this.f5712j);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer k2 = k(((limit - position) / this.f4505b.f4503d) * this.f4506c.f4503d);
        while (position < limit) {
            for (int i2 : iArr) {
                k2.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.f4505b.f4503d;
        }
        byteBuffer.position(limit);
        k2.flip();
    }

    public AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        boolean z2;
        boolean z3;
        int[] iArr = this.f5711i;
        if (iArr == null) {
            return AudioProcessor.AudioFormat.f4499e;
        }
        if (audioFormat.f4502c == 2) {
            if (audioFormat.f4501b != iArr.length) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i2 = 0;
            while (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 < audioFormat.f4501b) {
                    if (i3 != i2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z2 |= z3;
                    i2++;
                } else {
                    throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
                }
            }
            if (z2) {
                return new AudioProcessor.AudioFormat(audioFormat.f4500a, iArr.length, 2);
            }
            return AudioProcessor.AudioFormat.f4499e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    /* access modifiers changed from: protected */
    public void h() {
        this.f5712j = this.f5711i;
    }

    /* access modifiers changed from: protected */
    public void j() {
        this.f5712j = null;
        this.f5711i = null;
    }

    public void l(int[] iArr) {
        this.f5711i = iArr;
    }
}
