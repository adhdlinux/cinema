package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public final class DataSourceUtil {
    private DataSourceUtil() {
    }

    public static void a(DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException unused) {
            }
        }
    }
}
