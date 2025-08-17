package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public class DataSourceException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public final int f28332b;

    public DataSourceException(int i2) {
        this.f28332b = i2;
    }

    public static boolean a(IOException iOException) {
        Throwable th;
        while (th != null) {
            if ((th instanceof DataSourceException) && ((DataSourceException) th).f28332b == 2008) {
                return true;
            }
            Throwable cause = th.getCause();
            th = iOException;
            th = cause;
        }
        return false;
    }

    public DataSourceException(Throwable th, int i2) {
        super(th);
        this.f28332b = i2;
    }

    public DataSourceException(String str, int i2) {
        super(str);
        this.f28332b = i2;
    }

    public DataSourceException(String str, Throwable th, int i2) {
        super(str, th);
        this.f28332b = i2;
    }
}
