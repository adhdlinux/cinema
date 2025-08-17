package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Ac4Reader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableBitArray f24789a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f24790b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24791c;

    /* renamed from: d  reason: collision with root package name */
    private String f24792d;

    /* renamed from: e  reason: collision with root package name */
    private TrackOutput f24793e;

    /* renamed from: f  reason: collision with root package name */
    private int f24794f;

    /* renamed from: g  reason: collision with root package name */
    private int f24795g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24796h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24797i;

    /* renamed from: j  reason: collision with root package name */
    private long f24798j;

    /* renamed from: k  reason: collision with root package name */
    private Format f24799k;

    /* renamed from: l  reason: collision with root package name */
    private int f24800l;

    /* renamed from: m  reason: collision with root package name */
    private long f24801m;

    public Ac4Reader() {
        this((String) null);
    }

    private boolean b(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f24795g);
        parsableByteArray.l(bArr, this.f24795g, min);
        int i3 = this.f24795g + min;
        this.f24795g = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    @RequiresNonNull({"output"})
    private void g() {
        this.f24789a.p(0);
        Ac4Util.SyncFrameInfo d2 = Ac4Util.d(this.f24789a);
        Format format = this.f24799k;
        if (format == null || d2.f23652c != format.f23084z || d2.f23651b != format.A || !"audio/ac4".equals(format.f23071m)) {
            Format G = new Format.Builder().U(this.f24792d).g0("audio/ac4").J(d2.f23652c).h0(d2.f23651b).X(this.f24791c).G();
            this.f24799k = G;
            this.f24793e.d(G);
        }
        this.f24800l = d2.f23653d;
        this.f24798j = (((long) d2.f23654e) * 1000000) / ((long) this.f24799k.A);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean h(com.google.android.exoplayer2.util.ParsableByteArray r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r6.a()
            r1 = 0
            if (r0 <= 0) goto L_0x0031
            boolean r0 = r5.f24796h
            r2 = 172(0xac, float:2.41E-43)
            r3 = 1
            if (r0 != 0) goto L_0x0018
            int r0 = r6.H()
            if (r0 != r2) goto L_0x0015
            r1 = 1
        L_0x0015:
            r5.f24796h = r1
            goto L_0x0000
        L_0x0018:
            int r0 = r6.H()
            if (r0 != r2) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            r5.f24796h = r2
            r2 = 64
            r4 = 65
            if (r0 == r2) goto L_0x002b
            if (r0 != r4) goto L_0x0000
        L_0x002b:
            if (r0 != r4) goto L_0x002e
            r1 = 1
        L_0x002e:
            r5.f24797i = r1
            return r3
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.Ac4Reader.h(com.google.android.exoplayer2.util.ParsableByteArray):boolean");
    }

    public void a() {
        this.f24794f = 0;
        this.f24795g = 0;
        this.f24796h = false;
        this.f24797i = false;
        this.f24801m = -9223372036854775807L;
    }

    public void c(ParsableByteArray parsableByteArray) {
        int i2;
        Assertions.i(this.f24793e);
        while (parsableByteArray.a() > 0) {
            int i3 = this.f24794f;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        int min = Math.min(parsableByteArray.a(), this.f24800l - this.f24795g);
                        this.f24793e.c(parsableByteArray, min);
                        int i4 = this.f24795g + min;
                        this.f24795g = i4;
                        int i5 = this.f24800l;
                        if (i4 == i5) {
                            long j2 = this.f24801m;
                            if (j2 != -9223372036854775807L) {
                                this.f24793e.e(j2, 1, i5, 0, (TrackOutput.CryptoData) null);
                                this.f24801m += this.f24798j;
                            }
                            this.f24794f = 0;
                        }
                    }
                } else if (b(parsableByteArray, this.f24790b.e(), 16)) {
                    g();
                    this.f24790b.U(0);
                    this.f24793e.c(this.f24790b, 16);
                    this.f24794f = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f24794f = 1;
                this.f24790b.e()[0] = -84;
                byte[] e2 = this.f24790b.e();
                if (this.f24797i) {
                    i2 = 65;
                } else {
                    i2 = 64;
                }
                e2[1] = (byte) i2;
                this.f24795g = 2;
            }
        }
    }

    public void d(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.f24801m = j2;
        }
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f24792d = trackIdGenerator.b();
        this.f24793e = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    public void f() {
    }

    public Ac4Reader(String str) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[16]);
        this.f24789a = parsableBitArray;
        this.f24790b = new ParsableByteArray(parsableBitArray.f28757a);
        this.f24794f = 0;
        this.f24795g = 0;
        this.f24796h = false;
        this.f24797i = false;
        this.f24801m = -9223372036854775807L;
        this.f24791c = str;
    }
}
