package com.utils.Getlink.Resolver;

public class Filegram extends GenericResolver {
    public String c() {
        return "Filegram";
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return true;
    }

    /* access modifiers changed from: protected */
    public String p() {
        return "(?://|\\.)(filegram)\\.(?:tv|cc|to|co|sx|in|com|net|org)/(?:embed-|e/|d/|v/|file/)?([0-9a-zA-Z]+)";
    }

    /* access modifiers changed from: protected */
    public String q() {
        return "https://filegram.to";
    }
}
