package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

public final class SectionReader implements TsPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final SectionPayloadReader f9490a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f9491b = new ParsableByteArray(32);

    /* renamed from: c  reason: collision with root package name */
    private int f9492c;

    /* renamed from: d  reason: collision with root package name */
    private int f9493d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9494e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9495f;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        this.f9490a = sectionPayloadReader;
    }

    public void a() {
        this.f9495f = true;
    }

    public void b(ParsableByteArray parsableByteArray, int i2) {
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
        if (this.f9495f) {
            if (z2) {
                this.f9495f = false;
                parsableByteArray.U(i3);
                this.f9493d = 0;
            } else {
                return;
            }
        }
        while (parsableByteArray.a() > 0) {
            int i4 = this.f9493d;
            if (i4 < 3) {
                if (i4 == 0) {
                    int H = parsableByteArray.H();
                    parsableByteArray.U(parsableByteArray.f() - 1);
                    if (H == 255) {
                        this.f9495f = true;
                        return;
                    }
                }
                int min = Math.min(parsableByteArray.a(), 3 - this.f9493d);
                parsableByteArray.l(this.f9491b.e(), this.f9493d, min);
                int i5 = this.f9493d + min;
                this.f9493d = i5;
                if (i5 == 3) {
                    this.f9491b.U(0);
                    this.f9491b.T(3);
                    this.f9491b.V(1);
                    int H2 = this.f9491b.H();
                    int H3 = this.f9491b.H();
                    if ((H2 & 128) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.f9494e = z3;
                    this.f9492c = (((H2 & 15) << 8) | H3) + 3;
                    int b2 = this.f9491b.b();
                    int i6 = this.f9492c;
                    if (b2 < i6) {
                        this.f9491b.c(Math.min(4098, Math.max(i6, this.f9491b.b() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(parsableByteArray.a(), this.f9492c - this.f9493d);
                parsableByteArray.l(this.f9491b.e(), this.f9493d, min2);
                int i7 = this.f9493d + min2;
                this.f9493d = i7;
                int i8 = this.f9492c;
                if (i7 != i8) {
                    continue;
                } else {
                    if (!this.f9494e) {
                        this.f9491b.T(i8);
                    } else if (Util.x(this.f9491b.e(), 0, this.f9492c, -1) != 0) {
                        this.f9495f = true;
                        return;
                    } else {
                        this.f9491b.T(this.f9492c - 4);
                    }
                    this.f9491b.U(0);
                    this.f9490a.b(this.f9491b);
                    this.f9493d = 0;
                }
            }
        }
    }

    public void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f9490a.c(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.f9495f = true;
    }
}
