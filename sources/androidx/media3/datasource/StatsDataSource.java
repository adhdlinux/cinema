package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class StatsDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource f4911a;

    /* renamed from: b  reason: collision with root package name */
    private long f4912b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f4913c = Uri.EMPTY;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, List<String>> f4914d = Collections.emptyMap();

    public StatsDataSource(DataSource dataSource) {
        this.f4911a = (DataSource) Assertions.f(dataSource);
    }

    public Uri b() {
        return this.f4911a.b();
    }

    public void close() throws IOException {
        this.f4911a.close();
    }

    public Map<String, List<String>> d() {
        return this.f4911a.d();
    }

    public long i(DataSpec dataSpec) throws IOException {
        this.f4913c = dataSpec.f4823a;
        this.f4914d = Collections.emptyMap();
        long i2 = this.f4911a.i(dataSpec);
        this.f4913c = (Uri) Assertions.f(b());
        this.f4914d = d();
        return i2;
    }

    public void n(TransferListener transferListener) {
        Assertions.f(transferListener);
        this.f4911a.n(transferListener);
    }

    public long o() {
        return this.f4912b;
    }

    public Uri p() {
        return this.f4913c;
    }

    public Map<String, List<String>> q() {
        return this.f4914d;
    }

    public void r() {
        this.f4912b = 0;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.f4911a.read(bArr, i2, i3);
        if (read != -1) {
            this.f4912b += (long) read;
        }
        return read;
    }
}
