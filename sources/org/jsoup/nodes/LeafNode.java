package org.jsoup.nodes;

import java.util.List;
import org.jsoup.helper.Validate;

abstract class LeafNode extends Node {

    /* renamed from: d  reason: collision with root package name */
    Object f41598d;

    LeafNode() {
    }

    private void P() {
        if (!q()) {
            Object obj = this.f41598d;
            Attributes attributes = new Attributes();
            this.f41598d = attributes;
            if (obj != null) {
                attributes.t(u(), (String) obj);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String O() {
        return c(u());
    }

    public String a(String str) {
        P();
        return super.a(str);
    }

    public String c(String str) {
        Validate.j(str);
        if (q()) {
            return super.c(str);
        }
        if (str.equals(u())) {
            return (String) this.f41598d;
        }
        return "";
    }

    public Node d(String str, String str2) {
        if (q() || !str.equals(u())) {
            P();
            super.d(str, str2);
        } else {
            this.f41598d = str2;
        }
        return this;
    }

    public final Attributes e() {
        P();
        return (Attributes) this.f41598d;
    }

    public String f() {
        return r() ? B().f() : "";
    }

    public int i() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void m(String str) {
    }

    /* access modifiers changed from: protected */
    public List<Node> n() {
        throw new UnsupportedOperationException("Leaf Nodes do not have child nodes.");
    }

    public boolean p(String str) {
        P();
        return super.p(str);
    }

    /* access modifiers changed from: protected */
    public final boolean q() {
        return this.f41598d instanceof Attributes;
    }
}
