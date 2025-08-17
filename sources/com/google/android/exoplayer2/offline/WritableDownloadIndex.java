package com.google.android.exoplayer2.offline;

import java.io.IOException;

public interface WritableDownloadIndex extends DownloadIndex {
    void a(String str, int i2) throws IOException;

    void b(String str) throws IOException;

    void c(int i2) throws IOException;

    void e() throws IOException;

    void f() throws IOException;

    void h(Download download) throws IOException;
}
