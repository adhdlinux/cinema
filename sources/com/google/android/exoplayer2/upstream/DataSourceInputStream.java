package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.io.InputStream;

public final class DataSourceInputStream extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f28333b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSpec f28334c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f28335d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f28336e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f28337f = false;

    /* renamed from: g  reason: collision with root package name */
    private long f28338g;

    public DataSourceInputStream(DataSource dataSource, DataSpec dataSpec) {
        this.f28333b = dataSource;
        this.f28334c = dataSpec;
        this.f28335d = new byte[1];
    }

    private void a() throws IOException {
        if (!this.f28336e) {
            this.f28333b.i(this.f28334c);
            this.f28336e = true;
        }
    }

    public void close() throws IOException {
        if (!this.f28337f) {
            this.f28333b.close();
            this.f28337f = true;
        }
    }

    public void f() throws IOException {
        a();
    }

    public int read() throws IOException {
        if (read(this.f28335d) == -1) {
            return -1;
        }
        return this.f28335d[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        Assertions.g(!this.f28337f);
        a();
        int read = this.f28333b.read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        this.f28338g += (long) read;
        return read;
    }
}
