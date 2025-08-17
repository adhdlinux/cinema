package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class CryptoInfo {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f23936a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f23937b;

    /* renamed from: c  reason: collision with root package name */
    public int f23938c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f23939d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f23940e;

    /* renamed from: f  reason: collision with root package name */
    public int f23941f;

    /* renamed from: g  reason: collision with root package name */
    public int f23942g;

    /* renamed from: h  reason: collision with root package name */
    public int f23943h;

    /* renamed from: i  reason: collision with root package name */
    private final MediaCodec.CryptoInfo f23944i;

    /* renamed from: j  reason: collision with root package name */
    private final PatternHolderV24 f23945j;

    private static final class PatternHolderV24 {

        /* renamed from: a  reason: collision with root package name */
        private final MediaCodec.CryptoInfo f23946a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f23947b;

        /* access modifiers changed from: private */
        public void b(int i2, int i3) {
            this.f23947b.set(i2, i3);
            this.f23946a.setPattern(this.f23947b);
        }

        private PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            this.f23946a = cryptoInfo;
            this.f23947b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f23944i = cryptoInfo;
        this.f23945j = Util.f28808a >= 24 ? new PatternHolderV24(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f23944i;
    }

    public void b(int i2) {
        if (i2 != 0) {
            if (this.f23939d == null) {
                int[] iArr = new int[1];
                this.f23939d = iArr;
                this.f23944i.numBytesOfClearData = iArr;
            }
            int[] iArr2 = this.f23939d;
            iArr2[0] = iArr2[0] + i2;
        }
    }

    public void c(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        this.f23941f = i2;
        this.f23939d = iArr;
        this.f23940e = iArr2;
        this.f23937b = bArr;
        this.f23936a = bArr2;
        this.f23938c = i3;
        this.f23942g = i4;
        this.f23943h = i5;
        MediaCodec.CryptoInfo cryptoInfo = this.f23944i;
        cryptoInfo.numSubSamples = i2;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i3;
        if (Util.f28808a >= 24) {
            ((PatternHolderV24) Assertions.e(this.f23945j)).b(i4, i5);
        }
    }
}
