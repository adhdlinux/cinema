package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

abstract class StreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final OggPacket f24744a = new OggPacket();

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f24745b;

    /* renamed from: c  reason: collision with root package name */
    private ExtractorOutput f24746c;

    /* renamed from: d  reason: collision with root package name */
    private OggSeeker f24747d;

    /* renamed from: e  reason: collision with root package name */
    private long f24748e;

    /* renamed from: f  reason: collision with root package name */
    private long f24749f;

    /* renamed from: g  reason: collision with root package name */
    private long f24750g;

    /* renamed from: h  reason: collision with root package name */
    private int f24751h;

    /* renamed from: i  reason: collision with root package name */
    private int f24752i;

    /* renamed from: j  reason: collision with root package name */
    private SetupData f24753j = new SetupData();

    /* renamed from: k  reason: collision with root package name */
    private long f24754k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24755l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f24756m;

    static class SetupData {

        /* renamed from: a  reason: collision with root package name */
        Format f24757a;

        /* renamed from: b  reason: collision with root package name */
        OggSeeker f24758b;

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
        Assertions.i(this.f24745b);
        Util.j(this.f24746c);
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = true)
    private boolean h(ExtractorInput extractorInput) throws IOException {
        while (this.f24744a.d(extractorInput)) {
            this.f24754k = extractorInput.getPosition() - this.f24749f;
            if (!i(this.f24744a.c(), this.f24749f, this.f24753j)) {
                return true;
            }
            this.f24749f = extractorInput.getPosition();
        }
        this.f24751h = 3;
        return false;
    }

    @RequiresNonNull({"trackOutput"})
    private int j(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        if (!h(extractorInput)) {
            return -1;
        }
        Format format = this.f24753j.f24757a;
        this.f24752i = format.A;
        if (!this.f24756m) {
            this.f24745b.d(format);
            this.f24756m = true;
        }
        OggSeeker oggSeeker = this.f24753j.f24758b;
        if (oggSeeker != null) {
            this.f24747d = oggSeeker;
        } else if (extractorInput.getLength() == -1) {
            this.f24747d = new UnseekableOggSeeker();
        } else {
            OggPageHeader b2 = this.f24744a.b();
            if ((b2.f24731b & 4) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f24747d = new DefaultOggSeeker(this, this.f24749f, extractorInput.getLength(), (long) (b2.f24737h + b2.f24738i), b2.f24732c, z2);
        }
        this.f24751h = 2;
        this.f24744a.f();
        return 0;
    }

    @RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    private int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ExtractorInput extractorInput2 = extractorInput;
        long a2 = this.f24747d.a(extractorInput2);
        if (a2 >= 0) {
            positionHolder.f24231a = a2;
            return 1;
        }
        if (a2 < -1) {
            e(-(a2 + 2));
        }
        if (!this.f24755l) {
            this.f24746c.u((SeekMap) Assertions.i(this.f24747d.b()));
            this.f24755l = true;
        }
        if (this.f24754k > 0 || this.f24744a.d(extractorInput2)) {
            this.f24754k = 0;
            ParsableByteArray c2 = this.f24744a.c();
            long f2 = f(c2);
            if (f2 >= 0) {
                long j2 = this.f24750g;
                if (j2 + f2 >= this.f24748e) {
                    long b2 = b(j2);
                    this.f24745b.c(c2, c2.g());
                    this.f24745b.e(b2, 1, c2.g(), 0, (TrackOutput.CryptoData) null);
                    this.f24748e = -1;
                }
            }
            this.f24750g += f2;
            return 0;
        }
        this.f24751h = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    public long b(long j2) {
        return (j2 * 1000000) / ((long) this.f24752i);
    }

    /* access modifiers changed from: protected */
    public long c(long j2) {
        return (((long) this.f24752i) * j2) / 1000000;
    }

    /* access modifiers changed from: package-private */
    public void d(ExtractorOutput extractorOutput, TrackOutput trackOutput) {
        this.f24746c = extractorOutput;
        this.f24745b = trackOutput;
        l(true);
    }

    /* access modifiers changed from: protected */
    public void e(long j2) {
        this.f24750g = j2;
    }

    /* access modifiers changed from: protected */
    public abstract long f(ParsableByteArray parsableByteArray);

    /* access modifiers changed from: package-private */
    public final int g(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        a();
        int i2 = this.f24751h;
        if (i2 == 0) {
            return j(extractorInput);
        }
        if (i2 == 1) {
            extractorInput.k((int) this.f24749f);
            this.f24751h = 2;
            return 0;
        } else if (i2 == 2) {
            Util.j(this.f24747d);
            return k(extractorInput, positionHolder);
        } else if (i2 == 3) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean i(ParsableByteArray parsableByteArray, long j2, SetupData setupData) throws IOException;

    /* access modifiers changed from: protected */
    public void l(boolean z2) {
        if (z2) {
            this.f24753j = new SetupData();
            this.f24749f = 0;
            this.f24751h = 0;
        } else {
            this.f24751h = 1;
        }
        this.f24748e = -1;
        this.f24750g = 0;
    }

    /* access modifiers changed from: package-private */
    public final void m(long j2, long j3) {
        this.f24744a.e();
        if (j2 == 0) {
            l(!this.f24755l);
        } else if (this.f24751h != 0) {
            this.f24748e = c(j3);
            ((OggSeeker) Util.j(this.f24747d)).c(this.f24748e);
            this.f24751h = 2;
        }
    }
}
