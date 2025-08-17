package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class SectionReader implements TsPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final SectionPayloadReader f25069a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f25070b = new ParsableByteArray(32);

    /* renamed from: c  reason: collision with root package name */
    private int f25071c;

    /* renamed from: d  reason: collision with root package name */
    private int f25072d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25073e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25074f;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        this.f25069a = sectionPayloadReader;
    }

    public void a() {
        this.f25074f = true;
    }

    public void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f25069a.b(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.f25074f = true;
    }

    public void c(ParsableByteArray parsableByteArray, int i2) {
        boolean z2;
        int i3;
        boolean z3;
        if ((i2 & 1) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i3 = parsableByteArray.f() + parsableByteArray.H();
        } else {
            i3 = -1;
        }
        if (this.f25074f) {
            if (z2) {
                this.f25074f = false;
                parsableByteArray.U(i3);
                this.f25072d = 0;
            } else {
                return;
            }
        }
        while (parsableByteArray.a() > 0) {
            int i4 = this.f25072d;
            if (i4 < 3) {
                if (i4 == 0) {
                    int H = parsableByteArray.H();
                    parsableByteArray.U(parsableByteArray.f() - 1);
                    if (H == 255) {
                        this.f25074f = true;
                        return;
                    }
                }
                int min = Math.min(parsableByteArray.a(), 3 - this.f25072d);
                parsableByteArray.l(this.f25070b.e(), this.f25072d, min);
                int i5 = this.f25072d + min;
                this.f25072d = i5;
                if (i5 == 3) {
                    this.f25070b.U(0);
                    this.f25070b.T(3);
                    this.f25070b.V(1);
                    int H2 = this.f25070b.H();
                    int H3 = this.f25070b.H();
                    if ((H2 & 128) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.f25073e = z3;
                    this.f25071c = (((H2 & 15) << 8) | H3) + 3;
                    int b2 = this.f25070b.b();
                    int i6 = this.f25071c;
                    if (b2 < i6) {
                        this.f25070b.c(Math.min(4098, Math.max(i6, this.f25070b.b() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(parsableByteArray.a(), this.f25071c - this.f25072d);
                parsableByteArray.l(this.f25070b.e(), this.f25072d, min2);
                int i7 = this.f25072d + min2;
                this.f25072d = i7;
                int i8 = this.f25071c;
                if (i7 != i8) {
                    continue;
                } else {
                    if (!this.f25073e) {
                        this.f25070b.T(i8);
                    } else if (Util.t(this.f25070b.e(), 0, this.f25071c, -1) != 0) {
                        this.f25074f = true;
                        return;
                    } else {
                        this.f25070b.T(this.f25071c - 4);
                    }
                    this.f25070b.U(0);
                    this.f25069a.c(this.f25070b);
                    this.f25072d = 0;
                }
            }
        }
    }
}
