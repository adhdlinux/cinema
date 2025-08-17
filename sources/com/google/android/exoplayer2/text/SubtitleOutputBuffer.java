package com.google.android.exoplayer2.text;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;

public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle {

    /* renamed from: e  reason: collision with root package name */
    private Subtitle f27265e;

    /* renamed from: f  reason: collision with root package name */
    private long f27266f;

    public int a(long j2) {
        return ((Subtitle) Assertions.e(this.f27265e)).a(j2 - this.f27266f);
    }

    public List<Cue> b(long j2) {
        return ((Subtitle) Assertions.e(this.f27265e)).b(j2 - this.f27266f);
    }

    public long c(int i2) {
        return ((Subtitle) Assertions.e(this.f27265e)).c(i2) + this.f27266f;
    }

    public int d() {
        return ((Subtitle) Assertions.e(this.f27265e)).d();
    }

    public void f() {
        super.f();
        this.f27265e = null;
    }

    public void q(long j2, Subtitle subtitle, long j3) {
        this.f23969c = j2;
        this.f27265e = subtitle;
        if (j3 != Clock.MAX_TIME) {
            j2 = j3;
        }
        this.f27266f = j2;
    }
}
