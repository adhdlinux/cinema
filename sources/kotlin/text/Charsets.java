package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;

public final class Charsets {

    /* renamed from: a  reason: collision with root package name */
    public static final Charsets f40512a = new Charsets();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f40513b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f40514c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f40515d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f40516e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f40517f;

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f40518g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile Charset f40519h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile Charset f40520i;

    static {
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.e(forName, "forName(\"UTF-8\")");
        f40513b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        Intrinsics.e(forName2, "forName(\"UTF-16\")");
        f40514c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        Intrinsics.e(forName3, "forName(\"UTF-16BE\")");
        f40515d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        Intrinsics.e(forName4, "forName(\"UTF-16LE\")");
        f40516e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        Intrinsics.e(forName5, "forName(\"US-ASCII\")");
        f40517f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        Intrinsics.e(forName6, "forName(\"ISO-8859-1\")");
        f40518g = forName6;
    }

    private Charsets() {
    }

    public final Charset a() {
        Charset charset = f40520i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        Intrinsics.e(forName, "forName(\"UTF-32BE\")");
        f40520i = forName;
        return forName;
    }

    public final Charset b() {
        Charset charset = f40519h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        Intrinsics.e(forName, "forName(\"UTF-32LE\")");
        f40519h = forName;
        return forName;
    }
}
