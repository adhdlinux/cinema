package org.jsoup;

import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public class Jsoup {
    private Jsoup() {
    }

    public static Connection a(String str) {
        return HttpConnection.g(str);
    }

    public static Document b(String str) {
        return Parser.c(str, "");
    }

    public static Document c(String str, String str2, Parser parser) {
        return parser.e(str, str2);
    }
}
