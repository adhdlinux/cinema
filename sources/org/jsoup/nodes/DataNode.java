package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document;

public class DataNode extends LeafNode {
    public DataNode(String str) {
        this.f41598d = str;
    }

    public String Q() {
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
        return "#data";
    }

    /* access modifiers changed from: package-private */
    public void y(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(Q());
    }

    /* access modifiers changed from: package-private */
    public void z(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }
}
