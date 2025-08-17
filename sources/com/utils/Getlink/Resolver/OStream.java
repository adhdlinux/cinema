package com.utils.Getlink.Resolver;

public class OStream extends GenericResolver {
    public String c() {
        return "OStream";
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return false;
    }

    /* access modifiers changed from: protected */
    public String p() {
        return "(?://|\\.)(ostream\\.tv)/([0-9a-zA-Z]+)";
    }

    /* access modifiers changed from: protected */
    public String q() {
        return "http://ostream.tv/f/";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return "https://estream.to/" + str2 + ".html";
    }
}
