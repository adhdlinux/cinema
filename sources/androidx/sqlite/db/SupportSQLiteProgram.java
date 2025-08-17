package androidx.sqlite.db;

import java.io.Closeable;

public interface SupportSQLiteProgram extends Closeable {
    void R(int i2, String str);

    void X(int i2, long j2);

    void Y(int i2, byte[] bArr);

    void d0(int i2);

    void l(int i2, double d2);
}
