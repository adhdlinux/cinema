package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public class OggExtractor implements Extractor {

    /* renamed from: d  reason: collision with root package name */
    public static final ExtractorsFactory f24721d = new a();

    /* renamed from: a  reason: collision with root package name */
    private ExtractorOutput f24722a;

    /* renamed from: b  reason: collision with root package name */
    private StreamReader f24723b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24724c;

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] d() {
        return new Extractor[]{new OggExtractor()};
    }

    private static ParsableByteArray e(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(0);
        return parsableByteArray;
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private boolean f(ExtractorInput extractorInput) throws IOException {
        OggPageHeader oggPageHeader = new OggPageHeader();
        if (oggPageHeader.a(extractorInput, true) && (oggPageHeader.f24731b & 2) == 2) {
            int min = Math.min(oggPageHeader.f24738i, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(min);
            extractorInput.m(parsableByteArray.e(), 0, min);
            if (FlacReader.p(e(parsableByteArray))) {
                this.f24723b = new FlacReader();
            } else if (VorbisReader.r(e(parsableByteArray))) {
                this.f24723b = new VorbisReader();
            } else if (OpusReader.o(e(parsableByteArray))) {
                this.f24723b = new OpusReader();
            }
            return true;
        }
        return false;
    }

    public void a(long j2, long j3) {
        StreamReader streamReader = this.f24723b;
        if (streamReader != null) {
            streamReader.m(j2, j3);
        }
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f24722a = extractorOutput;
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        try {
            return f(extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.i(this.f24722a);
        if (this.f24723b == null) {
            if (f(extractorInput)) {
                extractorInput.e();
            } else {
                throw ParserException.a("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.f24724c) {
            TrackOutput d2 = this.f24722a.d(0, 1);
            this.f24722a.m();
            this.f24723b.d(this.f24722a, d2);
            this.f24724c = true;
        }
        return this.f24723b.g(extractorInput, positionHolder);
    }

    public void release() {
    }
}
