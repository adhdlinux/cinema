package org.jsoup.parser;

import java.io.Reader;
import java.util.ArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Token;

abstract class TreeBuilder {

    /* renamed from: a  reason: collision with root package name */
    CharacterReader f41793a;

    /* renamed from: b  reason: collision with root package name */
    Tokeniser f41794b;

    /* renamed from: c  reason: collision with root package name */
    protected Document f41795c;

    /* renamed from: d  reason: collision with root package name */
    protected ArrayList<Element> f41796d;

    /* renamed from: e  reason: collision with root package name */
    protected String f41797e;

    /* renamed from: f  reason: collision with root package name */
    protected Token f41798f;

    /* renamed from: g  reason: collision with root package name */
    protected ParseErrorList f41799g;

    /* renamed from: h  reason: collision with root package name */
    protected ParseSettings f41800h;

    /* renamed from: i  reason: collision with root package name */
    private Token.StartTag f41801i = new Token.StartTag();

    /* renamed from: j  reason: collision with root package name */
    private Token.EndTag f41802j = new Token.EndTag();

    TreeBuilder() {
    }

    /* access modifiers changed from: protected */
    public Element a() {
        int size = this.f41796d.size();
        if (size > 0) {
            return this.f41796d.get(size - 1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract ParseSettings b();

    /* access modifiers changed from: protected */
    public void c(Reader reader, String str, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        Validate.k(reader, "String input must not be null");
        Validate.k(str, "BaseURI must not be null");
        this.f41795c = new Document(str);
        this.f41800h = parseSettings;
        this.f41793a = new CharacterReader(reader);
        this.f41799g = parseErrorList;
        this.f41798f = null;
        this.f41794b = new Tokeniser(this.f41793a, parseErrorList);
        this.f41796d = new ArrayList<>(32);
        this.f41797e = str;
    }

    /* access modifiers changed from: package-private */
    public Document d(Reader reader, String str, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        c(reader, str, parseErrorList, parseSettings);
        i();
        return this.f41795c;
    }

    /* access modifiers changed from: protected */
    public abstract boolean e(Token token);

    /* access modifiers changed from: protected */
    public boolean f(String str) {
        Token token = this.f41798f;
        Token.EndTag endTag = this.f41802j;
        if (token == endTag) {
            return e(new Token.EndTag().A(str));
        }
        return e(endTag.l().A(str));
    }

    /* access modifiers changed from: protected */
    public boolean g(String str) {
        Token token = this.f41798f;
        Token.StartTag startTag = this.f41801i;
        if (token == startTag) {
            return e(new Token.StartTag().A(str));
        }
        return e(startTag.l().A(str));
    }

    public boolean h(String str, Attributes attributes) {
        Token token = this.f41798f;
        Token.StartTag startTag = this.f41801i;
        if (token == startTag) {
            return e(new Token.StartTag().F(str, attributes));
        }
        startTag.l();
        this.f41801i.F(str, attributes);
        return e(this.f41801i);
    }

    /* access modifiers changed from: protected */
    public void i() {
        Token t2;
        do {
            t2 = this.f41794b.t();
            e(t2);
            t2.l();
        } while (t2.f41701a != Token.TokenType.EOF);
    }
}
