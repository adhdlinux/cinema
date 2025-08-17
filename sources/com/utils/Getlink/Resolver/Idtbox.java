package com.utils.Getlink.Resolver;

public class Idtbox extends GenericResolver {
    public String c() {
        return "Idtbox";
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return true;
    }

    public String p() {
        return "(?://|\\.)(idtbox\\.com)/([a-zA-Z0-9]+)";
    }

    public String q() {
        return "https://idtbox.com";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/embed-" + str2 + ".html";
    }
}
