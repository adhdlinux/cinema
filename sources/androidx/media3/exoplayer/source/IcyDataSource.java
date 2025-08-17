package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class IcyDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource f6930a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6931b;

    /* renamed from: c  reason: collision with root package name */
    private final Listener f6932c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f6933d;

    /* renamed from: e  reason: collision with root package name */
    private int f6934e;

    public interface Listener {
        void c(ParsableByteArray parsableByteArray);
    }

    public IcyDataSource(DataSource dataSource, int i2, Listener listener) {
        boolean z2;
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f6930a = dataSource;
        this.f6931b = i2;
        this.f6932c = listener;
        this.f6933d = new byte[1];
        this.f6934e = i2;
    }

    private boolean o() throws IOException {
        if (this.f6930a.read(this.f6933d, 0, 1) == -1) {
            return false;
        }
        int i2 = (this.f6933d[0] & 255) << 4;
        if (i2 == 0) {
            return true;
        }
        byte[] bArr = new byte[i2];
        int i3 = i2;
        int i4 = 0;
        while (i3 > 0) {
            int read = this.f6930a.read(bArr, i4, i3);
            if (read == -1) {
                return false;
            }
            i4 += read;
            i3 -= read;
        }
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        if (i2 > 0) {
            this.f6932c.c(new ParsableByteArray(bArr, i2));
        }
        return true;
    }

    public Uri b() {
        return this.f6930a.b();
    }

    public void close() {
        throw new UnsupportedOperationException();
    }

    public Map<String, List<String>> d() {
        return this.f6930a.d();
    }

    public long i(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    public void n(TransferListener transferListener) {
        Assertions.f(transferListener);
        this.f6930a.n(transferListener);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f6934e == 0) {
            if (!o()) {
                return -1;
            }
            this.f6934e = this.f6931b;
        }
        int read = this.f6930a.read(bArr, i2, Math.min(this.f6934e, i3));
        if (read != -1) {
            this.f6934e -= read;
        }
        return read;
    }
}
