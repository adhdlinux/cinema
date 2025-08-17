package org.jsoup.parser;

import java.io.Reader;
import java.io.StringReader;
import org.jsoup.nodes.Document;

public class Parser {

    /* renamed from: a  reason: collision with root package name */
    private TreeBuilder f41680a;

    /* renamed from: b  reason: collision with root package name */
    private int f41681b = 0;

    /* renamed from: c  reason: collision with root package name */
    private ParseErrorList f41682c;

    /* renamed from: d  reason: collision with root package name */
    private ParseSettings f41683d;

    public Parser(TreeBuilder treeBuilder) {
        this.f41680a = treeBuilder;
        this.f41683d = treeBuilder.b();
    }

    public static Parser a() {
        return new Parser(new HtmlTreeBuilder());
    }

    public static Document c(String str, String str2) {
        HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
        return htmlTreeBuilder.d(new StringReader(str), str2, ParseErrorList.b(), htmlTreeBuilder.b());
    }

    public static Parser f() {
        return new Parser(new XmlTreeBuilder());
    }

    public boolean b() {
        return this.f41681b > 0;
    }

    public Document d(Reader reader, String str) {
        ParseErrorList parseErrorList;
        if (b()) {
            parseErrorList = ParseErrorList.c(this.f41681b);
        } else {
            parseErrorList = ParseErrorList.b();
        }
        this.f41682c = parseErrorList;
        return this.f41680a.d(reader, str, parseErrorList, this.f41683d);
    }

    public Document e(String str, String str2) {
        ParseErrorList parseErrorList;
        if (b()) {
            parseErrorList = ParseErrorList.c(this.f41681b);
        } else {
            parseErrorList = ParseErrorList.b();
        }
        this.f41682c = parseErrorList;
        return this.f41680a.d(new StringReader(str), str2, this.f41682c, this.f41683d);
    }
}
