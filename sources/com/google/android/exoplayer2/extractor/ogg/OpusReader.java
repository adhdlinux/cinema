package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class OpusReader extends StreamReader {

    /* renamed from: o  reason: collision with root package name */
    private static final byte[] f24741o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: p  reason: collision with root package name */
    private static final byte[] f24742p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* renamed from: n  reason: collision with root package name */
    private boolean f24743n;

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
        return n(parsableByteArray, f24741o);
    }

    /* access modifiers changed from: protected */
    public long f(ParsableByteArray parsableByteArray) {
        return c(OpusUtil.e(parsableByteArray.e()));
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean i(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) throws ParserException {
        if (n(parsableByteArray, f24741o)) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.e(), parsableByteArray.g());
            int c2 = OpusUtil.c(copyOf);
            List<byte[]> a2 = OpusUtil.a(copyOf);
            if (setupData.f24757a != null) {
                return true;
            }
            setupData.f24757a = new Format.Builder().g0("audio/opus").J(c2).h0(48000).V(a2).G();
            return true;
        }
        byte[] bArr = f24742p;
        if (n(parsableByteArray, bArr)) {
            Assertions.i(setupData.f24757a);
            if (this.f24743n) {
                return true;
            }
            this.f24743n = true;
            parsableByteArray.V(bArr.length);
            Metadata c3 = VorbisUtil.c(ImmutableList.o(VorbisUtil.j(parsableByteArray, false, false).f24260b));
            if (c3 == null) {
                return true;
            }
            setupData.f24757a = setupData.f24757a.b().Z(c3.c(setupData.f24757a.f23069k)).G();
            return true;
        }
        Assertions.i(setupData.f24757a);
        return false;
    }

    /* access modifiers changed from: protected */
    public void l(boolean z2) {
        super.l(z2);
        if (z2) {
            this.f24743n = false;
        }
    }
}
