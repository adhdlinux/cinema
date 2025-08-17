package androidx.media3.decoder;

import android.media.MediaCodec;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

public final class CryptoInfo {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f5053a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f5054b;

    /* renamed from: c  reason: collision with root package name */
    public int f5055c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f5056d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f5057e;

    /* renamed from: f  reason: collision with root package name */
    public int f5058f;

    /* renamed from: g  reason: collision with root package name */
    public int f5059g;

    /* renamed from: h  reason: collision with root package name */
    public int f5060h;

    /* renamed from: i  reason: collision with root package name */
    private final MediaCodec.CryptoInfo f5061i;

    /* renamed from: j  reason: collision with root package name */
    private final PatternHolderV24 f5062j;

    private static final class PatternHolderV24 {

        /* renamed from: a  reason: collision with root package name */
        private final MediaCodec.CryptoInfo f5063a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f5064b;

        /* access modifiers changed from: private */
        public void b(int i2, int i3) {
            this.f5064b.set(i2, i3);
            this.f5063a.setPattern(this.f5064b);
        }

        private PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            this.f5063a = cryptoInfo;
            this.f5064b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f5061i = cryptoInfo;
        this.f5062j = Util.f4714a >= 24 ? new PatternHolderV24(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f5061i;
    }

    public void b(int i2) {
        if (i2 != 0) {
            if (this.f5056d == null) {
                int[] iArr = new int[1];
                this.f5056d = iArr;
                this.f5061i.numBytesOfClearData = iArr;
            }
            int[] iArr2 = this.f5056d;
            iArr2[0] = iArr2[0] + i2;
        }
    }

    public void c(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        this.f5058f = i2;
        this.f5056d = iArr;
        this.f5057e = iArr2;
        this.f5054b = bArr;
        this.f5053a = bArr2;
        this.f5055c = i3;
        this.f5059g = i4;
        this.f5060h = i5;
        MediaCodec.CryptoInfo cryptoInfo = this.f5061i;
        cryptoInfo.numSubSamples = i2;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i3;
        if (Util.f4714a >= 24) {
            ((PatternHolderV24) Assertions.f(this.f5062j)).b(i4, i5);
        }
    }
}
