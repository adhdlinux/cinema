package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attributes;

abstract class Token {

    /* renamed from: a  reason: collision with root package name */
    TokenType f41701a;

    static final class Character extends Token {

        /* renamed from: b  reason: collision with root package name */
        private String f41702b;

        Character() {
            super();
            this.f41701a = TokenType.Character;
        }

        /* access modifiers changed from: package-private */
        public Token l() {
            this.f41702b = null;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Character o(String str) {
            this.f41702b = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public String p() {
            return this.f41702b;
        }

        public String toString() {
            return p();
        }
    }

    static final class Comment extends Token {

        /* renamed from: b  reason: collision with root package name */
        final StringBuilder f41703b = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        boolean f41704c = false;

        Comment() {
            super();
            this.f41701a = TokenType.Comment;
        }

        /* access modifiers changed from: package-private */
        public Token l() {
            Token.m(this.f41703b);
            this.f41704c = false;
            return this;
        }

        /* access modifiers changed from: package-private */
        public String o() {
            return this.f41703b.toString();
        }

        public String toString() {
            return "<!--" + o() + "-->";
        }
    }

    static final class Doctype extends Token {

        /* renamed from: b  reason: collision with root package name */
        final StringBuilder f41705b = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        String f41706c = null;

        /* renamed from: d  reason: collision with root package name */
        final StringBuilder f41707d = new StringBuilder();

        /* renamed from: e  reason: collision with root package name */
        final StringBuilder f41708e = new StringBuilder();

        /* renamed from: f  reason: collision with root package name */
        boolean f41709f = false;

        Doctype() {
            super();
            this.f41701a = TokenType.Doctype;
        }

        /* access modifiers changed from: package-private */
        public Token l() {
            Token.m(this.f41705b);
            this.f41706c = null;
            Token.m(this.f41707d);
            Token.m(this.f41708e);
            this.f41709f = false;
            return this;
        }

        /* access modifiers changed from: package-private */
        public String o() {
            return this.f41705b.toString();
        }

        /* access modifiers changed from: package-private */
        public String p() {
            return this.f41706c;
        }

        /* access modifiers changed from: package-private */
        public String q() {
            return this.f41707d.toString();
        }

        public String r() {
            return this.f41708e.toString();
        }

        public boolean s() {
            return this.f41709f;
        }
    }

    static final class EOF extends Token {
        EOF() {
            super();
            this.f41701a = TokenType.EOF;
        }

        /* access modifiers changed from: package-private */
        public Token l() {
            return this;
        }
    }

    static final class EndTag extends Tag {
        EndTag() {
            this.f41701a = TokenType.EndTag;
        }

        public String toString() {
            return "</" + z() + ">";
        }
    }

    static final class StartTag extends Tag {
        StartTag() {
            this.f41718j = new Attributes();
            this.f41701a = TokenType.StartTag;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: D */
        public Tag l() {
            super.l();
            this.f41718j = new Attributes();
            return this;
        }

        /* access modifiers changed from: package-private */
        public StartTag F(String str, Attributes attributes) {
            this.f41710b = str;
            this.f41718j = attributes;
            this.f41711c = Normalizer.a(str);
            return this;
        }

        public String toString() {
            Attributes attributes = this.f41718j;
            if (attributes == null || attributes.size() <= 0) {
                return "<" + z() + ">";
            }
            return "<" + z() + " " + this.f41718j.toString() + ">";
        }
    }

    static abstract class Tag extends Token {

        /* renamed from: b  reason: collision with root package name */
        protected String f41710b;

        /* renamed from: c  reason: collision with root package name */
        protected String f41711c;

        /* renamed from: d  reason: collision with root package name */
        private String f41712d;

        /* renamed from: e  reason: collision with root package name */
        private StringBuilder f41713e = new StringBuilder();

        /* renamed from: f  reason: collision with root package name */
        private String f41714f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f41715g = false;

        /* renamed from: h  reason: collision with root package name */
        private boolean f41716h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f41717i = false;

        /* renamed from: j  reason: collision with root package name */
        Attributes f41718j;

        Tag() {
            super();
        }

        private void v() {
            this.f41716h = true;
            String str = this.f41714f;
            if (str != null) {
                this.f41713e.append(str);
                this.f41714f = null;
            }
        }

        /* access modifiers changed from: package-private */
        public final Tag A(String str) {
            this.f41710b = str;
            this.f41711c = Normalizer.a(str);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void B() {
            String str;
            if (this.f41718j == null) {
                this.f41718j = new Attributes();
            }
            String str2 = this.f41712d;
            if (str2 != null) {
                String trim = str2.trim();
                this.f41712d = trim;
                if (trim.length() > 0) {
                    if (this.f41716h) {
                        if (this.f41713e.length() > 0) {
                            str = this.f41713e.toString();
                        } else {
                            str = this.f41714f;
                        }
                    } else if (this.f41715g) {
                        str = "";
                    } else {
                        str = null;
                    }
                    this.f41718j.t(this.f41712d, str);
                }
            }
            this.f41712d = null;
            this.f41715g = false;
            this.f41716h = false;
            Token.m(this.f41713e);
            this.f41714f = null;
        }

        /* access modifiers changed from: package-private */
        public final String C() {
            return this.f41711c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: D */
        public Tag l() {
            this.f41710b = null;
            this.f41711c = null;
            this.f41712d = null;
            Token.m(this.f41713e);
            this.f41714f = null;
            this.f41715g = false;
            this.f41716h = false;
            this.f41717i = false;
            this.f41718j = null;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void E() {
            this.f41715g = true;
        }

        /* access modifiers changed from: package-private */
        public final void o(char c2) {
            p(String.valueOf(c2));
        }

        /* access modifiers changed from: package-private */
        public final void p(String str) {
            String str2 = this.f41712d;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f41712d = str;
        }

        /* access modifiers changed from: package-private */
        public final void q(char c2) {
            v();
            this.f41713e.append(c2);
        }

        /* access modifiers changed from: package-private */
        public final void r(String str) {
            v();
            if (this.f41713e.length() == 0) {
                this.f41714f = str;
            } else {
                this.f41713e.append(str);
            }
        }

        /* access modifiers changed from: package-private */
        public final void s(int[] iArr) {
            v();
            for (int appendCodePoint : iArr) {
                this.f41713e.appendCodePoint(appendCodePoint);
            }
        }

        /* access modifiers changed from: package-private */
        public final void t(char c2) {
            u(String.valueOf(c2));
        }

        /* access modifiers changed from: package-private */
        public final void u(String str) {
            String str2 = this.f41710b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f41710b = str;
            this.f41711c = Normalizer.a(str);
        }

        /* access modifiers changed from: package-private */
        public final void w() {
            if (this.f41712d != null) {
                B();
            }
        }

        /* access modifiers changed from: package-private */
        public final Attributes x() {
            return this.f41718j;
        }

        /* access modifiers changed from: package-private */
        public final boolean y() {
            return this.f41717i;
        }

        /* access modifiers changed from: package-private */
        public final String z() {
            boolean z2;
            String str = this.f41710b;
            if (str == null || str.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Validate.b(z2);
            return this.f41710b;
        }
    }

    enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    static void m(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    /* access modifiers changed from: package-private */
    public final Character a() {
        return (Character) this;
    }

    /* access modifiers changed from: package-private */
    public final Comment b() {
        return (Comment) this;
    }

    /* access modifiers changed from: package-private */
    public final Doctype c() {
        return (Doctype) this;
    }

    /* access modifiers changed from: package-private */
    public final EndTag d() {
        return (EndTag) this;
    }

    /* access modifiers changed from: package-private */
    public final StartTag e() {
        return (StartTag) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return this.f41701a == TokenType.Character;
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        return this.f41701a == TokenType.Comment;
    }

    /* access modifiers changed from: package-private */
    public final boolean h() {
        return this.f41701a == TokenType.Doctype;
    }

    /* access modifiers changed from: package-private */
    public final boolean i() {
        return this.f41701a == TokenType.EOF;
    }

    /* access modifiers changed from: package-private */
    public final boolean j() {
        return this.f41701a == TokenType.EndTag;
    }

    /* access modifiers changed from: package-private */
    public final boolean k() {
        return this.f41701a == TokenType.StartTag;
    }

    /* access modifiers changed from: package-private */
    public abstract Token l();

    /* access modifiers changed from: package-private */
    public String n() {
        return getClass().getSimpleName();
    }

    private Token() {
    }
}
