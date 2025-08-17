package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

final class HlsSampleStream implements SampleStream {

    /* renamed from: b  reason: collision with root package name */
    private final int f26495b;

    /* renamed from: c  reason: collision with root package name */
    private final HlsSampleStreamWrapper f26496c;

    /* renamed from: d  reason: collision with root package name */
    private int f26497d = -1;

    public HlsSampleStream(HlsSampleStreamWrapper hlsSampleStreamWrapper, int i2) {
        this.f26496c = hlsSampleStreamWrapper;
        this.f26495b = i2;
    }

    private boolean c() {
        int i2 = this.f26497d;
        return (i2 == -1 || i2 == -3 || i2 == -2) ? false : true;
    }

    public void a() throws IOException {
        int i2 = this.f26497d;
        if (i2 == -2) {
            throw new SampleQueueMappingException(this.f26496c.n().b(this.f26495b).c(0).f23071m);
        } else if (i2 == -1) {
            this.f26496c.U();
        } else if (i2 != -3) {
            this.f26496c.V(i2);
        }
    }

    public void b() {
        boolean z2;
        if (this.f26497d == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f26497d = this.f26496c.y(this.f26495b);
    }

    public int d(long j2) {
        if (c()) {
            return this.f26496c.o0(this.f26497d, j2);
        }
        return 0;
    }

    public void e() {
        if (this.f26497d != -1) {
            this.f26496c.p0(this.f26495b);
            this.f26497d = -1;
        }
    }

    public boolean isReady() {
        if (this.f26497d == -3 || (c() && this.f26496c.Q(this.f26497d))) {
            return true;
        }
        return false;
    }

    public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (this.f26497d == -3) {
            decoderInputBuffer.e(4);
            return -4;
        } else if (c()) {
            return this.f26496c.e0(this.f26497d, formatHolder, decoderInputBuffer, i2);
        } else {
            return -3;
        }
    }
}
