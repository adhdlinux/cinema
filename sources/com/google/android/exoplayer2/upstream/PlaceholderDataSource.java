package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import java.io.IOException;
import java.util.Map;
import u0.b;
import u0.e;

public final class PlaceholderDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    public static final PlaceholderDataSource f28488a = new PlaceholderDataSource();

    /* renamed from: b  reason: collision with root package name */
    public static final DataSource.Factory f28489b = new e();

    private PlaceholderDataSource() {
    }

    public static /* synthetic */ PlaceholderDataSource q() {
        return new PlaceholderDataSource();
    }

    public Uri b() {
        return null;
    }

    public void close() {
    }

    public /* synthetic */ Map d() {
        return b.a(this);
    }

    public long i(DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    public void p(TransferListener transferListener) {
    }

    public int read(byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }
}
