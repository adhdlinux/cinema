package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;
import u0.d;

public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy {

    /* renamed from: a  reason: collision with root package name */
    private final int f28435a;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    public int a(int i2) {
        int i3 = this.f28435a;
        return i3 == -1 ? i2 == 7 ? 6 : 3 : i3;
    }

    public /* synthetic */ void b(long j2) {
        d.a(this, j2);
    }

    public long c(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        IOException iOException = loadErrorInfo.f28460c;
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource$CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException) || DataSourceException.a(iOException)) {
            return -9223372036854775807L;
        }
        return (long) Math.min((loadErrorInfo.f28461d - 1) * 1000, 5000);
    }

    public LoadErrorHandlingPolicy.FallbackSelection d(LoadErrorHandlingPolicy.FallbackOptions fallbackOptions, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        if (!e(loadErrorInfo.f28460c)) {
            return null;
        }
        if (fallbackOptions.a(1)) {
            return new LoadErrorHandlingPolicy.FallbackSelection(1, 300000);
        }
        if (fallbackOptions.a(2)) {
            return new LoadErrorHandlingPolicy.FallbackSelection(2, 60000);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean e(IOException iOException) {
        if (!(iOException instanceof HttpDataSource$InvalidResponseCodeException)) {
            return false;
        }
        int i2 = ((HttpDataSource$InvalidResponseCodeException) iOException).f28444e;
        if (i2 == 403 || i2 == 404 || i2 == 410 || i2 == 416 || i2 == 500 || i2 == 503) {
            return true;
        }
        return false;
    }

    public DefaultLoadErrorHandlingPolicy(int i2) {
        this.f28435a = i2;
    }
}
