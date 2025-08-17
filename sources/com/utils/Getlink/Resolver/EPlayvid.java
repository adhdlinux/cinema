package com.utils.Getlink.Resolver;

public class EPlayvid extends GenericResolver {
    public String c() {
        return "EPlayvid";
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return true;
    }

    public String p() {
        return "(?:\\/|\\.)(eplayvid)\\.(?:com|be|co|to|net)\\/(?:e|v|watch)\\/([0-9a-zA-Z-]+)";
    }

    public String q() {
        return "http://eplayvid.net";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/watch/" + str2;
    }
}
