package com.utils.Getlink.Resolver;

public class Supervideo extends GenericResolver {
    public String c() {
        return "Supervideo";
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return true;
    }

    public String p() {
        return "(?:\\/|\\.)(supervideo)\\.(?:com|be|co|to|tv|cc)(?:/e/|/v/|/)([0-9a-zA-Z-]+)";
    }

    public String q() {
        return "https://supervideo.tv";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/e/" + str2;
    }
}
