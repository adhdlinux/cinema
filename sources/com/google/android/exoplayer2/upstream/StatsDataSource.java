package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class StatsDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource f28512a;

    /* renamed from: b  reason: collision with root package name */
    private long f28513b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f28514c = Uri.EMPTY;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, List<String>> f28515d = Collections.emptyMap();

    public StatsDataSource(DataSource dataSource) {
        this.f28512a = (DataSource) Assertions.e(dataSource);
    }

    public Uri b() {
        return this.f28512a.b();
    }

    public void close() throws IOException {
        this.f28512a.close();
    }

    public Map<String, List<String>> d() {
        return this.f28512a.d();
    }

    public long i(DataSpec dataSpec) throws IOException {
        this.f28514c = dataSpec.f28339a;
        this.f28515d = Collections.emptyMap();
        long i2 = this.f28512a.i(dataSpec);
        this.f28514c = (Uri) Assertions.e(b());
        this.f28515d = d();
        return i2;
    }

    public void p(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f28512a.p(transferListener);
    }

    public long q() {
        return this.f28513b;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.f28512a.read(bArr, i2, i3);
        if (read != -1) {
            this.f28513b += (long) read;
        }
        return read;
    }

    public Uri s() {
        return this.f28514c;
    }

    public Map<String, List<String>> t() {
        return this.f28515d;
    }

    public void u() {
        this.f28513b = 0;
    }
}
