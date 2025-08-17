package androidx.media3.extractor.avi;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.NoOpExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class AviExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f8139a;

    /* renamed from: b  reason: collision with root package name */
    private final ChunkHeaderHolder f8140b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8141c;

    /* renamed from: d  reason: collision with root package name */
    private final SubtitleParser.Factory f8142d;

    /* renamed from: e  reason: collision with root package name */
    private int f8143e;

    /* renamed from: f  reason: collision with root package name */
    private ExtractorOutput f8144f;

    /* renamed from: g  reason: collision with root package name */
    private AviMainHeaderChunk f8145g;

    /* renamed from: h  reason: collision with root package name */
    private long f8146h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ChunkReader[] f8147i;

    /* renamed from: j  reason: collision with root package name */
    private long f8148j;

    /* renamed from: k  reason: collision with root package name */
    private ChunkReader f8149k;

    /* renamed from: l  reason: collision with root package name */
    private int f8150l;

    /* renamed from: m  reason: collision with root package name */
    private long f8151m;

    /* renamed from: n  reason: collision with root package name */
    private long f8152n;

    /* renamed from: o  reason: collision with root package name */
    private int f8153o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f8154p;

    private class AviSeekMap implements SeekMap {

        /* renamed from: a  reason: collision with root package name */
        private final long f8155a;

        public AviSeekMap(long j2) {
            this.f8155a = j2;
        }

        public SeekMap.SeekPoints d(long j2) {
            SeekMap.SeekPoints i2 = AviExtractor.this.f8147i[0].i(j2);
            for (int i3 = 1; i3 < AviExtractor.this.f8147i.length; i3++) {
                SeekMap.SeekPoints i4 = AviExtractor.this.f8147i[i3].i(j2);
                if (i4.f8070a.f8076b < i2.f8070a.f8076b) {
                    i2 = i4;
                }
            }
            return i2;
        }

        public boolean f() {
            return true;
        }

        public long h() {
            return this.f8155a;
        }
    }

    private static class ChunkHeaderHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f8157a;

        /* renamed from: b  reason: collision with root package name */
        public int f8158b;

        /* renamed from: c  reason: collision with root package name */
        public int f8159c;

        private ChunkHeaderHolder() {
        }

        public void a(ParsableByteArray parsableByteArray) {
            this.f8157a = parsableByteArray.u();
            this.f8158b = parsableByteArray.u();
            this.f8159c = 0;
        }

        public void b(ParsableByteArray parsableByteArray) throws ParserException {
            a(parsableByteArray);
            if (this.f8157a == 1414744396) {
                this.f8159c = parsableByteArray.u();
                return;
            }
            throw ParserException.a("LIST expected, found: " + this.f8157a, (Throwable) null);
        }
    }

    @Deprecated
    public AviExtractor() {
        this(1, SubtitleParser.Factory.f8798a);
    }

    private static void d(ExtractorInput extractorInput) throws IOException {
        if ((extractorInput.getPosition() & 1) == 1) {
            extractorInput.k(1);
        }
    }

    private ChunkReader e(int i2) {
        for (ChunkReader chunkReader : this.f8147i) {
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
                this.f8145g = aviMainHeaderChunk;
                this.f8146h = ((long) aviMainHeaderChunk.f8162c) * ((long) aviMainHeaderChunk.f8160a);
                ArrayList arrayList = new ArrayList();
                UnmodifiableIterator<AviChunk> h2 = c2.f8182a.iterator();
                int i2 = 0;
                while (h2.hasNext()) {
                    AviChunk next = h2.next();
                    if (next.getType() == 1819440243) {
                        int i3 = i2 + 1;
                        ChunkReader m2 = m((ListChunk) next, i2);
                        if (m2 != null) {
                            arrayList.add(m2);
                        }
                        i2 = i3;
                    }
                }
                this.f8147i = (ChunkReader[]) arrayList.toArray(new ChunkReader[0]);
                this.f8144f.m();
                return;
            }
            throw ParserException.a("AviHeader not found", (Throwable) null);
        }
        throw ParserException.a("Unexpected header list type " + c2.getType(), (Throwable) null);
    }

    private void h(ParsableByteArray parsableByteArray) {
        long l2 = l(parsableByteArray);
        while (parsableByteArray.a() >= 16) {
            int u2 = parsableByteArray.u();
            int u3 = parsableByteArray.u();
            long u4 = ((long) parsableByteArray.u()) + l2;
            parsableByteArray.u();
            ChunkReader e2 = e(u2);
            if (e2 != null) {
                if ((u3 & 16) == 16) {
                    e2.b(u4);
                }
                e2.k();
            }
        }
        for (ChunkReader c2 : this.f8147i) {
            c2.c();
        }
        this.f8154p = true;
        this.f8144f.r(new AviSeekMap(this.f8146h));
    }

    private long l(ParsableByteArray parsableByteArray) {
        long j2 = 0;
        if (parsableByteArray.a() < 16) {
            return 0;
        }
        int f2 = parsableByteArray.f();
        parsableByteArray.V(8);
        long j3 = this.f8151m;
        if (((long) parsableByteArray.u()) <= j3) {
            j2 = j3 + 8;
        }
        parsableByteArray.U(f2);
        return j2;
    }

    private ChunkReader m(ListChunk listChunk, int i2) {
        AviStreamHeaderChunk aviStreamHeaderChunk = (AviStreamHeaderChunk) listChunk.b(AviStreamHeaderChunk.class);
        StreamFormatChunk streamFormatChunk = (StreamFormatChunk) listChunk.b(StreamFormatChunk.class);
        if (aviStreamHeaderChunk == null) {
            Log.h("AviExtractor", "Missing Stream Header");
            return null;
        } else if (streamFormatChunk == null) {
            Log.h("AviExtractor", "Missing Stream Format");
            return null;
        } else {
            long a2 = aviStreamHeaderChunk.a();
            Format format = streamFormatChunk.f8184a;
            Format.Builder a3 = format.a();
            a3.Z(i2);
            int i3 = aviStreamHeaderChunk.f8169f;
            if (i3 != 0) {
                a3.f0(i3);
            }
            StreamNameChunk streamNameChunk = (StreamNameChunk) listChunk.b(StreamNameChunk.class);
            if (streamNameChunk != null) {
                a3.c0(streamNameChunk.f8185a);
            }
            int k2 = MimeTypes.k(format.f4015n);
            if (k2 != 1 && k2 != 2) {
                return null;
            }
            TrackOutput d2 = this.f8144f.d(i2, k2);
            d2.c(a3.K());
            ChunkReader chunkReader = new ChunkReader(i2, k2, a2, aviStreamHeaderChunk.f8168e, d2);
            this.f8146h = a2;
            return chunkReader;
        }
    }

    private int n(ExtractorInput extractorInput) throws IOException {
        if (extractorInput.getPosition() >= this.f8152n) {
            return -1;
        }
        ChunkReader chunkReader = this.f8149k;
        if (chunkReader == null) {
            d(extractorInput);
            int i2 = 12;
            extractorInput.m(this.f8139a.e(), 0, 12);
            this.f8139a.U(0);
            int u2 = this.f8139a.u();
            if (u2 == 1414744396) {
                this.f8139a.U(8);
                if (this.f8139a.u() != 1769369453) {
                    i2 = 8;
                }
                extractorInput.k(i2);
                extractorInput.e();
                return 0;
            }
            int u3 = this.f8139a.u();
            if (u2 == 1263424842) {
                this.f8148j = extractorInput.getPosition() + ((long) u3) + 8;
                return 0;
            }
            extractorInput.k(8);
            extractorInput.e();
            ChunkReader e2 = e(u2);
            if (e2 == null) {
                this.f8148j = extractorInput.getPosition() + ((long) u3);
                return 0;
            }
            e2.n(u3);
            this.f8149k = e2;
        } else if (chunkReader.m(extractorInput)) {
            this.f8149k = null;
        }
        return 0;
    }

    private boolean o(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        if (this.f8148j != -1) {
            long position = extractorInput.getPosition();
            long j2 = this.f8148j;
            if (j2 < position || j2 > 262144 + position) {
                positionHolder.f8069a = j2;
                z2 = true;
                this.f8148j = -1;
                return z2;
            }
            extractorInput.k((int) (j2 - position));
        }
        z2 = false;
        this.f8148j = -1;
        return z2;
    }

    public void a(long j2, long j3) {
        this.f8148j = -1;
        this.f8149k = null;
        for (ChunkReader o2 : this.f8147i) {
            o2.o(j2);
        }
        if (j2 != 0) {
            this.f8143e = 6;
        } else if (this.f8147i.length == 0) {
            this.f8143e = 0;
        } else {
            this.f8143e = 3;
        }
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f8143e = 0;
        if (this.f8141c) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f8142d);
        }
        this.f8144f = extractorOutput;
        this.f8148j = -1;
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        extractorInput.m(this.f8139a.e(), 0, 12);
        this.f8139a.U(0);
        if (this.f8139a.u() != 1179011410) {
            return false;
        }
        this.f8139a.V(4);
        if (this.f8139a.u() == 541677121) {
            return true;
        }
        return false;
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        if (o(extractorInput, positionHolder)) {
            return 1;
        }
        switch (this.f8143e) {
            case 0:
                if (i(extractorInput)) {
                    extractorInput.k(12);
                    this.f8143e = 1;
                    return 0;
                }
                throw ParserException.a("AVI Header List not found", (Throwable) null);
            case 1:
                extractorInput.readFully(this.f8139a.e(), 0, 12);
                this.f8139a.U(0);
                this.f8140b.b(this.f8139a);
                ChunkHeaderHolder chunkHeaderHolder = this.f8140b;
                if (chunkHeaderHolder.f8159c == 1819436136) {
                    this.f8150l = chunkHeaderHolder.f8158b;
                    this.f8143e = 2;
                    return 0;
                }
                throw ParserException.a("hdrl expected, found: " + this.f8140b.f8159c, (Throwable) null);
            case 2:
                int i2 = this.f8150l - 4;
                ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
                extractorInput.readFully(parsableByteArray.e(), 0, i2);
                f(parsableByteArray);
                this.f8143e = 3;
                return 0;
            case 3:
                if (this.f8151m != -1) {
                    long position = extractorInput.getPosition();
                    long j2 = this.f8151m;
                    if (position != j2) {
                        this.f8148j = j2;
                        return 0;
                    }
                }
                extractorInput.m(this.f8139a.e(), 0, 12);
                extractorInput.e();
                this.f8139a.U(0);
                this.f8140b.a(this.f8139a);
                int u2 = this.f8139a.u();
                int i3 = this.f8140b.f8157a;
                if (i3 == 1179011410) {
                    extractorInput.k(12);
                    return 0;
                } else if (i3 == 1414744396 && u2 == 1769369453) {
                    long position2 = extractorInput.getPosition();
                    this.f8151m = position2;
                    this.f8152n = position2 + ((long) this.f8140b.f8158b) + 8;
                    if (!this.f8154p) {
                        if (((AviMainHeaderChunk) Assertions.f(this.f8145g)).a()) {
                            this.f8143e = 4;
                            this.f8148j = this.f8152n;
                            return 0;
                        }
                        this.f8144f.r(new SeekMap.Unseekable(this.f8146h));
                        this.f8154p = true;
                    }
                    this.f8148j = extractorInput.getPosition() + 12;
                    this.f8143e = 6;
                    return 0;
                } else {
                    this.f8148j = extractorInput.getPosition() + ((long) this.f8140b.f8158b) + 8;
                    return 0;
                }
            case 4:
                extractorInput.readFully(this.f8139a.e(), 0, 8);
                this.f8139a.U(0);
                int u3 = this.f8139a.u();
                int u4 = this.f8139a.u();
                if (u3 == 829973609) {
                    this.f8143e = 5;
                    this.f8153o = u4;
                } else {
                    this.f8148j = extractorInput.getPosition() + ((long) u4);
                }
                return 0;
            case 5:
                ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.f8153o);
                extractorInput.readFully(parsableByteArray2.e(), 0, this.f8153o);
                h(parsableByteArray2);
                this.f8143e = 6;
                this.f8148j = this.f8151m;
                return 0;
            case 6:
                return n(extractorInput);
            default:
                throw new AssertionError();
        }
    }

    public void release() {
    }

    public AviExtractor(int i2, SubtitleParser.Factory factory) {
        this.f8142d = factory;
        this.f8141c = (i2 & 1) != 0 ? false : true;
        this.f8139a = new ParsableByteArray(12);
        this.f8140b = new ChunkHeaderHolder();
        this.f8144f = new NoOpExtractorOutput();
        this.f8147i = new ChunkReader[0];
        this.f8151m = -1;
        this.f8152n = -1;
        this.f8150l = -1;
        this.f8146h = -9223372036854775807L;
    }
}
