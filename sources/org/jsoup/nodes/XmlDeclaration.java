package org.jsoup.nodes;

import java.io.IOException;
import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

public class XmlDeclaration extends LeafNode {

    /* renamed from: e  reason: collision with root package name */
    private final boolean f41605e;

    public XmlDeclaration(String str, boolean z2) {
        Validate.j(str);
        this.f41598d = str;
        this.f41605e = z2;
    }

    private void Q(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        Iterator<Attribute> it2 = e().iterator();
        while (it2.hasNext()) {
            Attribute next = it2.next();
            if (!next.getKey().equals(u())) {
                appendable.append(' ');
                next.e(appendable, outputSettings);
            }
        }
    }

    public String R() {
        return O();
    }

    public /* bridge */ /* synthetic */ String a(String str) {
        return super.a(str);
    }

    public /* bridge */ /* synthetic */ String c(String str) {
        return super.c(str);
    }

    public /* bridge */ /* synthetic */ String f() {
        return super.f();
    }

    public /* bridge */ /* synthetic */ int i() {
        return super.i();
    }

    public /* bridge */ /* synthetic */ boolean p(String str) {
        return super.p(str);
    }

    public String toString() {
        return w();
    }

    public String u() {
        return "#declaration";
    }

    /* access modifiers changed from: package-private */
    public void y(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        String str;
        Appendable append = appendable.append("<");
        String str2 = "!";
        if (this.f41605e) {
            str = str2;
        } else {
            str = "?";
        }
        append.append(str).append(O());
        Q(appendable, outputSettings);
        if (!this.f41605e) {
            str2 = "?";
        }
        appendable.append(str2).append(">");
    }

    /* access modifiers changed from: package-private */
    public void z(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }
}
