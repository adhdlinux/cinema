package androidx.media3.extractor.text.cea;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import com.facebook.common.time.Clock;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

abstract class CeaDecoder implements SubtitleDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<CeaInputBuffer> f8891a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<SubtitleOutputBuffer> f8892b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityQueue<CeaInputBuffer> f8893c;

    /* renamed from: d  reason: collision with root package name */
    private CeaInputBuffer f8894d;

    /* renamed from: e  reason: collision with root package name */
    private long f8895e;

    /* renamed from: f  reason: collision with root package name */
    private long f8896f;

    /* renamed from: g  reason: collision with root package name */
    private long f8897g;

    private static final class CeaInputBuffer extends SubtitleInputBuffer implements Comparable<CeaInputBuffer> {
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public long f8898k;

        private CeaInputBuffer() {
        }

        /* renamed from: l */
        public int compareTo(CeaInputBuffer ceaInputBuffer) {
            if (isEndOfStream() == ceaInputBuffer.isEndOfStream()) {
                long j2 = this.f5069f - ceaInputBuffer.f5069f;
                if (j2 == 0) {
                    j2 = this.f8898k - ceaInputBuffer.f8898k;
                    if (j2 == 0) {
                        return 0;
                    }
                }
                if (j2 > 0) {
                    return 1;
                }
                return -1;
            } else if (isEndOfStream()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private static final class CeaOutputBuffer extends SubtitleOutputBuffer {

        /* renamed from: d  reason: collision with root package name */
        private DecoderOutputBuffer.Owner<CeaOutputBuffer> f8899d;

        public CeaOutputBuffer(DecoderOutputBuffer.Owner<CeaOutputBuffer> owner) {
            this.f8899d = owner;
        }

        public final void release() {
            this.f8899d.a(this);
        }
    }

    public CeaDecoder() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.f8891a.add(new CeaInputBuffer());
        }
        this.f8892b = new ArrayDeque<>();
        for (int i3 = 0; i3 < 2; i3++) {
            this.f8892b.add(new CeaOutputBuffer(new b(this)));
        }
        this.f8893c = new PriorityQueue<>();
        this.f8897g = -9223372036854775807L;
    }

    private void o(CeaInputBuffer ceaInputBuffer) {
        ceaInputBuffer.clear();
        this.f8891a.add(ceaInputBuffer);
    }

    public void b(long j2) {
        this.f8895e = j2;
    }

    public final void e(long j2) {
        this.f8897g = j2;
    }

    public void flush() {
        this.f8896f = 0;
        this.f8895e = 0;
        while (!this.f8893c.isEmpty()) {
            o((CeaInputBuffer) Util.i(this.f8893c.poll()));
        }
        CeaInputBuffer ceaInputBuffer = this.f8894d;
        if (ceaInputBuffer != null) {
            o(ceaInputBuffer);
            this.f8894d = null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Subtitle g();

    /* access modifiers changed from: protected */
    public abstract void h(SubtitleInputBuffer subtitleInputBuffer);

    /* renamed from: i */
    public SubtitleInputBuffer d() throws SubtitleDecoderException {
        boolean z2;
        if (this.f8894d == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (this.f8891a.isEmpty()) {
            return null;
        }
        CeaInputBuffer pollFirst = this.f8891a.pollFirst();
        this.f8894d = pollFirst;
        return pollFirst;
    }

    /* renamed from: j */
    public SubtitleOutputBuffer a() throws SubtitleDecoderException {
        if (this.f8892b.isEmpty()) {
            return null;
        }
        while (!this.f8893c.isEmpty() && ((CeaInputBuffer) Util.i(this.f8893c.peek())).f5069f <= this.f8895e) {
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) Util.i(this.f8893c.poll());
            if (ceaInputBuffer.isEndOfStream()) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) Util.i(this.f8892b.pollFirst());
                subtitleOutputBuffer.addFlag(4);
                o(ceaInputBuffer);
                return subtitleOutputBuffer;
            }
            h(ceaInputBuffer);
            if (m()) {
                Subtitle g2 = g();
                SubtitleOutputBuffer subtitleOutputBuffer2 = (SubtitleOutputBuffer) Util.i(this.f8892b.pollFirst());
                subtitleOutputBuffer2.e(ceaInputBuffer.f5069f, g2, Clock.MAX_TIME);
                o(ceaInputBuffer);
                return subtitleOutputBuffer2;
            }
            o(ceaInputBuffer);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final SubtitleOutputBuffer k() {
        return this.f8892b.pollFirst();
    }

    /* access modifiers changed from: protected */
    public final long l() {
        return this.f8895e;
    }

    /* access modifiers changed from: protected */
    public abstract boolean m();

    /* renamed from: n */
    public void c(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        boolean z2;
        if (subtitleInputBuffer == this.f8894d) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) subtitleInputBuffer;
        long j2 = this.f8897g;
        if (j2 == -9223372036854775807L || ceaInputBuffer.f5069f >= j2) {
            long j3 = this.f8896f;
            this.f8896f = 1 + j3;
            long unused = ceaInputBuffer.f8898k = j3;
            this.f8893c.add(ceaInputBuffer);
        } else {
            o(ceaInputBuffer);
        }
        this.f8894d = null;
    }

    /* access modifiers changed from: protected */
    public void p(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.f8892b.add(subtitleOutputBuffer);
    }

    public void release() {
    }
}
