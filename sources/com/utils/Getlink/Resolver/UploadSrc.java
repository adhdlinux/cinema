package com.utils.Getlink.Resolver;

public class UploadSrc extends GenericResolver {
    public String c() {
        return "UploadSrc";
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return false;
    }

    public String p() {
        return "(?:\\/|\\.)(uqload)\\.(?:com|be|co|to|sc|ws)\\/(?:v/|e/|embed-)([0-9a-zA-Z-]+)";
    }

    public String q() {
        return "https://uqload.ws";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/embed-" + str2 + ".html";
    }
}
