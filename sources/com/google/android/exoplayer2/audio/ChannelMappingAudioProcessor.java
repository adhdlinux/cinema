package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

final class ChannelMappingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private int[] f23743i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f23744j;

    ChannelMappingAudioProcessor() {
    }

    public void c(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) Assertions.e(this.f23744j);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer k2 = k(((limit - position) / this.f23736b.f23685d) * this.f23737c.f23685d);
        while (position < limit) {
            for (int i2 : iArr) {
                k2.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.f23736b.f23685d;
        }
        byteBuffer.position(limit);
        k2.flip();
    }

    public AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        boolean z2;
        boolean z3;
        int[] iArr = this.f23743i;
        if (iArr == null) {
            return AudioProcessor.AudioFormat.f23681e;
        }
        if (audioFormat.f23684c == 2) {
            if (audioFormat.f23683b != iArr.length) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i2 = 0;
            while (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 < audioFormat.f23683b) {
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
                return new AudioProcessor.AudioFormat(audioFormat.f23682a, iArr.length, 2);
            }
            return AudioProcessor.AudioFormat.f23681e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    /* access modifiers changed from: protected */
    public void h() {
        this.f23744j = this.f23743i;
    }

    /* access modifiers changed from: protected */
    public void j() {
        this.f23744j = null;
        this.f23743i = null;
    }

    public void l(int[] iArr) {
        this.f23743i = iArr;
    }
}
