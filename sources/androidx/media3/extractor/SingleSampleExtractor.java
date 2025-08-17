package androidx.media3.extractor;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class SingleSampleExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final int f8077a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8078b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8079c;

    /* renamed from: d  reason: collision with root package name */
    private int f8080d;

    /* renamed from: e  reason: collision with root package name */
    private int f8081e;

    /* renamed from: f  reason: collision with root package name */
    private ExtractorOutput f8082f;

    /* renamed from: g  reason: collision with root package name */
    private TrackOutput f8083g;

    public SingleSampleExtractor(int i2, int i3, String str) {
        this.f8077a = i2;
        this.f8078b = i3;
        this.f8079c = str;
    }

    @RequiresNonNull({"this.extractorOutput"})
    private void b(String str) {
        TrackOutput d2 = this.f8082f.d(1024, 4);
        this.f8083g = d2;
        d2.c(new Format.Builder().o0(str).K());
        this.f8082f.m();
        this.f8082f.r(new SingleSampleSeekMap(-9223372036854775807L));
        this.f8081e = 1;
    }

    private void d(ExtractorInput extractorInput) throws IOException {
        int d2 = ((TrackOutput) Assertions.f(this.f8083g)).d(extractorInput, 1024, true);
        if (d2 == -1) {
            this.f8081e = 2;
            this.f8083g.f(0, 1, this.f8080d, 0, (TrackOutput.CryptoData) null);
            this.f8080d = 0;
            return;
        }
        this.f8080d += d2;
    }

    public void a(long j2, long j3) {
        if (j2 == 0 || this.f8081e == 1) {
            this.f8081e = 1;
            this.f8080d = 0;
        }
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f8082f = extractorOutput;
        b(this.f8079c);
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        if (this.f8077a == -1 || this.f8078b == -1) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.h(z2);
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f8078b);
        extractorInput.m(parsableByteArray.e(), 0, this.f8078b);
        if (parsableByteArray.N() == this.f8077a) {
            return true;
        }
        return false;
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2 = this.f8081e;
        if (i2 == 1) {
            d(extractorInput);
            return 0;
        } else if (i2 == 2) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    public void release() {
    }
}
