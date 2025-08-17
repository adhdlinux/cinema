package com.utils.Getlink.Resolver;

public class Streamhub extends GenericResolver {
    public String c() {
        return "Streamhub";
    }

    public boolean o() {
        return false;
    }

    public String p() {
        return "(?://|\\.)(streamhub\\.(?:tv|cc|to|co))/(?:embed-|e/|d/|)?([0-9a-zA-Z]+)";
    }

    public String q() {
        return "https://streamhub.to";
    }
}
