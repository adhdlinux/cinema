package com.utils.Getlink.Resolver;

public class Aparat extends GenericResolver {
    public String c() {
        return "Aparat";
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return true;
    }

    public String p() {
        return "(?:\\/|\\.)(aparat)\\.(?:cam|com|be|co|to|cc)(?:/embed-|/)([0-9a-zA-Z-]+)";
    }

    public String q() {
        return "https://aparat.cam";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/embed-" + str2 + ".html";
    }
}
