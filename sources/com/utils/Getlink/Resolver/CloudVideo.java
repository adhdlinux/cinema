package com.utils.Getlink.Resolver;

public class CloudVideo extends GenericResolver {
    public String c() {
        return "CloudVideo";
    }

    public boolean o() {
        return false;
    }

    public String p() {
        return "(?://|\\.)(cloudvideo|media)\\.(?:tv|cc|si|cm)/(?:embed-)?([0-9a-zA-Z]+)";
    }

    public String q() {
        return "https://media.cm";
    }
}
