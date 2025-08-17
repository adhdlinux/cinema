package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class PriorityDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource f4902a;

    /* renamed from: b  reason: collision with root package name */
    private final PriorityTaskManager f4903b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4904c;

    public PriorityDataSource(DataSource dataSource, PriorityTaskManager priorityTaskManager, int i2) {
        this.f4902a = (DataSource) Assertions.f(dataSource);
        this.f4903b = (PriorityTaskManager) Assertions.f(priorityTaskManager);
        this.f4904c = i2;
    }

    public Uri b() {
        return this.f4902a.b();
    }

    public void close() throws IOException {
        this.f4902a.close();
    }

    public Map<String, List<String>> d() {
        return this.f4902a.d();
    }

    public long i(DataSpec dataSpec) throws IOException {
        this.f4903b.b(this.f4904c);
        return this.f4902a.i(dataSpec);
    }

    public void n(TransferListener transferListener) {
        Assertions.f(transferListener);
        this.f4902a.n(transferListener);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        this.f4903b.b(this.f4904c);
        return this.f4902a.read(bArr, i2, i3);
    }
}
