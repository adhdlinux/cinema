package com.google.android.exoplayer2.extractor.ts;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class DtsReader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f24839a = new ParsableByteArray(new byte[18]);

    /* renamed from: b  reason: collision with root package name */
    private final String f24840b;

    /* renamed from: c  reason: collision with root package name */
    private String f24841c;

    /* renamed from: d  reason: collision with root package name */
    private TrackOutput f24842d;

    /* renamed from: e  reason: collision with root package name */
    private int f24843e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f24844f;

    /* renamed from: g  reason: collision with root package name */
    private int f24845g;

    /* renamed from: h  reason: collision with root package name */
    private long f24846h;

    /* renamed from: i  reason: collision with root package name */
    private Format f24847i;

    /* renamed from: j  reason: collision with root package name */
    private int f24848j;

    /* renamed from: k  reason: collision with root package name */
    private long f24849k = -9223372036854775807L;

    public DtsReader(String str) {
        this.f24840b = str;
    }

    private boolean b(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f24844f);
        parsableByteArray.l(bArr, this.f24844f, min);
        int i3 = this.f24844f + min;
        this.f24844f = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    @RequiresNonNull({"output"})
    private void g() {
        byte[] e2 = this.f24839a.e();
        if (this.f24847i == null) {
            Format g2 = DtsUtil.g(e2, this.f24841c, this.f24840b, (DrmInitData) null);
            this.f24847i = g2;
            this.f24842d.d(g2);
        }
        this.f24848j = DtsUtil.a(e2);
        this.f24846h = (long) ((int) ((((long) DtsUtil.f(e2)) * 1000000) / ((long) this.f24847i.A)));
    }

    private boolean h(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.a() > 0) {
            int i2 = this.f24845g << 8;
            this.f24845g = i2;
            int H = i2 | parsableByteArray.H();
            this.f24845g = H;
            if (DtsUtil.d(H)) {
                byte[] e2 = this.f24839a.e();
                int i3 = this.f24845g;
                e2[0] = (byte) ((i3 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
                e2[1] = (byte) ((i3 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
                e2[2] = (byte) ((i3 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                e2[3] = (byte) (i3 & JfifUtil.MARKER_FIRST_BYTE);
                this.f24844f = 4;
                this.f24845g = 0;
                return true;
            }
        }
        return false;
    }

    public void a() {
        this.f24843e = 0;
        this.f24844f = 0;
        this.f24845g = 0;
        this.f24849k = -9223372036854775807L;
    }

    public void c(ParsableByteArray parsableByteArray) {
        Assertions.i(this.f24842d);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f24843e;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(parsableByteArray.a(), this.f24848j - this.f24844f);
                        this.f24842d.c(parsableByteArray, min);
                        int i3 = this.f24844f + min;
                        this.f24844f = i3;
                        int i4 = this.f24848j;
                        if (i3 == i4) {
                            long j2 = this.f24849k;
                            if (j2 != -9223372036854775807L) {
                                this.f24842d.e(j2, 1, i4, 0, (TrackOutput.CryptoData) null);
                                this.f24849k += this.f24846h;
                            }
                            this.f24843e = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (b(parsableByteArray, this.f24839a.e(), 18)) {
                    g();
                    this.f24839a.U(0);
                    this.f24842d.c(this.f24839a, 18);
                    this.f24843e = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f24843e = 1;
            }
        }
    }

    public void d(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.f24849k = j2;
        }
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f24841c = trackIdGenerator.b();
        this.f24842d = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    public void f() {
    }
}
