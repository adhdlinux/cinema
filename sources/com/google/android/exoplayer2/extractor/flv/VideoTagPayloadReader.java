package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.AvcConfig;
import com.unity3d.services.core.device.MimeTypes;

final class VideoTagPayloadReader extends TagPayloadReader {

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f24385b = new ParsableByteArray(NalUnitUtil.f28716a);

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f24386c = new ParsableByteArray(4);

    /* renamed from: d  reason: collision with root package name */
    private int f24387d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24388e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24389f;

    /* renamed from: g  reason: collision with root package name */
    private int f24390g;

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    /* access modifiers changed from: protected */
    public boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        int H = parsableByteArray.H();
        int i2 = (H >> 4) & 15;
        int i3 = H & 15;
        if (i3 == 7) {
            this.f24390g = i2;
            if (i2 != 5) {
                return true;
            }
            return false;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i3);
    }

    /* access modifiers changed from: protected */
    public boolean c(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        int i2;
        int H = parsableByteArray.H();
        long r2 = j2 + (((long) parsableByteArray.r()) * 1000);
        if (H == 0 && !this.f24388e) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.a()]);
            parsableByteArray.l(parsableByteArray2.e(), 0, parsableByteArray.a());
            AvcConfig b2 = AvcConfig.b(parsableByteArray2);
            this.f24387d = b2.f28833b;
            this.f24384a.d(new Format.Builder().g0(MimeTypes.VIDEO_H264).K(b2.f28837f).n0(b2.f28834c).S(b2.f28835d).c0(b2.f28836e).V(b2.f28832a).G());
            this.f24388e = true;
            return false;
        } else if (H != 1 || !this.f24388e) {
            return false;
        } else {
            if (this.f24390g == 1) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (!this.f24389f && i2 == 0) {
                return false;
            }
            byte[] e2 = this.f24386c.e();
            e2[0] = 0;
            e2[1] = 0;
            e2[2] = 0;
            int i3 = 4 - this.f24387d;
            int i4 = 0;
            while (parsableByteArray.a() > 0) {
                parsableByteArray.l(this.f24386c.e(), i3, this.f24387d);
                this.f24386c.U(0);
                int L = this.f24386c.L();
                this.f24385b.U(0);
                this.f24384a.c(this.f24385b, 4);
                this.f24384a.c(parsableByteArray, L);
                i4 = i4 + 4 + L;
            }
            this.f24384a.e(r2, i2, i4, 0, (TrackOutput.CryptoData) null);
            this.f24389f = true;
            return true;
        }
    }
}
