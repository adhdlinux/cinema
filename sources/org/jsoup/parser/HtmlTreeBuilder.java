package org.jsoup.parser;

import com.facebook.common.callercontext.ContextChain;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.cast.MediaTrack;
import com.vungle.ads.internal.model.AdPayload;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Token;

public class HtmlTreeBuilder extends TreeBuilder {
    static final String[] A = {"html", "table"};
    static final String[] B = {"optgroup", "option"};
    static final String[] C = {"dd", "dt", "li", "optgroup", "option", ContextChain.TAG_PRODUCT, "rp", "rt"};
    static final String[] D = {"address", "applet", "area", "article", "aside", Constants.SENSITIVITY_BASE, "basefont", "bgsound", "blockquote", "body", "br", "button", MediaTrack.ROLE_CAPTION, "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", ContextChain.TAG_PRODUCT, "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};

    /* renamed from: x  reason: collision with root package name */
    static final String[] f41614x = {"applet", MediaTrack.ROLE_CAPTION, "html", "marquee", "object", "table", "td", "th"};

    /* renamed from: y  reason: collision with root package name */
    static final String[] f41615y = {"ol", "ul"};

    /* renamed from: z  reason: collision with root package name */
    static final String[] f41616z = {"button"};

    /* renamed from: k  reason: collision with root package name */
    private HtmlTreeBuilderState f41617k;

    /* renamed from: l  reason: collision with root package name */
    private HtmlTreeBuilderState f41618l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f41619m;

    /* renamed from: n  reason: collision with root package name */
    private Element f41620n;

    /* renamed from: o  reason: collision with root package name */
    private FormElement f41621o;

    /* renamed from: p  reason: collision with root package name */
    private Element f41622p;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<Element> f41623q;

    /* renamed from: r  reason: collision with root package name */
    private List<String> f41624r;

    /* renamed from: s  reason: collision with root package name */
    private Token.EndTag f41625s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f41626t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f41627u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f41628v;

    /* renamed from: w  reason: collision with root package name */
    private String[] f41629w = {null};

    HtmlTreeBuilder() {
    }

    private boolean I(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.f41629w;
        strArr3[0] = str;
        return J(strArr3, strArr, strArr2);
    }

    private boolean J(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.f41796d.size() - 1;
        if (size > 100) {
            size = 100;
        }
        while (size >= 0) {
            String u2 = this.f41796d.get(size).u();
            if (StringUtil.c(u2, strArr)) {
                return true;
            }
            if (StringUtil.c(u2, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.c(u2, strArr3)) {
                return false;
            }
            size--;
        }
        Validate.a("Should not be reachable");
        return false;
    }

    private void T(Node node) {
        FormElement formElement;
        if (this.f41796d.size() == 0) {
            this.f41795c.Q(node);
        } else if (X()) {
            R(node);
        } else {
            a().Q(node);
        }
        if (node instanceof Element) {
            Element element = (Element) node;
            if (element.t0().e() && (formElement = this.f41621o) != null) {
                formElement.w0(element);
            }
        }
    }

    private boolean W(ArrayList<Element> arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == element) {
                return true;
            }
        }
        return false;
    }

    private boolean a0(Element element, Element element2) {
        if (!element.u().equals(element2.u()) || !element.e().equals(element2.e())) {
            return false;
        }
        return true;
    }

    private void l(String... strArr) {
        int size = this.f41796d.size() - 1;
        while (size >= 0) {
            Element element = this.f41796d.get(size);
            if (!StringUtil.b(element.u(), strArr) && !element.u().equals("html")) {
                this.f41796d.remove(size);
                size--;
            } else {
                return;
            }
        }
    }

    private void u0(ArrayList<Element> arrayList, Element element, Element element2) {
        boolean z2;
        int lastIndexOf = arrayList.lastIndexOf(element);
        if (lastIndexOf != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.d(z2);
        arrayList.set(lastIndexOf, element2);
    }

    /* access modifiers changed from: package-private */
    public List<String> A() {
        return this.f41624r;
    }

    /* access modifiers changed from: package-private */
    public HtmlTreeBuilderState A0() {
        return this.f41617k;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Element> B() {
        return this.f41796d;
    }

    /* access modifiers changed from: package-private */
    public void B0(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.f41617k = htmlTreeBuilderState;
    }

    /* access modifiers changed from: package-private */
    public boolean C(String str) {
        return F(str, f41616z);
    }

    /* access modifiers changed from: package-private */
    public boolean D(String str) {
        return F(str, f41615y);
    }

    /* access modifiers changed from: package-private */
    public boolean E(String str) {
        return F(str, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean F(String str, String[] strArr) {
        return I(str, f41614x, strArr);
    }

    /* access modifiers changed from: package-private */
    public boolean G(String[] strArr) {
        return J(strArr, f41614x, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean H(String str) {
        for (int size = this.f41796d.size() - 1; size >= 0; size--) {
            String u2 = this.f41796d.get(size).u();
            if (u2.equals(str)) {
                return true;
            }
            if (!StringUtil.c(u2, B)) {
                return false;
            }
        }
        Validate.a("Should not be reachable");
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean K(String str) {
        return I(str, A, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public Element L(Token.StartTag startTag) {
        if (startTag.y()) {
            Element P = P(startTag);
            this.f41796d.add(P);
            this.f41794b.u(TokeniserState.Data);
            this.f41794b.k(this.f41625s.l().A(P.u0()));
            return P;
        }
        Element element = new Element(Tag.k(startTag.z(), this.f41800h), this.f41797e, this.f41800h.a(startTag.f41718j));
        M(element);
        return element;
    }

    /* access modifiers changed from: package-private */
    public void M(Element element) {
        T(element);
        this.f41796d.add(element);
    }

    /* access modifiers changed from: package-private */
    public void N(Token.Character character) {
        Node node;
        String u02 = a().u0();
        if (u02.equals("script") || u02.equals("style")) {
            node = new DataNode(character.p());
        } else {
            node = new TextNode(character.p());
        }
        a().Q(node);
    }

    /* access modifiers changed from: package-private */
    public void O(Token.Comment comment) {
        T(new Comment(comment.o()));
    }

    /* access modifiers changed from: package-private */
    public Element P(Token.StartTag startTag) {
        Tag k2 = Tag.k(startTag.z(), this.f41800h);
        Element element = new Element(k2, this.f41797e, startTag.f41718j);
        T(element);
        if (startTag.y()) {
            if (!k2.f()) {
                k2.j();
            } else if (!k2.d()) {
                this.f41794b.q("Tag cannot be self closing; not a void tag");
            }
        }
        return element;
    }

    /* access modifiers changed from: package-private */
    public FormElement Q(Token.StartTag startTag, boolean z2) {
        FormElement formElement = new FormElement(Tag.k(startTag.z(), this.f41800h), this.f41797e, startTag.f41718j);
        x0(formElement);
        T(formElement);
        if (z2) {
            this.f41796d.add(formElement);
        }
        return formElement;
    }

    /* access modifiers changed from: package-private */
    public void R(Node node) {
        Element element;
        Element y2 = y("table");
        boolean z2 = false;
        if (y2 == null) {
            element = this.f41796d.get(0);
        } else if (y2.n0() != null) {
            element = y2.n0();
            z2 = true;
        } else {
            element = j(y2);
        }
        if (z2) {
            Validate.j(y2);
            y2.U(node);
            return;
        }
        element.Q(node);
    }

    /* access modifiers changed from: package-private */
    public void S() {
        this.f41623q.add((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void U(Element element, Element element2) {
        boolean z2;
        int lastIndexOf = this.f41796d.lastIndexOf(element);
        if (lastIndexOf != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.d(z2);
        this.f41796d.add(lastIndexOf + 1, element2);
    }

    /* access modifiers changed from: package-private */
    public Element V(String str) {
        Element element = new Element(Tag.k(str, this.f41800h), this.f41797e);
        M(element);
        return element;
    }

    /* access modifiers changed from: package-private */
    public boolean X() {
        return this.f41627u;
    }

    /* access modifiers changed from: package-private */
    public boolean Y() {
        return this.f41628v;
    }

    /* access modifiers changed from: package-private */
    public boolean Z(Element element) {
        return W(this.f41623q, element);
    }

    /* access modifiers changed from: package-private */
    public ParseSettings b() {
        return ParseSettings.f41676c;
    }

    /* access modifiers changed from: package-private */
    public boolean b0(Element element) {
        return StringUtil.c(element.u(), D);
    }

    /* access modifiers changed from: protected */
    public void c(Reader reader, String str, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        super.c(reader, str, parseErrorList, parseSettings);
        this.f41617k = HtmlTreeBuilderState.Initial;
        this.f41618l = null;
        this.f41619m = false;
        this.f41620n = null;
        this.f41621o = null;
        this.f41622p = null;
        this.f41623q = new ArrayList<>();
        this.f41624r = new ArrayList();
        this.f41625s = new Token.EndTag();
        this.f41626t = true;
        this.f41627u = false;
        this.f41628v = false;
    }

    /* access modifiers changed from: package-private */
    public Element c0() {
        if (this.f41623q.size() <= 0) {
            return null;
        }
        ArrayList<Element> arrayList = this.f41623q;
        return arrayList.get(arrayList.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public void d0() {
        this.f41618l = this.f41617k;
    }

    /* access modifiers changed from: protected */
    public boolean e(Token token) {
        this.f41798f = token;
        return this.f41617k.j(token, this);
    }

    /* access modifiers changed from: package-private */
    public void e0(Element element) {
        if (!this.f41619m) {
            String a2 = element.a("href");
            if (a2.length() != 0) {
                this.f41797e = a2;
                this.f41619m = true;
                this.f41795c.I(a2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f0() {
        this.f41624r = new ArrayList();
    }

    /* access modifiers changed from: package-private */
    public boolean g0(Element element) {
        return W(this.f41796d, element);
    }

    public /* bridge */ /* synthetic */ boolean h(String str, Attributes attributes) {
        return super.h(str, attributes);
    }

    /* access modifiers changed from: package-private */
    public HtmlTreeBuilderState h0() {
        return this.f41618l;
    }

    /* access modifiers changed from: package-private */
    public Element i0() {
        return this.f41796d.remove(this.f41796d.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public Element j(Element element) {
        for (int size = this.f41796d.size() - 1; size >= 0; size--) {
            if (this.f41796d.get(size) == element) {
                return this.f41796d.get(size - 1);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void j0(String str) {
        int size = this.f41796d.size() - 1;
        while (size >= 0 && !this.f41796d.get(size).u().equals(str)) {
            this.f41796d.remove(size);
            size--;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000c, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k() {
        /*
            r1 = this;
        L_0x0000:
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r1.f41623q
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x000e
            org.jsoup.nodes.Element r0 = r1.s0()
            if (r0 != 0) goto L_0x0000
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.k():void");
    }

    /* access modifiers changed from: package-private */
    public void k0(String str) {
        int size = this.f41796d.size() - 1;
        while (size >= 0) {
            this.f41796d.remove(size);
            if (!this.f41796d.get(size).u().equals(str)) {
                size--;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l0(String... strArr) {
        int size = this.f41796d.size() - 1;
        while (size >= 0) {
            this.f41796d.remove(size);
            if (!StringUtil.c(this.f41796d.get(size).u(), strArr)) {
                size--;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        l("tbody", "tfoot", "thead", AdPayload.KEY_TEMPLATE);
    }

    /* access modifiers changed from: package-private */
    public boolean m0(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.f41798f = token;
        return htmlTreeBuilderState.j(token, this);
    }

    /* access modifiers changed from: package-private */
    public void n() {
        l("table");
    }

    /* access modifiers changed from: package-private */
    public void n0(Element element) {
        this.f41796d.add(element);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        l("tr", AdPayload.KEY_TEMPLATE);
    }

    /* access modifiers changed from: package-private */
    public void o0(Element element) {
        int size = this.f41623q.size() - 1;
        int i2 = 0;
        while (true) {
            if (size >= 0) {
                Element element2 = this.f41623q.get(size);
                if (element2 == null) {
                    break;
                }
                if (a0(element, element2)) {
                    i2++;
                }
                if (i2 == 3) {
                    this.f41623q.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.f41623q.add(element);
    }

    /* access modifiers changed from: package-private */
    public void p(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.f41799g.a()) {
            this.f41799g.add(new ParseError(this.f41793a.E(), "Unexpected token [%s] when in state [%s]", this.f41798f.n(), htmlTreeBuilderState));
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    void p0() {
        /*
            r7 = this;
            org.jsoup.nodes.Element r0 = r7.c0()
            if (r0 == 0) goto L_0x0056
            boolean r1 = r7.g0(r0)
            if (r1 == 0) goto L_0x000d
            goto L_0x0056
        L_0x000d:
            java.util.ArrayList<org.jsoup.nodes.Element> r1 = r7.f41623q
            int r1 = r1.size()
            r2 = 1
            int r1 = r1 - r2
            r3 = r1
        L_0x0016:
            r4 = 0
            if (r3 != 0) goto L_0x001a
            goto L_0x002d
        L_0x001a:
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r7.f41623q
            int r3 = r3 + -1
            java.lang.Object r0 = r0.get(r3)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            if (r0 == 0) goto L_0x002c
            boolean r5 = r7.g0(r0)
            if (r5 == 0) goto L_0x0016
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r2 != 0) goto L_0x0039
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r7.f41623q
            int r3 = r3 + 1
            java.lang.Object r0 = r0.get(r3)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
        L_0x0039:
            org.jsoup.helper.Validate.j(r0)
            java.lang.String r2 = r0.u()
            org.jsoup.nodes.Element r2 = r7.V(r2)
            org.jsoup.nodes.Attributes r5 = r2.e()
            org.jsoup.nodes.Attributes r6 = r0.e()
            r5.d(r6)
            java.util.ArrayList<org.jsoup.nodes.Element> r5 = r7.f41623q
            r5.set(r3, r2)
            if (r3 != r1) goto L_0x002c
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.p0():void");
    }

    /* access modifiers changed from: package-private */
    public void q(boolean z2) {
        this.f41626t = z2;
    }

    /* access modifiers changed from: package-private */
    public void q0(Element element) {
        for (int size = this.f41623q.size() - 1; size >= 0; size--) {
            if (this.f41623q.get(size) == element) {
                this.f41623q.remove(size);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.f41626t;
    }

    /* access modifiers changed from: package-private */
    public boolean r0(Element element) {
        for (int size = this.f41796d.size() - 1; size >= 0; size--) {
            if (this.f41796d.get(size) == element) {
                this.f41796d.remove(size);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        t((String) null);
    }

    /* access modifiers changed from: package-private */
    public Element s0() {
        int size = this.f41623q.size();
        if (size > 0) {
            return this.f41623q.remove(size - 1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void t(String str) {
        while (str != null && !a().u().equals(str) && StringUtil.c(a().u(), C)) {
            i0();
        }
    }

    /* access modifiers changed from: package-private */
    public void t0(Element element, Element element2) {
        u0(this.f41623q, element, element2);
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.f41798f + ", state=" + this.f41617k + ", currentElement=" + a() + '}';
    }

    /* access modifiers changed from: package-private */
    public Element u(String str) {
        for (int size = this.f41623q.size() - 1; size >= 0; size--) {
            Element element = this.f41623q.get(size);
            if (element == null) {
                return null;
            }
            if (element.u().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String v() {
        return this.f41797e;
    }

    /* access modifiers changed from: package-private */
    public void v0(Element element, Element element2) {
        u0(this.f41796d, element, element2);
    }

    /* access modifiers changed from: package-private */
    public Document w() {
        return this.f41795c;
    }

    /* access modifiers changed from: package-private */
    public void w0() {
        int size = this.f41796d.size() - 1;
        boolean z2 = false;
        while (size >= 0) {
            Element element = this.f41796d.get(size);
            if (size == 0) {
                element = this.f41622p;
                z2 = true;
            }
            String u2 = element.u();
            if ("select".equals(u2)) {
                B0(HtmlTreeBuilderState.InSelect);
                return;
            } else if ("td".equals(u2) || ("th".equals(u2) && !z2)) {
                B0(HtmlTreeBuilderState.InCell);
                return;
            } else if ("tr".equals(u2)) {
                B0(HtmlTreeBuilderState.InRow);
                return;
            } else if ("tbody".equals(u2) || "thead".equals(u2) || "tfoot".equals(u2)) {
                B0(HtmlTreeBuilderState.InTableBody);
                return;
            } else if (MediaTrack.ROLE_CAPTION.equals(u2)) {
                B0(HtmlTreeBuilderState.InCaption);
                return;
            } else if ("colgroup".equals(u2)) {
                B0(HtmlTreeBuilderState.InColumnGroup);
                return;
            } else if ("table".equals(u2)) {
                B0(HtmlTreeBuilderState.InTable);
                return;
            } else if ("head".equals(u2)) {
                B0(HtmlTreeBuilderState.InBody);
                return;
            } else if ("body".equals(u2)) {
                B0(HtmlTreeBuilderState.InBody);
                return;
            } else if ("frameset".equals(u2)) {
                B0(HtmlTreeBuilderState.InFrameset);
                return;
            } else if ("html".equals(u2)) {
                B0(HtmlTreeBuilderState.BeforeHead);
                return;
            } else if (z2) {
                B0(HtmlTreeBuilderState.InBody);
                return;
            } else {
                size--;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public FormElement x() {
        return this.f41621o;
    }

    /* access modifiers changed from: package-private */
    public void x0(FormElement formElement) {
        this.f41621o = formElement;
    }

    /* access modifiers changed from: package-private */
    public Element y(String str) {
        for (int size = this.f41796d.size() - 1; size >= 0; size--) {
            Element element = this.f41796d.get(size);
            if (element.u().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void y0(boolean z2) {
        this.f41627u = z2;
    }

    /* access modifiers changed from: package-private */
    public Element z() {
        return this.f41620n;
    }

    /* access modifiers changed from: package-private */
    public void z0(Element element) {
        this.f41620n = element;
    }
}
