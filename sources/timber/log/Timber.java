package timber.log;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class Timber {

    /* renamed from: a  reason: collision with root package name */
    public static final Forest f42178a = new Forest((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private static final ArrayList<Tree> f42179b = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile Tree[] f42180c = new Tree[0];

    public static final class Forest extends Tree {
        private Forest() {
        }

        public /* synthetic */ Forest(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public void a(String str, Object... objArr) {
            Intrinsics.f(objArr, "args");
            for (Tree a2 : Timber.f42180c) {
                a2.a(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void b(String str, Object... objArr) {
            Intrinsics.f(objArr, "args");
            for (Tree b2 : Timber.f42180c) {
                b2.b(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void c(Throwable th) {
            for (Tree c2 : Timber.f42180c) {
                c2.c(th);
            }
        }

        public void d(Throwable th, String str, Object... objArr) {
            Intrinsics.f(objArr, "args");
            for (Tree d2 : Timber.f42180c) {
                d2.d(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void h(String str, Object... objArr) {
            Intrinsics.f(objArr, "args");
            for (Tree h2 : Timber.f42180c) {
                h2.h(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        /* access modifiers changed from: protected */
        public void k(int i2, String str, String str2, Throwable th) {
            Intrinsics.f(str2, "message");
            throw new AssertionError();
        }

        public void m(String str, Object... objArr) {
            Intrinsics.f(objArr, "args");
            for (Tree m2 : Timber.f42180c) {
                m2.m(str, Arrays.copyOf(objArr, objArr.length));
            }
        }
    }

    public static abstract class Tree {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadLocal<String> f42181a = new ThreadLocal<>();

        private final String f(Throwable th) {
            StringWriter stringWriter = new StringWriter(UserVerificationMethods.USER_VERIFY_HANDPRINT);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String stringWriter2 = stringWriter.toString();
            Intrinsics.e(stringWriter2, "sw.toString()");
            return stringWriter2;
        }

        private final void l(int i2, Throwable th, String str, Object... objArr) {
            boolean z2;
            String g2 = g();
            if (j(g2, i2)) {
                boolean z3 = false;
                if (str == null || str.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (objArr.length == 0) {
                        z3 = true;
                    }
                    if (!z3) {
                        str = e(str, objArr);
                    }
                    if (th != null) {
                        str = str + 10 + f(th);
                    }
                } else if (th != null) {
                    str = f(th);
                } else {
                    return;
                }
                k(i2, g2, str, th);
            }
        }

        public void a(String str, Object... objArr) {
            Intrinsics.f(objArr, "args");
            l(3, (Throwable) null, str, Arrays.copyOf(objArr, objArr.length));
        }

        public void b(String str, Object... objArr) {
            Intrinsics.f(objArr, "args");
            l(6, (Throwable) null, str, Arrays.copyOf(objArr, objArr.length));
        }

        public void c(Throwable th) {
            l(6, th, (String) null, new Object[0]);
        }

        public void d(Throwable th, String str, Object... objArr) {
            Intrinsics.f(objArr, "args");
            l(6, th, str, Arrays.copyOf(objArr, objArr.length));
        }

        /* access modifiers changed from: protected */
        public String e(String str, Object[] objArr) {
            Intrinsics.f(str, "message");
            Intrinsics.f(objArr, "args");
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.e(format, "java.lang.String.format(this, *args)");
            return format;
        }

        public /* synthetic */ String g() {
            String str = this.f42181a.get();
            if (str != null) {
                this.f42181a.remove();
            }
            return str;
        }

        public void h(String str, Object... objArr) {
            Intrinsics.f(objArr, "args");
            l(4, (Throwable) null, str, Arrays.copyOf(objArr, objArr.length));
        }

        /* access modifiers changed from: protected */
        public boolean i(int i2) {
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean j(String str, int i2) {
            return i(i2);
        }

        /* access modifiers changed from: protected */
        public abstract void k(int i2, String str, String str2, Throwable th);

        public void m(String str, Object... objArr) {
            Intrinsics.f(objArr, "args");
            l(5, (Throwable) null, str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    private Timber() {
        throw new AssertionError();
    }

    public static void b(String str, Object... objArr) {
        f42178a.a(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        f42178a.b(str, objArr);
    }

    public static void d(Throwable th) {
        f42178a.c(th);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        f42178a.d(th, str, objArr);
    }

    public static void f(String str, Object... objArr) {
        f42178a.h(str, objArr);
    }

    public static void g(String str, Object... objArr) {
        f42178a.m(str, objArr);
    }
}
