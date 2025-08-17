package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public final class HttpDataSource$CleartextNotPermittedException extends HttpDataSource$HttpDataSourceException {
    public HttpDataSource$CleartextNotPermittedException(IOException iOException, DataSpec dataSpec) {
        super("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, dataSpec, 2007, 1);
    }
}
