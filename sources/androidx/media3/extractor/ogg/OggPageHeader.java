package androidx.media3.extractor.ogg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;

final class OggPageHeader {

    /* renamed from: a  reason: collision with root package name */
    public int f8733a;

    /* renamed from: b  reason: collision with root package name */
    public int f8734b;

    /* renamed from: c  reason: collision with root package name */
    public long f8735c;

    /* renamed from: d  reason: collision with root package name */
    public long f8736d;

    /* renamed from: e  reason: collision with root package name */
    public long f8737e;

    /* renamed from: f  reason: collision with root package name */
    public long f8738f;

    /* renamed from: g  reason: collision with root package name */
    public int f8739g;

    /* renamed from: h  reason: collision with root package name */
    public int f8740h;

    /* renamed from: i  reason: collision with root package name */
    public int f8741i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f8742j = new int[JfifUtil.MARKER_FIRST_BYTE];

    /* renamed from: k  reason: collision with root package name */
    private final ParsableByteArray f8743k = new ParsableByteArray((int) JfifUtil.MARKER_FIRST_BYTE);

    OggPageHeader() {
    }

    public boolean a(ExtractorInput extractorInput, boolean z2) throws IOException {
        b();
        this.f8743k.Q(27);
        if (!ExtractorUtil.b(extractorInput, this.f8743k.e(), 0, 27, z2) || this.f8743k.J() != 1332176723) {
            return false;
        }
        int H = this.f8743k.H();
        this.f8733a = H;
        if (H == 0) {
            this.f8734b = this.f8743k.H();
            this.f8735c = this.f8743k.v();
            this.f8736d = this.f8743k.x();
            this.f8737e = this.f8743k.x();
            this.f8738f = this.f8743k.x();
            int H2 = this.f8743k.H();
            this.f8739g = H2;
            this.f8740h = H2 + 27;
            this.f8743k.Q(H2);
            if (!ExtractorUtil.b(extractorInput, this.f8743k.e(), 0, this.f8739g, z2)) {
                return false;
            }
            for (int i2 = 0; i2 < this.f8739g; i2++) {
                this.f8742j[i2] = this.f8743k.H();
                this.f8741i += this.f8742j[i2];
            }
            return true;
        } else if (z2) {
            return false;
        } else {
            throw ParserException.d("unsupported bit stream revision");
        }
    }

    public void b() {
        this.f8733a = 0;
        this.f8734b = 0;
        this.f8735c = 0;
        this.f8736d = 0;
        this.f8737e = 0;
        this.f8738f = 0;
        this.f8739g = 0;
        this.f8740h = 0;
        this.f8741i = 0;
    }

    public boolean c(ExtractorInput extractorInput) throws IOException {
        return d(extractorInput, -1);
    }

    public boolean d(ExtractorInput extractorInput, long j2) throws IOException {
        boolean z2;
        int i2;
        if (extractorInput.getPosition() == extractorInput.g()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f8743k.Q(4);
        while (true) {
            i2 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
            if ((i2 == 0 || extractorInput.getPosition() + 4 < j2) && ExtractorUtil.b(extractorInput, this.f8743k.e(), 0, 4, true)) {
                this.f8743k.U(0);
                if (this.f8743k.J() == 1332176723) {
                    extractorInput.e();
                    return true;
                }
                extractorInput.k(1);
            }
        }
        do {
            if ((i2 != 0 && extractorInput.getPosition() >= j2) || extractorInput.a(1) == -1) {
                return false;
            }
            break;
        } while (extractorInput.a(1) == -1);
        return false;
    }
}
