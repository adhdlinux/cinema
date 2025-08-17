package org.jsoup.parser;

import java.io.Reader;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Token;

public class XmlTreeBuilder extends TreeBuilder {

    /* renamed from: org.jsoup.parser.XmlTreeBuilder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41803a;

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
                f41803a = r0
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.StartTag     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f41803a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EndTag     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f41803a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Comment     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f41803a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Character     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f41803a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Doctype     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f41803a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EOF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.XmlTreeBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    private void n(Node node) {
        a().Q(node);
    }

    private void o(Token.EndTag endTag) {
        Element element;
        String z2 = endTag.z();
        int size = this.f41796d.size() - 1;
        while (true) {
            if (size < 0) {
                element = null;
                break;
            }
            element = this.f41796d.get(size);
            if (element.u().equals(z2)) {
                break;
            }
            size--;
        }
        if (element != null) {
            int size2 = this.f41796d.size() - 1;
            while (size2 >= 0) {
                Element element2 = this.f41796d.get(size2);
                this.f41796d.remove(size2);
                if (element2 != element) {
                    size2--;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ParseSettings b() {
        return ParseSettings.f41677d;
    }

    /* access modifiers changed from: protected */
    public void c(Reader reader, String str, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        super.c(reader, str, parseErrorList, parseSettings);
        this.f41796d.add(this.f41795c);
        this.f41795c.z0().k(Document.OutputSettings.Syntax.xml);
    }

    /* access modifiers changed from: protected */
    public boolean e(Token token) {
        switch (AnonymousClass1.f41803a[token.f41701a.ordinal()]) {
            case 1:
                j(token.e());
                return true;
            case 2:
                o(token.d());
                return true;
            case 3:
                l(token.b());
                return true;
            case 4:
                k(token.a());
                return true;
            case 5:
                m(token.c());
                return true;
            case 6:
                return true;
            default:
                Validate.a("Unexpected token type: " + token.f41701a);
                return true;
        }
    }

    /* access modifiers changed from: package-private */
    public Element j(Token.StartTag startTag) {
        Tag k2 = Tag.k(startTag.z(), this.f41800h);
        Element element = new Element(k2, this.f41797e, this.f41800h.a(startTag.f41718j));
        n(element);
        if (!startTag.y()) {
            this.f41796d.add(element);
        } else if (!k2.f()) {
            k2.j();
        }
        return element;
    }

    /* access modifiers changed from: package-private */
    public void k(Token.Character character) {
        n(new TextNode(character.p()));
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [org.jsoup.nodes.Node, org.jsoup.nodes.XmlDeclaration] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(org.jsoup.parser.Token.Comment r6) {
        /*
            r5 = this;
            org.jsoup.nodes.Comment r0 = new org.jsoup.nodes.Comment
            java.lang.String r1 = r6.o()
            r0.<init>(r1)
            boolean r6 = r6.f41704c
            if (r6 == 0) goto L_0x0075
            java.lang.String r6 = r0.Q()
            int r1 = r6.length()
            r2 = 1
            if (r1 <= r2) goto L_0x0075
            java.lang.String r1 = "!"
            boolean r3 = r6.startsWith(r1)
            if (r3 != 0) goto L_0x0028
            java.lang.String r3 = "?"
            boolean r3 = r6.startsWith(r3)
            if (r3 == 0) goto L_0x0075
        L_0x0028:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "<"
            r0.append(r3)
            int r3 = r6.length()
            int r3 = r3 - r2
            java.lang.String r2 = r6.substring(r2, r3)
            r0.append(r2)
            java.lang.String r2 = ">"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = r5.f41797e
            org.jsoup.parser.Parser r3 = org.jsoup.parser.Parser.f()
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.c(r0, r2, r3)
            r2 = 0
            org.jsoup.nodes.Element r0 = r0.V(r2)
            org.jsoup.nodes.XmlDeclaration r2 = new org.jsoup.nodes.XmlDeclaration
            org.jsoup.parser.ParseSettings r3 = r5.f41800h
            java.lang.String r4 = r0.u0()
            java.lang.String r3 = r3.b(r4)
            boolean r6 = r6.startsWith(r1)
            r2.<init>(r3, r6)
            org.jsoup.nodes.Attributes r6 = r2.e()
            org.jsoup.nodes.Attributes r0 = r0.e()
            r6.d(r0)
            r0 = r2
        L_0x0075:
            r5.n(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.XmlTreeBuilder.l(org.jsoup.parser.Token$Comment):void");
    }

    /* access modifiers changed from: package-private */
    public void m(Token.Doctype doctype) {
        DocumentType documentType = new DocumentType(this.f41800h.b(doctype.o()), doctype.q(), doctype.r());
        documentType.R(doctype.p());
        n(documentType);
    }
}
