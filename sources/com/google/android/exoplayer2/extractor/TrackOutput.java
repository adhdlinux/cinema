package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

public interface TrackOutput {

    public static final class CryptoData {

        /* renamed from: a  reason: collision with root package name */
        public final int f24239a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f24240b;

        /* renamed from: c  reason: collision with root package name */
        public final int f24241c;

        /* renamed from: d  reason: collision with root package name */
        public final int f24242d;

        public CryptoData(int i2, byte[] bArr, int i3, int i4) {
            this.f24239a = i2;
            this.f24240b = bArr;
            this.f24241c = i3;
            this.f24242d = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CryptoData.class != obj.getClass()) {
                return false;
            }
            CryptoData cryptoData = (CryptoData) obj;
            if (this.f24239a == cryptoData.f24239a && this.f24241c == cryptoData.f24241c && this.f24242d == cryptoData.f24242d && Arrays.equals(this.f24240b, cryptoData.f24240b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f24239a * 31) + Arrays.hashCode(this.f24240b)) * 31) + this.f24241c) * 31) + this.f24242d;
        }
    }

    int a(DataReader dataReader, int i2, boolean z2, int i3) throws IOException;

    int b(DataReader dataReader, int i2, boolean z2) throws IOException;

    void c(ParsableByteArray parsableByteArray, int i2);

    void d(Format format);

    void e(long j2, int i2, int i3, int i4, CryptoData cryptoData);

    void f(ParsableByteArray parsableByteArray, int i2, int i3);
}
