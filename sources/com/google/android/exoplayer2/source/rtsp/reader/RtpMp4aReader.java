package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class RtpMp4aReader implements RtpPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final RtpPayloadFormat f27034a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27035b;

    /* renamed from: c  reason: collision with root package name */
    private TrackOutput f27036c;

    /* renamed from: d  reason: collision with root package name */
    private long f27037d;

    /* renamed from: e  reason: collision with root package name */
    private int f27038e;

    /* renamed from: f  reason: collision with root package name */
    private int f27039f;

    /* renamed from: g  reason: collision with root package name */
    private long f27040g;

    /* renamed from: h  reason: collision with root package name */
    private long f27041h;

    public RtpMp4aReader(RtpPayloadFormat rtpPayloadFormat) {
        this.f27034a = rtpPayloadFormat;
        try {
            this.f27035b = e(rtpPayloadFormat.f26788d);
            this.f27037d = -9223372036854775807L;
            this.f27038e = -1;
            this.f27039f = 0;
            this.f27040g = 0;
            this.f27041h = -9223372036854775807L;
        } catch (ParserException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    /* JADX WARNING: type inference failed for: r5v10, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int e(com.google.common.collect.ImmutableMap<java.lang.String, java.lang.String> r5) throws com.google.android.exoplayer2.ParserException {
        /*
            java.lang.String r0 = "config"
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x006b
            int r2 = r5.length()
            int r2 = r2 % 2
            if (r2 != 0) goto L_0x006b
            byte[] r5 = com.google.android.exoplayer2.util.Util.J(r5)
            com.google.android.exoplayer2.util.ParsableBitArray r2 = new com.google.android.exoplayer2.util.ParsableBitArray
            r2.<init>(r5)
            int r5 = r2.h(r0)
            if (r5 != 0) goto L_0x0054
            int r5 = r2.h(r0)
            if (r5 != r0) goto L_0x002b
            r5 = 1
            goto L_0x002c
        L_0x002b:
            r5 = 0
        L_0x002c:
            java.lang.String r3 = "Only supports allStreamsSameTimeFraming."
            com.google.android.exoplayer2.util.Assertions.b(r5, r3)
            r5 = 6
            int r5 = r2.h(r5)
            r3 = 4
            int r3 = r2.h(r3)
            if (r3 != 0) goto L_0x003f
            r3 = 1
            goto L_0x0040
        L_0x003f:
            r3 = 0
        L_0x0040:
            java.lang.String r4 = "Only suppors one program."
            com.google.android.exoplayer2.util.Assertions.b(r3, r4)
            r3 = 3
            int r2 = r2.h(r3)
            if (r2 != 0) goto L_0x004d
            r1 = 1
        L_0x004d:
            java.lang.String r2 = "Only suppors one layer."
            com.google.android.exoplayer2.util.Assertions.b(r1, r2)
            r1 = r5
            goto L_0x006b
        L_0x0054:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unsupported audio mux version: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r0 = 0
            com.google.android.exoplayer2.ParserException r5 = com.google.android.exoplayer2.ParserException.b(r5, r0)
            throw r5
        L_0x006b:
            int r1 = r1 + r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.reader.RtpMp4aReader.e(com.google.common.collect.ImmutableMap):int");
    }

    private void f() {
        ((TrackOutput) Assertions.e(this.f27036c)).e(this.f27041h, 1, this.f27039f, 0, (TrackOutput.CryptoData) null);
        this.f27039f = 0;
        this.f27041h = -9223372036854775807L;
    }

    public void a(long j2, long j3) {
        this.f27037d = j2;
        this.f27039f = 0;
        this.f27040g = j3;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) {
        Assertions.i(this.f27036c);
        int b2 = RtpPacket.b(this.f27038e);
        if (this.f27039f > 0 && b2 < i2) {
            f();
        }
        for (int i3 = 0; i3 < this.f27035b; i3++) {
            int i4 = 0;
            while (parsableByteArray.f() < parsableByteArray.g()) {
                int H = parsableByteArray.H();
                i4 += H;
                if (H != 255) {
                    break;
                }
            }
            this.f27036c.c(parsableByteArray, i4);
            this.f27039f += i4;
        }
        this.f27041h = RtpReaderUtils.a(this.f27040g, j2, this.f27037d, this.f27034a.f26786b);
        if (z2) {
            f();
        }
        this.f27038e = i2;
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 2);
        this.f27036c = d2;
        ((TrackOutput) Util.j(d2)).d(this.f27034a.f26787c);
    }

    public void d(long j2, int i2) {
        boolean z2;
        if (this.f27037d == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f27037d = j2;
    }
}
