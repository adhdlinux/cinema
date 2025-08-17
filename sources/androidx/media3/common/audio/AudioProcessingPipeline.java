package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class AudioProcessingPipeline {

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableList<AudioProcessor> f4492a;

    /* renamed from: b  reason: collision with root package name */
    private final List<AudioProcessor> f4493b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer[] f4494c = new ByteBuffer[0];

    /* renamed from: d  reason: collision with root package name */
    private AudioProcessor.AudioFormat f4495d;

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.AudioFormat f4496e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4497f;

    public AudioProcessingPipeline(ImmutableList<AudioProcessor> immutableList) {
        this.f4492a = immutableList;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f4499e;
        this.f4495d = audioFormat;
        this.f4496e = audioFormat;
        this.f4497f = false;
    }

    private int c() {
        return this.f4494c.length - 1;
    }

    private void g(ByteBuffer byteBuffer) {
        boolean z2;
        ByteBuffer byteBuffer2;
        boolean z3;
        for (boolean z4 = true; z4; z4 = z2) {
            z2 = false;
            for (int i2 = 0; i2 <= c(); i2++) {
                if (!this.f4494c[i2].hasRemaining()) {
                    AudioProcessor audioProcessor = this.f4493b.get(i2);
                    if (!audioProcessor.a()) {
                        if (i2 > 0) {
                            byteBuffer2 = this.f4494c[i2 - 1];
                        } else if (byteBuffer.hasRemaining()) {
                            byteBuffer2 = byteBuffer;
                        } else {
                            byteBuffer2 = AudioProcessor.f4498a;
                        }
                        audioProcessor.c(byteBuffer2);
                        this.f4494c[i2] = audioProcessor.b();
                        if (((long) byteBuffer2.remaining()) - ((long) byteBuffer2.remaining()) > 0 || this.f4494c[i2].hasRemaining()) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        z2 |= z3;
                    } else if (!this.f4494c[i2].hasRemaining() && i2 < c()) {
                        this.f4493b.get(i2 + 1).d();
                    }
                }
            }
        }
    }

    public AudioProcessor.AudioFormat a(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (!audioFormat.equals(AudioProcessor.AudioFormat.f4499e)) {
            for (int i2 = 0; i2 < this.f4492a.size(); i2++) {
                AudioProcessor audioProcessor = this.f4492a.get(i2);
                AudioProcessor.AudioFormat e2 = audioProcessor.e(audioFormat);
                if (audioProcessor.isActive()) {
                    Assertions.h(!e2.equals(AudioProcessor.AudioFormat.f4499e));
                    audioFormat = e2;
                }
            }
            this.f4496e = audioFormat;
            return audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    public void b() {
        this.f4493b.clear();
        this.f4495d = this.f4496e;
        this.f4497f = false;
        for (int i2 = 0; i2 < this.f4492a.size(); i2++) {
            AudioProcessor audioProcessor = this.f4492a.get(i2);
            audioProcessor.flush();
            if (audioProcessor.isActive()) {
                this.f4493b.add(audioProcessor);
            }
        }
        this.f4494c = new ByteBuffer[this.f4493b.size()];
        for (int i3 = 0; i3 <= c(); i3++) {
            this.f4494c[i3] = this.f4493b.get(i3).b();
        }
    }

    public ByteBuffer d() {
        if (!f()) {
            return AudioProcessor.f4498a;
        }
        ByteBuffer byteBuffer = this.f4494c[c()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        g(AudioProcessor.f4498a);
        return this.f4494c[c()];
    }

    public boolean e() {
        if (!this.f4497f || !this.f4493b.get(c()).a() || this.f4494c[c()].hasRemaining()) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioProcessingPipeline)) {
            return false;
        }
        AudioProcessingPipeline audioProcessingPipeline = (AudioProcessingPipeline) obj;
        if (this.f4492a.size() != audioProcessingPipeline.f4492a.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f4492a.size(); i2++) {
            if (this.f4492a.get(i2) != audioProcessingPipeline.f4492a.get(i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        return !this.f4493b.isEmpty();
    }

    public void h() {
        if (f() && !this.f4497f) {
            this.f4497f = true;
            this.f4493b.get(0).d();
        }
    }

    public int hashCode() {
        return this.f4492a.hashCode();
    }

    public void i(ByteBuffer byteBuffer) {
        if (f() && !this.f4497f) {
            g(byteBuffer);
        }
    }

    public void j() {
        for (int i2 = 0; i2 < this.f4492a.size(); i2++) {
            AudioProcessor audioProcessor = this.f4492a.get(i2);
            audioProcessor.flush();
            audioProcessor.reset();
        }
        this.f4494c = new ByteBuffer[0];
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f4499e;
        this.f4495d = audioFormat;
        this.f4496e = audioFormat;
        this.f4497f = false;
    }
}
