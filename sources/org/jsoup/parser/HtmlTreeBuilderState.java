package org.jsoup.parser;

import com.facebook.ads.internal.c.a;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.MediaTrack;
import com.vungle.ads.internal.model.AdPayload;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Token;

enum HtmlTreeBuilderState {
    Initial {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.i(token)) {
                return true;
            }
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
            } else if (token.h()) {
                Token.Doctype c2 = token.c();
                DocumentType documentType = new DocumentType(htmlTreeBuilder.f41800h.b(c2.o()), c2.q(), c2.r());
                documentType.R(c2.p());
                htmlTreeBuilder.w().Q(documentType);
                if (c2.s()) {
                    htmlTreeBuilder.w().B0(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.B0(HtmlTreeBuilderState.BeforeHtml);
            } else {
                htmlTreeBuilder.B0(HtmlTreeBuilderState.BeforeHtml);
                return htmlTreeBuilder.e(token);
            }
            return true;
        }
    },
    BeforeHtml {
        private boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.V("html");
            htmlTreeBuilder.B0(HtmlTreeBuilderState.BeforeHead);
            return htmlTreeBuilder.e(token);
        }

        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.h()) {
                htmlTreeBuilder.p(this);
                return false;
            }
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
            } else if (HtmlTreeBuilderState.i(token)) {
                return true;
            } else {
                if (token.k() && token.e().C().equals("html")) {
                    htmlTreeBuilder.L(token.e());
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.BeforeHead);
                } else if (token.j() && StringUtil.b(token.d().C(), "head", "body", "html", "br")) {
                    return k(token, htmlTreeBuilder);
                } else {
                    if (!token.j()) {
                        return k(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.p(this);
                    return false;
                }
            }
            return true;
        }
    },
    BeforeHead {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.i(token)) {
                return true;
            }
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
            } else if (token.h()) {
                htmlTreeBuilder.p(this);
                return false;
            } else if (token.k() && token.e().C().equals("html")) {
                return HtmlTreeBuilderState.InBody.j(token, htmlTreeBuilder);
            } else {
                if (token.k() && token.e().C().equals("head")) {
                    htmlTreeBuilder.z0(htmlTreeBuilder.L(token.e()));
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.InHead);
                } else if (token.j() && StringUtil.b(token.d().C(), "head", "body", "html", "br")) {
                    htmlTreeBuilder.g("head");
                    return htmlTreeBuilder.e(token);
                } else if (token.j()) {
                    htmlTreeBuilder.p(this);
                    return false;
                } else {
                    htmlTreeBuilder.g("head");
                    return htmlTreeBuilder.e(token);
                }
            }
            return true;
        }
    },
    InHead {
        private boolean k(Token token, TreeBuilder treeBuilder) {
            treeBuilder.f("head");
            return treeBuilder.e(token);
        }

        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.i(token)) {
                htmlTreeBuilder.N(token.a());
                return true;
            }
            int i2 = AnonymousClass24.f41655a[token.f41701a.ordinal()];
            if (i2 == 1) {
                htmlTreeBuilder.O(token.b());
            } else if (i2 == 2) {
                htmlTreeBuilder.p(this);
                return false;
            } else if (i2 == 3) {
                Token.StartTag e2 = token.e();
                String C = e2.C();
                if (C.equals("html")) {
                    return HtmlTreeBuilderState.InBody.j(token, htmlTreeBuilder);
                }
                if (StringUtil.b(C, com.facebook.hermes.intl.Constants.SENSITIVITY_BASE, "basefont", "bgsound", "command", "link")) {
                    Element P = htmlTreeBuilder.P(e2);
                    if (C.equals(com.facebook.hermes.intl.Constants.SENSITIVITY_BASE) && P.p("href")) {
                        htmlTreeBuilder.e0(P);
                    }
                } else if (C.equals("meta")) {
                    htmlTreeBuilder.P(e2);
                } else if (C.equals("title")) {
                    HtmlTreeBuilderState.g(e2, htmlTreeBuilder);
                } else if (StringUtil.b(C, "noframes", "style")) {
                    HtmlTreeBuilderState.f(e2, htmlTreeBuilder);
                } else if (C.equals("noscript")) {
                    htmlTreeBuilder.L(e2);
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.InHeadNoscript);
                } else if (C.equals("script")) {
                    htmlTreeBuilder.f41794b.u(TokeniserState.ScriptData);
                    htmlTreeBuilder.d0();
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.Text);
                    htmlTreeBuilder.L(e2);
                } else if (!C.equals("head")) {
                    return k(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.p(this);
                    return false;
                }
            } else if (i2 != 4) {
                return k(token, htmlTreeBuilder);
            } else {
                String C2 = token.d().C();
                if (C2.equals("head")) {
                    htmlTreeBuilder.i0();
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.AfterHead);
                } else if (StringUtil.b(C2, "body", "html", "br")) {
                    return k(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.p(this);
                    return false;
                }
            }
            return true;
        }
    },
    InHeadNoscript {
        private boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.p(this);
            htmlTreeBuilder.N(new Token.Character().o(token.toString()));
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.h()) {
                htmlTreeBuilder.p(this);
                return true;
            } else if (token.k() && token.e().C().equals("html")) {
                return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InBody);
            } else {
                if (token.j() && token.d().C().equals("noscript")) {
                    htmlTreeBuilder.i0();
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.InHead);
                    return true;
                } else if (HtmlTreeBuilderState.i(token) || token.g() || (token.k() && StringUtil.b(token.e().C(), "basefont", "bgsound", "link", "meta", "noframes", "style"))) {
                    return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InHead);
                } else {
                    if (token.j() && token.d().C().equals("br")) {
                        return k(token, htmlTreeBuilder);
                    }
                    if ((!token.k() || !StringUtil.b(token.e().C(), "head", "noscript")) && !token.j()) {
                        return k(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.p(this);
                    return false;
                }
            }
        }
    },
    AfterHead {
        private boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.g("body");
            htmlTreeBuilder.q(true);
            return htmlTreeBuilder.e(token);
        }

        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token token2 = token;
            HtmlTreeBuilder htmlTreeBuilder2 = htmlTreeBuilder;
            if (HtmlTreeBuilderState.i(token)) {
                htmlTreeBuilder2.N(token.a());
                return true;
            } else if (token.g()) {
                htmlTreeBuilder2.O(token.b());
                return true;
            } else if (token.h()) {
                htmlTreeBuilder2.p(this);
                return true;
            } else if (token.k()) {
                Token.StartTag e2 = token.e();
                String C = e2.C();
                if (C.equals("html")) {
                    return htmlTreeBuilder2.m0(token2, HtmlTreeBuilderState.InBody);
                }
                if (C.equals("body")) {
                    htmlTreeBuilder2.L(e2);
                    htmlTreeBuilder2.q(false);
                    htmlTreeBuilder2.B0(HtmlTreeBuilderState.InBody);
                    return true;
                } else if (C.equals("frameset")) {
                    htmlTreeBuilder2.L(e2);
                    htmlTreeBuilder2.B0(HtmlTreeBuilderState.InFrameset);
                    return true;
                } else if (StringUtil.b(C, com.facebook.hermes.intl.Constants.SENSITIVITY_BASE, "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "title")) {
                    htmlTreeBuilder2.p(this);
                    Element z2 = htmlTreeBuilder.z();
                    htmlTreeBuilder2.n0(z2);
                    htmlTreeBuilder2.m0(token2, HtmlTreeBuilderState.InHead);
                    htmlTreeBuilder2.r0(z2);
                    return true;
                } else if (C.equals("head")) {
                    htmlTreeBuilder2.p(this);
                    return false;
                } else {
                    k(token, htmlTreeBuilder);
                    return true;
                }
            } else if (!token.j()) {
                k(token, htmlTreeBuilder);
                return true;
            } else if (StringUtil.b(token.d().C(), "body", "html")) {
                k(token, htmlTreeBuilder);
                return true;
            } else {
                htmlTreeBuilder2.p(this);
                return false;
            }
        }
    },
    InBody {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Element element;
            Token token2 = token;
            HtmlTreeBuilder htmlTreeBuilder2 = htmlTreeBuilder;
            int i2 = AnonymousClass24.f41655a[token2.f41701a.ordinal()];
            boolean z2 = true;
            if (i2 == 1) {
                htmlTreeBuilder2.O(token.b());
            } else if (i2 == 2) {
                htmlTreeBuilder2.p(this);
                return false;
            } else if (i2 == 3) {
                Token.StartTag e2 = token.e();
                String C = e2.C();
                if (C.equals(a.f20042a)) {
                    if (htmlTreeBuilder2.u(a.f20042a) != null) {
                        htmlTreeBuilder2.p(this);
                        htmlTreeBuilder2.f(a.f20042a);
                        Element y2 = htmlTreeBuilder2.y(a.f20042a);
                        if (y2 != null) {
                            htmlTreeBuilder2.q0(y2);
                            htmlTreeBuilder2.r0(y2);
                        }
                    }
                    htmlTreeBuilder.p0();
                    htmlTreeBuilder2.o0(htmlTreeBuilder2.L(e2));
                } else if (StringUtil.c(C, Constants.f41664i)) {
                    htmlTreeBuilder.p0();
                    htmlTreeBuilder2.P(e2);
                    htmlTreeBuilder2.q(false);
                } else if (StringUtil.c(C, Constants.f41657b)) {
                    if (htmlTreeBuilder2.C(ContextChain.TAG_PRODUCT)) {
                        htmlTreeBuilder2.f(ContextChain.TAG_PRODUCT);
                    }
                    htmlTreeBuilder2.L(e2);
                } else if (C.equals("span")) {
                    htmlTreeBuilder.p0();
                    htmlTreeBuilder2.L(e2);
                } else if (C.equals("li")) {
                    htmlTreeBuilder2.q(false);
                    ArrayList<Element> B = htmlTreeBuilder.B();
                    int size = B.size() - 1;
                    while (true) {
                        if (size <= 0) {
                            break;
                        }
                        Element element2 = B.get(size);
                        if (!element2.u().equals("li")) {
                            if (htmlTreeBuilder2.b0(element2) && !StringUtil.c(element2.u(), Constants.f41660e)) {
                                break;
                            }
                            size--;
                        } else {
                            htmlTreeBuilder2.f("li");
                            break;
                        }
                    }
                    if (htmlTreeBuilder2.C(ContextChain.TAG_PRODUCT)) {
                        htmlTreeBuilder2.f(ContextChain.TAG_PRODUCT);
                    }
                    htmlTreeBuilder2.L(e2);
                } else if (C.equals("html")) {
                    htmlTreeBuilder2.p(this);
                    Element element3 = htmlTreeBuilder.B().get(0);
                    Iterator<Attribute> it2 = e2.x().iterator();
                    while (it2.hasNext()) {
                        Attribute next = it2.next();
                        if (!element3.p(next.getKey())) {
                            element3.e().u(next);
                        }
                    }
                } else if (StringUtil.c(C, Constants.f41656a)) {
                    return htmlTreeBuilder2.m0(token2, HtmlTreeBuilderState.InHead);
                } else {
                    if (C.equals("body")) {
                        htmlTreeBuilder2.p(this);
                        ArrayList<Element> B2 = htmlTreeBuilder.B();
                        if (B2.size() == 1 || (B2.size() > 2 && !B2.get(1).u().equals("body"))) {
                            return false;
                        }
                        htmlTreeBuilder2.q(false);
                        Element element4 = B2.get(1);
                        Iterator<Attribute> it3 = e2.x().iterator();
                        while (it3.hasNext()) {
                            Attribute next2 = it3.next();
                            if (!element4.p(next2.getKey())) {
                                element4.e().u(next2);
                            }
                        }
                    } else if (C.equals("frameset")) {
                        htmlTreeBuilder2.p(this);
                        ArrayList<Element> B3 = htmlTreeBuilder.B();
                        if (B3.size() == 1 || ((B3.size() > 2 && !B3.get(1).u().equals("body")) || !htmlTreeBuilder.r())) {
                            return false;
                        }
                        Element element5 = B3.get(1);
                        if (element5.n0() != null) {
                            element5.E();
                        }
                        for (int i3 = 1; B3.size() > i3; i3 = 1) {
                            B3.remove(B3.size() - i3);
                        }
                        htmlTreeBuilder2.L(e2);
                        htmlTreeBuilder2.B0(HtmlTreeBuilderState.InFrameset);
                    } else {
                        String[] strArr = Constants.f41658c;
                        if (StringUtil.c(C, strArr)) {
                            if (htmlTreeBuilder2.C(ContextChain.TAG_PRODUCT)) {
                                htmlTreeBuilder2.f(ContextChain.TAG_PRODUCT);
                            }
                            if (StringUtil.c(htmlTreeBuilder.a().u(), strArr)) {
                                htmlTreeBuilder2.p(this);
                                htmlTreeBuilder.i0();
                            }
                            htmlTreeBuilder2.L(e2);
                        } else if (StringUtil.c(C, Constants.f41659d)) {
                            if (htmlTreeBuilder2.C(ContextChain.TAG_PRODUCT)) {
                                htmlTreeBuilder2.f(ContextChain.TAG_PRODUCT);
                            }
                            htmlTreeBuilder2.L(e2);
                            htmlTreeBuilder2.q(false);
                        } else if (C.equals("form")) {
                            if (htmlTreeBuilder.x() != null) {
                                htmlTreeBuilder2.p(this);
                                return false;
                            }
                            if (htmlTreeBuilder2.C(ContextChain.TAG_PRODUCT)) {
                                htmlTreeBuilder2.f(ContextChain.TAG_PRODUCT);
                            }
                            htmlTreeBuilder2.Q(e2, true);
                            return true;
                        } else if (StringUtil.c(C, Constants.f41661f)) {
                            htmlTreeBuilder2.q(false);
                            ArrayList<Element> B4 = htmlTreeBuilder.B();
                            int size2 = B4.size() - 1;
                            while (true) {
                                if (size2 <= 0) {
                                    break;
                                }
                                Element element6 = B4.get(size2);
                                if (!StringUtil.c(element6.u(), Constants.f41661f)) {
                                    if (htmlTreeBuilder2.b0(element6) && !StringUtil.c(element6.u(), Constants.f41660e)) {
                                        break;
                                    }
                                    size2--;
                                } else {
                                    htmlTreeBuilder2.f(element6.u());
                                    break;
                                }
                            }
                            if (htmlTreeBuilder2.C(ContextChain.TAG_PRODUCT)) {
                                htmlTreeBuilder2.f(ContextChain.TAG_PRODUCT);
                            }
                            htmlTreeBuilder2.L(e2);
                        } else if (C.equals("plaintext")) {
                            if (htmlTreeBuilder2.C(ContextChain.TAG_PRODUCT)) {
                                htmlTreeBuilder2.f(ContextChain.TAG_PRODUCT);
                            }
                            htmlTreeBuilder2.L(e2);
                            htmlTreeBuilder2.f41794b.u(TokeniserState.PLAINTEXT);
                        } else if (C.equals("button")) {
                            if (htmlTreeBuilder2.C("button")) {
                                htmlTreeBuilder2.p(this);
                                htmlTreeBuilder2.f("button");
                                htmlTreeBuilder2.e(e2);
                            } else {
                                htmlTreeBuilder.p0();
                                htmlTreeBuilder2.L(e2);
                                htmlTreeBuilder2.q(false);
                            }
                        } else if (StringUtil.c(C, Constants.f41662g)) {
                            htmlTreeBuilder.p0();
                            htmlTreeBuilder2.o0(htmlTreeBuilder2.L(e2));
                        } else if (C.equals("nobr")) {
                            htmlTreeBuilder.p0();
                            if (htmlTreeBuilder2.E("nobr")) {
                                htmlTreeBuilder2.p(this);
                                htmlTreeBuilder2.f("nobr");
                                htmlTreeBuilder.p0();
                            }
                            htmlTreeBuilder2.o0(htmlTreeBuilder2.L(e2));
                        } else if (StringUtil.c(C, Constants.f41663h)) {
                            htmlTreeBuilder.p0();
                            htmlTreeBuilder2.L(e2);
                            htmlTreeBuilder.S();
                            htmlTreeBuilder2.q(false);
                        } else if (C.equals("table")) {
                            if (htmlTreeBuilder.w().A0() != Document.QuirksMode.quirks && htmlTreeBuilder2.C(ContextChain.TAG_PRODUCT)) {
                                htmlTreeBuilder2.f(ContextChain.TAG_PRODUCT);
                            }
                            htmlTreeBuilder2.L(e2);
                            htmlTreeBuilder2.q(false);
                            htmlTreeBuilder2.B0(HtmlTreeBuilderState.InTable);
                        } else if (C.equals("input")) {
                            htmlTreeBuilder.p0();
                            if (!htmlTreeBuilder2.P(e2).c("type").equalsIgnoreCase(ViewProps.HIDDEN)) {
                                htmlTreeBuilder2.q(false);
                            }
                        } else if (StringUtil.c(C, Constants.f41665j)) {
                            htmlTreeBuilder2.P(e2);
                        } else if (C.equals("hr")) {
                            if (htmlTreeBuilder2.C(ContextChain.TAG_PRODUCT)) {
                                htmlTreeBuilder2.f(ContextChain.TAG_PRODUCT);
                            }
                            htmlTreeBuilder2.P(e2);
                            htmlTreeBuilder2.q(false);
                        } else if (C.equals("image")) {
                            if (htmlTreeBuilder2.y("svg") == null) {
                                return htmlTreeBuilder2.e(e2.A("img"));
                            }
                            htmlTreeBuilder2.L(e2);
                        } else if (C.equals("isindex")) {
                            htmlTreeBuilder2.p(this);
                            if (htmlTreeBuilder.x() != null) {
                                return false;
                            }
                            htmlTreeBuilder2.g("form");
                            if (e2.f41718j.m("action")) {
                                htmlTreeBuilder.x().T("action", e2.f41718j.k("action"));
                            }
                            htmlTreeBuilder2.g("hr");
                            htmlTreeBuilder2.g("label");
                            htmlTreeBuilder2.e(new Token.Character().o(e2.f41718j.m("prompt") ? e2.f41718j.k("prompt") : "This is a searchable index. Enter search keywords: "));
                            Attributes attributes = new Attributes();
                            Iterator<Attribute> it4 = e2.f41718j.iterator();
                            while (it4.hasNext()) {
                                Attribute next3 = it4.next();
                                if (!StringUtil.c(next3.getKey(), Constants.f41666k)) {
                                    attributes.u(next3);
                                }
                            }
                            attributes.t("name", "isindex");
                            htmlTreeBuilder2.h("input", attributes);
                            htmlTreeBuilder2.f("label");
                            htmlTreeBuilder2.g("hr");
                            htmlTreeBuilder2.f("form");
                        } else if (C.equals("textarea")) {
                            htmlTreeBuilder2.L(e2);
                            htmlTreeBuilder2.f41794b.u(TokeniserState.Rcdata);
                            htmlTreeBuilder.d0();
                            htmlTreeBuilder2.q(false);
                            htmlTreeBuilder2.B0(HtmlTreeBuilderState.Text);
                        } else if (C.equals("xmp")) {
                            if (htmlTreeBuilder2.C(ContextChain.TAG_PRODUCT)) {
                                htmlTreeBuilder2.f(ContextChain.TAG_PRODUCT);
                            }
                            htmlTreeBuilder.p0();
                            htmlTreeBuilder2.q(false);
                            HtmlTreeBuilderState.f(e2, htmlTreeBuilder2);
                        } else if (C.equals("iframe")) {
                            htmlTreeBuilder2.q(false);
                            HtmlTreeBuilderState.f(e2, htmlTreeBuilder2);
                        } else if (C.equals("noembed")) {
                            HtmlTreeBuilderState.f(e2, htmlTreeBuilder2);
                        } else if (C.equals("select")) {
                            htmlTreeBuilder.p0();
                            htmlTreeBuilder2.L(e2);
                            htmlTreeBuilder2.q(false);
                            HtmlTreeBuilderState A0 = htmlTreeBuilder.A0();
                            if (A0.equals(HtmlTreeBuilderState.InTable) || A0.equals(HtmlTreeBuilderState.InCaption) || A0.equals(HtmlTreeBuilderState.InTableBody) || A0.equals(HtmlTreeBuilderState.InRow) || A0.equals(HtmlTreeBuilderState.InCell)) {
                                htmlTreeBuilder2.B0(HtmlTreeBuilderState.InSelectInTable);
                            } else {
                                htmlTreeBuilder2.B0(HtmlTreeBuilderState.InSelect);
                            }
                        } else if (StringUtil.c(C, Constants.f41667l)) {
                            if (htmlTreeBuilder.a().u().equals("option")) {
                                htmlTreeBuilder2.f("option");
                            }
                            htmlTreeBuilder.p0();
                            htmlTreeBuilder2.L(e2);
                        } else if (StringUtil.c(C, Constants.f41668m)) {
                            if (htmlTreeBuilder2.E("ruby")) {
                                htmlTreeBuilder.s();
                                if (!htmlTreeBuilder.a().u().equals("ruby")) {
                                    htmlTreeBuilder2.p(this);
                                    htmlTreeBuilder2.j0("ruby");
                                }
                                htmlTreeBuilder2.L(e2);
                            }
                        } else if (C.equals("math")) {
                            htmlTreeBuilder.p0();
                            htmlTreeBuilder2.L(e2);
                        } else if (C.equals("svg")) {
                            htmlTreeBuilder.p0();
                            htmlTreeBuilder2.L(e2);
                        } else if (StringUtil.c(C, Constants.f41669n)) {
                            htmlTreeBuilder2.p(this);
                            return false;
                        } else {
                            htmlTreeBuilder.p0();
                            htmlTreeBuilder2.L(e2);
                        }
                    }
                }
            } else if (i2 == 4) {
                Token.EndTag d2 = token.d();
                String C2 = d2.C();
                if (StringUtil.c(C2, Constants.f41671p)) {
                    int i4 = 0;
                    while (i4 < 8) {
                        Element u2 = htmlTreeBuilder2.u(C2);
                        if (u2 == null) {
                            return k(token, htmlTreeBuilder);
                        }
                        if (!htmlTreeBuilder2.g0(u2)) {
                            htmlTreeBuilder2.p(this);
                            htmlTreeBuilder2.q0(u2);
                            return z2;
                        } else if (!htmlTreeBuilder2.E(u2.u())) {
                            htmlTreeBuilder2.p(this);
                            return false;
                        } else {
                            if (htmlTreeBuilder.a() != u2) {
                                htmlTreeBuilder2.p(this);
                            }
                            ArrayList<Element> B5 = htmlTreeBuilder.B();
                            int size3 = B5.size();
                            Element element7 = null;
                            int i5 = 0;
                            boolean z3 = false;
                            while (true) {
                                if (i5 >= size3 || i5 >= 64) {
                                    element = null;
                                } else {
                                    element = B5.get(i5);
                                    if (element != u2) {
                                        if (z3 && htmlTreeBuilder2.b0(element)) {
                                            break;
                                        }
                                    } else {
                                        element7 = B5.get(i5 - 1);
                                        z3 = true;
                                    }
                                    i5++;
                                }
                            }
                            element = null;
                            if (element == null) {
                                htmlTreeBuilder2.k0(u2.u());
                                htmlTreeBuilder2.q0(u2);
                                return z2;
                            }
                            Element element8 = element;
                            Element element9 = element8;
                            for (int i6 = 0; i6 < 3; i6++) {
                                if (htmlTreeBuilder2.g0(element8)) {
                                    element8 = htmlTreeBuilder2.j(element8);
                                }
                                if (!htmlTreeBuilder2.Z(element8)) {
                                    htmlTreeBuilder2.r0(element8);
                                } else if (element8 == u2) {
                                    break;
                                } else {
                                    Element element10 = new Element(Tag.k(element8.u(), ParseSettings.f41677d), htmlTreeBuilder.v());
                                    htmlTreeBuilder2.t0(element8, element10);
                                    htmlTreeBuilder2.v0(element8, element10);
                                    if (element9.n0() != null) {
                                        element9.E();
                                    }
                                    element10.Q(element9);
                                    element8 = element10;
                                    element9 = element8;
                                }
                            }
                            if (StringUtil.c(element7.u(), Constants.f41672q)) {
                                if (element9.n0() != null) {
                                    element9.E();
                                }
                                htmlTreeBuilder2.R(element9);
                            } else {
                                if (element9.n0() != null) {
                                    element9.E();
                                }
                                element7.Q(element9);
                            }
                            Element element11 = new Element(u2.t0(), htmlTreeBuilder.v());
                            element11.e().d(u2.e());
                            for (Node Q : (Node[]) element.j().toArray(new Node[element.i()])) {
                                element11.Q(Q);
                            }
                            element.Q(element11);
                            htmlTreeBuilder2.q0(u2);
                            htmlTreeBuilder2.r0(u2);
                            htmlTreeBuilder2.U(element, element11);
                            i4++;
                            z2 = true;
                        }
                    }
                } else if (StringUtil.c(C2, Constants.f41670o)) {
                    if (!htmlTreeBuilder2.E(C2)) {
                        htmlTreeBuilder2.p(this);
                        return false;
                    }
                    htmlTreeBuilder.s();
                    if (!htmlTreeBuilder.a().u().equals(C2)) {
                        htmlTreeBuilder2.p(this);
                    }
                    htmlTreeBuilder2.k0(C2);
                } else if (C2.equals("span")) {
                    return k(token, htmlTreeBuilder);
                } else {
                    if (C2.equals("li")) {
                        if (!htmlTreeBuilder2.D(C2)) {
                            htmlTreeBuilder2.p(this);
                            return false;
                        }
                        htmlTreeBuilder2.t(C2);
                        if (!htmlTreeBuilder.a().u().equals(C2)) {
                            htmlTreeBuilder2.p(this);
                        }
                        htmlTreeBuilder2.k0(C2);
                    } else if (C2.equals("body")) {
                        if (!htmlTreeBuilder2.E("body")) {
                            htmlTreeBuilder2.p(this);
                            return false;
                        }
                        htmlTreeBuilder2.B0(HtmlTreeBuilderState.AfterBody);
                    } else if (C2.equals("html")) {
                        if (htmlTreeBuilder2.f("body")) {
                            return htmlTreeBuilder2.e(d2);
                        }
                    } else if (C2.equals("form")) {
                        FormElement x2 = htmlTreeBuilder.x();
                        htmlTreeBuilder2.x0((FormElement) null);
                        if (x2 == null || !htmlTreeBuilder2.E(C2)) {
                            htmlTreeBuilder2.p(this);
                            return false;
                        }
                        htmlTreeBuilder.s();
                        if (!htmlTreeBuilder.a().u().equals(C2)) {
                            htmlTreeBuilder2.p(this);
                        }
                        htmlTreeBuilder2.r0(x2);
                    } else if (C2.equals(ContextChain.TAG_PRODUCT)) {
                        if (!htmlTreeBuilder2.C(C2)) {
                            htmlTreeBuilder2.p(this);
                            htmlTreeBuilder2.g(C2);
                            return htmlTreeBuilder2.e(d2);
                        }
                        htmlTreeBuilder2.t(C2);
                        if (!htmlTreeBuilder.a().u().equals(C2)) {
                            htmlTreeBuilder2.p(this);
                        }
                        htmlTreeBuilder2.k0(C2);
                    } else if (!StringUtil.c(C2, Constants.f41661f)) {
                        String[] strArr2 = Constants.f41658c;
                        if (StringUtil.c(C2, strArr2)) {
                            if (!htmlTreeBuilder2.G(strArr2)) {
                                htmlTreeBuilder2.p(this);
                                return false;
                            }
                            htmlTreeBuilder2.t(C2);
                            if (!htmlTreeBuilder.a().u().equals(C2)) {
                                htmlTreeBuilder2.p(this);
                            }
                            htmlTreeBuilder2.l0(strArr2);
                        } else if (C2.equals("sarcasm")) {
                            return k(token, htmlTreeBuilder);
                        } else {
                            if (StringUtil.c(C2, Constants.f41663h)) {
                                if (!htmlTreeBuilder2.E("name")) {
                                    if (!htmlTreeBuilder2.E(C2)) {
                                        htmlTreeBuilder2.p(this);
                                        return false;
                                    }
                                    htmlTreeBuilder.s();
                                    if (!htmlTreeBuilder.a().u().equals(C2)) {
                                        htmlTreeBuilder2.p(this);
                                    }
                                    htmlTreeBuilder2.k0(C2);
                                    htmlTreeBuilder.k();
                                }
                            } else if (!C2.equals("br")) {
                                return k(token, htmlTreeBuilder);
                            } else {
                                htmlTreeBuilder2.p(this);
                                htmlTreeBuilder2.g("br");
                                return false;
                            }
                        }
                    } else if (!htmlTreeBuilder2.E(C2)) {
                        htmlTreeBuilder2.p(this);
                        return false;
                    } else {
                        htmlTreeBuilder2.t(C2);
                        if (!htmlTreeBuilder.a().u().equals(C2)) {
                            htmlTreeBuilder2.p(this);
                        }
                        htmlTreeBuilder2.k0(C2);
                    }
                }
            } else if (i2 == 5) {
                Token.Character a2 = token.a();
                if (a2.p().equals(HtmlTreeBuilderState.f41653y)) {
                    htmlTreeBuilder2.p(this);
                    return false;
                } else if (!htmlTreeBuilder.r() || !HtmlTreeBuilderState.i(a2)) {
                    htmlTreeBuilder.p0();
                    htmlTreeBuilder2.N(a2);
                    htmlTreeBuilder2.q(false);
                } else {
                    htmlTreeBuilder.p0();
                    htmlTreeBuilder2.N(a2);
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String b2 = htmlTreeBuilder.f41800h.b(token.d().z());
            ArrayList<Element> B = htmlTreeBuilder.B();
            int size = B.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = B.get(size);
                if (element.u().equals(b2)) {
                    htmlTreeBuilder.t(b2);
                    if (!b2.equals(htmlTreeBuilder.a().u())) {
                        htmlTreeBuilder.p(this);
                    }
                    htmlTreeBuilder.k0(b2);
                } else if (htmlTreeBuilder.b0(element)) {
                    htmlTreeBuilder.p(this);
                    return false;
                } else {
                    size--;
                }
            }
            return true;
        }
    },
    Text {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.f()) {
                htmlTreeBuilder.N(token.a());
                return true;
            } else if (token.i()) {
                htmlTreeBuilder.p(this);
                htmlTreeBuilder.i0();
                htmlTreeBuilder.B0(htmlTreeBuilder.h0());
                return htmlTreeBuilder.e(token);
            } else if (!token.j()) {
                return true;
            } else {
                htmlTreeBuilder.i0();
                htmlTreeBuilder.B0(htmlTreeBuilder.h0());
                return true;
            }
        }
    },
    InTable {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token token2 = token;
            HtmlTreeBuilder htmlTreeBuilder2 = htmlTreeBuilder;
            if (token.f()) {
                htmlTreeBuilder.f0();
                htmlTreeBuilder.d0();
                htmlTreeBuilder2.B0(HtmlTreeBuilderState.InTableText);
                return htmlTreeBuilder2.e(token2);
            } else if (token.g()) {
                htmlTreeBuilder2.O(token.b());
                return true;
            } else if (token.h()) {
                htmlTreeBuilder2.p(this);
                return false;
            } else if (token.k()) {
                Token.StartTag e2 = token.e();
                String C = e2.C();
                if (C.equals(MediaTrack.ROLE_CAPTION)) {
                    htmlTreeBuilder.n();
                    htmlTreeBuilder.S();
                    htmlTreeBuilder2.L(e2);
                    htmlTreeBuilder2.B0(HtmlTreeBuilderState.InCaption);
                } else if (C.equals("colgroup")) {
                    htmlTreeBuilder.n();
                    htmlTreeBuilder2.L(e2);
                    htmlTreeBuilder2.B0(HtmlTreeBuilderState.InColumnGroup);
                } else if (C.equals("col")) {
                    htmlTreeBuilder2.g("colgroup");
                    return htmlTreeBuilder2.e(token2);
                } else if (StringUtil.b(C, "tbody", "tfoot", "thead")) {
                    htmlTreeBuilder.n();
                    htmlTreeBuilder2.L(e2);
                    htmlTreeBuilder2.B0(HtmlTreeBuilderState.InTableBody);
                } else if (StringUtil.b(C, "td", "th", "tr")) {
                    htmlTreeBuilder2.g("tbody");
                    return htmlTreeBuilder2.e(token2);
                } else if (C.equals("table")) {
                    htmlTreeBuilder2.p(this);
                    if (htmlTreeBuilder2.f("table")) {
                        return htmlTreeBuilder2.e(token2);
                    }
                } else if (StringUtil.b(C, "style", "script")) {
                    return htmlTreeBuilder2.m0(token2, HtmlTreeBuilderState.InHead);
                } else {
                    if (C.equals("input")) {
                        if (!e2.f41718j.k("type").equalsIgnoreCase(ViewProps.HIDDEN)) {
                            return k(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder2.P(e2);
                    } else if (!C.equals("form")) {
                        return k(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder2.p(this);
                        if (htmlTreeBuilder.x() != null) {
                            return false;
                        }
                        htmlTreeBuilder2.Q(e2, false);
                    }
                }
                return true;
            } else if (token.j()) {
                String C2 = token.d().C();
                if (C2.equals("table")) {
                    if (!htmlTreeBuilder2.K(C2)) {
                        htmlTreeBuilder2.p(this);
                        return false;
                    }
                    htmlTreeBuilder2.k0("table");
                    htmlTreeBuilder.w0();
                    return true;
                } else if (!StringUtil.b(C2, "body", MediaTrack.ROLE_CAPTION, "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                    return k(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder2.p(this);
                    return false;
                }
            } else if (!token.i()) {
                return k(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.a().u().equals("html")) {
                    htmlTreeBuilder2.p(this);
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.p(this);
            if (!StringUtil.b(htmlTreeBuilder.a().u(), "table", "tbody", "tfoot", "thead", "tr")) {
                return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InBody);
            }
            htmlTreeBuilder.y0(true);
            boolean m02 = htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InBody);
            htmlTreeBuilder.y0(false);
            return m02;
        }
    },
    InTableText {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (AnonymousClass24.f41655a[token.f41701a.ordinal()] != 5) {
                if (htmlTreeBuilder.A().size() > 0) {
                    for (String next : htmlTreeBuilder.A()) {
                        if (!HtmlTreeBuilderState.h(next)) {
                            htmlTreeBuilder.p(this);
                            if (StringUtil.b(htmlTreeBuilder.a().u(), "table", "tbody", "tfoot", "thead", "tr")) {
                                htmlTreeBuilder.y0(true);
                                htmlTreeBuilder.m0(new Token.Character().o(next), HtmlTreeBuilderState.InBody);
                                htmlTreeBuilder.y0(false);
                            } else {
                                htmlTreeBuilder.m0(new Token.Character().o(next), HtmlTreeBuilderState.InBody);
                            }
                        } else {
                            htmlTreeBuilder.N(new Token.Character().o(next));
                        }
                    }
                    htmlTreeBuilder.f0();
                }
                htmlTreeBuilder.B0(htmlTreeBuilder.h0());
                return htmlTreeBuilder.e(token);
            }
            Token.Character a2 = token.a();
            if (a2.p().equals(HtmlTreeBuilderState.f41653y)) {
                htmlTreeBuilder.p(this);
                return false;
            }
            htmlTreeBuilder.A().add(a2.p());
            return true;
        }
    },
    InCaption {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!token.j() || !token.d().C().equals(MediaTrack.ROLE_CAPTION)) {
                if ((token.k() && StringUtil.b(token.e().C(), MediaTrack.ROLE_CAPTION, "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) || (token.j() && token.d().C().equals("table"))) {
                    htmlTreeBuilder.p(this);
                    if (htmlTreeBuilder.f(MediaTrack.ROLE_CAPTION)) {
                        return htmlTreeBuilder.e(token);
                    }
                    return true;
                } else if (!token.j() || !StringUtil.b(token.d().C(), "body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                    return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InBody);
                } else {
                    htmlTreeBuilder.p(this);
                    return false;
                }
            } else if (!htmlTreeBuilder.K(token.d().C())) {
                htmlTreeBuilder.p(this);
                return false;
            } else {
                htmlTreeBuilder.s();
                if (!htmlTreeBuilder.a().u().equals(MediaTrack.ROLE_CAPTION)) {
                    htmlTreeBuilder.p(this);
                }
                htmlTreeBuilder.k0(MediaTrack.ROLE_CAPTION);
                htmlTreeBuilder.k();
                htmlTreeBuilder.B0(HtmlTreeBuilderState.InTable);
                return true;
            }
        }
    },
    InColumnGroup {
        private boolean k(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.f("colgroup")) {
                return treeBuilder.e(token);
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.i(token)) {
                htmlTreeBuilder.N(token.a());
                return true;
            }
            int i2 = AnonymousClass24.f41655a[token.f41701a.ordinal()];
            if (i2 == 1) {
                htmlTreeBuilder.O(token.b());
            } else if (i2 == 2) {
                htmlTreeBuilder.p(this);
            } else if (i2 == 3) {
                Token.StartTag e2 = token.e();
                String C = e2.C();
                C.hashCode();
                if (C.equals("col")) {
                    htmlTreeBuilder.P(e2);
                } else if (!C.equals("html")) {
                    return k(token, htmlTreeBuilder);
                } else {
                    return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InBody);
                }
            } else if (i2 != 4) {
                if (i2 != 6) {
                    return k(token, htmlTreeBuilder);
                }
                if (htmlTreeBuilder.a().u().equals("html")) {
                    return true;
                }
                return k(token, htmlTreeBuilder);
            } else if (!token.d().f41711c.equals("colgroup")) {
                return k(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.a().u().equals("html")) {
                    htmlTreeBuilder.p(this);
                    return false;
                }
                htmlTreeBuilder.i0();
                htmlTreeBuilder.B0(HtmlTreeBuilderState.InTable);
            }
            return true;
        }
    },
    InTableBody {
        private boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InTable);
        }

        private boolean l(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.K("tbody") || htmlTreeBuilder.K("thead") || htmlTreeBuilder.E("tfoot")) {
                htmlTreeBuilder.m();
                htmlTreeBuilder.f(htmlTreeBuilder.a().u());
                return htmlTreeBuilder.e(token);
            }
            htmlTreeBuilder.p(this);
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i2 = AnonymousClass24.f41655a[token.f41701a.ordinal()];
            if (i2 == 3) {
                Token.StartTag e2 = token.e();
                String C = e2.C();
                if (C.equals(AdPayload.KEY_TEMPLATE)) {
                    htmlTreeBuilder.L(e2);
                    return true;
                } else if (C.equals("tr")) {
                    htmlTreeBuilder.m();
                    htmlTreeBuilder.L(e2);
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.InRow);
                    return true;
                } else if (StringUtil.b(C, "th", "td")) {
                    htmlTreeBuilder.p(this);
                    htmlTreeBuilder.g("tr");
                    return htmlTreeBuilder.e(e2);
                } else if (StringUtil.b(C, MediaTrack.ROLE_CAPTION, "col", "colgroup", "tbody", "tfoot", "thead")) {
                    return l(token, htmlTreeBuilder);
                } else {
                    return k(token, htmlTreeBuilder);
                }
            } else if (i2 != 4) {
                return k(token, htmlTreeBuilder);
            } else {
                String C2 = token.d().C();
                if (StringUtil.b(C2, "tbody", "tfoot", "thead")) {
                    if (!htmlTreeBuilder.K(C2)) {
                        htmlTreeBuilder.p(this);
                        return false;
                    }
                    htmlTreeBuilder.m();
                    htmlTreeBuilder.i0();
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.InTable);
                    return true;
                } else if (C2.equals("table")) {
                    return l(token, htmlTreeBuilder);
                } else {
                    if (!StringUtil.b(C2, "body", MediaTrack.ROLE_CAPTION, "col", "colgroup", "html", "td", "th", "tr")) {
                        return k(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.p(this);
                    return false;
                }
            }
        }
    },
    InRow {
        private boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InTable);
        }

        private boolean l(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.f("tr")) {
                return treeBuilder.e(token);
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.k()) {
                Token.StartTag e2 = token.e();
                String C = e2.C();
                if (C.equals(AdPayload.KEY_TEMPLATE)) {
                    htmlTreeBuilder.L(e2);
                    return true;
                } else if (StringUtil.b(C, "th", "td")) {
                    htmlTreeBuilder.o();
                    htmlTreeBuilder.L(e2);
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.InCell);
                    htmlTreeBuilder.S();
                    return true;
                } else if (StringUtil.b(C, MediaTrack.ROLE_CAPTION, "col", "colgroup", "tbody", "tfoot", "thead", "tr")) {
                    return l(token, htmlTreeBuilder);
                } else {
                    return k(token, htmlTreeBuilder);
                }
            } else if (!token.j()) {
                return k(token, htmlTreeBuilder);
            } else {
                String C2 = token.d().C();
                if (C2.equals("tr")) {
                    if (!htmlTreeBuilder.K(C2)) {
                        htmlTreeBuilder.p(this);
                        return false;
                    }
                    htmlTreeBuilder.o();
                    htmlTreeBuilder.i0();
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.InTableBody);
                    return true;
                } else if (C2.equals("table")) {
                    return l(token, htmlTreeBuilder);
                } else {
                    if (StringUtil.b(C2, "tbody", "tfoot", "thead")) {
                        if (!htmlTreeBuilder.K(C2)) {
                            htmlTreeBuilder.p(this);
                            return false;
                        }
                        htmlTreeBuilder.f("tr");
                        return htmlTreeBuilder.e(token);
                    } else if (!StringUtil.b(C2, "body", MediaTrack.ROLE_CAPTION, "col", "colgroup", "html", "td", "th")) {
                        return k(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.p(this);
                        return false;
                    }
                }
            }
        }
    },
    InCell {
        private boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InBody);
        }

        private void l(HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.K("td")) {
                htmlTreeBuilder.f("td");
            } else {
                htmlTreeBuilder.f("th");
            }
        }

        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.j()) {
                String C = token.d().C();
                if (StringUtil.b(C, "td", "th")) {
                    if (!htmlTreeBuilder.K(C)) {
                        htmlTreeBuilder.p(this);
                        htmlTreeBuilder.B0(HtmlTreeBuilderState.InRow);
                        return false;
                    }
                    htmlTreeBuilder.s();
                    if (!htmlTreeBuilder.a().u().equals(C)) {
                        htmlTreeBuilder.p(this);
                    }
                    htmlTreeBuilder.k0(C);
                    htmlTreeBuilder.k();
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.InRow);
                    return true;
                } else if (StringUtil.b(C, "body", MediaTrack.ROLE_CAPTION, "col", "colgroup", "html")) {
                    htmlTreeBuilder.p(this);
                    return false;
                } else if (!StringUtil.b(C, "table", "tbody", "tfoot", "thead", "tr")) {
                    return k(token, htmlTreeBuilder);
                } else {
                    if (!htmlTreeBuilder.K(C)) {
                        htmlTreeBuilder.p(this);
                        return false;
                    }
                    l(htmlTreeBuilder);
                    return htmlTreeBuilder.e(token);
                }
            } else if (!token.k() || !StringUtil.b(token.e().C(), MediaTrack.ROLE_CAPTION, "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                return k(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.K("td") || htmlTreeBuilder.K("th")) {
                    l(htmlTreeBuilder);
                    return htmlTreeBuilder.e(token);
                }
                htmlTreeBuilder.p(this);
                return false;
            }
        }
    },
    InSelect {
        private boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.p(this);
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass24.f41655a[token.f41701a.ordinal()]) {
                case 1:
                    htmlTreeBuilder.O(token.b());
                    break;
                case 2:
                    htmlTreeBuilder.p(this);
                    return false;
                case 3:
                    Token.StartTag e2 = token.e();
                    String C = e2.C();
                    if (C.equals("html")) {
                        return htmlTreeBuilder.m0(e2, HtmlTreeBuilderState.InBody);
                    }
                    if (C.equals("option")) {
                        if (htmlTreeBuilder.a().u().equals("option")) {
                            htmlTreeBuilder.f("option");
                        }
                        htmlTreeBuilder.L(e2);
                        break;
                    } else if (C.equals("optgroup")) {
                        if (htmlTreeBuilder.a().u().equals("option")) {
                            htmlTreeBuilder.f("option");
                        } else if (htmlTreeBuilder.a().u().equals("optgroup")) {
                            htmlTreeBuilder.f("optgroup");
                        }
                        htmlTreeBuilder.L(e2);
                        break;
                    } else if (C.equals("select")) {
                        htmlTreeBuilder.p(this);
                        return htmlTreeBuilder.f("select");
                    } else if (StringUtil.b(C, "input", "keygen", "textarea")) {
                        htmlTreeBuilder.p(this);
                        if (!htmlTreeBuilder.H("select")) {
                            return false;
                        }
                        htmlTreeBuilder.f("select");
                        return htmlTreeBuilder.e(e2);
                    } else if (C.equals("script")) {
                        return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InHead);
                    } else {
                        return k(token, htmlTreeBuilder);
                    }
                case 4:
                    String C2 = token.d().C();
                    C2.hashCode();
                    char c2 = 65535;
                    switch (C2.hashCode()) {
                        case -1010136971:
                            if (C2.equals("option")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -906021636:
                            if (C2.equals("select")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -80773204:
                            if (C2.equals("optgroup")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            if (!htmlTreeBuilder.a().u().equals("option")) {
                                htmlTreeBuilder.p(this);
                                break;
                            } else {
                                htmlTreeBuilder.i0();
                                break;
                            }
                        case 1:
                            if (htmlTreeBuilder.H(C2)) {
                                htmlTreeBuilder.k0(C2);
                                htmlTreeBuilder.w0();
                                break;
                            } else {
                                htmlTreeBuilder.p(this);
                                return false;
                            }
                        case 2:
                            if (htmlTreeBuilder.a().u().equals("option") && htmlTreeBuilder.j(htmlTreeBuilder.a()) != null && htmlTreeBuilder.j(htmlTreeBuilder.a()).u().equals("optgroup")) {
                                htmlTreeBuilder.f("option");
                            }
                            if (!htmlTreeBuilder.a().u().equals("optgroup")) {
                                htmlTreeBuilder.p(this);
                                break;
                            } else {
                                htmlTreeBuilder.i0();
                                break;
                            }
                        default:
                            return k(token, htmlTreeBuilder);
                    }
                case 5:
                    Token.Character a2 = token.a();
                    if (!a2.p().equals(HtmlTreeBuilderState.f41653y)) {
                        htmlTreeBuilder.N(a2);
                        break;
                    } else {
                        htmlTreeBuilder.p(this);
                        return false;
                    }
                case 6:
                    if (!htmlTreeBuilder.a().u().equals("html")) {
                        htmlTreeBuilder.p(this);
                        break;
                    }
                    break;
                default:
                    return k(token, htmlTreeBuilder);
            }
            return true;
        }
    },
    InSelectInTable {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.k() && StringUtil.b(token.e().C(), MediaTrack.ROLE_CAPTION, "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                htmlTreeBuilder.p(this);
                htmlTreeBuilder.f("select");
                return htmlTreeBuilder.e(token);
            } else if (!token.j() || !StringUtil.b(token.d().C(), MediaTrack.ROLE_CAPTION, "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InSelect);
            } else {
                htmlTreeBuilder.p(this);
                if (!htmlTreeBuilder.K(token.d().C())) {
                    return false;
                }
                htmlTreeBuilder.f("select");
                return htmlTreeBuilder.e(token);
            }
        }
    },
    AfterBody {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.i(token)) {
                return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
                return true;
            } else if (token.h()) {
                htmlTreeBuilder.p(this);
                return false;
            } else if (token.k() && token.e().C().equals("html")) {
                return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InBody);
            } else {
                if (!token.j() || !token.d().C().equals("html")) {
                    if (token.i()) {
                        return true;
                    }
                    htmlTreeBuilder.p(this);
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.InBody);
                    return htmlTreeBuilder.e(token);
                } else if (htmlTreeBuilder.Y()) {
                    htmlTreeBuilder.p(this);
                    return false;
                } else {
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.AfterAfterBody);
                    return true;
                }
            }
        }
    },
    InFrameset {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.i(token)) {
                htmlTreeBuilder.N(token.a());
            } else if (token.g()) {
                htmlTreeBuilder.O(token.b());
            } else if (token.h()) {
                htmlTreeBuilder.p(this);
                return false;
            } else if (token.k()) {
                Token.StartTag e2 = token.e();
                String C = e2.C();
                C.hashCode();
                char c2 = 65535;
                switch (C.hashCode()) {
                    case -1644953643:
                        if (C.equals("frameset")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3213227:
                        if (C.equals("html")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 97692013:
                        if (C.equals("frame")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1192721831:
                        if (C.equals("noframes")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        htmlTreeBuilder.L(e2);
                        break;
                    case 1:
                        return htmlTreeBuilder.m0(e2, HtmlTreeBuilderState.InBody);
                    case 2:
                        htmlTreeBuilder.P(e2);
                        break;
                    case 3:
                        return htmlTreeBuilder.m0(e2, HtmlTreeBuilderState.InHead);
                    default:
                        htmlTreeBuilder.p(this);
                        return false;
                }
            } else if (!token.j() || !token.d().C().equals("frameset")) {
                if (!token.i()) {
                    htmlTreeBuilder.p(this);
                    return false;
                } else if (!htmlTreeBuilder.a().u().equals("html")) {
                    htmlTreeBuilder.p(this);
                }
            } else if (htmlTreeBuilder.a().u().equals("html")) {
                htmlTreeBuilder.p(this);
                return false;
            } else {
                htmlTreeBuilder.i0();
                if (!htmlTreeBuilder.Y() && !htmlTreeBuilder.a().u().equals("frameset")) {
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.AfterFrameset);
                }
            }
            return true;
        }
    },
    AfterFrameset {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.i(token)) {
                htmlTreeBuilder.N(token.a());
                return true;
            } else if (token.g()) {
                htmlTreeBuilder.O(token.b());
                return true;
            } else if (token.h()) {
                htmlTreeBuilder.p(this);
                return false;
            } else if (token.k() && token.e().C().equals("html")) {
                return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InBody);
            } else {
                if (token.j() && token.d().C().equals("html")) {
                    htmlTreeBuilder.B0(HtmlTreeBuilderState.AfterAfterFrameset);
                    return true;
                } else if (token.k() && token.e().C().equals("noframes")) {
                    return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InHead);
                } else {
                    if (token.i()) {
                        return true;
                    }
                    htmlTreeBuilder.p(this);
                    return false;
                }
            }
        }
    },
    AfterAfterBody {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
                return true;
            } else if (token.h() || HtmlTreeBuilderState.i(token) || (token.k() && token.e().C().equals("html"))) {
                return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InBody);
            } else {
                if (token.i()) {
                    return true;
                }
                htmlTreeBuilder.p(this);
                htmlTreeBuilder.B0(HtmlTreeBuilderState.InBody);
                return htmlTreeBuilder.e(token);
            }
        }
    },
    AfterAfterFrameset {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
                return true;
            } else if (token.h() || HtmlTreeBuilderState.i(token) || (token.k() && token.e().C().equals("html"))) {
                return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InBody);
            } else {
                if (token.i()) {
                    return true;
                }
                if (token.k() && token.e().C().equals("noframes")) {
                    return htmlTreeBuilder.m0(token, HtmlTreeBuilderState.InHead);
                }
                htmlTreeBuilder.p(this);
                return false;
            }
        }
    },
    ForeignContent {
        /* access modifiers changed from: package-private */
        public boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };
    
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public static String f41653y;

    /* renamed from: org.jsoup.parser.HtmlTreeBuilderState$24  reason: invalid class name */
    static /* synthetic */ class AnonymousClass24 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41655a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jsoup.parser.Token$TokenType[] r0 = org.jsoup.parser.Token.TokenType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f41655a = r0
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Comment     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f41655a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Doctype     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f41655a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.StartTag     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f41655a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EndTag     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f41655a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Character     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f41655a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EOF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.<clinit>():void");
        }
    }

    static final class Constants {

        /* renamed from: a  reason: collision with root package name */
        static final String[] f41656a = null;

        /* renamed from: b  reason: collision with root package name */
        static final String[] f41657b = null;

        /* renamed from: c  reason: collision with root package name */
        static final String[] f41658c = null;

        /* renamed from: d  reason: collision with root package name */
        static final String[] f41659d = null;

        /* renamed from: e  reason: collision with root package name */
        static final String[] f41660e = null;

        /* renamed from: f  reason: collision with root package name */
        static final String[] f41661f = null;

        /* renamed from: g  reason: collision with root package name */
        static final String[] f41662g = null;

        /* renamed from: h  reason: collision with root package name */
        static final String[] f41663h = null;

        /* renamed from: i  reason: collision with root package name */
        static final String[] f41664i = null;

        /* renamed from: j  reason: collision with root package name */
        static final String[] f41665j = null;

        /* renamed from: k  reason: collision with root package name */
        static final String[] f41666k = null;

        /* renamed from: l  reason: collision with root package name */
        static final String[] f41667l = null;

        /* renamed from: m  reason: collision with root package name */
        static final String[] f41668m = null;

        /* renamed from: n  reason: collision with root package name */
        static final String[] f41669n = null;

        /* renamed from: o  reason: collision with root package name */
        static final String[] f41670o = null;

        /* renamed from: p  reason: collision with root package name */
        static final String[] f41671p = null;

        /* renamed from: q  reason: collision with root package name */
        static final String[] f41672q = null;

        static {
            f41656a = new String[]{com.facebook.hermes.intl.Constants.SENSITIVITY_BASE, "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "title"};
            f41657b = new String[]{"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", ContextChain.TAG_PRODUCT, "section", "summary", "ul"};
            f41658c = new String[]{"h1", "h2", "h3", "h4", "h5", "h6"};
            f41659d = new String[]{"listing", "pre"};
            f41660e = new String[]{"address", "div", ContextChain.TAG_PRODUCT};
            f41661f = new String[]{"dd", "dt"};
            f41662g = new String[]{"b", "big", "code", "em", "font", ContextChain.TAG_INFRA, "s", "small", "strike", "strong", "tt", "u"};
            f41663h = new String[]{"applet", "marquee", "object"};
            f41664i = new String[]{"area", "br", "embed", "img", "keygen", "wbr"};
            f41665j = new String[]{"param", "source", "track"};
            f41666k = new String[]{"action", "name", "prompt"};
            f41667l = new String[]{"optgroup", "option"};
            f41668m = new String[]{"rp", "rt"};
            f41669n = new String[]{MediaTrack.ROLE_CAPTION, "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
            f41670o = new String[]{"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
            f41671p = new String[]{a.f20042a, "b", "big", "code", "em", "font", ContextChain.TAG_INFRA, "nobr", "s", "small", "strike", "strong", "tt", "u"};
            f41672q = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
        }

        Constants() {
        }
    }

    static {
        f41653y = String.valueOf(0);
    }

    /* access modifiers changed from: private */
    public static void f(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.f41794b.u(TokeniserState.Rawtext);
        htmlTreeBuilder.d0();
        htmlTreeBuilder.B0(Text);
        htmlTreeBuilder.L(startTag);
    }

    /* access modifiers changed from: private */
    public static void g(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.f41794b.u(TokeniserState.Rcdata);
        htmlTreeBuilder.d0();
        htmlTreeBuilder.B0(Text);
        htmlTreeBuilder.L(startTag);
    }

    /* access modifiers changed from: private */
    public static boolean h(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!StringUtil.g(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean i(Token token) {
        if (token.f()) {
            return h(token.a().p());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean j(Token token, HtmlTreeBuilder htmlTreeBuilder);
}
