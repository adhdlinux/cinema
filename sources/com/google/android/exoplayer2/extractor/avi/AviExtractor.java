package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.DummyExtractorOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.util.ArrayList;

public final class AviExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f24297a = new ParsableByteArray(12);

    /* renamed from: b  reason: collision with root package name */
    private final ChunkHeaderHolder f24298b = new ChunkHeaderHolder();

    /* renamed from: c  reason: collision with root package name */
    private int f24299c;

    /* renamed from: d  reason: collision with root package name */
    private ExtractorOutput f24300d = new DummyExtractorOutput();

    /* renamed from: e  reason: collision with root package name */
    private AviMainHeaderChunk f24301e;

    /* renamed from: f  reason: collision with root package name */
    private long f24302f = -9223372036854775807L;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ChunkReader[] f24303g = new ChunkReader[0];

    /* renamed from: h  reason: collision with root package name */
    private long f24304h;

    /* renamed from: i  reason: collision with root package name */
    private ChunkReader f24305i;

    /* renamed from: j  reason: collision with root package name */
    private int f24306j = -1;

    /* renamed from: k  reason: collision with root package name */
    private long f24307k = -1;

    /* renamed from: l  reason: collision with root package name */
    private long f24308l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f24309m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24310n;

    private class AviSeekMap implements SeekMap {

        /* renamed from: a  reason: collision with root package name */
        private final long f24311a;

        public AviSeekMap(long j2) {
            this.f24311a = j2;
        }

        public SeekMap.SeekPoints d(long j2) {
            SeekMap.SeekPoints i2 = AviExtractor.this.f24303g[0].i(j2);
            for (int i3 = 1; i3 < AviExtractor.this.f24303g.length; i3++) {
                SeekMap.SeekPoints i4 = AviExtractor.this.f24303g[i3].i(j2);
                if (i4.f24232a.f24238b < i2.f24232a.f24238b) {
                    i2 = i4;
                }
            }
            return i2;
        }

        public boolean f() {
            return true;
        }

        public long h() {
            return this.f24311a;
        }
    }

    private static class ChunkHeaderHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f24313a;

        /* renamed from: b  reason: collision with root package name */
        public int f24314b;

        /* renamed from: c  reason: collision with root package name */
        public int f24315c;

        private ChunkHeaderHolder() {
        }

        public void a(ParsableByteArray parsableByteArray) {
            this.f24313a = parsableByteArray.u();
            this.f24314b = parsableByteArray.u();
            this.f24315c = 0;
        }

        public void b(ParsableByteArray parsableByteArray) throws ParserException {
            a(parsableByteArray);
            if (this.f24313a == 1414744396) {
                this.f24315c = parsableByteArray.u();
                return;
            }
            throw ParserException.a("LIST expected, found: " + this.f24313a, (Throwable) null);
        }
    }

    private static void d(ExtractorInput extractorInput) throws IOException {
        if ((extractorInput.getPosition() & 1) == 1) {
            extractorInput.k(1);
        }
    }

    private ChunkReader e(int i2) {
        for (ChunkReader chunkReader : this.f24303g) {
            if (chunkReader.j(i2)) {
                return chunkReader;
            }
        }
        return null;
    }

    private void f(ParsableByteArray parsableByteArray) throws IOException {
        ListChunk c2 = ListChunk.c(1819436136, parsableByteArray);
        if (c2.getType() == 1819436136) {
            AviMainHeaderChunk aviMainHeaderChunk = (AviMainHeaderChunk) c2.b(AviMainHeaderChunk.class);
            if (aviMainHeaderChunk != null) {
                this.f24301e = aviMainHeaderChunk;
                this.f24302f = ((long) aviMainHeaderChunk.f24318c) * ((long) aviMainHeaderChunk.f24316a);
                ArrayList arrayList = new ArrayList();
                UnmodifiableIterator<AviChunk> h2 = c2.f24338a.iterator();
                int i2 = 0;
                while (h2.hasNext()) {
                    AviChunk next = h2.next();
                    if (next.getType() == 1819440243) {
                        int i3 = i2 + 1;
                        ChunkReader k2 = k((ListChunk) next, i2);
                        if (k2 != null) {
                            arrayList.add(k2);
                        }
                        i2 = i3;
                    }
                }
                this.f24303g = (ChunkReader[]) arrayList.toArray(new ChunkReader[0]);
                this.f24300d.m();
                return;
            }
            throw ParserException.a("AviHeader not found", (Throwable) null);
        }
        throw ParserException.a("Unexpected header list type " + c2.getType(), (Throwable) null);
    }

    private void h(ParsableByteArray parsableByteArray) {
        long j2 = j(parsableByteArray);
        while (parsableByteArray.a() >= 16) {
            int u2 = parsableByteArray.u();
            int u3 = parsableByteArray.u();
            long u4 = ((long) parsableByteArray.u()) + j2;
            parsableByteArray.u();
            ChunkReader e2 = e(u2);
            if (e2 != null) {
                if ((u3 & 16) == 16) {
                    e2.b(u4);
                }
                e2.k();
            }
        }
        for (ChunkReader c2 : this.f24303g) {
            c2.c();
        }
        this.f24310n = true;
        this.f24300d.u(new AviSeekMap(this.f24302f));
    }

    private long j(ParsableByteArray parsableByteArray) {
        long j2 = 0;
        if (parsableByteArray.a() < 16) {
            return 0;
        }
        int f2 = parsableByteArray.f();
        parsableByteArray.V(8);
        long j3 = this.f24307k;
        if (((long) parsableByteArray.u()) <= j3) {
            j2 = j3 + 8;
        }
        parsableByteArray.U(f2);
        return j2;
    }

    private ChunkReader k(ListChunk listChunk, int i2) {
        AviStreamHeaderChunk aviStreamHeaderChunk = (AviStreamHeaderChunk) listChunk.b(AviStreamHeaderChunk.class);
        StreamFormatChunk streamFormatChunk = (StreamFormatChunk) listChunk.b(StreamFormatChunk.class);
        if (aviStreamHeaderChunk == null) {
            Log.i("AviExtractor", "Missing Stream Header");
            return null;
        } else if (streamFormatChunk == null) {
            Log.i("AviExtractor", "Missing Stream Format");
            return null;
        } else {
            long a2 = aviStreamHeaderChunk.a();
            Format format = streamFormatChunk.f24340a;
            Format.Builder b2 = format.b();
            b2.T(i2);
            int i3 = aviStreamHeaderChunk.f24325f;
            if (i3 != 0) {
                b2.Y(i3);
            }
            StreamNameChunk streamNameChunk = (StreamNameChunk) listChunk.b(StreamNameChunk.class);
            if (streamNameChunk != null) {
                b2.W(streamNameChunk.f24341a);
            }
            int k2 = MimeTypes.k(format.f23071m);
            if (k2 != 1 && k2 != 2) {
                return null;
            }
            TrackOutput d2 = this.f24300d.d(i2, k2);
            d2.d(b2.G());
            ChunkReader chunkReader = new ChunkReader(i2, k2, a2, aviStreamHeaderChunk.f24324e, d2);
            this.f24302f = a2;
            return chunkReader;
        }
    }

    private int l(ExtractorInput extractorInput) throws IOException {
        if (extractorInput.getPosition() >= this.f24308l) {
            return -1;
        }
        ChunkReader chunkReader = this.f24305i;
        if (chunkReader == null) {
            d(extractorInput);
            int i2 = 12;
            extractorInput.m(this.f24297a.e(), 0, 12);
            this.f24297a.U(0);
            int u2 = this.f24297a.u();
            if (u2 == 1414744396) {
                this.f24297a.U(8);
                if (this.f24297a.u() != 1769369453) {
                    i2 = 8;
                }
                extractorInput.k(i2);
                extractorInput.e();
                return 0;
            }
            int u3 = this.f24297a.u();
            if (u2 == 1263424842) {
                this.f24304h = extractorInput.getPosition() + ((long) u3) + 8;
                return 0;
            }
            extractorInput.k(8);
            extractorInput.e();
            ChunkReader e2 = e(u2);
            if (e2 == null) {
                this.f24304h = extractorInput.getPosition() + ((long) u3);
                return 0;
            }
            e2.n(u3);
            this.f24305i = e2;
        } else if (chunkReader.m(extractorInput)) {
            this.f24305i = null;
        }
        return 0;
    }

    private boolean m(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        if (this.f24304h != -1) {
            long position = extractorInput.getPosition();
            long j2 = this.f24304h;
            if (j2 < position || j2 > 262144 + position) {
                positionHolder.f24231a = j2;
                z2 = true;
                this.f24304h = -1;
                return z2;
            }
            extractorInput.k((int) (j2 - position));
        }
        z2 = false;
        this.f24304h = -1;
        return z2;
    }

    public void a(long j2, long j3) {
        this.f24304h = -1;
        this.f24305i = null;
        for (ChunkReader o2 : this.f24303g) {
            o2.o(j2);
        }
        if (j2 != 0) {
            this.f24299c = 6;
        } else if (this.f24303g.length == 0) {
            this.f24299c = 0;
        } else {
            this.f24299c = 3;
        }
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f24299c = 0;
        this.f24300d = extractorOutput;
        this.f24304h = -1;
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        extractorInput.m(this.f24297a.e(), 0, 12);
        this.f24297a.U(0);
        if (this.f24297a.u() != 1179011410) {
            return false;
        }
        this.f24297a.V(4);
        if (this.f24297a.u() == 541677121) {
            return true;
        }
        return false;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        if (m(extractorInput, positionHolder)) {
            return 1;
        }
        switch (this.f24299c) {
            case 0:
                if (g(extractorInput)) {
                    extractorInput.k(12);
                    this.f24299c = 1;
                    return 0;
                }
                throw ParserException.a("AVI Header List not found", (Throwable) null);
            case 1:
                extractorInput.readFully(this.f24297a.e(), 0, 12);
                this.f24297a.U(0);
                this.f24298b.b(this.f24297a);
                ChunkHeaderHolder chunkHeaderHolder = this.f24298b;
                if (chunkHeaderHolder.f24315c == 1819436136) {
                    this.f24306j = chunkHeaderHolder.f24314b;
                    this.f24299c = 2;
                    return 0;
                }
                throw ParserException.a("hdrl expected, found: " + this.f24298b.f24315c, (Throwable) null);
            case 2:
                int i2 = this.f24306j - 4;
                ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
                extractorInput.readFully(parsableByteArray.e(), 0, i2);
                f(parsableByteArray);
                this.f24299c = 3;
                return 0;
            case 3:
                if (this.f24307k != -1) {
                    long position = extractorInput.getPosition();
                    long j2 = this.f24307k;
                    if (position != j2) {
                        this.f24304h = j2;
                        return 0;
                    }
                }
                extractorInput.m(this.f24297a.e(), 0, 12);
                extractorInput.e();
                this.f24297a.U(0);
                this.f24298b.a(this.f24297a);
                int u2 = this.f24297a.u();
                int i3 = this.f24298b.f24313a;
                if (i3 == 1179011410) {
                    extractorInput.k(12);
                    return 0;
                } else if (i3 == 1414744396 && u2 == 1769369453) {
                    long position2 = extractorInput.getPosition();
                    this.f24307k = position2;
                    this.f24308l = position2 + ((long) this.f24298b.f24314b) + 8;
                    if (!this.f24310n) {
                        if (((AviMainHeaderChunk) Assertions.e(this.f24301e)).a()) {
                            this.f24299c = 4;
                            this.f24304h = this.f24308l;
                            return 0;
                        }
                        this.f24300d.u(new SeekMap.Unseekable(this.f24302f));
                        this.f24310n = true;
                    }
                    this.f24304h = extractorInput.getPosition() + 12;
                    this.f24299c = 6;
                    return 0;
                } else {
                    this.f24304h = extractorInput.getPosition() + ((long) this.f24298b.f24314b) + 8;
                    return 0;
                }
            case 4:
                extractorInput.readFully(this.f24297a.e(), 0, 8);
                this.f24297a.U(0);
                int u3 = this.f24297a.u();
                int u4 = this.f24297a.u();
                if (u3 == 829973609) {
                    this.f24299c = 5;
                    this.f24309m = u4;
                } else {
                    this.f24304h = extractorInput.getPosition() + ((long) u4);
                }
                return 0;
            case 5:
                ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.f24309m);
                extractorInput.readFully(parsableByteArray2.e(), 0, this.f24309m);
                h(parsableByteArray2);
                this.f24299c = 6;
                this.f24304h = this.f24307k;
                return 0;
            case 6:
                return l(extractorInput);
            default:
                throw new AssertionError();
        }
    }

    public void release() {
    }
}
