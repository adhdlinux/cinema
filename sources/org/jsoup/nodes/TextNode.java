package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;

public class TextNode extends LeafNode {
    public TextNode(String str) {
        this.f41598d = str;
    }

    static boolean S(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    public String Q() {
        return O();
    }

    public boolean R() {
        return StringUtil.e(O());
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
        return "#text";
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (R() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        s(r7, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (R() == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void y(java.lang.Appendable r7, int r8, org.jsoup.nodes.Document.OutputSettings r9) throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r9.i()
            if (r0 == 0) goto L_0x003d
            int r0 = r6.L()
            if (r0 != 0) goto L_0x0024
            org.jsoup.nodes.Node r0 = r6.f41599b
            boolean r1 = r0 instanceof org.jsoup.nodes.Element
            if (r1 == 0) goto L_0x0024
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            org.jsoup.parser.Tag r0 = r0.t0()
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0024
            boolean r0 = r6.R()
            if (r0 == 0) goto L_0x003a
        L_0x0024:
            boolean r0 = r9.g()
            if (r0 == 0) goto L_0x003d
            java.util.List r0 = r6.M()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x003d
            boolean r0 = r6.R()
            if (r0 != 0) goto L_0x003d
        L_0x003a:
            r6.s(r7, r8, r9)
        L_0x003d:
            boolean r8 = r9.i()
            if (r8 == 0) goto L_0x0058
            org.jsoup.nodes.Node r8 = r6.B()
            boolean r8 = r8 instanceof org.jsoup.nodes.Element
            if (r8 == 0) goto L_0x0058
            org.jsoup.nodes.Node r8 = r6.B()
            boolean r8 = org.jsoup.nodes.Element.o0(r8)
            if (r8 != 0) goto L_0x0058
            r8 = 1
            r4 = 1
            goto L_0x005a
        L_0x0058:
            r8 = 0
            r4 = 0
        L_0x005a:
            java.lang.String r1 = r6.O()
            r3 = 0
            r5 = 0
            r0 = r7
            r2 = r9
            org.jsoup.nodes.Entities.e(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.TextNode.y(java.lang.Appendable, int, org.jsoup.nodes.Document$OutputSettings):void");
    }

    /* access modifiers changed from: package-private */
    public void z(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }
}
