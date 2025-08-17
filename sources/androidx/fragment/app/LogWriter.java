package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

final class LogWriter extends Writer {

    /* renamed from: b  reason: collision with root package name */
    private final String f3613b;

    /* renamed from: c  reason: collision with root package name */
    private StringBuilder f3614c = new StringBuilder(128);

    LogWriter(String str) {
        this.f3613b = str;
    }

    private void a() {
        if (this.f3614c.length() > 0) {
            Log.d(this.f3613b, this.f3614c.toString());
            StringBuilder sb = this.f3614c;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == 10) {
                a();
            } else {
                this.f3614c.append(c2);
            }
        }
    }
}
