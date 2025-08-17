package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.io.EOFException;
import java.io.IOException;

final class DefaultOggSeeker implements OggSeeker {

    /* renamed from: a  reason: collision with root package name */
    private final OggPageHeader f24702a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f24703b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final long f24704c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final StreamReader f24705d;

    /* renamed from: e  reason: collision with root package name */
    private int f24706e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f24707f;

    /* renamed from: g  reason: collision with root package name */
    private long f24708g;

    /* renamed from: h  reason: collision with root package name */
    private long f24709h;

    /* renamed from: i  reason: collision with root package name */
    private long f24710i;

    /* renamed from: j  reason: collision with root package name */
    private long f24711j;

    /* renamed from: k  reason: collision with root package name */
    private long f24712k;

    /* renamed from: l  reason: collision with root package name */
    private long f24713l;

    private final class OggSeekMap implements SeekMap {
        private OggSeekMap() {
        }

        public SeekMap.SeekPoints d(long j2) {
            return new SeekMap.SeekPoints(new SeekPoint(j2, Util.r((DefaultOggSeeker.this.f24703b + ((DefaultOggSeeker.this.f24705d.c(j2) * (DefaultOggSeeker.this.f24704c - DefaultOggSeeker.this.f24703b)) / DefaultOggSeeker.this.f24707f)) - NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS, DefaultOggSeeker.this.f24703b, DefaultOggSeeker.this.f24704c - 1)));
        }

        public boolean f() {
            return true;
        }

        public long h() {
            return DefaultOggSeeker.this.f24705d.b(DefaultOggSeeker.this.f24707f);
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
        this.f24705d = streamReader;
        this.f24703b = j2;
        this.f24704c = j3;
        if (j4 == j3 - j2 || z2) {
            this.f24707f = j5;
            this.f24706e = 4;
        } else {
            this.f24706e = 0;
        }
        this.f24702a = new OggPageHeader();
    }

    private long i(ExtractorInput extractorInput) throws IOException {
        long j2;
        ExtractorInput extractorInput2 = extractorInput;
        if (this.f24710i == this.f24711j) {
            return -1;
        }
        long position = extractorInput.getPosition();
        if (!this.f24702a.d(extractorInput2, this.f24711j)) {
            long j3 = this.f24710i;
            if (j3 != position) {
                return j3;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f24702a.a(extractorInput2, false);
        extractorInput.e();
        long j4 = this.f24709h;
        OggPageHeader oggPageHeader = this.f24702a;
        long j5 = oggPageHeader.f24732c;
        long j6 = j4 - j5;
        int i2 = oggPageHeader.f24737h + oggPageHeader.f24738i;
        if (0 <= j6 && j6 < 72000) {
            return -1;
        }
        int i3 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
        if (i3 < 0) {
            this.f24711j = position;
            this.f24713l = j5;
        } else {
            this.f24710i = extractorInput.getPosition() + ((long) i2);
            this.f24712k = this.f24702a.f24732c;
        }
        long j7 = this.f24711j;
        long j8 = this.f24710i;
        if (j7 - j8 < 100000) {
            this.f24711j = j8;
            return j8;
        }
        long j9 = (long) i2;
        if (i3 <= 0) {
            j2 = 2;
        } else {
            j2 = 1;
        }
        long j10 = j9 * j2;
        long j11 = this.f24711j;
        long j12 = this.f24710i;
        return Util.r((extractorInput.getPosition() - j10) + ((j6 * (j11 - j12)) / (this.f24713l - this.f24712k)), j12, j11 - 1);
    }

    private void k(ExtractorInput extractorInput) throws IOException {
        while (true) {
            this.f24702a.c(extractorInput);
            this.f24702a.a(extractorInput, false);
            OggPageHeader oggPageHeader = this.f24702a;
            if (oggPageHeader.f24732c > this.f24709h) {
                extractorInput.e();
                return;
            }
            extractorInput.k(oggPageHeader.f24737h + oggPageHeader.f24738i);
            this.f24710i = extractorInput.getPosition();
            this.f24712k = this.f24702a.f24732c;
        }
    }

    public long a(ExtractorInput extractorInput) throws IOException {
        int i2 = this.f24706e;
        if (i2 == 0) {
            long position = extractorInput.getPosition();
            this.f24708g = position;
            this.f24706e = 1;
            long j2 = this.f24704c - 65307;
            if (j2 > position) {
                return j2;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                long i3 = i(extractorInput);
                if (i3 != -1) {
                    return i3;
                }
                this.f24706e = 3;
            } else if (i2 != 3) {
                if (i2 == 4) {
                    return -1;
                }
                throw new IllegalStateException();
            }
            k(extractorInput);
            this.f24706e = 4;
            return -(this.f24712k + 2);
        }
        this.f24707f = j(extractorInput);
        this.f24706e = 4;
        return this.f24708g;
    }

    public void c(long j2) {
        this.f24709h = Util.r(j2, 0, this.f24707f - 1);
        this.f24706e = 2;
        this.f24710i = this.f24703b;
        this.f24711j = this.f24704c;
        this.f24712k = 0;
        this.f24713l = this.f24707f;
    }

    /* renamed from: h */
    public OggSeekMap b() {
        if (this.f24707f != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public long j(ExtractorInput extractorInput) throws IOException {
        this.f24702a.b();
        if (this.f24702a.c(extractorInput)) {
            this.f24702a.a(extractorInput, false);
            OggPageHeader oggPageHeader = this.f24702a;
            extractorInput.k(oggPageHeader.f24737h + oggPageHeader.f24738i);
            long j2 = this.f24702a.f24732c;
            while (true) {
                OggPageHeader oggPageHeader2 = this.f24702a;
                if ((oggPageHeader2.f24731b & 4) == 4 || !oggPageHeader2.c(extractorInput) || extractorInput.getPosition() >= this.f24704c || !this.f24702a.a(extractorInput, true)) {
                    break;
                }
                OggPageHeader oggPageHeader3 = this.f24702a;
                if (!ExtractorUtil.e(extractorInput, oggPageHeader3.f24737h + oggPageHeader3.f24738i)) {
                    break;
                }
                j2 = this.f24702a.f24732c;
            }
            return j2;
        }
        throw new EOFException();
    }
}
