package org.jsoup.parser;

import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;

public class TokenQueue {

    /* renamed from: a  reason: collision with root package name */
    private String f41726a;

    /* renamed from: b  reason: collision with root package name */
    private int f41727b = 0;

    public TokenQueue(String str) {
        Validate.j(str);
        this.f41726a = str;
    }

    private int r() {
        return this.f41726a.length() - this.f41727b;
    }

    public static String s(String str) {
        StringBuilder m2 = StringUtil.m();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i2 = 0;
        char c2 = 0;
        while (i2 < length) {
            char c3 = charArray[i2];
            if (c3 != '\\') {
                m2.append(c3);
            } else if (c2 != 0 && c2 == '\\') {
                m2.append(c3);
            }
            i2++;
            c2 = c3;
        }
        return m2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068 A[EDGE_INSN: B:35:0x0068->B:28:0x0068 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(char r9, char r10) {
        /*
            r8 = this;
            r0 = -1
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = -1
            r5 = -1
        L_0x0006:
            boolean r6 = r8.j()
            if (r6 == 0) goto L_0x000d
            goto L_0x0068
        L_0x000d:
            char r6 = r8.c()
            java.lang.Character r6 = java.lang.Character.valueOf(r6)
            if (r1 == 0) goto L_0x001b
            r7 = 92
            if (r1 == r7) goto L_0x005b
        L_0x001b:
            r7 = 39
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0033
            r7 = 34
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x003b
        L_0x0033:
            char r7 = r6.charValue()
            if (r7 == r9) goto L_0x003b
            r2 = r2 ^ 1
        L_0x003b:
            if (r2 == 0) goto L_0x003e
            goto L_0x0066
        L_0x003e:
            java.lang.Character r7 = java.lang.Character.valueOf(r9)
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x004f
            int r3 = r3 + 1
            if (r4 != r0) goto L_0x005b
            int r4 = r8.f41727b
            goto L_0x005b
        L_0x004f:
            java.lang.Character r7 = java.lang.Character.valueOf(r10)
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x005b
            int r3 = r3 + -1
        L_0x005b:
            if (r3 <= 0) goto L_0x0062
            if (r1 == 0) goto L_0x0062
            int r1 = r8.f41727b
            r5 = r1
        L_0x0062:
            char r1 = r6.charValue()
        L_0x0066:
            if (r3 > 0) goto L_0x0006
        L_0x0068:
            if (r5 < 0) goto L_0x0071
            java.lang.String r9 = r8.f41726a
            java.lang.String r9 = r9.substring(r4, r5)
            goto L_0x0073
        L_0x0071:
            java.lang.String r9 = ""
        L_0x0073:
            if (r3 <= 0) goto L_0x008e
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Did not find balanced marker at '"
            r10.append(r0)
            r10.append(r9)
            java.lang.String r0 = "'"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            org.jsoup.helper.Validate.a(r10)
        L_0x008e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.TokenQueue.a(char, char):java.lang.String");
    }

    public String b(String str) {
        String g2 = g(str);
        k(str);
        return g2;
    }

    public char c() {
        String str = this.f41726a;
        int i2 = this.f41727b;
        this.f41727b = i2 + 1;
        return str.charAt(i2);
    }

    public void d(String str) {
        if (l(str)) {
            int length = str.length();
            if (length <= r()) {
                this.f41727b += length;
                return;
            }
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public String e() {
        int i2 = this.f41727b;
        while (!j() && (p() || m('-', '_'))) {
            this.f41727b++;
        }
        return this.f41726a.substring(i2, this.f41727b);
    }

    public String f() {
        int i2 = this.f41727b;
        while (!j() && (p() || n("*|", "|", "_", "-"))) {
            this.f41727b++;
        }
        return this.f41726a.substring(i2, this.f41727b);
    }

    public String g(String str) {
        int indexOf = this.f41726a.indexOf(str, this.f41727b);
        if (indexOf == -1) {
            return q();
        }
        String substring = this.f41726a.substring(this.f41727b, indexOf);
        this.f41727b += substring.length();
        return substring;
    }

    public String h(String... strArr) {
        int i2 = this.f41727b;
        while (!j() && !n(strArr)) {
            this.f41727b++;
        }
        return this.f41726a.substring(i2, this.f41727b);
    }

    public boolean i() {
        boolean z2 = false;
        while (o()) {
            this.f41727b++;
            z2 = true;
        }
        return z2;
    }

    public boolean j() {
        return r() == 0;
    }

    public boolean k(String str) {
        if (!l(str)) {
            return false;
        }
        this.f41727b += str.length();
        return true;
    }

    public boolean l(String str) {
        return this.f41726a.regionMatches(true, this.f41727b, str, 0, str.length());
    }

    public boolean m(char... cArr) {
        if (j()) {
            return false;
        }
        for (char c2 : cArr) {
            if (this.f41726a.charAt(this.f41727b) == c2) {
                return true;
            }
        }
        return false;
    }

    public boolean n(String... strArr) {
        for (String l2 : strArr) {
            if (l(l2)) {
                return true;
            }
        }
        return false;
    }

    public boolean o() {
        return !j() && StringUtil.g(this.f41726a.charAt(this.f41727b));
    }

    public boolean p() {
        return !j() && Character.isLetterOrDigit(this.f41726a.charAt(this.f41727b));
    }

    public String q() {
        String str = this.f41726a;
        String substring = str.substring(this.f41727b, str.length());
        this.f41727b = this.f41726a.length();
        return substring;
    }

    public String toString() {
        return this.f41726a.substring(this.f41727b);
    }
}
