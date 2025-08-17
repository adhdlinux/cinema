package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;

public final class TrueHdSampleRechunker {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f8090a = new byte[10];

    /* renamed from: b  reason: collision with root package name */
    private boolean f8091b;

    /* renamed from: c  reason: collision with root package name */
    private int f8092c;

    /* renamed from: d  reason: collision with root package name */
    private long f8093d;

    /* renamed from: e  reason: collision with root package name */
    private int f8094e;

    /* renamed from: f  reason: collision with root package name */
    private int f8095f;

    /* renamed from: g  reason: collision with root package name */
    private int f8096g;

    public void a(TrackOutput trackOutput, TrackOutput.CryptoData cryptoData) {
        if (this.f8092c > 0) {
            trackOutput.f(this.f8093d, this.f8094e, this.f8095f, this.f8096g, cryptoData);
            this.f8092c = 0;
        }
    }

    public void b() {
        this.f8091b = false;
        this.f8092c = 0;
    }

    public void c(TrackOutput trackOutput, long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
        boolean z2;
        if (this.f8096g <= i3 + i4) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.i(z2, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f8091b) {
            int i5 = this.f8092c;
            int i6 = i5 + 1;
            this.f8092c = i6;
            if (i5 == 0) {
                this.f8093d = j2;
                this.f8094e = i2;
                this.f8095f = 0;
            }
            this.f8095f += i3;
            this.f8096g = i4;
            if (i6 >= 16) {
                a(trackOutput, cryptoData);
            }
        }
    }

    public void d(ExtractorInput extractorInput) throws IOException {
        if (!this.f8091b) {
            extractorInput.m(this.f8090a, 0, 10);
            extractorInput.e();
            if (Ac3Util.j(this.f8090a) != 0) {
                this.f8091b = true;
            }
        }
    }
}
