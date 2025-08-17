package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class BaseAudioProcessor implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    protected AudioProcessor.AudioFormat f4505b;

    /* renamed from: c  reason: collision with root package name */
    protected AudioProcessor.AudioFormat f4506c;

    /* renamed from: d  reason: collision with root package name */
    private AudioProcessor.AudioFormat f4507d;

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.AudioFormat f4508e;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer f4509f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f4510g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4511h;

    public BaseAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.f4498a;
        this.f4509f = byteBuffer;
        this.f4510g = byteBuffer;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f4499e;
        this.f4507d = audioFormat;
        this.f4508e = audioFormat;
        this.f4505b = audioFormat;
        this.f4506c = audioFormat;
    }

    public boolean a() {
        return this.f4511h && this.f4510g == AudioProcessor.f4498a;
    }

    public ByteBuffer b() {
        ByteBuffer byteBuffer = this.f4510g;
        this.f4510g = AudioProcessor.f4498a;
        return byteBuffer;
    }

    public final void d() {
        this.f4511h = true;
        i();
    }

    public final AudioProcessor.AudioFormat e(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        this.f4507d = audioFormat;
        this.f4508e = g(audioFormat);
        if (isActive()) {
            return this.f4508e;
        }
        return AudioProcessor.AudioFormat.f4499e;
    }

    /* access modifiers changed from: protected */
    public final boolean f() {
        return this.f4510g.hasRemaining();
    }

    public final void flush() {
        this.f4510g = AudioProcessor.f4498a;
        this.f4511h = false;
        this.f4505b = this.f4507d;
        this.f4506c = this.f4508e;
        h();
    }

    /* access modifiers changed from: protected */
    public AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        return AudioProcessor.AudioFormat.f4499e;
    }

    /* access modifiers changed from: protected */
    public void h() {
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    public boolean isActive() {
        return this.f4508e != AudioProcessor.AudioFormat.f4499e;
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer k(int i2) {
        if (this.f4509f.capacity() < i2) {
            this.f4509f = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f4509f.clear();
        }
        ByteBuffer byteBuffer = this.f4509f;
        this.f4510g = byteBuffer;
        return byteBuffer;
    }

    public final void reset() {
        flush();
        this.f4509f = AudioProcessor.f4498a;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f4499e;
        this.f4507d = audioFormat;
        this.f4508e = audioFormat;
        this.f4505b = audioFormat;
        this.f4506c = audioFormat;
        j();
    }
}
