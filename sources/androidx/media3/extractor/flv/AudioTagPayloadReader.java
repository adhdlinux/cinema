package androidx.media3.extractor.flv;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.flv.TagPayloadReader;
import java.util.Collections;

final class AudioTagPayloadReader extends TagPayloadReader {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f8207e = {5512, 11025, 22050, 44100};

    /* renamed from: b  reason: collision with root package name */
    private boolean f8208b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8209c;

    /* renamed from: d  reason: collision with root package name */
    private int f8210d;

    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    /* access modifiers changed from: protected */
    public boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        String str;
        if (!this.f8208b) {
            int H = parsableByteArray.H();
            int i2 = (H >> 4) & 15;
            this.f8210d = i2;
            if (i2 == 2) {
                this.f8231a.c(new Format.Builder().o0("audio/mpeg").N(1).p0(f8207e[(H >> 2) & 3]).K());
                this.f8209c = true;
            } else if (i2 == 7 || i2 == 8) {
                if (i2 == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                this.f8231a.c(new Format.Builder().o0(str).N(1).p0(8000).K());
                this.f8209c = true;
            } else if (i2 != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f8210d);
            }
            this.f8208b = true;
        } else {
            parsableByteArray.V(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean c(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        if (this.f8210d == 2) {
            int a2 = parsableByteArray.a();
            this.f8231a.b(parsableByteArray, a2);
            this.f8231a.f(j2, 1, a2, 0, (TrackOutput.CryptoData) null);
            return true;
        }
        int H = parsableByteArray.H();
        if (H == 0 && !this.f8209c) {
            int a3 = parsableByteArray.a();
            byte[] bArr = new byte[a3];
            parsableByteArray.l(bArr, 0, a3);
            AacUtil.Config e2 = AacUtil.e(bArr);
            this.f8231a.c(new Format.Builder().o0("audio/mp4a-latm").O(e2.f7897c).N(e2.f7896b).p0(e2.f7895a).b0(Collections.singletonList(bArr)).K());
            this.f8209c = true;
            return false;
        } else if (this.f8210d == 10 && H != 1) {
            return false;
        } else {
            int a4 = parsableByteArray.a();
            this.f8231a.b(parsableByteArray, a4);
            this.f8231a.f(j2, 1, a4, 0, (TrackOutput.CryptoData) null);
            return true;
        }
    }
}
