package org.jsoup.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;
import org.jsoup.UncheckedIOException;
import org.jsoup.helper.Validate;

public final class CharacterReader {

    /* renamed from: a  reason: collision with root package name */
    private final char[] f41606a;

    /* renamed from: b  reason: collision with root package name */
    private final Reader f41607b;

    /* renamed from: c  reason: collision with root package name */
    private int f41608c;

    /* renamed from: d  reason: collision with root package name */
    private int f41609d;

    /* renamed from: e  reason: collision with root package name */
    private int f41610e;

    /* renamed from: f  reason: collision with root package name */
    private int f41611f;

    /* renamed from: g  reason: collision with root package name */
    private int f41612g;

    /* renamed from: h  reason: collision with root package name */
    private final String[] f41613h;

    public CharacterReader(Reader reader, int i2) {
        this.f41613h = new String[512];
        Validate.j(reader);
        Validate.d(reader.markSupported());
        this.f41607b = reader;
        this.f41606a = new char[(i2 > 32768 ? 32768 : i2)];
        b();
    }

    static boolean F(char[] cArr, int i2, int i3, String str) {
        if (i3 != str.length()) {
            return false;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 == 0) {
                return true;
            }
            int i6 = i2 + 1;
            int i7 = i4 + 1;
            if (cArr[i2] != str.charAt(i4)) {
                return false;
            }
            i2 = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    private void b() {
        int i2 = this.f41610e;
        if (i2 >= this.f41609d) {
            try {
                this.f41611f += i2;
                this.f41607b.skip((long) i2);
                this.f41607b.mark(32768);
                this.f41608c = this.f41607b.read(this.f41606a);
                this.f41607b.reset();
                this.f41610e = 0;
                this.f41612g = 0;
                int i3 = this.f41608c;
                if (i3 > 24576) {
                    i3 = 24576;
                }
                this.f41609d = i3;
            } catch (IOException e2) {
                throw new UncheckedIOException(e2);
            }
        }
    }

    private static String c(char[] cArr, String[] strArr, int i2, int i3) {
        if (i3 > 12) {
            return new String(cArr, i2, i3);
        }
        int i4 = 0;
        int i5 = i2;
        int i6 = 0;
        while (i4 < i3) {
            i6 = (i6 * 31) + cArr[i5];
            i4++;
            i5++;
        }
        int length = (strArr.length - 1) & i6;
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i2, i3);
            strArr[length] = str2;
            return str2;
        } else if (F(cArr, i2, i3, str)) {
            return str;
        } else {
            String str3 = new String(cArr, i2, i3);
            strArr[length] = str3;
            return str3;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean A(String str) {
        b();
        int length = str.length();
        if (length > this.f41608c - this.f41610e) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.toUpperCase(str.charAt(i2)) != Character.toUpperCase(this.f41606a[this.f41610e + i2])) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        if (r()) {
            return false;
        }
        char c2 = this.f41606a[this.f41610e];
        if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !Character.isLetter(c2))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public int C(char c2) {
        b();
        for (int i2 = this.f41610e; i2 < this.f41608c; i2++) {
            if (c2 == this.f41606a[i2]) {
                return i2 - this.f41610e;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int D(CharSequence charSequence) {
        b();
        char charAt = charSequence.charAt(0);
        int i2 = this.f41610e;
        while (i2 < this.f41608c) {
            int i3 = 1;
            if (charAt != this.f41606a[i2]) {
                do {
                    i2++;
                    if (i2 >= this.f41608c) {
                        break;
                    }
                } while (charAt == this.f41606a[i2]);
            }
            int i4 = i2 + 1;
            int length = (charSequence.length() + i4) - 1;
            int i5 = this.f41608c;
            if (i2 < i5 && length <= i5) {
                int i6 = i4;
                while (i6 < length && charSequence.charAt(i3) == this.f41606a[i6]) {
                    i6++;
                    i3++;
                }
                if (i6 == length) {
                    return i2 - this.f41610e;
                }
            }
            i2 = i4;
        }
        return -1;
    }

    public int E() {
        return this.f41611f + this.f41610e;
    }

    /* access modifiers changed from: package-private */
    public void G() {
        this.f41610e = this.f41612g;
    }

    /* access modifiers changed from: package-private */
    public void H() {
        this.f41610e--;
    }

    public void a() {
        this.f41610e++;
    }

    /* access modifiers changed from: package-private */
    public char d() {
        char c2;
        b();
        if (r()) {
            c2 = 65535;
        } else {
            c2 = this.f41606a[this.f41610e];
        }
        this.f41610e++;
        return c2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String e() {
        /*
            r6 = this;
            r6.b()
            int r0 = r6.f41610e
            int r1 = r6.f41608c
            char[] r2 = r6.f41606a
        L_0x0009:
            int r3 = r6.f41610e
            if (r3 >= r1) goto L_0x001f
            char r4 = r2[r3]
            r5 = 38
            if (r4 == r5) goto L_0x001f
            r5 = 60
            if (r4 == r5) goto L_0x001f
            if (r4 != 0) goto L_0x001a
            goto L_0x001f
        L_0x001a:
            int r3 = r3 + 1
            r6.f41610e = r3
            goto L_0x0009
        L_0x001f:
            if (r3 <= r0) goto L_0x002b
            char[] r1 = r6.f41606a
            java.lang.String[] r2 = r6.f41613h
            int r3 = r3 - r0
            java.lang.String r0 = c(r1, r2, r0, r3)
            goto L_0x002d
        L_0x002b:
            java.lang.String r0 = ""
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.CharacterReader.e():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public String f() {
        int i2;
        char c2;
        b();
        int i3 = this.f41610e;
        while (true) {
            i2 = this.f41610e;
            if (i2 < this.f41608c && (c2 = this.f41606a[i2]) >= '0' && c2 <= '9') {
                this.f41610e = i2 + 1;
            }
        }
        return c(this.f41606a, this.f41613h, i3, i2 - i3);
    }

    /* access modifiers changed from: package-private */
    public String g() {
        int i2;
        char c2;
        b();
        int i3 = this.f41610e;
        while (true) {
            i2 = this.f41610e;
            if (i2 < this.f41608c && (((c2 = this.f41606a[i2]) >= '0' && c2 <= '9') || ((c2 >= 'A' && c2 <= 'F') || (c2 >= 'a' && c2 <= 'f')))) {
                this.f41610e = i2 + 1;
            }
        }
        return c(this.f41606a, this.f41613h, i3, i2 - i3);
    }

    /* access modifiers changed from: package-private */
    public String h() {
        char c2;
        b();
        int i2 = this.f41610e;
        while (true) {
            int i3 = this.f41610e;
            if (i3 < this.f41608c && (((c2 = this.f41606a[i3]) >= 'A' && c2 <= 'Z') || ((c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2)))) {
                this.f41610e++;
            }
        }
        return c(this.f41606a, this.f41613h, i2, this.f41610e - i2);
    }

    /* access modifiers changed from: package-private */
    public String i() {
        char c2;
        b();
        int i2 = this.f41610e;
        while (true) {
            int i3 = this.f41610e;
            if (i3 < this.f41608c && (((c2 = this.f41606a[i3]) >= 'A' && c2 <= 'Z') || ((c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2)))) {
                this.f41610e++;
            }
        }
        while (!r() && (r1 = this.f41606a[r2]) >= '0' && r1 <= '9') {
            this.f41610e = (r2 = this.f41610e) + 1;
        }
        return c(this.f41606a, this.f41613h, i2, this.f41610e - i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String j() {
        /*
            r6 = this;
            r6.b()
            int r0 = r6.f41610e
            int r1 = r6.f41608c
            char[] r2 = r6.f41606a
        L_0x0009:
            int r3 = r6.f41610e
            if (r3 >= r1) goto L_0x0033
            char r4 = r2[r3]
            r5 = 9
            if (r4 == r5) goto L_0x0033
            r5 = 10
            if (r4 == r5) goto L_0x0033
            r5 = 13
            if (r4 == r5) goto L_0x0033
            r5 = 12
            if (r4 == r5) goto L_0x0033
            r5 = 32
            if (r4 == r5) goto L_0x0033
            r5 = 47
            if (r4 == r5) goto L_0x0033
            r5 = 62
            if (r4 == r5) goto L_0x0033
            if (r4 != 0) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            int r3 = r3 + 1
            r6.f41610e = r3
            goto L_0x0009
        L_0x0033:
            if (r3 <= r0) goto L_0x003f
            char[] r1 = r6.f41606a
            java.lang.String[] r2 = r6.f41613h
            int r3 = r3 - r0
            java.lang.String r0 = c(r1, r2, r0, r3)
            goto L_0x0041
        L_0x003f:
            java.lang.String r0 = ""
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.CharacterReader.j():java.lang.String");
    }

    public String k(char c2) {
        int C = C(c2);
        if (C == -1) {
            return o();
        }
        String c3 = c(this.f41606a, this.f41613h, this.f41610e, C);
        this.f41610e += C;
        return c3;
    }

    /* access modifiers changed from: package-private */
    public String l(String str) {
        int D = D(str);
        if (D == -1) {
            return o();
        }
        String c2 = c(this.f41606a, this.f41613h, this.f41610e, D);
        this.f41610e += D;
        return c2;
    }

    public String m(char... cArr) {
        b();
        int i2 = this.f41610e;
        int i3 = this.f41608c;
        char[] cArr2 = this.f41606a;
        loop0:
        while (this.f41610e < i3) {
            for (char c2 : cArr) {
                if (cArr2[this.f41610e] == c2) {
                    break loop0;
                }
            }
            this.f41610e++;
        }
        int i4 = this.f41610e;
        if (i4 > i2) {
            return c(this.f41606a, this.f41613h, i2, i4 - i2);
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    public String n(char... cArr) {
        b();
        int i2 = this.f41610e;
        int i3 = this.f41608c;
        char[] cArr2 = this.f41606a;
        while (true) {
            int i4 = this.f41610e;
            if (i4 >= i3 || Arrays.binarySearch(cArr, cArr2[i4]) >= 0) {
                int i5 = this.f41610e;
            } else {
                this.f41610e++;
            }
        }
        int i52 = this.f41610e;
        if (i52 > i2) {
            return c(this.f41606a, this.f41613h, i2, i52 - i2);
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    public String o() {
        b();
        char[] cArr = this.f41606a;
        String[] strArr = this.f41613h;
        int i2 = this.f41610e;
        String c2 = c(cArr, strArr, i2, this.f41608c - i2);
        this.f41610e = this.f41608c;
        return c2;
    }

    /* access modifiers changed from: package-private */
    public boolean p(String str) {
        Locale locale = Locale.ENGLISH;
        String lowerCase = str.toLowerCase(locale);
        String upperCase = str.toUpperCase(locale);
        if (D(lowerCase) > -1 || D(upperCase) > -1) {
            return true;
        }
        return false;
    }

    public char q() {
        b();
        if (r()) {
            return 65535;
        }
        return this.f41606a[this.f41610e];
    }

    public boolean r() {
        return this.f41610e >= this.f41608c;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.f41612g = this.f41610e;
    }

    /* access modifiers changed from: package-private */
    public boolean t(String str) {
        b();
        if (!w(str)) {
            return false;
        }
        this.f41610e += str.length();
        return true;
    }

    public String toString() {
        char[] cArr = this.f41606a;
        int i2 = this.f41610e;
        return new String(cArr, i2, this.f41608c - i2);
    }

    /* access modifiers changed from: package-private */
    public boolean u(String str) {
        if (!A(str)) {
            return false;
        }
        this.f41610e += str.length();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean v(char c2) {
        return !r() && this.f41606a[this.f41610e] == c2;
    }

    /* access modifiers changed from: package-private */
    public boolean w(String str) {
        b();
        int length = str.length();
        if (length > this.f41608c - this.f41610e) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != this.f41606a[this.f41610e + i2]) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean x(char... cArr) {
        if (r()) {
            return false;
        }
        b();
        char c2 = this.f41606a[this.f41610e];
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean y(char[] cArr) {
        b();
        if (r() || Arrays.binarySearch(cArr, this.f41606a[this.f41610e]) < 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean z() {
        char c2;
        if (!r() && (c2 = this.f41606a[this.f41610e]) >= '0' && c2 <= '9') {
            return true;
        }
        return false;
    }

    public CharacterReader(Reader reader) {
        this(reader, 32768);
    }

    public CharacterReader(String str) {
        this(new StringReader(str), str.length());
    }
}
