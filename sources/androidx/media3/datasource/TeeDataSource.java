package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class TeeDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource f4915a;

    /* renamed from: b  reason: collision with root package name */
    private final DataSink f4916b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4917c;

    /* renamed from: d  reason: collision with root package name */
    private long f4918d;

    public TeeDataSource(DataSource dataSource, DataSink dataSink) {
        this.f4915a = (DataSource) Assertions.f(dataSource);
        this.f4916b = (DataSink) Assertions.f(dataSink);
    }

    public Uri b() {
        return this.f4915a.b();
    }

    public void close() throws IOException {
        try {
            this.f4915a.close();
        } finally {
            if (this.f4917c) {
                this.f4917c = false;
                this.f4916b.close();
            }
        }
    }

    public Map<String, List<String>> d() {
        return this.f4915a.d();
    }

    public long i(DataSpec dataSpec) throws IOException {
        long i2 = this.f4915a.i(dataSpec);
        this.f4918d = i2;
        if (i2 == 0) {
            return 0;
        }
        if (dataSpec.f4830h == -1 && i2 != -1) {
            dataSpec = dataSpec.f(0, i2);
        }
        this.f4917c = true;
        this.f4916b.i(dataSpec);
        return this.f4918d;
    }

    public void n(TransferListener transferListener) {
        Assertions.f(transferListener);
        this.f4915a.n(transferListener);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f4918d == 0) {
            return -1;
        }
        int read = this.f4915a.read(bArr, i2, i3);
        if (read > 0) {
            this.f4916b.write(bArr, i2, read);
            long j2 = this.f4918d;
            if (j2 != -1) {
                this.f4918d = j2 - ((long) read);
            }
        }
        return read;
    }
}
