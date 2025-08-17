package androidx.media3.exoplayer.source.chunk;

import android.util.SparseArray;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.g;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleParser;
import com.facebook.common.time.Clock;
import java.io.IOException;

public final class BundledChunkExtractor implements ExtractorOutput, ChunkExtractor {

    /* renamed from: k  reason: collision with root package name */
    public static final Factory f7197k = new Factory();

    /* renamed from: l  reason: collision with root package name */
    private static final PositionHolder f7198l = new PositionHolder();

    /* renamed from: b  reason: collision with root package name */
    private final Extractor f7199b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7200c;

    /* renamed from: d  reason: collision with root package name */
    private final Format f7201d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<BindingTrackOutput> f7202e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f7203f;

    /* renamed from: g  reason: collision with root package name */
    private ChunkExtractor.TrackOutputProvider f7204g;

    /* renamed from: h  reason: collision with root package name */
    private long f7205h;

    /* renamed from: i  reason: collision with root package name */
    private SeekMap f7206i;

    /* renamed from: j  reason: collision with root package name */
    private Format[] f7207j;

    private static final class BindingTrackOutput implements TrackOutput {

        /* renamed from: a  reason: collision with root package name */
        private final int f7208a;

        /* renamed from: b  reason: collision with root package name */
        private final int f7209b;

        /* renamed from: c  reason: collision with root package name */
        private final Format f7210c;

        /* renamed from: d  reason: collision with root package name */
        private final DiscardingTrackOutput f7211d = new DiscardingTrackOutput();

        /* renamed from: e  reason: collision with root package name */
        public Format f7212e;

        /* renamed from: f  reason: collision with root package name */
        private TrackOutput f7213f;

        /* renamed from: g  reason: collision with root package name */
        private long f7214g;

        public BindingTrackOutput(int i2, int i3, Format format) {
            this.f7208a = i2;
            this.f7209b = i3;
            this.f7210c = format;
        }

        public void a(ParsableByteArray parsableByteArray, int i2, int i3) {
            ((TrackOutput) Util.i(this.f7213f)).b(parsableByteArray, i2);
        }

        public /* synthetic */ void b(ParsableByteArray parsableByteArray, int i2) {
            g.b(this, parsableByteArray, i2);
        }

        public void c(Format format) {
            Format format2 = this.f7210c;
            if (format2 != null) {
                format = format.h(format2);
            }
            this.f7212e = format;
            ((TrackOutput) Util.i(this.f7213f)).c(this.f7212e);
        }

        public /* synthetic */ int d(DataReader dataReader, int i2, boolean z2) {
            return g.a(this, dataReader, i2, z2);
        }

        public int e(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
            return ((TrackOutput) Util.i(this.f7213f)).d(dataReader, i2, z2);
        }

        public void f(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            long j3 = this.f7214g;
            if (j3 != -9223372036854775807L && j2 >= j3) {
                this.f7213f = this.f7211d;
            }
            ((TrackOutput) Util.i(this.f7213f)).f(j2, i2, i3, i4, cryptoData);
        }

        public void g(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j2) {
            if (trackOutputProvider == null) {
                this.f7213f = this.f7211d;
                return;
            }
            this.f7214g = j2;
            TrackOutput d2 = trackOutputProvider.d(this.f7208a, this.f7209b);
            this.f7213f = d2;
            Format format = this.f7212e;
            if (format != null) {
                d2.c(format);
            }
        }
    }

    public static final class Factory implements ChunkExtractor.Factory {

        /* renamed from: a  reason: collision with root package name */
        private SubtitleParser.Factory f7215a = new DefaultSubtitleParserFactory();

        /* renamed from: b  reason: collision with root package name */
        private boolean f7216b;

        public Format c(Format format) {
            String str;
            if (!this.f7216b || !this.f7215a.c(format)) {
                return format;
            }
            Format.Builder S = format.a().o0("application/x-media3-cues").S(this.f7215a.a(format));
            StringBuilder sb = new StringBuilder();
            sb.append(format.f4015n);
            if (format.f4011j != null) {
                str = " " + format.f4011j;
            } else {
                str = "";
            }
            sb.append(str);
            return S.O(sb.toString()).s0(Clock.MAX_TIME).K();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: androidx.media3.extractor.text.SubtitleTranscodingExtractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: androidx.media3.extractor.text.SubtitleTranscodingExtractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: androidx.media3.extractor.jpeg.JpegExtractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: androidx.media3.extractor.mkv.MatroskaExtractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: androidx.media3.extractor.text.SubtitleExtractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX WARNING: type inference failed for: r10v10, types: [androidx.media3.extractor.png.PngExtractor] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.media3.exoplayer.source.chunk.ChunkExtractor d(int r8, androidx.media3.common.Format r9, boolean r10, java.util.List<androidx.media3.common.Format> r11, androidx.media3.extractor.TrackOutput r12, androidx.media3.exoplayer.analytics.PlayerId r13) {
            /*
                r7 = this;
                java.lang.String r13 = r9.f4014m
                boolean r0 = androidx.media3.common.MimeTypes.r(r13)
                if (r0 == 0) goto L_0x001a
                boolean r10 = r7.f7216b
                if (r10 != 0) goto L_0x000e
                r8 = 0
                return r8
            L_0x000e:
                androidx.media3.extractor.text.SubtitleExtractor r10 = new androidx.media3.extractor.text.SubtitleExtractor
                androidx.media3.extractor.text.SubtitleParser$Factory r11 = r7.f7215a
                androidx.media3.extractor.text.SubtitleParser r11 = r11.b(r9)
                r10.<init>(r11, r9)
                goto L_0x0062
            L_0x001a:
                boolean r0 = androidx.media3.common.MimeTypes.q(r13)
                r1 = 1
                if (r0 == 0) goto L_0x002e
                boolean r10 = r7.f7216b
                if (r10 != 0) goto L_0x0026
                r1 = 3
            L_0x0026:
                androidx.media3.extractor.mkv.MatroskaExtractor r10 = new androidx.media3.extractor.mkv.MatroskaExtractor
                androidx.media3.extractor.text.SubtitleParser$Factory r11 = r7.f7215a
                r10.<init>(r11, r1)
                goto L_0x0062
            L_0x002e:
                java.lang.String r0 = "image/jpeg"
                boolean r0 = java.util.Objects.equals(r13, r0)
                if (r0 == 0) goto L_0x003c
                androidx.media3.extractor.jpeg.JpegExtractor r10 = new androidx.media3.extractor.jpeg.JpegExtractor
                r10.<init>(r1)
                goto L_0x0062
            L_0x003c:
                java.lang.String r0 = "image/png"
                boolean r0 = java.util.Objects.equals(r13, r0)
                if (r0 == 0) goto L_0x004a
                androidx.media3.extractor.png.PngExtractor r10 = new androidx.media3.extractor.png.PngExtractor
                r10.<init>()
                goto L_0x0062
            L_0x004a:
                if (r10 == 0) goto L_0x004e
                r10 = 4
                goto L_0x004f
            L_0x004e:
                r10 = 0
            L_0x004f:
                boolean r0 = r7.f7216b
                if (r0 != 0) goto L_0x0055
                r10 = r10 | 32
            L_0x0055:
                r2 = r10
                androidx.media3.extractor.mp4.FragmentedMp4Extractor r10 = new androidx.media3.extractor.mp4.FragmentedMp4Extractor
                androidx.media3.extractor.text.SubtitleParser$Factory r1 = r7.f7215a
                r3 = 0
                r4 = 0
                r0 = r10
                r5 = r11
                r6 = r12
                r0.<init>(r1, r2, r3, r4, r5, r6)
            L_0x0062:
                boolean r11 = r7.f7216b
                if (r11 == 0) goto L_0x0084
                boolean r11 = androidx.media3.common.MimeTypes.r(r13)
                if (r11 != 0) goto L_0x0084
                androidx.media3.extractor.Extractor r11 = r10.c()
                boolean r11 = r11 instanceof androidx.media3.extractor.mp4.FragmentedMp4Extractor
                if (r11 != 0) goto L_0x0084
                androidx.media3.extractor.Extractor r11 = r10.c()
                boolean r11 = r11 instanceof androidx.media3.extractor.mkv.MatroskaExtractor
                if (r11 != 0) goto L_0x0084
                androidx.media3.extractor.text.SubtitleTranscodingExtractor r11 = new androidx.media3.extractor.text.SubtitleTranscodingExtractor
                androidx.media3.extractor.text.SubtitleParser$Factory r12 = r7.f7215a
                r11.<init>(r10, r12)
                r10 = r11
            L_0x0084:
                androidx.media3.exoplayer.source.chunk.BundledChunkExtractor r11 = new androidx.media3.exoplayer.source.chunk.BundledChunkExtractor
                r11.<init>(r10, r8, r9)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.chunk.BundledChunkExtractor.Factory.d(int, androidx.media3.common.Format, boolean, java.util.List, androidx.media3.extractor.TrackOutput, androidx.media3.exoplayer.analytics.PlayerId):androidx.media3.exoplayer.source.chunk.ChunkExtractor");
        }

        /* renamed from: e */
        public Factory b(boolean z2) {
            this.f7216b = z2;
            return this;
        }

        /* renamed from: f */
        public Factory a(SubtitleParser.Factory factory) {
            this.f7215a = (SubtitleParser.Factory) Assertions.f(factory);
            return this;
        }
    }

    public BundledChunkExtractor(Extractor extractor, int i2, Format format) {
        this.f7199b = extractor;
        this.f7200c = i2;
        this.f7201d = format;
    }

    public boolean a(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        int k2 = this.f7199b.k(extractorInput, f7198l);
        if (k2 != 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (k2 == 0) {
            return true;
        }
        return false;
    }

    public ChunkIndex b() {
        SeekMap seekMap = this.f7206i;
        if (seekMap instanceof ChunkIndex) {
            return (ChunkIndex) seekMap;
        }
        return null;
    }

    public Format[] c() {
        return this.f7207j;
    }

    public TrackOutput d(int i2, int i3) {
        boolean z2;
        Format format;
        BindingTrackOutput bindingTrackOutput = this.f7202e.get(i2);
        if (bindingTrackOutput == null) {
            if (this.f7207j == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            if (i3 == this.f7200c) {
                format = this.f7201d;
            } else {
                format = null;
            }
            bindingTrackOutput = new BindingTrackOutput(i2, i3, format);
            bindingTrackOutput.g(this.f7204g, this.f7205h);
            this.f7202e.put(i2, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }

    public void e(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j2, long j3) {
        this.f7204g = trackOutputProvider;
        this.f7205h = j3;
        if (!this.f7203f) {
            this.f7199b.g(this);
            if (j2 != -9223372036854775807L) {
                this.f7199b.a(0, j2);
            }
            this.f7203f = true;
            return;
        }
        Extractor extractor = this.f7199b;
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        extractor.a(0, j2);
        for (int i2 = 0; i2 < this.f7202e.size(); i2++) {
            this.f7202e.valueAt(i2).g(trackOutputProvider, j3);
        }
    }

    public void m() {
        Format[] formatArr = new Format[this.f7202e.size()];
        for (int i2 = 0; i2 < this.f7202e.size(); i2++) {
            formatArr[i2] = (Format) Assertions.j(this.f7202e.valueAt(i2).f7212e);
        }
        this.f7207j = formatArr;
    }

    public void r(SeekMap seekMap) {
        this.f7206i = seekMap;
    }

    public void release() {
        this.f7199b.release();
    }
}
