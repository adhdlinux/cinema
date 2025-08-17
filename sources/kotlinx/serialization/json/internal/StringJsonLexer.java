package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;

public final class StringJsonLexer extends AbstractJsonLexer {

    /* renamed from: e  reason: collision with root package name */
    private final String f41276e;

    public StringJsonLexer(String str) {
        Intrinsics.f(str, "source");
        this.f41276e = str;
    }

    public int G(int i2) {
        if (i2 < C().length()) {
            return i2;
        }
        return -1;
    }

    public int I() {
        int i2 = this.f41184a;
        if (i2 == -1) {
            return i2;
        }
        while (i2 < C().length() && ((r1 = C().charAt(i2)) == ' ' || r1 == 10 || r1 == 13 || r1 == 9)) {
            i2++;
        }
        this.f41184a = i2;
        return i2;
    }

    public boolean L() {
        int I = I();
        if (I == C().length() || I == -1 || C().charAt(I) != ',') {
            return false;
        }
        this.f41184a++;
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: P */
    public String C() {
        return this.f41276e;
    }

    public boolean f() {
        int i2 = this.f41184a;
        if (i2 == -1) {
            return false;
        }
        while (i2 < C().length()) {
            char charAt = C().charAt(i2);
            if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                i2++;
            } else {
                this.f41184a = i2;
                return D(charAt);
            }
        }
        this.f41184a = i2;
        return false;
    }

    public String k() {
        o('\"');
        int i2 = this.f41184a;
        int V = StringsKt__StringsKt.V(C(), '\"', i2, false, 4, (Object) null);
        if (V != -1) {
            for (int i3 = i2; i3 < V; i3++) {
                if (C().charAt(i3) == '\\') {
                    return r(C(), this.f41184a, i3);
                }
            }
            this.f41184a = V + 1;
            String substring = C().substring(i2, V);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        z((byte) 1);
        throw new KotlinNothingValueException();
    }

    public String l(String str, boolean z2) {
        String str2;
        String str3;
        Intrinsics.f(str, "keyToMatch");
        int i2 = this.f41184a;
        try {
            if (m() != 6) {
                return null;
            }
            if (z2) {
                str2 = k();
            } else {
                str2 = t();
            }
            if (!Intrinsics.a(str2, str)) {
                this.f41184a = i2;
                return null;
            } else if (m() != 5) {
                this.f41184a = i2;
                return null;
            } else {
                if (z2) {
                    str3 = q();
                } else {
                    str3 = t();
                }
                this.f41184a = i2;
                return str3;
            }
        } finally {
            this.f41184a = i2;
        }
    }

    public byte m() {
        byte a2;
        String P = C();
        do {
            int i2 = this.f41184a;
            if (i2 == -1 || i2 >= P.length()) {
                return 10;
            }
            int i3 = this.f41184a;
            this.f41184a = i3 + 1;
            a2 = AbstractJsonLexerKt.a(P.charAt(i3));
        } while (a2 == 3);
        return a2;
    }

    public void o(char c2) {
        if (this.f41184a == -1) {
            N(c2);
        }
        String P = C();
        while (this.f41184a < P.length()) {
            int i2 = this.f41184a;
            this.f41184a = i2 + 1;
            char charAt = P.charAt(i2);
            if (!(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                if (charAt != c2) {
                    N(c2);
                } else {
                    return;
                }
            }
        }
        N(c2);
    }
}
