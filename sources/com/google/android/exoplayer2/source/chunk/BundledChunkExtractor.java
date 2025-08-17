package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class BundledChunkExtractor implements ExtractorOutput, ChunkExtractor {

    /* renamed from: k  reason: collision with root package name */
    public static final ChunkExtractor.Factory f26060k = new a();

    /* renamed from: l  reason: collision with root package name */
    private static final PositionHolder f26061l = new PositionHolder();

    /* renamed from: b  reason: collision with root package name */
    private final Extractor f26062b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26063c;

    /* renamed from: d  reason: collision with root package name */
    private final Format f26064d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<BindingTrackOutput> f26065e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f26066f;

    /* renamed from: g  reason: collision with root package name */
    private ChunkExtractor.TrackOutputProvider f26067g;

    /* renamed from: h  reason: collision with root package name */
    private long f26068h;

    /* renamed from: i  reason: collision with root package name */
    private SeekMap f26069i;

    /* renamed from: j  reason: collision with root package name */
    private Format[] f26070j;

    private static final class BindingTrackOutput implements TrackOutput {

        /* renamed from: a  reason: collision with root package name */
        private final int f26071a;

        /* renamed from: b  reason: collision with root package name */
        private final int f26072b;

        /* renamed from: c  reason: collision with root package name */
        private final Format f26073c;

        /* renamed from: d  reason: collision with root package name */
        private final DummyTrackOutput f26074d = new DummyTrackOutput();

        /* renamed from: e  reason: collision with root package name */
        public Format f26075e;

        /* renamed from: f  reason: collision with root package name */
        private TrackOutput f26076f;

        /* renamed from: g  reason: collision with root package name */
        private long f26077g;

        public BindingTrackOutput(int i2, int i3, Format format) {
            this.f26071a = i2;
            this.f26072b = i3;
            this.f26073c = format;
        }

        public int a(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
            return ((TrackOutput) Util.j(this.f26076f)).b(dataReader, i2, z2);
        }

        public /* synthetic */ int b(DataReader dataReader, int i2, boolean z2) {
            return f.a(this, dataReader, i2, z2);
        }

        public /* synthetic */ void c(ParsableByteArray parsableByteArray, int i2) {
            f.b(this, parsableByteArray, i2);
        }

        public void d(Format format) {
            Format format2 = this.f26073c;
            if (format2 != null) {
                format = format.k(format2);
            }
            this.f26075e = format;
            ((TrackOutput) Util.j(this.f26076f)).d(this.f26075e);
        }

        public void e(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            long j3 = this.f26077g;
            if (j3 != -9223372036854775807L && j2 >= j3) {
                this.f26076f = this.f26074d;
            }
            ((TrackOutput) Util.j(this.f26076f)).e(j2, i2, i3, i4, cryptoData);
        }

        public void f(ParsableByteArray parsableByteArray, int i2, int i3) {
            ((TrackOutput) Util.j(this.f26076f)).c(parsableByteArray, i2);
        }

        public void g(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j2) {
            if (trackOutputProvider == null) {
                this.f26076f = this.f26074d;
                return;
            }
            this.f26077g = j2;
            TrackOutput d2 = trackOutputProvider.d(this.f26071a, this.f26072b);
            this.f26076f = d2;
            Format format = this.f26075e;
            if (format != null) {
                d2.d(format);
            }
        }
    }

    public BundledChunkExtractor(Extractor extractor, int i2, Format format) {
        this.f26062b = extractor;
        this.f26063c = i2;
        this.f26064d = format;
    }

    /* JADX WARNING: type inference failed for: r8v5, types: [com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ com.google.android.exoplayer2.source.chunk.ChunkExtractor g(int r6, com.google.android.exoplayer2.Format r7, boolean r8, java.util.List r9, com.google.android.exoplayer2.extractor.TrackOutput r10, com.google.android.exoplayer2.analytics.PlayerId r11) {
        /*
            java.lang.String r11 = r7.f23070l
            boolean r0 = com.google.android.exoplayer2.util.MimeTypes.r(r11)
            if (r0 == 0) goto L_0x000a
            r6 = 0
            return r6
        L_0x000a:
            boolean r11 = com.google.android.exoplayer2.util.MimeTypes.q(r11)
            if (r11 == 0) goto L_0x0017
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor r8 = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor
            r9 = 1
            r8.<init>(r9)
            goto L_0x0028
        L_0x0017:
            if (r8 == 0) goto L_0x001c
            r8 = 4
            r1 = 4
            goto L_0x001e
        L_0x001c:
            r8 = 0
            r1 = 0
        L_0x001e:
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor r8 = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor
            r2 = 0
            r3 = 0
            r0 = r8
            r4 = r9
            r5 = r10
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0028:
            com.google.android.exoplayer2.source.chunk.BundledChunkExtractor r9 = new com.google.android.exoplayer2.source.chunk.BundledChunkExtractor
            r9.<init>(r8, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.BundledChunkExtractor.g(int, com.google.android.exoplayer2.Format, boolean, java.util.List, com.google.android.exoplayer2.extractor.TrackOutput, com.google.android.exoplayer2.analytics.PlayerId):com.google.android.exoplayer2.source.chunk.ChunkExtractor");
    }

    public boolean a(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        int i2 = this.f26062b.i(extractorInput, f26061l);
        if (i2 != 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (i2 == 0) {
            return true;
        }
        return false;
    }

    public ChunkIndex b() {
        SeekMap seekMap = this.f26069i;
        if (seekMap instanceof ChunkIndex) {
            return (ChunkIndex) seekMap;
        }
        return null;
    }

    public Format[] c() {
        return this.f26070j;
    }

    public TrackOutput d(int i2, int i3) {
        boolean z2;
        Format format;
        BindingTrackOutput bindingTrackOutput = this.f26065e.get(i2);
        if (bindingTrackOutput == null) {
            if (this.f26070j == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            if (i3 == this.f26063c) {
                format = this.f26064d;
            } else {
                format = null;
            }
            bindingTrackOutput = new BindingTrackOutput(i2, i3, format);
            bindingTrackOutput.g(this.f26067g, this.f26068h);
            this.f26065e.put(i2, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }

    public void e(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j2, long j3) {
        this.f26067g = trackOutputProvider;
        this.f26068h = j3;
        if (!this.f26066f) {
            this.f26062b.c(this);
            if (j2 != -9223372036854775807L) {
                this.f26062b.a(0, j2);
            }
            this.f26066f = true;
            return;
        }
        Extractor extractor = this.f26062b;
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        extractor.a(0, j2);
        for (int i2 = 0; i2 < this.f26065e.size(); i2++) {
            this.f26065e.valueAt(i2).g(trackOutputProvider, j3);
        }
    }

    public void m() {
        Format[] formatArr = new Format[this.f26065e.size()];
        for (int i2 = 0; i2 < this.f26065e.size(); i2++) {
            formatArr[i2] = (Format) Assertions.i(this.f26065e.valueAt(i2).f26075e);
        }
        this.f26070j = formatArr;
    }

    public void release() {
        this.f26062b.release();
    }

    public void u(SeekMap seekMap) {
        this.f26069i = seekMap;
    }
}
