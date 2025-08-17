package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public abstract class Node implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    Node f41599b;

    /* renamed from: c  reason: collision with root package name */
    int f41600c;

    private static class OuterHtmlVisitor implements NodeVisitor {

        /* renamed from: a  reason: collision with root package name */
        private Appendable f41603a;

        /* renamed from: b  reason: collision with root package name */
        private Document.OutputSettings f41604b;

        OuterHtmlVisitor(Appendable appendable, Document.OutputSettings outputSettings) {
            this.f41603a = appendable;
            this.f41604b = outputSettings;
            outputSettings.h();
        }

        public void a(Node node, int i2) {
            if (!node.u().equals("#text")) {
                try {
                    node.z(this.f41603a, i2, this.f41604b);
                } catch (IOException e2) {
                    throw new SerializationException(e2);
                }
            }
        }

        public void b(Node node, int i2) {
            try {
                node.y(this.f41603a, i2, this.f41604b);
            } catch (IOException e2) {
                throw new SerializationException(e2);
            }
        }
    }

    protected Node() {
    }

    private void D(int i2) {
        List<Node> n2 = n();
        while (i2 < n2.size()) {
            n2.get(i2).K(i2);
            i2++;
        }
    }

    public Document A() {
        Node H = H();
        if (H instanceof Document) {
            return (Document) H;
        }
        return null;
    }

    public Node B() {
        return this.f41599b;
    }

    public final Node C() {
        return this.f41599b;
    }

    public void E() {
        Validate.j(this.f41599b);
        this.f41599b.F(this);
    }

    /* access modifiers changed from: protected */
    public void F(Node node) {
        boolean z2;
        if (node.f41599b == this) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.d(z2);
        int i2 = node.f41600c;
        n().remove(i2);
        D(i2);
        node.f41599b = null;
    }

    /* access modifiers changed from: protected */
    public void G(Node node) {
        node.J(this);
    }

    public Node H() {
        Node node = this;
        while (true) {
            Node node2 = node.f41599b;
            if (node2 == null) {
                return node;
            }
            node = node2;
        }
    }

    public void I(final String str) {
        Validate.j(str);
        N(new NodeVisitor() {
            public void a(Node node, int i2) {
            }

            public void b(Node node, int i2) {
                node.m(str);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void J(Node node) {
        Validate.j(node);
        Node node2 = this.f41599b;
        if (node2 != null) {
            node2.F(this);
        }
        this.f41599b = node;
    }

    /* access modifiers changed from: protected */
    public void K(int i2) {
        this.f41600c = i2;
    }

    public int L() {
        return this.f41600c;
    }

    public List<Node> M() {
        Node node = this.f41599b;
        if (node == null) {
            return Collections.emptyList();
        }
        List<Node> n2 = node.n();
        ArrayList arrayList = new ArrayList(n2.size() - 1);
        for (Node next : n2) {
            if (next != this) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Node N(NodeVisitor nodeVisitor) {
        Validate.j(nodeVisitor);
        NodeTraversor.b(nodeVisitor, this);
        return this;
    }

    public String a(String str) {
        Validate.h(str);
        if (!p(str)) {
            return "";
        }
        return StringUtil.k(f(), c(str));
    }

    /* access modifiers changed from: protected */
    public void b(int i2, Node... nodeArr) {
        Validate.f(nodeArr);
        List<Node> n2 = n();
        for (Node G : nodeArr) {
            G(G);
        }
        n2.addAll(i2, Arrays.asList(nodeArr));
        D(i2);
    }

    public String c(String str) {
        Validate.j(str);
        if (!q()) {
            return "";
        }
        String l2 = e().l(str);
        if (l2.length() > 0) {
            return l2;
        }
        if (str.startsWith("abs:")) {
            return a(str.substring(4));
        }
        return "";
    }

    public Node d(String str, String str2) {
        e().v(str, str2);
        return this;
    }

    public abstract Attributes e();

    public boolean equals(Object obj) {
        return this == obj;
    }

    public abstract String f();

    public Node g(Node node) {
        Validate.j(node);
        Validate.j(this.f41599b);
        this.f41599b.b(this.f41600c, node);
        return this;
    }

    public Node h(int i2) {
        return n().get(i2);
    }

    public abstract int i();

    public List<Node> j() {
        return Collections.unmodifiableList(n());
    }

    /* renamed from: k */
    public Node clone() {
        Node l2 = l((Node) null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(l2);
        while (!linkedList.isEmpty()) {
            Node node = (Node) linkedList.remove();
            int i2 = node.i();
            for (int i3 = 0; i3 < i2; i3++) {
                List<Node> n2 = node.n();
                Node l3 = n2.get(i3).l(node);
                n2.set(i3, l3);
                linkedList.add(l3);
            }
        }
        return l2;
    }

    /* access modifiers changed from: protected */
    public Node l(Node node) {
        int i2;
        try {
            Node node2 = (Node) super.clone();
            node2.f41599b = node;
            if (node == null) {
                i2 = 0;
            } else {
                i2 = this.f41600c;
            }
            node2.f41600c = i2;
            return node2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void m(String str);

    /* access modifiers changed from: protected */
    public abstract List<Node> n();

    /* access modifiers changed from: package-private */
    public Document.OutputSettings o() {
        Document A = A();
        if (A == null) {
            A = new Document("");
        }
        return A.z0();
    }

    public boolean p(String str) {
        Validate.j(str);
        if (str.startsWith("abs:")) {
            String substring = str.substring(4);
            if (e().n(substring) && !a(substring).equals("")) {
                return true;
            }
        }
        return e().n(str);
    }

    /* access modifiers changed from: protected */
    public abstract boolean q();

    public boolean r() {
        return this.f41599b != null;
    }

    /* access modifiers changed from: protected */
    public void s(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(10).append(StringUtil.j(i2 * outputSettings.f()));
    }

    public Node t() {
        Node node = this.f41599b;
        if (node == null) {
            return null;
        }
        List<Node> n2 = node.n();
        int i2 = this.f41600c + 1;
        if (n2.size() > i2) {
            return n2.get(i2);
        }
        return null;
    }

    public String toString() {
        return w();
    }

    public abstract String u();

    /* access modifiers changed from: package-private */
    public void v() {
    }

    public String w() {
        StringBuilder sb = new StringBuilder(128);
        x(sb);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void x(Appendable appendable) {
        NodeTraversor.b(new OuterHtmlVisitor(appendable, o()), this);
    }

    /* access modifiers changed from: package-private */
    public abstract void y(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void z(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException;
}
