package com.utils.Getlink.Resolver;

public class UpStream extends GenericResolver {
    public String c() {
        return "UpStream";
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return true;
    }

    public String p() {
        return "(?:\\/|\\.)(upstream)\\.(?:com|be|co|to)(?:/embed-|/)([0-9a-zA-Z-]+)";
    }

    public String q() {
        return "https://upstream.to";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/embed-" + str2 + ".html";
    }
}
