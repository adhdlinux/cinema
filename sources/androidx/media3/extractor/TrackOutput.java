package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

public interface TrackOutput {

    public static final class CryptoData {

        /* renamed from: a  reason: collision with root package name */
        public final int f8086a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f8087b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8088c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8089d;

        public CryptoData(int i2, byte[] bArr, int i3, int i4) {
            this.f8086a = i2;
            this.f8087b = bArr;
            this.f8088c = i3;
            this.f8089d = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CryptoData.class != obj.getClass()) {
                return false;
            }
            CryptoData cryptoData = (CryptoData) obj;
            if (this.f8086a == cryptoData.f8086a && this.f8088c == cryptoData.f8088c && this.f8089d == cryptoData.f8089d && Arrays.equals(this.f8087b, cryptoData.f8087b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f8086a * 31) + Arrays.hashCode(this.f8087b)) * 31) + this.f8088c) * 31) + this.f8089d;
        }
    }

    void a(ParsableByteArray parsableByteArray, int i2, int i3);

    void b(ParsableByteArray parsableByteArray, int i2);

    void c(Format format);

    int d(DataReader dataReader, int i2, boolean z2) throws IOException;

    int e(DataReader dataReader, int i2, boolean z2, int i3) throws IOException;

    void f(long j2, int i2, int i3, int i4, CryptoData cryptoData);
}
