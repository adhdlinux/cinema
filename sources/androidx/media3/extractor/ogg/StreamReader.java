package androidx.media3.extractor.ogg;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

abstract class StreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final OggPacket f8747a = new OggPacket();

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f8748b;

    /* renamed from: c  reason: collision with root package name */
    private ExtractorOutput f8749c;

    /* renamed from: d  reason: collision with root package name */
    private OggSeeker f8750d;

    /* renamed from: e  reason: collision with root package name */
    private long f8751e;

    /* renamed from: f  reason: collision with root package name */
    private long f8752f;

    /* renamed from: g  reason: collision with root package name */
    private long f8753g;

    /* renamed from: h  reason: collision with root package name */
    private int f8754h;

    /* renamed from: i  reason: collision with root package name */
    private int f8755i;

    /* renamed from: j  reason: collision with root package name */
    private SetupData f8756j = new SetupData();

    /* renamed from: k  reason: collision with root package name */
    private long f8757k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8758l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f8759m;

    static class SetupData {

        /* renamed from: a  reason: collision with root package name */
        Format f8760a;

        /* renamed from: b  reason: collision with root package name */
        OggSeeker f8761b;

        SetupData() {
        }
    }

    private static final class UnseekableOggSeeker implements OggSeeker {
        private UnseekableOggSeeker() {
        }

        public long a(ExtractorInput extractorInput) {
            return -1;
        }

        public SeekMap b() {
            return new SeekMap.Unseekable(-9223372036854775807L);
        }

        public void c(long j2) {
        }
    }

    @EnsuresNonNull({"trackOutput", "extractorOutput"})
    private void a() {
        Assertions.j(this.f8748b);
        Util.i(this.f8749c);
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = true)
    private boolean i(ExtractorInput extractorInput) throws IOException {
        while (this.f8747a.d(extractorInput)) {
            this.f8757k = extractorInput.getPosition() - this.f8752f;
            if (!h(this.f8747a.c(), this.f8752f, this.f8756j)) {
                return true;
            }
            this.f8752f = extractorInput.getPosition();
        }
        this.f8754h = 3;
        return false;
    }

    @RequiresNonNull({"trackOutput"})
    private int j(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        if (!i(extractorInput)) {
            return -1;
        }
        Format format = this.f8756j.f8760a;
        this.f8755i = format.C;
        if (!this.f8759m) {
            this.f8748b.c(format);
            this.f8759m = true;
        }
        OggSeeker oggSeeker = this.f8756j.f8761b;
        if (oggSeeker != null) {
            this.f8750d = oggSeeker;
        } else if (extractorInput.getLength() == -1) {
            this.f8750d = new UnseekableOggSeeker();
        } else {
            OggPageHeader b2 = this.f8747a.b();
            if ((b2.f8734b & 4) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f8750d = new DefaultOggSeeker(this, this.f8752f, extractorInput.getLength(), (long) (b2.f8740h + b2.f8741i), b2.f8735c, z2);
        }
        this.f8754h = 2;
        this.f8747a.f();
        return 0;
    }

    @RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    private int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ExtractorInput extractorInput2 = extractorInput;
        long a2 = this.f8750d.a(extractorInput2);
        if (a2 >= 0) {
            positionHolder.f8069a = a2;
            return 1;
        }
        if (a2 < -1) {
            e(-(a2 + 2));
        }
        if (!this.f8758l) {
            this.f8749c.r((SeekMap) Assertions.j(this.f8750d.b()));
            this.f8758l = true;
        }
        if (this.f8757k > 0 || this.f8747a.d(extractorInput2)) {
            this.f8757k = 0;
            ParsableByteArray c2 = this.f8747a.c();
            long f2 = f(c2);
            if (f2 >= 0) {
                long j2 = this.f8753g;
                if (j2 + f2 >= this.f8751e) {
                    long b2 = b(j2);
                    this.f8748b.b(c2, c2.g());
                    this.f8748b.f(b2, 1, c2.g(), 0, (TrackOutput.CryptoData) null);
                    this.f8751e = -1;
                }
            }
            this.f8753g += f2;
            return 0;
        }
        this.f8754h = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    public long b(long j2) {
        return (j2 * 1000000) / ((long) this.f8755i);
    }

    /* access modifiers changed from: protected */
    public long c(long j2) {
        return (((long) this.f8755i) * j2) / 1000000;
    }

    /* access modifiers changed from: package-private */
    public void d(ExtractorOutput extractorOutput, TrackOutput trackOutput) {
        this.f8749c = extractorOutput;
        this.f8748b = trackOutput;
        l(true);
    }

    /* access modifiers changed from: protected */
    public void e(long j2) {
        this.f8753g = j2;
    }

    /* access modifiers changed from: protected */
    public abstract long f(ParsableByteArray parsableByteArray);

    /* access modifiers changed from: package-private */
    public final int g(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        a();
        int i2 = this.f8754h;
        if (i2 == 0) {
            return j(extractorInput);
        }
        if (i2 == 1) {
            extractorInput.k((int) this.f8752f);
            this.f8754h = 2;
            return 0;
        } else if (i2 == 2) {
            Util.i(this.f8750d);
            return k(extractorInput, positionHolder);
        } else if (i2 == 3) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean h(ParsableByteArray parsableByteArray, long j2, SetupData setupData) throws IOException;

    /* access modifiers changed from: protected */
    public void l(boolean z2) {
        if (z2) {
            this.f8756j = new SetupData();
            this.f8752f = 0;
            this.f8754h = 0;
        } else {
            this.f8754h = 1;
        }
        this.f8751e = -1;
        this.f8753g = 0;
    }

    /* access modifiers changed from: package-private */
    public final void m(long j2, long j3) {
        this.f8747a.e();
        if (j2 == 0) {
            l(!this.f8758l);
        } else if (this.f8754h != 0) {
            this.f8751e = c(j3);
            ((OggSeeker) Util.i(this.f8750d)).c(this.f8751e);
            this.f8754h = 2;
        }
    }
}
