package com.utils.Getlink.Resolver;

public class Embedwish extends GenericResolver {
    public String c() {
        return "Embedwish";
    }

    /* access modifiers changed from: protected */
    public boolean n() {
        return true;
    }

    public boolean o() {
        return false;
    }

    public String p() {
        return "(?://|\\.)(embedwish)\\.(?:tv|cc|to|co|sx|com)/(?:embed-|e/|d/|)?([0-9a-zA-Z]+)";
    }

    public String q() {
        return "https://embedwish.com";
    }

    public String r(String str, String str2) {
        return str + "/e/" + str2;
    }
}
