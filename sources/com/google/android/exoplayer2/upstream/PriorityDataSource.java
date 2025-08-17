package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class PriorityDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource f28490a;

    /* renamed from: b  reason: collision with root package name */
    private final PriorityTaskManager f28491b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28492c;

    public PriorityDataSource(DataSource dataSource, PriorityTaskManager priorityTaskManager, int i2) {
        this.f28490a = (DataSource) Assertions.e(dataSource);
        this.f28491b = (PriorityTaskManager) Assertions.e(priorityTaskManager);
        this.f28492c = i2;
    }

    public Uri b() {
        return this.f28490a.b();
    }

    public void close() throws IOException {
        this.f28490a.close();
    }

    public Map<String, List<String>> d() {
        return this.f28490a.d();
    }

    public long i(DataSpec dataSpec) throws IOException {
        this.f28491b.c(this.f28492c);
        return this.f28490a.i(dataSpec);
    }

    public void p(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f28490a.p(transferListener);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        this.f28491b.c(this.f28492c);
        return this.f28490a.read(bArr, i2, i3);
    }
}
