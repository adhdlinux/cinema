package androidx.media3.datasource;

import java.io.IOException;

public class DataSourceException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public final int f4816b;

    public DataSourceException(int i2) {
        this.f4816b = i2;
    }

    public static boolean a(IOException iOException) {
        Throwable th;
        while (th != null) {
            if ((th instanceof DataSourceException) && ((DataSourceException) th).f4816b == 2008) {
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
        this.f4816b = i2;
    }

    public DataSourceException(String str, int i2) {
        super(str);
        this.f4816b = i2;
    }

    public DataSourceException(String str, Throwable th, int i2) {
        super(str, th);
        this.f4816b = i2;
    }
}
