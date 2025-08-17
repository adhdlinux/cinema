package androidx.media3.extractor.flv;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.flv.TagPayloadReader;
import com.unity3d.services.core.device.MimeTypes;

final class VideoTagPayloadReader extends TagPayloadReader {

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f8232b = new ParsableByteArray(NalUnitUtil.f4748a);

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f8233c = new ParsableByteArray(4);

    /* renamed from: d  reason: collision with root package name */
    private int f8234d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8235e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8236f;

    /* renamed from: g  reason: collision with root package name */
    private int f8237g;

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    /* access modifiers changed from: protected */
    public boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        int H = parsableByteArray.H();
        int i2 = (H >> 4) & 15;
        int i3 = H & 15;
        if (i3 == 7) {
            this.f8237g = i2;
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
        if (H == 0 && !this.f8235e) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.a()]);
            parsableByteArray.l(parsableByteArray2.e(), 0, parsableByteArray.a());
            AvcConfig b2 = AvcConfig.b(parsableByteArray2);
            this.f8234d = b2.f7918b;
            this.f8231a.c(new Format.Builder().o0(MimeTypes.VIDEO_H264).O(b2.f7928l).v0(b2.f7919c).Y(b2.f7920d).k0(b2.f7927k).b0(b2.f7917a).K());
            this.f8235e = true;
            return false;
        } else if (H != 1 || !this.f8235e) {
            return false;
        } else {
            if (this.f8237g == 1) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (!this.f8236f && i2 == 0) {
                return false;
            }
            byte[] e2 = this.f8233c.e();
            e2[0] = 0;
            e2[1] = 0;
            e2[2] = 0;
            int i3 = 4 - this.f8234d;
            int i4 = 0;
            while (parsableByteArray.a() > 0) {
                parsableByteArray.l(this.f8233c.e(), i3, this.f8234d);
                this.f8233c.U(0);
                int L = this.f8233c.L();
                this.f8232b.U(0);
                this.f8231a.b(this.f8232b, 4);
                this.f8231a.b(parsableByteArray, L);
                i4 = i4 + 4 + L;
            }
            this.f8231a.f(r2, i2, i4, 0, (TrackOutput.CryptoData) null);
            this.f8236f = true;
            return true;
        }
    }
}
