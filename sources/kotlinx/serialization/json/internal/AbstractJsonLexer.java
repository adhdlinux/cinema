package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;

public abstract class AbstractJsonLexer {
    /* access modifiers changed from: protected */

    /* renamed from: a  reason: collision with root package name */
    public int f41184a;

    /* renamed from: b  reason: collision with root package name */
    public final JsonPath f41185b = new JsonPath();

    /* renamed from: c  reason: collision with root package name */
    private String f41186c;

    /* renamed from: d  reason: collision with root package name */
    private StringBuilder f41187d = new StringBuilder();

    private final int B(CharSequence charSequence, int i2) {
        boolean z2;
        boolean z3;
        char charAt = charSequence.charAt(i2);
        boolean z4 = true;
        if ('0' > charAt || charAt >= ':') {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return charAt - '0';
        }
        char c2 = 'a';
        if ('a' > charAt || charAt >= 'g') {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            c2 = 'A';
            if ('A' > charAt || charAt >= 'G') {
                z4 = false;
            }
            if (!z4) {
                y(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        return (charAt - c2) + 10;
    }

    private final String K() {
        String str = this.f41186c;
        Intrinsics.c(str);
        this.f41186c = null;
        return str;
    }

    private final boolean O() {
        return C().charAt(this.f41184a - 1) != '\"';
    }

    private final int b(int i2) {
        int G = G(i2);
        if (G != -1) {
            int i3 = G + 1;
            char charAt = C().charAt(G);
            if (charAt == 'u') {
                return d(C(), i3);
            }
            char b2 = AbstractJsonLexerKt.b(charAt);
            if (b2 != 0) {
                this.f41187d.append(b2);
                return i3;
            }
            y(this, "Invalid escaped char '" + charAt + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        y(this, "Expected escape sequence to continue, got EOF", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final int c(int i2, int i3) {
        e(i2, i3);
        return b(i3 + 1);
    }

    private final int d(CharSequence charSequence, int i2) {
        int i3 = i2 + 4;
        if (i3 >= charSequence.length()) {
            this.f41184a = i2;
            v();
            if (this.f41184a + 4 < charSequence.length()) {
                return d(charSequence, this.f41184a);
            }
            y(this, "Unexpected EOF during unicode escape", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        this.f41187d.append((char) ((B(charSequence, i2) << 12) + (B(charSequence, i2 + 1) << 8) + (B(charSequence, i2 + 2) << 4) + B(charSequence, i2 + 3)));
        return i3;
    }

    private final boolean h(int i2) {
        int G = G(i2);
        if (G >= C().length() || G == -1) {
            y(this, "EOF", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        int i3 = G + 1;
        char charAt = C().charAt(G) | ' ';
        if (charAt == 'f') {
            j("alse", i3);
            return false;
        } else if (charAt == 't') {
            j("rue", i3);
            return true;
        } else {
            y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    private final void j(String str, int i2) {
        if (C().length() - i2 >= str.length()) {
            int length = str.length();
            int i3 = 0;
            while (i3 < length) {
                if (str.charAt(i3) == (C().charAt(i2 + i3) | ' ')) {
                    i3++;
                } else {
                    y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            this.f41184a = i2 + str.length();
            return;
        }
        y(this, "Unexpected end of boolean literal", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final String u(int i2, int i3) {
        e(i2, i3);
        String sb = this.f41187d.toString();
        Intrinsics.e(sb, "escapedString.toString()");
        this.f41187d.setLength(0);
        return sb;
    }

    public static /* synthetic */ Void y(AbstractJsonLexer abstractJsonLexer, String str, int i2, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = abstractJsonLexer.f41184a;
            }
            if ((i3 & 4) != 0) {
                str2 = "";
            }
            return abstractJsonLexer.x(str, i2, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public final void A(String str) {
        Intrinsics.f(str, "key");
        int b02 = StringsKt__StringsKt.b0(J(0, this.f41184a), str, 0, false, 6, (Object) null);
        x("Encountered an unknown key '" + str + '\'', b02, "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence C();

    /* access modifiers changed from: protected */
    public final boolean D(char c2) {
        boolean z2 = false;
        if (((c2 == '}' || c2 == ']') || c2 == ':') || c2 == ',') {
            z2 = true;
        }
        return !z2;
    }

    public final byte E() {
        CharSequence C = C();
        int i2 = this.f41184a;
        while (true) {
            int G = G(i2);
            if (G != -1) {
                char charAt = C.charAt(G);
                if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                    i2 = G + 1;
                } else {
                    this.f41184a = G;
                    return AbstractJsonLexerKt.a(charAt);
                }
            } else {
                this.f41184a = G;
                return 10;
            }
        }
    }

    public final String F(boolean z2) {
        String str;
        byte E = E();
        if (z2) {
            if (E != 1 && E != 0) {
                return null;
            }
            str = s();
        } else if (E != 1) {
            return null;
        } else {
            str = q();
        }
        this.f41186c = str;
        return str;
    }

    public abstract int G(int i2);

    public final void H(boolean z2) {
        ArrayList arrayList = new ArrayList();
        byte E = E();
        if (E == 8 || E == 6) {
            while (true) {
                byte E2 = E();
                boolean z3 = true;
                if (E2 != 1) {
                    if (!(E2 == 8 || E2 == 6)) {
                        z3 = false;
                    }
                    if (z3) {
                        arrayList.add(Byte.valueOf(E2));
                    } else if (E2 == 9) {
                        if (((Number) CollectionsKt___CollectionsKt.K(arrayList)).byteValue() == 8) {
                            Object unused = CollectionsKt__MutableCollectionsKt.w(arrayList);
                        } else {
                            int i2 = this.f41184a;
                            throw JsonExceptionsKt.f(i2, "found ] instead of } at path: " + this.f41185b, C());
                        }
                    } else if (E2 == 7) {
                        if (((Number) CollectionsKt___CollectionsKt.K(arrayList)).byteValue() == 6) {
                            Object unused2 = CollectionsKt__MutableCollectionsKt.w(arrayList);
                        } else {
                            int i3 = this.f41184a;
                            throw JsonExceptionsKt.f(i3, "found } instead of ] at path: " + this.f41185b, C());
                        }
                    } else if (E2 == 10) {
                        y(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, (String) null, 6, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                    m();
                    if (arrayList.size() == 0) {
                        return;
                    }
                } else if (z2) {
                    s();
                } else {
                    k();
                }
            }
        } else {
            s();
        }
    }

    public int I() {
        int G;
        char charAt;
        int i2 = this.f41184a;
        while (true) {
            G = G(i2);
            if (G == -1 || !((charAt = C().charAt(G)) == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                this.f41184a = G;
            } else {
                i2 = G + 1;
            }
        }
        this.f41184a = G;
        return G;
    }

    public String J(int i2, int i3) {
        return C().subSequence(i2, i3).toString();
    }

    public abstract boolean L();

    public final boolean M() {
        int G = G(I());
        int length = C().length() - G;
        if (length < 4 || G == -1) {
            return true;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            if ("null".charAt(i2) != C().charAt(G + i2)) {
                return true;
            }
        }
        if (length > 4 && AbstractJsonLexerKt.a(C().charAt(G + 4)) == 0) {
            return true;
        }
        this.f41184a = G + 4;
        return false;
    }

    /* access modifiers changed from: protected */
    public final void N(char c2) {
        int i2 = this.f41184a - 1;
        this.f41184a = i2;
        if (i2 < 0 || c2 != '\"' || !Intrinsics.a(s(), "null")) {
            z(AbstractJsonLexerKt.a(c2));
            throw new KotlinNothingValueException();
        } else {
            x("Expected string literal but 'null' literal was found", this.f41184a - 4, "Use 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    public void e(int i2, int i3) {
        this.f41187d.append(C(), i2, i3);
    }

    public abstract boolean f();

    public final boolean g() {
        return h(I());
    }

    public final boolean i() {
        boolean z2;
        int I = I();
        if (I != C().length()) {
            if (C().charAt(I) == '\"') {
                I++;
                z2 = true;
            } else {
                z2 = false;
            }
            boolean h2 = h(I);
            if (z2) {
                if (this.f41184a == C().length()) {
                    y(this, "EOF", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                } else if (C().charAt(this.f41184a) == '\"') {
                    this.f41184a++;
                } else {
                    y(this, "Expected closing quotation mark", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            return h2;
        }
        y(this, "EOF", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public abstract String k();

    public abstract String l(String str, boolean z2);

    public abstract byte m();

    public final byte n(byte b2) {
        byte m2 = m();
        if (m2 == b2) {
            return m2;
        }
        z(b2);
        throw new KotlinNothingValueException();
    }

    public void o(char c2) {
        v();
        CharSequence C = C();
        int i2 = this.f41184a;
        while (true) {
            int G = G(i2);
            if (G != -1) {
                int i3 = G + 1;
                char charAt = C.charAt(G);
                if (!(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                    this.f41184a = i3;
                    if (charAt != c2) {
                        N(c2);
                    } else {
                        return;
                    }
                }
                i2 = i3;
            } else {
                this.f41184a = G;
                N(c2);
                return;
            }
        }
    }

    public final long p() {
        boolean z2;
        boolean z3;
        int G = G(I());
        if (G >= C().length() || G == -1) {
            y(this, "EOF", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        if (C().charAt(G) == '\"') {
            G++;
            if (G != C().length()) {
                z2 = true;
            } else {
                y(this, "EOF", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        } else {
            z2 = false;
        }
        int i2 = G;
        long j2 = 0;
        boolean z4 = true;
        boolean z5 = false;
        while (z4) {
            char charAt = C().charAt(i2);
            if (charAt != '-') {
                if (AbstractJsonLexerKt.a(charAt) != 0) {
                    break;
                }
                i2++;
                if (i2 != C().length()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i3 = charAt - '0';
                if (i3 < 0 || i3 >= 10) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    j2 = (j2 * ((long) 10)) - ((long) i3);
                    if (j2 > 0) {
                        y(this, "Numeric value overflow", 0, (String) null, 6, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    y(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            } else if (i2 == G) {
                i2++;
                z5 = true;
            } else {
                y(this, "Unexpected symbol '-' in numeric literal", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        if (G == i2 || (z5 && G == i2 - 1)) {
            y(this, "Expected numeric literal", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        if (z2) {
            if (!z4) {
                y(this, "EOF", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            } else if (C().charAt(i2) == '\"') {
                i2++;
            } else {
                y(this, "Expected closing quotation mark", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        this.f41184a = i2;
        if (z5) {
            return j2;
        }
        if (j2 != Long.MIN_VALUE) {
            return -j2;
        }
        y(this, "Numeric value overflow", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final String q() {
        if (this.f41186c != null) {
            return K();
        }
        return k();
    }

    /* access modifiers changed from: protected */
    public final String r(CharSequence charSequence, int i2, int i3) {
        String str;
        int G;
        Intrinsics.f(charSequence, "source");
        char charAt = charSequence.charAt(i3);
        boolean z2 = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                G = G(c(i2, i3));
                if (G == -1) {
                    y(this, "EOF", G, (String) null, 4, (Object) null);
                    throw new KotlinNothingValueException();
                }
            } else {
                i3++;
                if (i3 >= charSequence.length()) {
                    e(i2, i3);
                    G = G(i3);
                    if (G == -1) {
                        y(this, "EOF", G, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    charAt = charSequence.charAt(i3);
                }
            }
            i2 = G;
            i3 = i2;
            z2 = true;
            charAt = charSequence.charAt(i3);
        }
        if (!z2) {
            str = J(i2, i3);
        } else {
            str = u(i2, i3);
        }
        this.f41184a = i3 + 1;
        return str;
    }

    public final String s() {
        String str;
        if (this.f41186c != null) {
            return K();
        }
        int I = I();
        if (I >= C().length() || I == -1) {
            y(this, "EOF", I, (String) null, 4, (Object) null);
            throw new KotlinNothingValueException();
        }
        byte a2 = AbstractJsonLexerKt.a(C().charAt(I));
        if (a2 == 1) {
            return q();
        }
        if (a2 == 0) {
            boolean z2 = false;
            while (AbstractJsonLexerKt.a(C().charAt(I)) == 0) {
                I++;
                if (I >= C().length()) {
                    e(this.f41184a, I);
                    int G = G(I);
                    if (G == -1) {
                        this.f41184a = I;
                        return u(0, 0);
                    }
                    I = G;
                    z2 = true;
                }
            }
            if (!z2) {
                str = J(this.f41184a, I);
            } else {
                str = u(this.f41184a, I);
            }
            this.f41184a = I;
            return str;
        }
        y(this, "Expected beginning of the string, but got " + C().charAt(I), 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final String t() {
        String s2 = s();
        if (!Intrinsics.a(s2, "null") || !O()) {
            return s2;
        }
        y(this, "Unexpected 'null' value instead of string literal", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return "JsonReader(source='" + C() + "', currentPosition=" + this.f41184a + ')';
    }

    public void v() {
    }

    public final void w() {
        if (m() != 10) {
            y(this, "Expected EOF after parsing, but had " + C().charAt(this.f41184a - 1) + " instead", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final Void x(String str, int i2, String str2) {
        boolean z2;
        String str3;
        Intrinsics.f(str, "message");
        Intrinsics.f(str2, "hint");
        if (str2.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            str3 = "";
        } else {
            str3 = 10 + str2;
        }
        throw JsonExceptionsKt.f(i2, str + " at path: " + this.f41185b.a() + str3, C());
    }

    public final Void z(byte b2) {
        String str;
        String str2;
        if (b2 == 1) {
            str = "quotation mark '\"'";
        } else if (b2 == 4) {
            str = "comma ','";
        } else if (b2 == 5) {
            str = "colon ':'";
        } else if (b2 == 6) {
            str = "start of the object '{'";
        } else if (b2 == 7) {
            str = "end of the object '}'";
        } else if (b2 == 8) {
            str = "start of the array '['";
        } else if (b2 == 9) {
            str = "end of the array ']'";
        } else {
            str = "valid token";
        }
        if (this.f41184a == C().length() || this.f41184a <= 0) {
            str2 = "EOF";
        } else {
            str2 = String.valueOf(C().charAt(this.f41184a - 1));
        }
        y(this, "Expected " + str + ", but had '" + str2 + "' instead", this.f41184a - 1, (String) null, 4, (Object) null);
        throw new KotlinNothingValueException();
    }
}
