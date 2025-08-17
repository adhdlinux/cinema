package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.datasource.DataSource;
import c.a;
import c.b;
import java.io.IOException;
import java.util.Map;

public final class PlaceholderDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    public static final PlaceholderDataSource f4900a = new PlaceholderDataSource();

    /* renamed from: b  reason: collision with root package name */
    public static final DataSource.Factory f4901b = new b();

    private PlaceholderDataSource() {
    }

    public static /* synthetic */ PlaceholderDataSource o() {
        return new PlaceholderDataSource();
    }

    public Uri b() {
        return null;
    }

    public void close() {
    }

    public /* synthetic */ Map d() {
        return a.a(this);
    }

    public long i(DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    public void n(TransferListener transferListener) {
    }

    public int read(byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }
}
