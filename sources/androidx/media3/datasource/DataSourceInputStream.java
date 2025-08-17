package androidx.media3.datasource;

import androidx.media3.common.util.Assertions;
import java.io.IOException;
import java.io.InputStream;

public final class DataSourceInputStream extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f4817b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSpec f4818c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f4819d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4820e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4821f = false;

    /* renamed from: g  reason: collision with root package name */
    private long f4822g;

    public DataSourceInputStream(DataSource dataSource, DataSpec dataSpec) {
        this.f4817b = dataSource;
        this.f4818c = dataSpec;
        this.f4819d = new byte[1];
    }

    private void a() throws IOException {
        if (!this.f4820e) {
            this.f4817b.i(this.f4818c);
            this.f4820e = true;
        }
    }

    public void close() throws IOException {
        if (!this.f4821f) {
            this.f4817b.close();
            this.f4821f = true;
        }
    }

    public void f() throws IOException {
        a();
    }

    public int read() throws IOException {
        if (read(this.f4819d) == -1) {
            return -1;
        }
        return this.f4819d[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        Assertions.h(!this.f4821f);
        a();
        int read = this.f4817b.read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        this.f4822g += (long) read;
        return read;
    }
}
