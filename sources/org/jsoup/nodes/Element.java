package org.jsoup.nodes;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.Selector;

public class Element extends Node {

    /* renamed from: i  reason: collision with root package name */
    private static final List<Node> f41571i = Collections.emptyList();

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f41572j = Pattern.compile("\\s+");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Tag f41573d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<List<Element>> f41574e;

    /* renamed from: f  reason: collision with root package name */
    List<Node> f41575f;

    /* renamed from: g  reason: collision with root package name */
    private Attributes f41576g;

    /* renamed from: h  reason: collision with root package name */
    private String f41577h;

    private static final class NodeList extends ChangeNotifyingArrayList<Node> {

        /* renamed from: b  reason: collision with root package name */
        private final Element f41580b;

        NodeList(Element element, int i2) {
            super(i2);
            this.f41580b = element;
        }

        public void a() {
            this.f41580b.v();
        }
    }

    public Element(Tag tag, String str, Attributes attributes) {
        Validate.j(tag);
        Validate.j(str);
        this.f41575f = f41571i;
        this.f41577h = str;
        this.f41576g = attributes;
        this.f41573d = tag;
    }

    /* access modifiers changed from: private */
    public static void R(StringBuilder sb, TextNode textNode) {
        String Q = textNode.Q();
        if (o0(textNode.f41599b)) {
            sb.append(Q);
        } else {
            StringUtil.a(sb, Q, TextNode.S(sb));
        }
    }

    private static void S(Element element, StringBuilder sb) {
        if (element.f41573d.b().equals("br") && !TextNode.S(sb)) {
            sb.append(" ");
        }
    }

    private List<Element> W() {
        List<Element> list;
        WeakReference<List<Element>> weakReference = this.f41574e;
        if (weakReference != null && (list = weakReference.get()) != null) {
            return list;
        }
        int size = this.f41575f.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            Node node = this.f41575f.get(i2);
            if (node instanceof Element) {
                arrayList.add((Element) node);
            }
        }
        this.f41574e = new WeakReference<>(arrayList);
        return arrayList;
    }

    private void h0(StringBuilder sb) {
        for (Node x2 : this.f41575f) {
            x2.x(sb);
        }
    }

    private static <E extends Element> int j0(Element element, List<E> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) == element) {
                return i2;
            }
        }
        return 0;
    }

    private void m0(StringBuilder sb) {
        for (Node next : this.f41575f) {
            if (next instanceof TextNode) {
                R(sb, (TextNode) next);
            } else if (next instanceof Element) {
                S((Element) next, sb);
            }
        }
    }

    static boolean o0(Node node) {
        if (node == null || !(node instanceof Element)) {
            return false;
        }
        Element element = (Element) node;
        if (element.f41573d.h() || (element.n0() != null && element.n0().f41573d.h())) {
            return true;
        }
        return false;
    }

    public Element Q(Node node) {
        Validate.j(node);
        G(node);
        n();
        this.f41575f.add(node);
        node.K(this.f41575f.size() - 1);
        return this;
    }

    public Element T(String str, String str2) {
        super.d(str, str2);
        return this;
    }

    public Element U(Node node) {
        return (Element) super.g(node);
    }

    public Element V(int i2) {
        return W().get(i2);
    }

    public Elements X() {
        return new Elements(W());
    }

    /* renamed from: Y */
    public Element k() {
        return (Element) super.clone();
    }

    public String Z() {
        StringBuilder sb = new StringBuilder();
        for (Node next : this.f41575f) {
            if (next instanceof DataNode) {
                sb.append(((DataNode) next).Q());
            } else if (next instanceof Comment) {
                sb.append(((Comment) next).Q());
            } else if (next instanceof Element) {
                sb.append(((Element) next).Z());
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a0 */
    public Element l(Node node) {
        Attributes attributes;
        Element element = (Element) super.l(node);
        Attributes attributes2 = this.f41576g;
        if (attributes2 != null) {
            attributes = attributes2.clone();
        } else {
            attributes = null;
        }
        element.f41576g = attributes;
        element.f41577h = this.f41577h;
        NodeList nodeList = new NodeList(element, this.f41575f.size());
        element.f41575f = nodeList;
        nodeList.addAll(this.f41575f);
        return element;
    }

    public int b0() {
        if (n0() == null) {
            return 0;
        }
        return j0(this, n0().W());
    }

    public Elements c0() {
        return Collector.a(new Evaluator.AllElements(), this);
    }

    public Elements d0(String str) {
        Validate.h(str);
        return Collector.a(new Evaluator.Tag(Normalizer.b(str)), this);
    }

    public Attributes e() {
        if (!q()) {
            this.f41576g = new Attributes();
        }
        return this.f41576g;
    }

    public boolean e0(String str) {
        String l2 = e().l("class");
        int length = l2.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(l2);
            }
            boolean z2 = false;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (Character.isWhitespace(l2.charAt(i3))) {
                    if (!z2) {
                        continue;
                    } else if (i3 - i2 == length2 && l2.regionMatches(true, i2, str, 0, length2)) {
                        return true;
                    } else {
                        z2 = false;
                    }
                } else if (!z2) {
                    i2 = i3;
                    z2 = true;
                }
            }
            if (z2 && length - i2 == length2) {
                return l2.regionMatches(true, i2, str, 0, length2);
            }
        }
        return false;
    }

    public String f() {
        return this.f41577h;
    }

    public boolean f0() {
        for (Node next : this.f41575f) {
            if (next instanceof TextNode) {
                if (!((TextNode) next).R()) {
                    return true;
                }
            } else if ((next instanceof Element) && ((Element) next).f0()) {
                return true;
            }
        }
        return false;
    }

    public String g0() {
        StringBuilder m2 = StringUtil.m();
        h0(m2);
        boolean i2 = o().i();
        String sb = m2.toString();
        if (i2) {
            return sb.trim();
        }
        return sb;
    }

    public int i() {
        return this.f41575f.size();
    }

    public String i0() {
        return e().l("id");
    }

    public boolean k0() {
        return this.f41573d.c();
    }

    public String l0() {
        StringBuilder sb = new StringBuilder();
        m0(sb);
        return sb.toString().trim();
    }

    /* access modifiers changed from: protected */
    public void m(String str) {
        this.f41577h = str;
    }

    /* access modifiers changed from: protected */
    public List<Node> n() {
        if (this.f41575f == f41571i) {
            this.f41575f = new NodeList(this, 4);
        }
        return this.f41575f;
    }

    public final Element n0() {
        return (Element) this.f41599b;
    }

    public Element p0() {
        if (this.f41599b == null) {
            return null;
        }
        List<Element> W = n0().W();
        Integer valueOf = Integer.valueOf(j0(this, W));
        Validate.j(valueOf);
        if (valueOf.intValue() > 0) {
            return W.get(valueOf.intValue() - 1);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean q() {
        return this.f41576g != null;
    }

    public Elements q0(String str) {
        return Selector.b(str, this);
    }

    public Element r0(String str) {
        return Selector.d(str, this);
    }

    public Elements s0() {
        if (this.f41599b == null) {
            return new Elements(0);
        }
        List<Element> W = n0().W();
        Elements elements = new Elements(W.size() - 1);
        for (Element next : W) {
            if (next != this) {
                elements.add(next);
            }
        }
        return elements;
    }

    public Tag t0() {
        return this.f41573d;
    }

    public String toString() {
        return w();
    }

    public String u() {
        return this.f41573d.b();
    }

    public String u0() {
        return this.f41573d.b();
    }

    /* access modifiers changed from: package-private */
    public void v() {
        super.v();
        this.f41574e = null;
    }

    public String v0() {
        final StringBuilder sb = new StringBuilder();
        NodeTraversor.b(new NodeVisitor() {
            public void a(Node node, int i2) {
            }

            public void b(Node node, int i2) {
                if (node instanceof TextNode) {
                    Element.R(sb, (TextNode) node);
                } else if (node instanceof Element) {
                    Element element = (Element) node;
                    if (sb.length() <= 0) {
                        return;
                    }
                    if ((element.k0() || element.f41573d.b().equals("br")) && !TextNode.S(sb)) {
                        sb.append(' ');
                    }
                }
            }
        }, this);
        return sb.toString().trim();
    }

    /* access modifiers changed from: package-private */
    public void y(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.i() && (this.f41573d.a() || ((n0() != null && n0().t0().a()) || outputSettings.g()))) {
            if (!(appendable instanceof StringBuilder)) {
                s(appendable, i2, outputSettings);
            } else if (((StringBuilder) appendable).length() > 0) {
                s(appendable, i2, outputSettings);
            }
        }
        appendable.append('<').append(u0());
        Attributes attributes = this.f41576g;
        if (attributes != null) {
            attributes.p(appendable, outputSettings);
        }
        if (!this.f41575f.isEmpty() || !this.f41573d.g()) {
            appendable.append('>');
        } else if (outputSettings.j() != Document.OutputSettings.Syntax.html || !this.f41573d.d()) {
            appendable.append(" />");
        } else {
            appendable.append('>');
        }
    }

    /* access modifiers changed from: package-private */
    public void z(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (!this.f41575f.isEmpty() || !this.f41573d.g()) {
            if (outputSettings.i() && !this.f41575f.isEmpty() && (this.f41573d.a() || (outputSettings.g() && (this.f41575f.size() > 1 || (this.f41575f.size() == 1 && !(this.f41575f.get(0) instanceof TextNode)))))) {
                s(appendable, i2, outputSettings);
            }
            appendable.append("</").append(u0()).append('>');
        }
    }

    public Element(Tag tag, String str) {
        this(tag, str, (Attributes) null);
    }
}
