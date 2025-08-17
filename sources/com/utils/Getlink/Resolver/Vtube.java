package com.utils.Getlink.Resolver;

public class Vtube extends GenericResolver {
    public String c() {
        return "Vtube";
    }

    public boolean o() {
        return true;
    }

    public String p() {
        return "(?://|\\.)(vtube|vtbe)\\.(?:to|com|net|network)/([0-9a-zA-Z]+)";
    }

    public String q() {
        return "https://vtube.network";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/" + str2 + ".html";
    }
}
