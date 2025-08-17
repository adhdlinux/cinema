package androidx.work;

import android.util.Log;

public abstract class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static Logger f12184a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final int f12185b = 20;

    public static class LogcatLogger extends Logger {

        /* renamed from: c  reason: collision with root package name */
        private int f12186c;

        public LogcatLogger(int i2) {
            super(i2);
            this.f12186c = i2;
        }

        public void a(String str, String str2, Throwable... thArr) {
            if (this.f12186c > 3) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, thArr[0]);
            }
        }

        public void b(String str, String str2, Throwable... thArr) {
            if (this.f12186c > 6) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, thArr[0]);
            }
        }

        public void d(String str, String str2, Throwable... thArr) {
            if (this.f12186c > 4) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, thArr[0]);
            }
        }

        public void g(String str, String str2, Throwable... thArr) {
            if (this.f12186c > 2) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, thArr[0]);
            }
        }

        public void h(String str, String str2, Throwable... thArr) {
            if (this.f12186c > 5) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, thArr[0]);
            }
        }
    }

    public Logger(int i2) {
    }

    public static synchronized Logger c() {
        Logger logger;
        synchronized (Logger.class) {
            if (f12184a == null) {
                f12184a = new LogcatLogger(3);
            }
            logger = f12184a;
        }
        return logger;
    }

    public static synchronized void e(Logger logger) {
        synchronized (Logger.class) {
            f12184a = logger;
        }
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i2 = f12185b;
        if (length >= i2) {
            sb.append(str.substring(0, i2));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void g(String str, String str2, Throwable... thArr);

    public abstract void h(String str, String str2, Throwable... thArr);
}
