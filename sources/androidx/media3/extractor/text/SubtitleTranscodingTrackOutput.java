package androidx.media3.extractor.text;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.g;
import androidx.media3.extractor.text.SubtitleParser;
import com.facebook.common.time.Clock;
import java.io.EOFException;
import java.io.IOException;

final class SubtitleTranscodingTrackOutput implements TrackOutput {

    /* renamed from: a  reason: collision with root package name */
    private final TrackOutput f8808a;

    /* renamed from: b  reason: collision with root package name */
    private final SubtitleParser.Factory f8809b;

    /* renamed from: c  reason: collision with root package name */
    private final CueEncoder f8810c = new CueEncoder();

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f8811d = new ParsableByteArray();

    /* renamed from: e  reason: collision with root package name */
    private int f8812e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f8813f = 0;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f8814g = Util.f4719f;

    /* renamed from: h  reason: collision with root package name */
    private SubtitleParser f8815h;

    /* renamed from: i  reason: collision with root package name */
    private Format f8816i;

    public SubtitleTranscodingTrackOutput(TrackOutput trackOutput, SubtitleParser.Factory factory) {
        this.f8808a = trackOutput;
        this.f8809b = factory;
    }

    private void h(int i2) {
        byte[] bArr;
        int length = this.f8814g.length;
        int i3 = this.f8813f;
        if (length - i3 < i2) {
            int i4 = i3 - this.f8812e;
            int max = Math.max(i4 * 2, i2 + i4);
            byte[] bArr2 = this.f8814g;
            if (max <= bArr2.length) {
                bArr = bArr2;
            } else {
                bArr = new byte[max];
            }
            System.arraycopy(bArr2, this.f8812e, bArr, 0, i4);
            this.f8812e = 0;
            this.f8813f = i4;
            this.f8814g = bArr;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void i(CuesWithTiming cuesWithTiming, long j2, int i2) {
        boolean z2;
        Assertions.j(this.f8816i);
        byte[] a2 = this.f8810c.a(cuesWithTiming.f8773a, cuesWithTiming.f8775c);
        this.f8811d.R(a2);
        this.f8808a.b(this.f8811d, a2.length);
        long j3 = cuesWithTiming.f8774b;
        if (j3 == -9223372036854775807L) {
            if (this.f8816i.f4020s == Clock.MAX_TIME) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
        } else {
            long j4 = this.f8816i.f4020s;
            if (j4 == Clock.MAX_TIME) {
                j2 += j3;
            } else {
                j2 = j3 + j4;
            }
        }
        this.f8808a.f(j2, i2, a2.length, 0, (TrackOutput.CryptoData) null);
    }

    public void a(ParsableByteArray parsableByteArray, int i2, int i3) {
        if (this.f8815h == null) {
            this.f8808a.a(parsableByteArray, i2, i3);
            return;
        }
        h(i2);
        parsableByteArray.l(this.f8814g, this.f8813f, i2);
        this.f8813f += i2;
    }

    public /* synthetic */ void b(ParsableByteArray parsableByteArray, int i2) {
        g.b(this, parsableByteArray, i2);
    }

    public void c(Format format) {
        boolean z2;
        SubtitleParser subtitleParser;
        Assertions.f(format.f4015n);
        if (MimeTypes.k(format.f4015n) == 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (!format.equals(this.f8816i)) {
            this.f8816i = format;
            if (this.f8809b.c(format)) {
                subtitleParser = this.f8809b.b(format);
            } else {
                subtitleParser = null;
            }
            this.f8815h = subtitleParser;
        }
        if (this.f8815h == null) {
            this.f8808a.c(format);
        } else {
            this.f8808a.c(format.a().o0("application/x-media3-cues").O(format.f4015n).s0(Clock.MAX_TIME).S(this.f8809b.a(format)).K());
        }
    }

    public /* synthetic */ int d(DataReader dataReader, int i2, boolean z2) {
        return g.a(this, dataReader, i2, z2);
    }

    public int e(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
        if (this.f8815h == null) {
            return this.f8808a.e(dataReader, i2, z2, i3);
        }
        h(i2);
        int read = dataReader.read(this.f8814g, this.f8813f, i2);
        if (read != -1) {
            this.f8813f += read;
            return read;
        } else if (z2) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public void f(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
        boolean z2;
        if (this.f8815h == null) {
            this.f8808a.f(j2, i2, i3, i4, cryptoData);
            return;
        }
        if (cryptoData == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.b(z2, "DRM on subtitles is not supported");
        int i5 = (this.f8813f - i4) - i3;
        this.f8815h.a(this.f8814g, i5, i3, SubtitleParser.OutputOptions.b(), new g(this, j2, i2));
        int i6 = i5 + i3;
        this.f8812e = i6;
        if (i6 == this.f8813f) {
            this.f8812e = 0;
            this.f8813f = 0;
        }
    }

    public void k() {
        SubtitleParser subtitleParser = this.f8815h;
        if (subtitleParser != null) {
            subtitleParser.reset();
        }
    }
}
