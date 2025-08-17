package androidx.media3.extractor.ogg;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;

final class DefaultOggSeeker implements OggSeeker {

    /* renamed from: a  reason: collision with root package name */
    private final OggPageHeader f8705a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f8706b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final long f8707c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final StreamReader f8708d;

    /* renamed from: e  reason: collision with root package name */
    private int f8709e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f8710f;

    /* renamed from: g  reason: collision with root package name */
    private long f8711g;

    /* renamed from: h  reason: collision with root package name */
    private long f8712h;

    /* renamed from: i  reason: collision with root package name */
    private long f8713i;

    /* renamed from: j  reason: collision with root package name */
    private long f8714j;

    /* renamed from: k  reason: collision with root package name */
    private long f8715k;

    /* renamed from: l  reason: collision with root package name */
    private long f8716l;

    private final class OggSeekMap implements SeekMap {
        private OggSeekMap() {
        }

        public SeekMap.SeekPoints d(long j2) {
            return new SeekMap.SeekPoints(new SeekPoint(j2, Util.q((DefaultOggSeeker.this.f8706b + BigInteger.valueOf(DefaultOggSeeker.this.f8708d.c(j2)).multiply(BigInteger.valueOf(DefaultOggSeeker.this.f8707c - DefaultOggSeeker.this.f8706b)).divide(BigInteger.valueOf(DefaultOggSeeker.this.f8710f)).longValue()) - NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS, DefaultOggSeeker.this.f8706b, DefaultOggSeeker.this.f8707c - 1)));
        }

        public boolean f() {
            return true;
        }

        public long h() {
            return DefaultOggSeeker.this.f8708d.b(DefaultOggSeeker.this.f8710f);
        }
    }

    public DefaultOggSeeker(StreamReader streamReader, long j2, long j3, long j4, long j5, boolean z2) {
        boolean z3;
        if (j2 < 0 || j3 <= j2) {
            z3 = false;
        } else {
            z3 = true;
        }
        Assertions.a(z3);
        this.f8708d = streamReader;
        this.f8706b = j2;
        this.f8707c = j3;
        if (j4 == j3 - j2 || z2) {
            this.f8710f = j5;
            this.f8709e = 4;
        } else {
            this.f8709e = 0;
        }
        this.f8705a = new OggPageHeader();
    }

    private long i(ExtractorInput extractorInput) throws IOException {
        long j2;
        ExtractorInput extractorInput2 = extractorInput;
        if (this.f8713i == this.f8714j) {
            return -1;
        }
        long position = extractorInput.getPosition();
        if (!this.f8705a.d(extractorInput2, this.f8714j)) {
            long j3 = this.f8713i;
            if (j3 != position) {
                return j3;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f8705a.a(extractorInput2, false);
        extractorInput.e();
        long j4 = this.f8712h;
        OggPageHeader oggPageHeader = this.f8705a;
        long j5 = oggPageHeader.f8735c;
        long j6 = j4 - j5;
        int i2 = oggPageHeader.f8740h + oggPageHeader.f8741i;
        if (0 <= j6 && j6 < 72000) {
            return -1;
        }
        int i3 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
        if (i3 < 0) {
            this.f8714j = position;
            this.f8716l = j5;
        } else {
            this.f8713i = extractorInput.getPosition() + ((long) i2);
            this.f8715k = this.f8705a.f8735c;
        }
        long j7 = this.f8714j;
        long j8 = this.f8713i;
        if (j7 - j8 < 100000) {
            this.f8714j = j8;
            return j8;
        }
        long j9 = (long) i2;
        if (i3 <= 0) {
            j2 = 2;
        } else {
            j2 = 1;
        }
        long j10 = j9 * j2;
        long j11 = this.f8714j;
        long j12 = this.f8713i;
        return Util.q((extractorInput.getPosition() - j10) + ((j6 * (j11 - j12)) / (this.f8716l - this.f8715k)), j12, j11 - 1);
    }

    private void k(ExtractorInput extractorInput) throws IOException {
        while (true) {
            this.f8705a.c(extractorInput);
            this.f8705a.a(extractorInput, false);
            OggPageHeader oggPageHeader = this.f8705a;
            if (oggPageHeader.f8735c > this.f8712h) {
                extractorInput.e();
                return;
            }
            extractorInput.k(oggPageHeader.f8740h + oggPageHeader.f8741i);
            this.f8713i = extractorInput.getPosition();
            this.f8715k = this.f8705a.f8735c;
        }
    }

    public long a(ExtractorInput extractorInput) throws IOException {
        int i2 = this.f8709e;
        if (i2 == 0) {
            long position = extractorInput.getPosition();
            this.f8711g = position;
            this.f8709e = 1;
            long j2 = this.f8707c - 65307;
            if (j2 > position) {
                return j2;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                long i3 = i(extractorInput);
                if (i3 != -1) {
                    return i3;
                }
                this.f8709e = 3;
            } else if (i2 != 3) {
                if (i2 == 4) {
                    return -1;
                }
                throw new IllegalStateException();
            }
            k(extractorInput);
            this.f8709e = 4;
            return -(this.f8715k + 2);
        }
        this.f8710f = j(extractorInput);
        this.f8709e = 4;
        return this.f8711g;
    }

    public void c(long j2) {
        this.f8712h = Util.q(j2, 0, this.f8710f - 1);
        this.f8709e = 2;
        this.f8713i = this.f8706b;
        this.f8714j = this.f8707c;
        this.f8715k = 0;
        this.f8716l = this.f8710f;
    }

    /* renamed from: h */
    public OggSeekMap b() {
        if (this.f8710f != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public long j(ExtractorInput extractorInput) throws IOException {
        this.f8705a.b();
        if (this.f8705a.c(extractorInput)) {
            this.f8705a.a(extractorInput, false);
            OggPageHeader oggPageHeader = this.f8705a;
            extractorInput.k(oggPageHeader.f8740h + oggPageHeader.f8741i);
            long j2 = this.f8705a.f8735c;
            while (true) {
                OggPageHeader oggPageHeader2 = this.f8705a;
                if ((oggPageHeader2.f8734b & 4) == 4 || !oggPageHeader2.c(extractorInput) || extractorInput.getPosition() >= this.f8707c || !this.f8705a.a(extractorInput, true)) {
                    break;
                }
                OggPageHeader oggPageHeader3 = this.f8705a;
                if (!ExtractorUtil.e(extractorInput, oggPageHeader3.f8740h + oggPageHeader3.f8741i)) {
                    break;
                }
                j2 = this.f8705a.f8735c;
            }
            return j2;
        }
        throw new EOFException();
    }
}
