package org.jsoup.nodes;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Tag;

public class Document extends Element {

    /* renamed from: k  reason: collision with root package name */
    private OutputSettings f41552k = new OutputSettings();

    /* renamed from: l  reason: collision with root package name */
    private QuirksMode f41553l = QuirksMode.noQuirks;

    /* renamed from: m  reason: collision with root package name */
    private String f41554m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f41555n = false;

    public static class OutputSettings implements Cloneable {

        /* renamed from: b  reason: collision with root package name */
        private Entities.EscapeMode f41556b = Entities.EscapeMode.f41590g;

        /* renamed from: c  reason: collision with root package name */
        private Charset f41557c;

        /* renamed from: d  reason: collision with root package name */
        CharsetEncoder f41558d;

        /* renamed from: e  reason: collision with root package name */
        Entities.CoreCharset f41559e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f41560f = true;

        /* renamed from: g  reason: collision with root package name */
        private boolean f41561g = false;

        /* renamed from: h  reason: collision with root package name */
        private int f41562h = 1;

        /* renamed from: i  reason: collision with root package name */
        private Syntax f41563i = Syntax.html;

        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            c(Charset.forName("UTF8"));
        }

        public Charset a() {
            return this.f41557c;
        }

        public OutputSettings b(String str) {
            c(Charset.forName(str));
            return this;
        }

        public OutputSettings c(Charset charset) {
            this.f41557c = charset;
            return this;
        }

        /* renamed from: d */
        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.b(this.f41557c.name());
                outputSettings.f41556b = Entities.EscapeMode.valueOf(this.f41556b.name());
                return outputSettings;
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }

        public Entities.EscapeMode e() {
            return this.f41556b;
        }

        public int f() {
            return this.f41562h;
        }

        public boolean g() {
            return this.f41561g;
        }

        /* access modifiers changed from: package-private */
        public CharsetEncoder h() {
            CharsetEncoder newEncoder = this.f41557c.newEncoder();
            this.f41558d = newEncoder;
            this.f41559e = Entities.CoreCharset.a(newEncoder.charset().name());
            return this.f41558d;
        }

        public boolean i() {
            return this.f41560f;
        }

        public Syntax j() {
            return this.f41563i;
        }

        public OutputSettings k(Syntax syntax) {
            this.f41563i = syntax;
            return this;
        }
    }

    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(Tag.k("#root", ParseSettings.f41676c), str);
        this.f41554m = str;
    }

    private Element y0(String str, Node node) {
        if (node.u().equals(str)) {
            return (Element) node;
        }
        int i2 = node.i();
        for (int i3 = 0; i3 < i2; i3++) {
            Element y02 = y0(str, node.h(i3));
            if (y02 != null) {
                return y02;
            }
        }
        return null;
    }

    public QuirksMode A0() {
        return this.f41553l;
    }

    public Document B0(QuirksMode quirksMode) {
        this.f41553l = quirksMode;
        return this;
    }

    public String u() {
        return "#document";
    }

    public String w() {
        return super.g0();
    }

    public Element w0() {
        return y0("body", this);
    }

    /* renamed from: x0 */
    public Document k() {
        Document document = (Document) super.k();
        document.f41552k = this.f41552k.clone();
        return document;
    }

    public OutputSettings z0() {
        return this.f41552k;
    }
}
