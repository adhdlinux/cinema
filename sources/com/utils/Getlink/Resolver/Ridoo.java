package com.utils.Getlink.Resolver;

public class Ridoo extends GenericResolver {
    public String c() {
        return "Ridoo";
    }

    public boolean o() {
        return false;
    }

    public String p() {
        return "(?://|\\.)(vidto\\.me)/(?:embed-)?([0-9a-zA-Z]+)";
    }

    public String q() {
        return "http://vidto.me";
    }

    /* access modifiers changed from: protected */
    public boolean s() {
        return true;
    }
}
