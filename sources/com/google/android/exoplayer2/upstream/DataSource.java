package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DataSource extends DataReader {

    public interface Factory {
        DataSource a();
    }

    Uri b();

    void close() throws IOException;

    Map<String, List<String>> d();

    long i(DataSpec dataSpec) throws IOException;

    void p(TransferListener transferListener);
}
