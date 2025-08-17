package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class TeeDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource f28516a;

    /* renamed from: b  reason: collision with root package name */
    private final DataSink f28517b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f28518c;

    /* renamed from: d  reason: collision with root package name */
    private long f28519d;

    public TeeDataSource(DataSource dataSource, DataSink dataSink) {
        this.f28516a = (DataSource) Assertions.e(dataSource);
        this.f28517b = (DataSink) Assertions.e(dataSink);
    }

    public Uri b() {
        return this.f28516a.b();
    }

    public void close() throws IOException {
        try {
            this.f28516a.close();
        } finally {
            if (this.f28518c) {
                this.f28518c = false;
                this.f28517b.close();
            }
        }
    }

    public Map<String, List<String>> d() {
        return this.f28516a.d();
    }

    public long i(DataSpec dataSpec) throws IOException {
        long i2 = this.f28516a.i(dataSpec);
        this.f28519d = i2;
        if (i2 == 0) {
            return 0;
        }
        if (dataSpec.f28346h == -1 && i2 != -1) {
            dataSpec = dataSpec.f(0, i2);
        }
        this.f28518c = true;
        this.f28517b.i(dataSpec);
        return this.f28519d;
    }

    public void p(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f28516a.p(transferListener);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f28519d == 0) {
            return -1;
        }
        int read = this.f28516a.read(bArr, i2, i3);
        if (read > 0) {
            this.f28517b.write(bArr, i2, read);
            long j2 = this.f28519d;
            if (j2 != -1) {
                this.f28519d = j2 - ((long) read);
            }
        }
        return read;
    }
}
