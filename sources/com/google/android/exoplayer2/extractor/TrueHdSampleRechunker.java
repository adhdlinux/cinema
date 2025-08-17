package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class TrueHdSampleRechunker {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f24243a = new byte[10];

    /* renamed from: b  reason: collision with root package name */
    private boolean f24244b;

    /* renamed from: c  reason: collision with root package name */
    private int f24245c;

    /* renamed from: d  reason: collision with root package name */
    private long f24246d;

    /* renamed from: e  reason: collision with root package name */
    private int f24247e;

    /* renamed from: f  reason: collision with root package name */
    private int f24248f;

    /* renamed from: g  reason: collision with root package name */
    private int f24249g;

    public void a(TrackOutput trackOutput, TrackOutput.CryptoData cryptoData) {
        if (this.f24245c > 0) {
            trackOutput.e(this.f24246d, this.f24247e, this.f24248f, this.f24249g, cryptoData);
            this.f24245c = 0;
        }
    }

    public void b() {
        this.f24244b = false;
        this.f24245c = 0;
    }

    public void c(TrackOutput trackOutput, long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
        boolean z2;
        if (this.f24249g <= i3 + i4) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f24244b) {
            int i5 = this.f24245c;
            int i6 = i5 + 1;
            this.f24245c = i6;
            if (i5 == 0) {
                this.f24246d = j2;
                this.f24247e = i2;
                this.f24248f = 0;
            }
            this.f24248f += i3;
            this.f24249g = i4;
            if (i6 >= 16) {
                a(trackOutput, cryptoData);
            }
        }
    }

    public void d(ExtractorInput extractorInput) throws IOException {
        if (!this.f24244b) {
            extractorInput.m(this.f24243a, 0, 10);
            extractorInput.e();
            if (Ac3Util.j(this.f24243a) != 0) {
                this.f24244b = true;
            }
        }
    }
}
