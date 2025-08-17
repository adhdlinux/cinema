package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;

final class AudioTagPayloadReader extends TagPayloadReader {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f24360e = {5512, 11025, 22050, 44100};

    /* renamed from: b  reason: collision with root package name */
    private boolean f24361b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24362c;

    /* renamed from: d  reason: collision with root package name */
    private int f24363d;

    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    /* access modifiers changed from: protected */
    public boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        String str;
        if (!this.f24361b) {
            int H = parsableByteArray.H();
            int i2 = (H >> 4) & 15;
            this.f24363d = i2;
            if (i2 == 2) {
                this.f24384a.d(new Format.Builder().g0("audio/mpeg").J(1).h0(f24360e[(H >> 2) & 3]).G());
                this.f24362c = true;
            } else if (i2 == 7 || i2 == 8) {
                if (i2 == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                this.f24384a.d(new Format.Builder().g0(str).J(1).h0(8000).G());
                this.f24362c = true;
            } else if (i2 != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f24363d);
            }
            this.f24361b = true;
        } else {
            parsableByteArray.V(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean c(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        if (this.f24363d == 2) {
            int a2 = parsableByteArray.a();
            this.f24384a.c(parsableByteArray, a2);
            this.f24384a.e(j2, 1, a2, 0, (TrackOutput.CryptoData) null);
            return true;
        }
        int H = parsableByteArray.H();
        if (H == 0 && !this.f24362c) {
            int a3 = parsableByteArray.a();
            byte[] bArr = new byte[a3];
            parsableByteArray.l(bArr, 0, a3);
            AacUtil.Config f2 = AacUtil.f(bArr);
            this.f24384a.d(new Format.Builder().g0("audio/mp4a-latm").K(f2.f23635c).J(f2.f23634b).h0(f2.f23633a).V(Collections.singletonList(bArr)).G());
            this.f24362c = true;
            return false;
        } else if (this.f24363d == 10 && H != 1) {
            return false;
        } else {
            int a4 = parsableByteArray.a();
            this.f24384a.c(parsableByteArray, a4);
            this.f24384a.e(j2, 1, a4, 0, (TrackOutput.CryptoData) null);
            return true;
        }
    }
}
