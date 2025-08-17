package androidx.media3.extractor.ogg;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.ogg.StreamReader;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class OpusReader extends StreamReader {

    /* renamed from: o  reason: collision with root package name */
    private static final byte[] f8744o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: p  reason: collision with root package name */
    private static final byte[] f8745p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* renamed from: n  reason: collision with root package name */
    private boolean f8746n;

    OpusReader() {
    }

    private static boolean n(ParsableByteArray parsableByteArray, byte[] bArr) {
        if (parsableByteArray.a() < bArr.length) {
            return false;
        }
        int f2 = parsableByteArray.f();
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.l(bArr2, 0, bArr.length);
        parsableByteArray.U(f2);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean o(ParsableByteArray parsableByteArray) {
        return n(parsableByteArray, f8744o);
    }

    /* access modifiers changed from: protected */
    public long f(ParsableByteArray parsableByteArray) {
        return c(OpusUtil.e(parsableByteArray.e()));
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean h(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) throws ParserException {
        if (n(parsableByteArray, f8744o)) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.e(), parsableByteArray.g());
            int c2 = OpusUtil.c(copyOf);
            List<byte[]> a2 = OpusUtil.a(copyOf);
            if (setupData.f8760a != null) {
                return true;
            }
            setupData.f8760a = new Format.Builder().o0("audio/opus").N(c2).p0(48000).b0(a2).K();
            return true;
        }
        byte[] bArr = f8745p;
        if (n(parsableByteArray, bArr)) {
            Assertions.j(setupData.f8760a);
            if (this.f8746n) {
                return true;
            }
            this.f8746n = true;
            parsableByteArray.V(bArr.length);
            Metadata d2 = VorbisUtil.d(ImmutableList.o(VorbisUtil.k(parsableByteArray, false, false).f8102b));
            if (d2 == null) {
                return true;
            }
            setupData.f8760a = setupData.f8760a.a().h0(d2.c(setupData.f8760a.f4012k)).K();
            return true;
        }
        Assertions.j(setupData.f8760a);
        return false;
    }

    /* access modifiers changed from: protected */
    public void l(boolean z2) {
        super.l(z2);
        if (z2) {
            this.f8746n = false;
        }
    }
}
