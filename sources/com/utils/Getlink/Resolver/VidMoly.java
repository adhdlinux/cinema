package com.utils.Getlink.Resolver;

public class VidMoly extends GenericResolver {
    public String c() {
        return "VidMoly";
    }

    public boolean o() {
        return true;
    }

    public String p() {
        return "(?://|\\.)(vidmoly\\.(?:me|to))/(?:embed-)?([0-9a-zA-Z]+)";
    }

    public String q() {
        return "https://vidmoly.me";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/embed-" + str2 + "-920x360.html";
    }
}
