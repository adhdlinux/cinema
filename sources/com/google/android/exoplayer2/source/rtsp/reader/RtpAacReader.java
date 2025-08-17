package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;

final class RtpAacReader implements RtpPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final RtpPayloadFormat f26979a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableBitArray f26980b = new ParsableBitArray();

    /* renamed from: c  reason: collision with root package name */
    private final int f26981c;

    /* renamed from: d  reason: collision with root package name */
    private final int f26982d;

    /* renamed from: e  reason: collision with root package name */
    private final int f26983e;

    /* renamed from: f  reason: collision with root package name */
    private final int f26984f;

    /* renamed from: g  reason: collision with root package name */
    private long f26985g;

    /* renamed from: h  reason: collision with root package name */
    private TrackOutput f26986h;

    /* renamed from: i  reason: collision with root package name */
    private long f26987i;

    public RtpAacReader(RtpPayloadFormat rtpPayloadFormat) {
        this.f26979a = rtpPayloadFormat;
        this.f26981c = rtpPayloadFormat.f26786b;
        String str = (String) Assertions.e(rtpPayloadFormat.f26788d.get("mode"));
        if (Ascii.a(str, "AAC-hbr")) {
            this.f26982d = 13;
            this.f26983e = 3;
        } else if (Ascii.a(str, "AAC-lbr")) {
            this.f26982d = 6;
            this.f26983e = 2;
        } else {
            throw new UnsupportedOperationException("AAC mode not supported");
        }
        this.f26984f = this.f26983e + this.f26982d;
    }

    private static void e(TrackOutput trackOutput, long j2, int i2) {
        trackOutput.e(j2, 1, i2, 0, (TrackOutput.CryptoData) null);
    }

    public void a(long j2, long j3) {
        this.f26985g = j2;
        this.f26987i = j3;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) {
        Assertions.e(this.f26986h);
        short D = parsableByteArray.D();
        int i3 = D / this.f26984f;
        long a2 = RtpReaderUtils.a(this.f26987i, j2, this.f26985g, this.f26981c);
        this.f26980b.m(parsableByteArray);
        if (i3 == 1) {
            int h2 = this.f26980b.h(this.f26982d);
            this.f26980b.r(this.f26983e);
            this.f26986h.c(parsableByteArray, parsableByteArray.a());
            if (z2) {
                e(this.f26986h, a2, h2);
                return;
            }
            return;
        }
        parsableByteArray.V((D + 7) / 8);
        for (int i4 = 0; i4 < i3; i4++) {
            int h3 = this.f26980b.h(this.f26982d);
            this.f26980b.r(this.f26983e);
            this.f26986h.c(parsableByteArray, h3);
            e(this.f26986h, a2, h3);
            a2 += Util.R0((long) i3, 1000000, (long) this.f26981c);
        }
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 1);
        this.f26986h = d2;
        d2.d(this.f26979a.f26787c);
    }

    public void d(long j2, int i2) {
        this.f26985g = j2;
    }
}
