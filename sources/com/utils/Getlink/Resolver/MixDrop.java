package com.utils.Getlink.Resolver;

public class MixDrop extends GenericResolver {
    public String c() {
        return "MixDrop";
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return false;
    }

    public String p() {
        return "(?:\\/|\\.)(mixdrop|mixdrp|mdbekjwqa|mdfx9dc8n)\\.(?:com|be|co|to|ag|nu|ms|)\\/(?:v|f|e)\\/([0-9a-zA-Z-]+)";
    }

    public String q() {
        return "";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/e/" + str2;
    }
}
