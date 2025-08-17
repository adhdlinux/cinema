package com.google.android.exoplayer2.text.cea;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

abstract class CeaDecoder implements SubtitleDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<CeaInputBuffer> f27354a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<SubtitleOutputBuffer> f27355b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityQueue<CeaInputBuffer> f27356c;

    /* renamed from: d  reason: collision with root package name */
    private CeaInputBuffer f27357d;

    /* renamed from: e  reason: collision with root package name */
    private long f27358e;

    /* renamed from: f  reason: collision with root package name */
    private long f27359f;

    private static final class CeaInputBuffer extends SubtitleInputBuffer implements Comparable<CeaInputBuffer> {
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public long f27360k;

        private CeaInputBuffer() {
        }

        /* renamed from: w */
        public int compareTo(CeaInputBuffer ceaInputBuffer) {
            if (k() == ceaInputBuffer.k()) {
                long j2 = this.f23963f - ceaInputBuffer.f23963f;
                if (j2 == 0) {
                    j2 = this.f27360k - ceaInputBuffer.f27360k;
                    if (j2 == 0) {
                        return 0;
                    }
                }
                if (j2 > 0) {
                    return 1;
                }
                return -1;
            } else if (k()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private static final class CeaOutputBuffer extends SubtitleOutputBuffer {

        /* renamed from: g  reason: collision with root package name */
        private DecoderOutputBuffer.Owner<CeaOutputBuffer> f27361g;

        public CeaOutputBuffer(DecoderOutputBuffer.Owner<CeaOutputBuffer> owner) {
            this.f27361g = owner;
        }

        public final void p() {
            this.f27361g.a(this);
        }
    }

    public CeaDecoder() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.f27354a.add(new CeaInputBuffer());
        }
        this.f27355b = new ArrayDeque<>();
        for (int i3 = 0; i3 < 2; i3++) {
            this.f27355b.add(new CeaOutputBuffer(new b(this)));
        }
        this.f27356c = new PriorityQueue<>();
    }

    private void m(CeaInputBuffer ceaInputBuffer) {
        ceaInputBuffer.f();
        this.f27354a.add(ceaInputBuffer);
    }

    public void b(long j2) {
        this.f27358e = j2;
    }

    /* access modifiers changed from: protected */
    public abstract Subtitle e();

    /* access modifiers changed from: protected */
    public abstract void f(SubtitleInputBuffer subtitleInputBuffer);

    public void flush() {
        this.f27359f = 0;
        this.f27358e = 0;
        while (!this.f27356c.isEmpty()) {
            m((CeaInputBuffer) Util.j(this.f27356c.poll()));
        }
        CeaInputBuffer ceaInputBuffer = this.f27357d;
        if (ceaInputBuffer != null) {
            m(ceaInputBuffer);
            this.f27357d = null;
        }
    }

    /* renamed from: g */
    public SubtitleInputBuffer d() throws SubtitleDecoderException {
        boolean z2;
        if (this.f27357d == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (this.f27354a.isEmpty()) {
            return null;
        }
        CeaInputBuffer pollFirst = this.f27354a.pollFirst();
        this.f27357d = pollFirst;
        return pollFirst;
    }

    /* renamed from: h */
    public SubtitleOutputBuffer a() throws SubtitleDecoderException {
        if (this.f27355b.isEmpty()) {
            return null;
        }
        while (!this.f27356c.isEmpty() && ((CeaInputBuffer) Util.j(this.f27356c.peek())).f23963f <= this.f27358e) {
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) Util.j(this.f27356c.poll());
            if (ceaInputBuffer.k()) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) Util.j(this.f27355b.pollFirst());
                subtitleOutputBuffer.e(4);
                m(ceaInputBuffer);
                return subtitleOutputBuffer;
            }
            f(ceaInputBuffer);
            if (k()) {
                Subtitle e2 = e();
                SubtitleOutputBuffer subtitleOutputBuffer2 = (SubtitleOutputBuffer) Util.j(this.f27355b.pollFirst());
                subtitleOutputBuffer2.q(ceaInputBuffer.f23963f, e2, Clock.MAX_TIME);
                m(ceaInputBuffer);
                return subtitleOutputBuffer2;
            }
            m(ceaInputBuffer);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final SubtitleOutputBuffer i() {
        return this.f27355b.pollFirst();
    }

    /* access modifiers changed from: protected */
    public final long j() {
        return this.f27358e;
    }

    /* access modifiers changed from: protected */
    public abstract boolean k();

    /* renamed from: l */
    public void c(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        boolean z2;
        if (subtitleInputBuffer == this.f27357d) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) subtitleInputBuffer;
        if (ceaInputBuffer.j()) {
            m(ceaInputBuffer);
        } else {
            long j2 = this.f27359f;
            this.f27359f = 1 + j2;
            long unused = ceaInputBuffer.f27360k = j2;
            this.f27356c.add(ceaInputBuffer);
        }
        this.f27357d = null;
    }

    /* access modifiers changed from: protected */
    public void n(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.f();
        this.f27355b.add(subtitleOutputBuffer);
    }

    public void release() {
    }
}
