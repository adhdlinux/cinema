package com.utils.Getlink.Resolver;

public class Furher extends GenericResolver {
    public String c() {
        return "Furher";
    }

    /* access modifiers changed from: protected */
    public boolean n() {
        return true;
    }

    public boolean o() {
        return true;
    }

    public String p() {
        return "(?://|\\.)(furher)\\.(?:tv|cc|to|co|sx|in)/(?:embed-|e/|d/|)?([0-9a-zA-Z]+)";
    }

    public String q() {
        return "https://furher.in";
    }

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/e/" + str2;
    }
}
