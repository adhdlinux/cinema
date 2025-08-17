package com.utils.Getlink.Resolver;

public class Streamwish extends GenericResolver {
    public String c() {
        return "Streamwish";
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return true;
    }

    public String p() {
        return "(?:\\/|\\.)(streamwish|cdnwish|swdyu)\\.(?:com|be|co|to|tv|net)\\/(?:e/|v/|watch/|)([0-9a-zA-Z-]+)";
    }

    public String q() {
        return "https://streamwish.to";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/e/" + str2;
    }
}
