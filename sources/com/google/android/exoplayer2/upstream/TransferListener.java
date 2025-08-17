package com.google.android.exoplayer2.upstream;

public interface TransferListener {
    void d(DataSource dataSource, DataSpec dataSpec, boolean z2);

    void f(DataSource dataSource, DataSpec dataSpec, boolean z2, int i2);

    void h(DataSource dataSource, DataSpec dataSpec, boolean z2);

    void i(DataSource dataSource, DataSpec dataSpec, boolean z2);
}
