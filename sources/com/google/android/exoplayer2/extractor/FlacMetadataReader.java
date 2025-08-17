package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class FlacMetadataReader {

    public static final class FlacStreamMetadataHolder {

        /* renamed from: a  reason: collision with root package name */
        public FlacStreamMetadata f24205a;

        public FlacStreamMetadataHolder(FlacStreamMetadata flacStreamMetadata) {
            this.f24205a = flacStreamMetadata;
        }
    }

    private FlacMetadataReader() {
    }

    public static boolean a(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        extractorInput.m(parsableByteArray.e(), 0, 4);
        if (parsableByteArray.J() == 1716281667) {
            return true;
        }
        return false;
    }

    public static int b(ExtractorInput extractorInput) throws IOException {
        extractorInput.e();
        ParsableByteArray parsableByteArray = new ParsableByteArray(2);
        extractorInput.m(parsableByteArray.e(), 0, 2);
        int N = parsableByteArray.N();
        if ((N >> 2) == 16382) {
            extractorInput.e();
            return N;
        }
        extractorInput.e();
        throw ParserException.a("First frame does not start with sync code.", (Throwable) null);
    }

    public static Metadata c(ExtractorInput extractorInput, boolean z2) throws IOException {
        Id3Decoder.FramePredicate framePredicate;
        if (z2) {
            framePredicate = null;
        } else {
            framePredicate = Id3Decoder.f25423b;
        }
        Metadata a2 = new Id3Peeker().a(extractorInput, framePredicate);
        if (a2 == null || a2.f() == 0) {
            return null;
        }
        return a2;
    }

    public static Metadata d(ExtractorInput extractorInput, boolean z2) throws IOException {
        extractorInput.e();
        long g2 = extractorInput.g();
        Metadata c2 = c(extractorInput, z2);
        extractorInput.k((int) (extractorInput.g() - g2));
        return c2;
    }

    public static boolean e(ExtractorInput extractorInput, FlacStreamMetadataHolder flacStreamMetadataHolder) throws IOException {
        extractorInput.e();
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[4]);
        extractorInput.m(parsableBitArray.f28757a, 0, 4);
        boolean g2 = parsableBitArray.g();
        int h2 = parsableBitArray.h(7);
        int h3 = parsableBitArray.h(24) + 4;
        if (h2 == 0) {
            flacStreamMetadataHolder.f24205a = h(extractorInput);
        } else {
            FlacStreamMetadata flacStreamMetadata = flacStreamMetadataHolder.f24205a;
            if (flacStreamMetadata == null) {
                throw new IllegalArgumentException();
            } else if (h2 == 3) {
                flacStreamMetadataHolder.f24205a = flacStreamMetadata.b(f(extractorInput, h3));
            } else if (h2 == 4) {
                flacStreamMetadataHolder.f24205a = flacStreamMetadata.c(j(extractorInput, h3));
            } else if (h2 == 6) {
                ParsableByteArray parsableByteArray = new ParsableByteArray(h3);
                extractorInput.readFully(parsableByteArray.e(), 0, h3);
                parsableByteArray.V(4);
                flacStreamMetadataHolder.f24205a = flacStreamMetadata.a(ImmutableList.s(PictureFrame.b(parsableByteArray)));
            } else {
                extractorInput.k(h3);
            }
        }
        return g2;
    }

    private static FlacStreamMetadata.SeekTable f(ExtractorInput extractorInput, int i2) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
        extractorInput.readFully(parsableByteArray.e(), 0, i2);
        return g(parsableByteArray);
    }

    public static FlacStreamMetadata.SeekTable g(ParsableByteArray parsableByteArray) {
        parsableByteArray.V(1);
        int K = parsableByteArray.K();
        long f2 = ((long) parsableByteArray.f()) + ((long) K);
        int i2 = K / 18;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            long A = parsableByteArray.A();
            if (A == -1) {
                jArr = Arrays.copyOf(jArr, i3);
                jArr2 = Arrays.copyOf(jArr2, i3);
                break;
            }
            jArr[i3] = A;
            jArr2[i3] = parsableByteArray.A();
            parsableByteArray.V(2);
            i3++;
        }
        parsableByteArray.V((int) (f2 - ((long) parsableByteArray.f())));
        return new FlacStreamMetadata.SeekTable(jArr, jArr2);
    }

    private static FlacStreamMetadata h(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = new byte[38];
        extractorInput.readFully(bArr, 0, 38);
        return new FlacStreamMetadata(bArr, 4);
    }

    public static void i(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        extractorInput.readFully(parsableByteArray.e(), 0, 4);
        if (parsableByteArray.J() != 1716281667) {
            throw ParserException.a("Failed to read FLAC stream marker.", (Throwable) null);
        }
    }

    private static List<String> j(ExtractorInput extractorInput, int i2) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
        extractorInput.readFully(parsableByteArray.e(), 0, i2);
        parsableByteArray.V(4);
        return Arrays.asList(VorbisUtil.j(parsableByteArray, false, false).f24260b);
    }
}
