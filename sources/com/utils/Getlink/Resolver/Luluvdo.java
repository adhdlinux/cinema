package com.utils.Getlink.Resolver;

public class Luluvdo extends GenericResolver {
    public String c() {
        return "Luluvdo";
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return false;
    }

    public String p() {
        return "(?:\\/|\\.)(luluvdo)\\.(?:com|be|co|to|tv|net)\\/(?:e/|v/|watch/|)([0-9a-zA-Z-]+)";
    }

    public String q() {
        return "https://luluvdo.com";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/e/" + str2;
    }
}
