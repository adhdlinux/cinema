package org.jsoup.parser;

import java.util.Arrays;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

final class Tokeniser {

    /* renamed from: r  reason: collision with root package name */
    private static final char[] f41728r;

    /* renamed from: a  reason: collision with root package name */
    private final CharacterReader f41729a;

    /* renamed from: b  reason: collision with root package name */
    private final ParseErrorList f41730b;

    /* renamed from: c  reason: collision with root package name */
    private TokeniserState f41731c = TokeniserState.Data;

    /* renamed from: d  reason: collision with root package name */
    private Token f41732d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f41733e = false;

    /* renamed from: f  reason: collision with root package name */
    private String f41734f = null;

    /* renamed from: g  reason: collision with root package name */
    private StringBuilder f41735g = new StringBuilder(1024);

    /* renamed from: h  reason: collision with root package name */
    StringBuilder f41736h = new StringBuilder(1024);

    /* renamed from: i  reason: collision with root package name */
    Token.Tag f41737i;

    /* renamed from: j  reason: collision with root package name */
    Token.StartTag f41738j = new Token.StartTag();

    /* renamed from: k  reason: collision with root package name */
    Token.EndTag f41739k = new Token.EndTag();

    /* renamed from: l  reason: collision with root package name */
    Token.Character f41740l = new Token.Character();

    /* renamed from: m  reason: collision with root package name */
    Token.Doctype f41741m = new Token.Doctype();

    /* renamed from: n  reason: collision with root package name */
    Token.Comment f41742n = new Token.Comment();

    /* renamed from: o  reason: collision with root package name */
    private String f41743o;

    /* renamed from: p  reason: collision with root package name */
    private final int[] f41744p = new int[1];

    /* renamed from: q  reason: collision with root package name */
    private final int[] f41745q = new int[2];

    static {
        char[] cArr = {9, 10, 13, 12, ' ', '<', '&'};
        f41728r = cArr;
        Arrays.sort(cArr);
    }

    Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.f41729a = characterReader;
        this.f41730b = parseErrorList;
    }

    private void c(String str) {
        if (this.f41730b.a()) {
            this.f41730b.add(new ParseError(this.f41729a.E(), "Invalid character reference: %s", str));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(TokeniserState tokeniserState) {
        this.f41729a.a();
        this.f41731c = tokeniserState;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.f41743o;
    }

    /* access modifiers changed from: package-private */
    public int[] d(Character ch, boolean z2) {
        boolean z3;
        String str;
        int i2;
        int i3;
        if (this.f41729a.r()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.f41729a.q()) || this.f41729a.y(f41728r)) {
            return null;
        }
        int[] iArr = this.f41744p;
        this.f41729a.s();
        if (this.f41729a.t("#")) {
            boolean u2 = this.f41729a.u("X");
            CharacterReader characterReader = this.f41729a;
            if (u2) {
                str = characterReader.g();
            } else {
                str = characterReader.f();
            }
            if (str.length() == 0) {
                c("numeric reference with no numerals");
                this.f41729a.G();
                return null;
            }
            if (!this.f41729a.t(";")) {
                c("missing semicolon");
            }
            if (u2) {
                i2 = 16;
            } else {
                i2 = 10;
            }
            try {
                i3 = Integer.valueOf(str, i2).intValue();
            } catch (NumberFormatException unused) {
                i3 = -1;
            }
            if (i3 == -1 || ((i3 >= 55296 && i3 <= 57343) || i3 > 1114111)) {
                c("character outside of valid range");
                iArr[0] = 65533;
                return iArr;
            }
            iArr[0] = i3;
            return iArr;
        }
        String i4 = this.f41729a.i();
        boolean v2 = this.f41729a.v(';');
        if (Entities.f(i4) || (Entities.g(i4) && v2)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            this.f41729a.G();
            if (v2) {
                c(String.format("invalid named referenece '%s'", new Object[]{i4}));
            }
            return null;
        } else if (!z2 || (!this.f41729a.B() && !this.f41729a.z() && !this.f41729a.x('=', '-', '_'))) {
            if (!this.f41729a.t(";")) {
                c("missing semicolon");
            }
            int d2 = Entities.d(i4, this.f41745q);
            if (d2 == 1) {
                iArr[0] = this.f41745q[0];
                return iArr;
            } else if (d2 == 2) {
                return this.f41745q;
            } else {
                Validate.a("Unexpected characters returned for " + i4);
                return this.f41745q;
            }
        } else {
            this.f41729a.G();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f41742n.l();
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f41741m.l();
    }

    /* access modifiers changed from: package-private */
    public Token.Tag g(boolean z2) {
        Token.Tag D = z2 ? this.f41738j.l() : this.f41739k.l();
        this.f41737i = D;
        return D;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Token.m(this.f41736h);
    }

    /* access modifiers changed from: package-private */
    public void i(char c2) {
        j(String.valueOf(c2));
    }

    /* access modifiers changed from: package-private */
    public void j(String str) {
        if (this.f41734f == null) {
            this.f41734f = str;
            return;
        }
        if (this.f41735g.length() == 0) {
            this.f41735g.append(this.f41734f);
        }
        this.f41735g.append(str);
    }

    /* access modifiers changed from: package-private */
    public void k(Token token) {
        Validate.c(this.f41733e, "There is an unread token pending!");
        this.f41732d = token;
        this.f41733e = true;
        Token.TokenType tokenType = token.f41701a;
        if (tokenType == Token.TokenType.StartTag) {
            this.f41743o = ((Token.StartTag) token).f41710b;
        } else if (tokenType == Token.TokenType.EndTag && ((Token.EndTag) token).f41718j != null) {
            q("Attributes incorrectly present on end tag");
        }
    }

    /* access modifiers changed from: package-private */
    public void l(int[] iArr) {
        j(new String(iArr, 0, iArr.length));
    }

    /* access modifiers changed from: package-private */
    public void m() {
        k(this.f41742n);
    }

    /* access modifiers changed from: package-private */
    public void n() {
        k(this.f41741m);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f41737i.w();
        k(this.f41737i);
    }

    /* access modifiers changed from: package-private */
    public void p(TokeniserState tokeniserState) {
        if (this.f41730b.a()) {
            this.f41730b.add(new ParseError(this.f41729a.E(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    /* access modifiers changed from: package-private */
    public void q(String str) {
        if (this.f41730b.a()) {
            this.f41730b.add(new ParseError(this.f41729a.E(), str));
        }
    }

    /* access modifiers changed from: package-private */
    public void r(TokeniserState tokeniserState) {
        if (this.f41730b.a()) {
            this.f41730b.add(new ParseError(this.f41729a.E(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f41729a.q()), tokeniserState));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        return this.f41743o != null && this.f41737i.z().equalsIgnoreCase(this.f41743o);
    }

    /* access modifiers changed from: package-private */
    public Token t() {
        while (!this.f41733e) {
            this.f41731c.m(this, this.f41729a);
        }
        if (this.f41735g.length() > 0) {
            String sb = this.f41735g.toString();
            StringBuilder sb2 = this.f41735g;
            sb2.delete(0, sb2.length());
            this.f41734f = null;
            return this.f41740l.o(sb);
        }
        String str = this.f41734f;
        if (str != null) {
            Token.Character o2 = this.f41740l.o(str);
            this.f41734f = null;
            return o2;
        }
        this.f41733e = false;
        return this.f41732d;
    }

    /* access modifiers changed from: package-private */
    public void u(TokeniserState tokeniserState) {
        this.f41731c = tokeniserState;
    }
}
