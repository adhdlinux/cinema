package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class BaseAudioProcessor implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    protected AudioProcessor.AudioFormat f23736b;

    /* renamed from: c  reason: collision with root package name */
    protected AudioProcessor.AudioFormat f23737c;

    /* renamed from: d  reason: collision with root package name */
    private AudioProcessor.AudioFormat f23738d;

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.AudioFormat f23739e;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer f23740f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f23741g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23742h;

    public BaseAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.f23680a;
        this.f23740f = byteBuffer;
        this.f23741g = byteBuffer;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f23681e;
        this.f23738d = audioFormat;
        this.f23739e = audioFormat;
        this.f23736b = audioFormat;
        this.f23737c = audioFormat;
    }

    public boolean a() {
        return this.f23742h && this.f23741g == AudioProcessor.f23680a;
    }

    public ByteBuffer b() {
        ByteBuffer byteBuffer = this.f23741g;
        this.f23741g = AudioProcessor.f23680a;
        return byteBuffer;
    }

    public final void d() {
        this.f23742h = true;
        i();
    }

    public final AudioProcessor.AudioFormat e(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        this.f23738d = audioFormat;
        this.f23739e = g(audioFormat);
        if (isActive()) {
            return this.f23739e;
        }
        return AudioProcessor.AudioFormat.f23681e;
    }

    /* access modifiers changed from: protected */
    public final boolean f() {
        return this.f23741g.hasRemaining();
    }

    public final void flush() {
        this.f23741g = AudioProcessor.f23680a;
        this.f23742h = false;
        this.f23736b = this.f23738d;
        this.f23737c = this.f23739e;
        h();
    }

    /* access modifiers changed from: protected */
    public AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        return AudioProcessor.AudioFormat.f23681e;
    }

    /* access modifiers changed from: protected */
    public void h() {
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    public boolean isActive() {
        return this.f23739e != AudioProcessor.AudioFormat.f23681e;
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer k(int i2) {
        if (this.f23740f.capacity() < i2) {
            this.f23740f = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f23740f.clear();
        }
        ByteBuffer byteBuffer = this.f23740f;
        this.f23741g = byteBuffer;
        return byteBuffer;
    }

    public final void reset() {
        flush();
        this.f23740f = AudioProcessor.f23680a;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f23681e;
        this.f23738d = audioFormat;
        this.f23739e = audioFormat;
        this.f23736b = audioFormat;
        this.f23737c = audioFormat;
        j();
    }
}
